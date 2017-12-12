package forbaya.news.controller;

import forbaya.news.domain.Image;
import forbaya.news.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * The image controller.
 */
@Controller
public class ImageController {
    @Autowired
    private ImageRepository imageRepository;
    @Autowired
    private HttpSession session;

    /**
     * Handles GET /image/new
     *
     * @return the newImage.html view
     */
    @GetMapping("/image/new")
    public String getNewImage() {
        return "newImage";
    }

    /**
     * Handles POST /image/new
     * The image file need to be in png-format to be saved in the database.
     *
     * @param file the image file
     * @return redirects to /
     * @throws IOException an IOException
     */
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

    /**
     * Handles GET /image/{id}
     *
     * @param id the id of an image
     * @return the image
     */
    @GetMapping(path = "/image/{id}", produces = "image/png")
    @ResponseBody
    public byte[] getImage(@PathVariable Long id) {
        return imageRepository.getOne(id).getContent();
    }
}
