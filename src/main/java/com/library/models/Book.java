package com.library.models;

import com.library.enums.Status;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class Book {
    private int id;
    private String title;
    private String author;
    private int quantity;
    private String genre;
    private String ISBN;
    private String publishDate;
    private Status status;

    public boolean isAvailable() {
        return status == Status.AVAILABLE && quantity > 0;
    }
}
