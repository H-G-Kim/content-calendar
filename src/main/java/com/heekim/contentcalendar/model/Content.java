package com.heekim.contentcalendar.model;

import java.time.LocalDateTime;

public record Content(
        Integer id,
        String title,
        String desc,
        Status status,
        Type contenType,
        LocalDateTime dataCreated,
        LocalDateTime dateUpdate,
        String url

) {
}
