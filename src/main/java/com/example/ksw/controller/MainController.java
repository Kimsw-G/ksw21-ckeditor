package com.example.ksw.controller;

import com.google.gson.JsonObject;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.UUID;

@Controller
public class MainController {

    @GetMapping("/")
    public String hello() {

        return "hello";
    }

    @PostMapping("/ckUpload")
    public static void postCKEditorImg(HttpServletRequest request,
                                       HttpServletResponse response,
                                       HttpSession session,
                                       @RequestParam MultipartFile upload) throws Exception{
        // 여기서 저장경로 지정. 난 내 PC기준으로 했음
        String uploadPath = "C:/Users/ksw/IdeaProjects/ksw00-default/src/main/resources/static";
        String filename = upload.getOriginalFilename();
        System.out.println("filename : "+filename);
        String ex = "."+FilenameUtils.getExtension(filename);
        System.out.println("ex : "+ex);

        UUID uid = UUID.randomUUID();
//
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json");
//
        String ckUploadPath = new StringBuilder()
                .append(uploadPath)
                .append("/img/hello/") // 여길 계정정보, 게시판정보등으로 하면 될듯?
                .append(uid)
                .append(ex).toString();
        String fileUrl = new StringBuilder()
                .append("/img/hello/") // 여기도. 위랑 연계해서 모듈화 시키기
                .append(uid)
                .append(ex).toString();

        File saveFile = new File(ckUploadPath);
        upload.transferTo(saveFile);


        PrintWriter printWriter = response.getWriter();
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("uploaded",1);
        jsonObject.addProperty("url",ckUploadPath);

        printWriter.println(jsonObject);
        printWriter.flush();

        System.out.println("url : "+fileUrl);
        System.out.println("ckUploadPath : "+ckUploadPath);


    }


}

