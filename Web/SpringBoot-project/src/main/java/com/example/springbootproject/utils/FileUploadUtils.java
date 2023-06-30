package com.example.springbootproject.utils;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;

@Component
public class FileUploadUtils {

    /**
     * 保存文件
     *
     * @param file     文件对象
     * @param filePath 文件保存路径
     * @throws IOException
     */
    public void saveFile(MultipartFile file, String filePath) throws IOException {
        File dest = new File(filePath);
        file.transferTo(dest);
    }

    /**
     * 下载文件
     *
     * @param response HttpServletResponse对象
     * @param filePath 文件路径
     * @param fileName 文件名
     * @throws IOException
     */
    public void downloadFile(HttpServletResponse response, String filePath, String fileName) throws IOException {
        File file = new File(filePath);
        if (!file.exists()) {
            throw new FileNotFoundException("文件不存在");
        }

        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));

        try (InputStream inputStream = new FileInputStream(file);
             OutputStream outputStream = response.getOutputStream()) {
            byte[] buffer = new byte[1024];
            int length;
            while ((length = inputStream.read(buffer)) > 0) {
                outputStream.write(buffer, 0, length);
            }
            outputStream.flush();
        }
    }
}