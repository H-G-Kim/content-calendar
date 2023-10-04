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
    private final List<Content> contentList = new ArrayList<>();

    public ContentCollectionRepository(){

    }

    public List<Content> findAll(){
        return contentList;
    }

    //1:01.01
    // ?? what exactly is optional type-what is old alternative or alternative if any?
    //??Stream filter  ??c -> c.id().equals(id) ?? is this an anonymous fx
    //?c.id() how can this be a method?
    public Optional<Content> findById(Integer id){
        return contentList.stream().filter(c -> c.id().equals(id)).findFirst();

    }

    //??Predicate
    public void save(Content content) {
        contentList.removeIf(c -> c.id().equals(content.id()));
        contentList.add(content);
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

        contentList.add(c);
    }


    public void update(Content content) {
        content.equals(null);
    }

    public boolean idExists(Integer id) {
        return contentList.stream().filter(c -> c.id().equals(id)).count() == 1;
    }
}
