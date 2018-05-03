package com.isep.cardis.projet_fiches_module_A2;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class HelloWorld {

    @RequestMapping("/")
    public String index() {
        return "Bienvenue sur la dernière version de Cardis!";
    }

}
