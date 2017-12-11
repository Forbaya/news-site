package forbaya.news.controller;

import forbaya.news.domain.Image;
import forbaya.news.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
public class ImageController {
    @Autowired
    private ImageRepository imageRepository;

    @GetMapping("/image/new")
    public String getNewImage() {
        return "newImage";
    }

    @PostMapping(path = "/image/new", produces = "image/png")
    public String postNewImage(@RequestParam("file") MultipartFile file) throws IOException {
        if (file.getContentType().equals("image/png")) {
             Image image = new Image();
             image.setName(file.getOriginalFilename());
             image.setContentType(file.getContentType());
             image.setContentLength(file.getSize());
             image.setContent(file.getBytes());
             imageRepository.save(image);
        }
        return "redirect:/";
    }

    @GetMapping(path = "/image/{id}", produces = "image/png")
    @ResponseBody
    public byte[] getImage(@PathVariable Long id) {
        return imageRepository.getOne(id).getContent();
    }
}
