package com.restapi.controller;

import com.restapi.util.HTMLUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.io.StringReader;

@RestController
public class GreetController {

    @GetMapping("/")
    public ModelAndView success() {
        /*String msg = "Server up and running: RestAPI";
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(msg);*/
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index.html");
        return modelAndView;
    }

    @GetMapping("/greet")
    public ResponseEntity<?> sayHello() {
        return ResponseEntity
                .badRequest()
                .body("Hello! Greetings from the rest api application.");
    }

    @PostMapping
    public ResponseEntity<?> sayHelloWithName(@RequestBody String name) {
        return ResponseEntity
                .status(HttpStatus.I_AM_A_TEAPOT)
                .body("Hello " + name + "! Welcome to the rest api application using spring boot");
    }

    @GetMapping("/self")
    public ResponseEntity<?> apiSelf() {
        String uri = "http://localhost:80/";
        RestTemplate rt = new RestTemplate();
        String result = rt.getForObject(uri, String.class);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(result);
    }

    @GetMapping("/meow")
    @ResponseBody
    public String apiCat() {
        String uri = "http://meowfacts.herokuapp.com/";
        RestTemplate rt = new RestTemplate();
        String res = rt.getForObject(uri, String.class);

        JsonReader reader = Json.createReader(new StringReader(res));
        JsonObject obj = reader.readObject();
        JsonArray arr = obj.getJsonArray("data");
        String data = arr.getString(0);

        return HTMLUtil.getTextHTML(data);
    }

    @RequestMapping(value = "/dogs")
    @ResponseBody
    public ResponseEntity<?> apiRandDog() {
        String uri = "https://random.dog/woof.json";
        RestTemplate rt = new RestTemplate();
        String res = rt.getForObject(uri, String.class);

        //fetch only images/gifs
        while (!(null == res || HTMLUtil.isImage(res))) {
            res = rt.getForObject(uri, String.class);
        }

        //parse the url
        JsonReader reader = Json.createReader(new StringReader(res));
        JsonObject json = reader.readObject();
        String url = json.getString("url").substring(8).toLowerCase();
        System.out.println("url = https://" + url);

        String t = HTMLUtil.getDogViewHTML(url);
        return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).body(t);
    }

    @GetMapping("/redir")
    public RedirectView redir() {
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("http://www.google.com");
        return redirectView;
    }

    @GetMapping(value = "/em")
    @ResponseBody
    public String em() {
        String uri = "https://github.com/public-apis/public-apis";
        return new RestTemplate().getForObject(uri, String.class);
    }

}
