package com.alamin.controller;

import com.alamin.dto.UserDTO;
import com.alamin.models.Language;
import com.alamin.utils.Constant;
import com.alamin.models.CoursesView;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {
    @Autowired
    private ServletContext servletContext;
    @GetMapping("/")
    public String home(){
        return "index";
    }
    @GetMapping("/user/add")
    public String createUser(Model model, @ModelAttribute("userDto") UserDTO userDTO){

        return "createUser";
    }
    @PostMapping("/user/add")
    public String addUser(Model model,
                          @ModelAttribute("userDto") UserDTO userDTO,
                          @RequestParam("image") MultipartFile file,
                          HttpSession session) throws InterruptedException {


        System.out.println(file.getContentType());
        System.out.println(file.getName());
        String path = session.getServletContext().getRealPath("/")+ Constant.USER_IMAGE_LOCATION +file.getOriginalFilename();
        System.out.println("-------->"+path);

        try{
            file.transferTo(new File(path));

//            byte[] data = file.getBytes();
//            FileOutputStream fos = new FileOutputStream(path);
//            fos.write(data);
//            fos.close();
//            System.out.println("Uploaded");

            //image show
//            InputStream inputStream = new ByteArrayInputStream(data);
//            IOUtils.copy(inputStream, response.getOutputStream());

//            InputStream inputStream = new BufferedInputStream(new FileInputStream(path));
//            FileCopyUtils.copy(inputStream, response.getOutputStream());

            model.addAttribute("msg","Uploaded");
            model.addAttribute("filename",file.getOriginalFilename());

        }catch (Exception e){

            e.printStackTrace();
            System.out.println("Not Uploaded!");
            model.addAttribute("msg","Not Uploaded");

        }

        return "usershow";
    }


    @RequestMapping(value = "/getStudentPhoto/{filename}")
    public void getStudentPhoto(HttpServletResponse response, @PathVariable("filename") String path) throws Exception {
//        response.setContentType("image/jpeg");
//
//
//        byte[] bytes = path.getBytes();
//        InputStream inputStream = new ByteArrayInputStream(bytes);
//        IOUtils.copy(inputStream, response.getOutputStream());
        File file = new File(path);
        String mimeType = URLConnection.guessContentTypeFromName(file.getName());
        if (mimeType == null) {
            mimeType = "application/octet-stream";
        }
        response.setContentType(mimeType);
        response.setHeader("Content-Disposition", String.format("inline; filename=\"" + file.getName() + "\""));
        response.setContentLength((int) file.length());
        InputStream inputStream = new BufferedInputStream(new FileInputStream(file));
        FileCopyUtils.copy(inputStream, response.getOutputStream());
    }

    @GetMapping("/image-manual-response/{filename}")
    public void getImageAsByteArray(@PathVariable("filename") String filename, HttpServletResponse response) throws IOException {
        InputStream in = servletContext.getResourceAsStream(Constant.USER_IMAGE_LOCATION+filename);
        response.setContentType(MediaType.IMAGE_JPEG_VALUE);
        IOUtils.copy(in, response.getOutputStream());
    }


    @GetMapping("/languages/view")
    public String getCheckbox(Model model, @ModelAttribute("languages") Language languages){

        CoursesView language = new CoursesView();
        List<String> arr =new ArrayList<>(List.of(new String[]{"Java", "C", "C++", "Python"})) ;
        language.setFavLanguages(arr);
        model.addAttribute("lg", language);
        return "checkboxs";
    }
    @PostMapping("/languages/view")
    public String postCheckbox(@ModelAttribute("languages") Language languages){
//        System.out.println(languages.getName());
//        for(String language : languages.getFavLanguages()){
//            System.out.println(language);
//        }
        return "checkboxs";
    }


}
