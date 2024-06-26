package com.example.controller;

import com.example.common.Result;
import cn.hutool.core.io.FileUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;

@RestController//标识这是一个控制器类，Spring会自动注册它并将其识别为REST风格Controller
@RequestMapping("/files")// 标识请求路径
public class FileController {
    private static final String ROOT_PATH = System.getProperty("user.dir") + "/files";
//ROOT_PATH文件存储根路径，System.getProperty("user.dir")获取当前项目的根目录，并在其下创建/files目录用于存储上传的文件。
    // 文件上传
    @PostMapping("/upload")
    public Result upload(MultipartFile file) throws IOException {
        String originalFilename = file.getOriginalFilename();  //获取上传文件的原始文件名
        long flag = System.currentTimeMillis();  //时间戳，用于生成唯一文件名
        String fileName = flag + "_" + originalFilename; //生成唯一的文件名,上传到服务器的文件名

        File finalFile = new File(ROOT_PATH + "/" + fileName); //文件在存盘存储的对象
        if (!finalFile.getParentFile().exists()) { //如果文件夹不存在，则创建
            finalFile.getParentFile().mkdirs(); //创建文件夹
        }
        file.transferTo(finalFile);//将上传的文件保存到服务器指定路径

        // 返回文件的url
        String url = "http://localhost:8888/files/download?fileName=" + fileName;
        return Result.success(url);
    }

    // 文件下载
    @GetMapping("/download")//处理 HTTP GET 请求，路径为 /files/download，用于下载指定文件。
    public void download(String fileName, HttpServletResponse response) throws IOException {//从请求参数中获取要下载的文件名
        File file = new File(ROOT_PATH + "/" + fileName);  // 文件在存盘存储的对象
        ServletOutputStream os = response.getOutputStream();//获取响应的输出流ServletOutputStream，用于将文件内容写入响应。
        response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
        //Content-Disposition是一个HTTP响应头，用于指定响应内容如何显示。attachment，表示内容应作为附件下载，而不是直接在浏览器中显示。
        response.setContentType("application/octet-stream");// 设置响应类型为文件流
        FileUtil.writeToStream(file, os);// 将文件写入输出流
        os.flush();//刷新输出流
        os.close();//关闭输出流
    }
}
