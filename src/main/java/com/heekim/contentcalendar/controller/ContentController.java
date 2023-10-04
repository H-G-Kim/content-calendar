package com.heekim.contentcalendar.controller;


import com.heekim.contentcalendar.model.Content;
import com.heekim.contentcalendar.repository.ContentCollectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


//WE WANT TO CREATE ALL THE CRUD ABILITY HERE- create read update delete | filter | paging and sorting
//gk:but seems we make it in repository first
@RestController
@RequestMapping("/api/content")
public class ContentController {

    private final ContentCollectionRepository repository;


    //step 1.old way-but this creates extra repository instance-there should already be 1 in application context container
    /*private ContentController(){
        this.repository = new ContentCollectionRepository();
    }*/

    //step2.One way of injecting the already instacen in container-inject by argument
    /*private ContentController(ContentCollectionRepository contentCollectionRepository){
        this.repository = contentCollectionRepository;
    }*/

    //step3.An easier way is to use final for line 13  and then intellij suggestion-"add parameter constructor"
    @Autowired
    //this is not needed if you have just 1 public constructor as in this case-but lets leave it-it means there in an injection(autowired) of bean
    public ContentController(ContentCollectionRepository repository) {
        this.repository = repository;
    }
    //1:08.08
    @GetMapping("") //this is a @RequestMapping under hood-a subset
    public List<Content> findAll(){

        return repository.findAll();
    }

    //??-Bug
    //@GetMapping("/1"); @GetMapping("/1"); @GetMapping("/1");@GetMapping("/1");@GetMapping("/1");
    //??@PathVariable
    @GetMapping("/{id}")
    public Content findById(@PathVariable Integer id){
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Content not found!" ));
    }

    //?what is Content content mean for parameters
    //@ResponseStatus gives the caller of the request to create a resource a indication the resouce actually created ->
    //IT WILL GIVE A 201 response
    @ResponseStatus(HttpStatus.CREATED)
    //??why keep using same "" -isn't this confusing
    @PostMapping("")
    public void Create(@RequestBody Content content){

        repository.save(content);
    }

    @PutMapping
    public void Update(Content content, @PathVariable Integer id){

        if(!repository.idExists(id)){
            new ResponseStatusException(HttpStatus.NOT_FOUND, "Content not found!" );
        }

        repository.save(content);
    }








}
