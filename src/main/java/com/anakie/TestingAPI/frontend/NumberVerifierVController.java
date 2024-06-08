package com.anakie.TestingAPI.frontend;

import com.anakie.TestingAPI.googleSearch.model.numberVerifierModel.CellNumber;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@Controller
@RequestMapping("/numberVerifier")
public class NumberVerifierVController {

    @GetMapping
    public String view(Model model){
        return "verifyNumber";
    }

    @PostMapping("/checkNumber")
    public String numberVerifier(@RequestParam("number") String number, Model model) throws Exception {
        String url = "http://localhost:8081/apiTesting/verify/" + Integer.parseInt(number);
        RestTemplate restTemplate = new RestTemplate();
        CellNumber cellNumber = restTemplate.getForObject(url, CellNumber.class);
        if (cellNumber != null) {
            model.addAttribute("cellNumber", cellNumber);
            model.addAttribute("displayInfo", true);
            return "verifyNumber";
        }
        throw new Exception("No result");
    }
}
