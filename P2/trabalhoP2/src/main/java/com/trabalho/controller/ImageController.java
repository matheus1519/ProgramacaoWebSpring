package com.trabalho.controller;

import com.trabalho.model.Produto;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Calendar;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class ImageController {

    @RequestMapping("/images/{imagename}")
    public void imageViewer(HttpServletRequest req,
            HttpServletResponse res,
            @PathVariable("imagename") String imageName) {
        String path = "C:\\Users\\1519m\\Pictures\\";
        Path image = Paths.get(path, imageName);

        if (Files.exists(image)) {
            res.setHeader("Content-Disposition", "inline");
            res.setContentType(MediaType.IMAGE_JPEG_VALUE);
            try {
                Files.copy(image, res.getOutputStream());
                res.getOutputStream().flush();
            } catch (Exception ex) {
                ex.printStackTrace();

            }
        }
    }
    
    public static void salvarFoto(MultipartFile photo, Produto produto){
        try {
            String name = Calendar.getInstance().getTimeInMillis() + photo.getOriginalFilename();
            photo.transferTo(Paths.get("C:\\Users\\1519m\\Pictures\\" + name));
//            mv.addObject("path", context.getContextPath() +"/images/"+name);
            produto.setFoto("http://localhost:8080/images/" + name);
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

}
