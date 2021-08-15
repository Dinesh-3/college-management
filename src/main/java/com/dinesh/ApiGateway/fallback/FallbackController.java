package com.dinesh.ApiGateway.fallback;

import com.dinesh.ApiGateway.util.ResponseBody;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallbackController {

    @GetMapping("/user-service")
    public ResponseEntity<ResponseBody> userService() {
        return new ResponseEntity<>(new ResponseBody(false,"User Service Unavailable. Please try again"), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/department-service")
    public ResponseEntity<ResponseBody> departmentService() {
        return new ResponseEntity<>(new ResponseBody(false,"Department Service Unavailable. Please try again"), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

