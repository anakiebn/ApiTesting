package com.anakie.TestingAPI.frontend;

import com.anakie.TestingAPI.googleSearch.model.OrganicResult;
import com.anakie.TestingAPI.googleSearch.model.Result;
import com.anakie.TestingAPI.googleSearch.model.googleModel.Image;
import com.anakie.TestingAPI.googleSearch.model.googleModel.ImageResults;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Controller
@RequestMapping("/profile")
public class ProfileController {


    @GetMapping
    public String first(Model model){
        model.addAttribute("available",false);
        return "profile";
    }

    @PostMapping("/search")
    public String profile(@RequestParam String name, Model model) throws Exception {
        String url="http://localhost:8081/apiTest/googleImageSearch/"+name;
        RestTemplate restTemplate = new RestTemplate();
        ImageResults imageResults = restTemplate.getForObject(url, ImageResults.class);
        if(imageResults!=null){
            model.addAttribute("available",true);
            if(imageResults.getImages()!=null){
                List<Image> images=imageResults.getImages().stream().map(image -> image).toList();

                model.addAttribute("data",images);
            }else {
                throw new Exception("No images");
            }
        }else {
            throw new Exception("No image resutls");
        }

        return "profile";
    }
}
