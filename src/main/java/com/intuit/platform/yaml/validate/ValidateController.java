package com.intuit.platform.yaml.validate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.nio.charset.StandardCharsets;

@RestController
public class ValidateController {
  @Autowired
  ValidateProperties props;

  @RequestMapping("/get")
  //HttpServletResponse response
  public ResponseEntity<String> get() {
    //response.addHeader("content-type", "text/plain; charset=utf-8");
    HttpHeaders httpHeaders = new HttpHeaders();
    httpHeaders.setContentType(new MediaType("text", "plain", StandardCharsets.UTF_8));

    return new ResponseEntity<>(props.check(), httpHeaders, HttpStatus.OK);
  }


}
