package com.heekim.contentcalendar.repository;

//versus-Later the data access repository name will be just ContentRepository

import com.heekim.contentcalendar.model.Content;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class ContentCollectionRepository {
    private final List<Content> content = new ArrayList<Content>();




}
