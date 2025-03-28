package org.example.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class ServiceProxyController {

    private final RestTemplate restTemplate = new RestTemplate();

    @GetMapping("/lucas")
    public ResponseEntity<Map<String, Object>> proxyLucas(@RequestParam(value = "num", defaultValue = "10") int num,
                                                          @RequestParam(value = "server", defaultValue = "1") int server) {
        String baseUrl;
        if (server == 1) {
            baseUrl = "http://localhost:8081/api/lucasServer1";
        } else if (server == 2) {
            baseUrl = "http://localhost:8082/api/lucasServer2";
        } else {
            return ResponseEntity.badRequest().body(Map.of("error", "Servidor no válido. Usa 1 o 2."));
        }

        String url = baseUrl + "?num=" + num;

        return restTemplate.getForEntity(url, (Class<Map<String, Object>>) (Class<?>) Map.class);
    }
}
