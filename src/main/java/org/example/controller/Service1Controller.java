package org.example.controller;

import org.example.backend.LucasService1Application;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class Service1Controller {

    @GetMapping("/lucasServer1")
    public Map<String, Object> getLucasSequence(@RequestParam(value = "num", defaultValue = "10") int num) {
        List<Integer> sequence = LucasService1Application.LucasSec(num);

        Map<String, Object> response = new HashMap<>();
        response.put("operation", "Secuencia de Lucas)");
        response.put("operation", "Secuencia de Lucas)");
        response.put("input", num);
        response.put("sequence", sequence);

        return response;
    }
}