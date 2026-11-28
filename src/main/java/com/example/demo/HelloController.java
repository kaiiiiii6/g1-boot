package com.example.demo;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class HelloController {

    private final HelloService service;
    private final OrderService orderService;
    private final Greeting greeting;
    private final HelloLogMapper helloLogMapper;


   @Autowired
    public HelloController(HelloService service,
                           OrderService orderService,
                           @Qualifier("EnGreeting")Greeting greeting,HelloLogMapper helloLogMapper) {
        this.service = service;
        this.orderService = orderService;
        this.greeting = greeting;
        this.helloLogMapper = helloLogMapper;
    }

    @GetMapping("/hello")
    public Result<String> hello(@RequestParam(value="name",required = false)  String name){
       if(name==null){
           return Result.ok(service.greet()+" | "+orderService.order());
       }else {
           return Result.ok("hello "+name+" | "+orderService.order());
       }

    }

    @GetMapping("/hello/{name}")
    public Result<String> helloname(@PathVariable("name") String name){
           return Result.ok("hello " + name +" | " + orderService.order()) ;
    }

    @GetMapping("/greet")
    public Result<String> greet(){
        return Result.ok(greeting.hello());
    }

    @GetMapping("/boom")
    public Result<String> boom(){
       throw new RuntimeException("试一下");
    }

    @GetMapping("/hello/db/{id}")
    public Result<String> hellodb(@PathVariable("id") Long  id){
       return Result.ok(helloLogMapper.findmessageById(id));
    }

    @PostMapping ("/echo")
    public Result<Map<String,Object>> echo(@RequestBody Map<String,Object> body){
        return Result.ok(body);
    }

    @PostMapping("/hello/json")
    public Result<String> hellojson(@Valid @RequestBody GreetRequest req){
       return Result.ok("hello " + req.getName() + " | "+orderService.order()) ;
    }

}
