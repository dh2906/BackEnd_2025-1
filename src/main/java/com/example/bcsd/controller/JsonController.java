package com.example.bcsd.controller;

import com.example.bcsd.controller.dto.resopnse.JsonResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/json")
public class JsonController {
    @GetMapping
    public ResponseEntity<JsonResponse> getJson() {
        JsonResponse response = new JsonResponse(24, "이동훈");

        return ResponseEntity.ok(response);
    }
}
