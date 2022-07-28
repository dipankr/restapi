package com.test.restapi.controller;

import com.test.restapi.util.HTMLUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.view.RedirectView;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.io.StringReader;
import java.net.URISyntaxException;

@RestController
public class GreetController {

    @GetMapping("/")
    public ResponseEntity<?> success(){
        String msg = "Server up and running: RestAPI";
        return ResponseEntity.status(HttpStatus.OK).body(msg);
    }

    @GetMapping("/greet")
    public ResponseEntity<?> sayHello(){
        return ResponseEntity.badRequest().body("Hello! Greetings from the rest api application.");
    }
    @PostMapping
    public ResponseEntity<?> sayHelloWithName(@RequestBody String name){
        return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).body("Hello "+name+"! Welcome to the rest api application using spring boot");
    }

    @GetMapping("/self")
    public String apiSelf(){
        String uri = "http://localhost:80/";
        RestTemplate rt = new RestTemplate();
        String result = rt.getForObject(uri, String.class);
        return result;
    }

    @GetMapping("/meow")
    @ResponseBody
    public String apiCat(){
        String uri = "https://github.com/wh-iterabb-it/meowfacts";
        RestTemplate rt = new RestTemplate();
        String result = rt.getForObject(uri, String.class);
        return result;
    }

    @RequestMapping(value = "/dogs", produces = MediaType.TEXT_HTML_VALUE)
    public String apiRandDog() {
        String uri = "https://random.dog/woof.json";
        RestTemplate rt = new RestTemplate();
        String res = rt.getForObject(uri, String.class);

        //fetch only images/gifs
        while(!(null == res || res.endsWith(".jpg\"}") || res.endsWith(".jpeg\"}") || res.endsWith(".png\"}") || res.endsWith(".gif\"}"))){
            res = rt.getForObject(uri, String.class);
        }

        //parse the url
        JsonReader reader = Json.createReader(new StringReader(res));
        JsonObject json = reader.readObject();
        String url = json.getString("url").substring(8).toLowerCase();
        System.out.println("url = https://" + url);

        String t = HTMLUtil.getDogViewHTML(url);
        return t;
    }

    @GetMapping("/redir")
    public RedirectView redir() throws URISyntaxException {
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("http://www.google.com");
        return redirectView;
    }
}
