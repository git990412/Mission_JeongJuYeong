package com.ll;

import lombok.Data;
<<<<<<< HEAD
import lombok.NoArgsConstructor;

@NoArgsConstructor
=======

>>>>>>> main
public @Data class LifeQuotes {
    private int id;
    private String author;
    private String quotes;

    public LifeQuotes(int id, String author, String quotes){
        this.id = id;
        this.author = author;
        this.quotes = quotes;
    }
}
