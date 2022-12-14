package com.Joker.mvc.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

/**
 * @author Joker
 * @Date 2022/12/6 18:26
 * @Description ResponseEntity实现下载及上传功能
 * @since version-1.0
 */
@RestController
public class FileUpAndDownController {

    // 下载
    @RequestMapping("/testDown")
    public ResponseEntity<byte[]> testResponseEntity(HttpSession session)throws IOException{

        // 获取ServletContext对象
        ServletContext servletContext = session.getServletContext();
        // 获取服务器中文件的真实路径
        String realPath = servletContext.getRealPath("/WEB-INF/static/img/1.jpg");
        // 创建输入流
        InputStream is = new FileInputStream(realPath);
        // 创建字节流
        byte[] bytes = new byte[is.available()];
        // 将凌读到字节数组中
        is.read(bytes);
        // 创建HttpHeaders对象设置应头信息
        MultiValueMap<String,String>headers = new HttpHeaders();
        // 设置要下载方式及下载文件的名子
        headers.add("Content-Disposition","attachment;filename = 1.jpg");
        // 设置响应状态码
        HttpStatus statusCode = HttpStatus.OK;
        // 创建ResponseEntity对象
        ResponseEntity<byte[]>responseEntity = new ResponseEntity<>(bytes,headers,statusCode);
        //关闭输入流
        is.close();
        return responseEntity;
    }



    // 上传
    @RequestMapping("/testUp")
    public String testUp(MultipartFile photo,HttpSession session) throws IOException {

        // 获取上传文件的文件名
        String fileName = photo.getOriginalFilename();
        // 获取上传文件的后缀名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        // 将UUID作为文件名,通过.replaceAll将“-”替换为“”空字符串
        String uuid = UUID.randomUUID().toString().replaceAll("-","");
        // 将uuid和后缀名拼接后的结果作为最终的文件名
        fileName = uuid + suffixName;
        // 通过ServletContext获取服务器中Photo目录的路径
        ServletContext servletContext = session.getServletContext();
        String photoPath =  servletContext.getRealPath("photo");
        File file = new File(photoPath);
        // 判断photoPath所对应路径是否存在
        if (!file.exists()){
            // 若不存在，则创建目录
            file.mkdir();
        }
        String finalPath = photoPath + File.separator + fileName;
        photo.transferTo(new File(finalPath));
        return "success";
    }
}
