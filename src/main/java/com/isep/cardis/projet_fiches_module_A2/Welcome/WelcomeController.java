package com.isep.cardis.projet_fiches_module_A2.Welcome;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WelcomeController {

    @RequestMapping(value={"", "/", "index"})
    public String index() {
        return "index";
    }

}
