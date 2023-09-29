package com.heekim.contentcalendar.repository;



import com.heekim.contentcalendar.model.Content;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


//versus-Later the data access repository name will be just ContentRepository
@Repository
public class ContentCollectionRepository {
    private final List<Content> content = new ArrayList<>();

    public ContentCollectionRepository(){

    }




}
