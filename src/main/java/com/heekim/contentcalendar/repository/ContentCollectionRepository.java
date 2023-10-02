package com.heekim.contentcalendar.repository;

import com.heekim.contentcalendar.model.Content;
import com.heekim.contentcalendar.model.Status;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.heekim.contentcalendar.model.Type.ARTICLE;


//versus-Later the data access repository name will be just ContentRepository
//@repository == @Component-see docs
@Repository
public class  ContentCollectionRepository {
    //??why is this private and others public
    private final List<Content> content = new ArrayList<>();

    public ContentCollectionRepository(){

    }

    public List<Content> findAll(){
        return content;
    }

    //1:01.01
    // ?? what exactly is optional type-what is old alterntive
    //??Stream filter
    public Optional<Content> findById(Integer id){
        return content.stream().filter(c -> c.equals(id)).findFirst();

    }

    //post-construct -after dependency injection to do any "initialisation"
    //temp way to put some data into application
    @PostConstruct
    private void contentDataInit() {
        Content c = new Content(1,
                "My forst blog post",
                "About blog post re. spring",
                Status.IDEA,
                ARTICLE,
                LocalDateTime.now(),
                null,
                "http://www.myspring-blog.com");

        content.add(c);
    }



}
