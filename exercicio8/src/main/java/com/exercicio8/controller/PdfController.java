package com.exercicio8.controller;

import com.exercicio8.model.Cliente;
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
public class PdfController {

    @RequestMapping("/pdf/{pdfname}")
    public void imageViewer(HttpServletRequest req,
            HttpServletResponse res,
            @PathVariable("pdfname") String pdfName) {
        String path = "C:\\Users\\1519m\\Pictures\\PDF\\";
        Path pdf = Paths.get(path, pdfName);

        if (Files.exists(pdf)) {
            res.setHeader("Content-Disposition", "inline");
            res.setContentType(MediaType.APPLICATION_PDF_VALUE);
            try {
                Files.copy(pdf, res.getOutputStream());
                res.getOutputStream().flush();
            } catch (Exception ex) {
                ex.printStackTrace();

            }
        }
    }

    public static void salvarPdf(MultipartFile currir, Cliente cliente) {
        try {
            String name = Calendar.getInstance().getTimeInMillis() + currir.getOriginalFilename();
            currir.transferTo(Paths.get("C:\\Users\\1519m\\Pictures\\PDF\\" + name));
//            mv.addObject("path", context.getContextPath() +"/images/"+name);
            cliente.setCurriculo("http://localhost:8080/pdf/" + name);
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

}
