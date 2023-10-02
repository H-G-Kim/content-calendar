package com.heekim.contentcalendar.repository;



import com.heekim.contentcalendar.model.Content;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


//versus-Later the data access repository name will be just ContentRepository
//@repository == @Component-see docs
@Repository
public class  ContentCollectionRepository {
    private final List<Content> content = new ArrayList<>();

    public ContentCollectionRepository(){

    }

    public List<Content> findAll(){
        return content;
    }

    //1:01.01
    // ?? what exactly is optional type-what is old alterntive
    public Optional<Content> findById(Integer id){
        return content.stream().filter(c -> c.equals(id)).findFirst();

    }

    //post-construct -after dependency injection to do any "initialisation"
    //temp way to put some data into application
    @PostConstruct
    private void contentDataInit(){

    }




}
