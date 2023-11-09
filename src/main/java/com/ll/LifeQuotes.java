//LifeQuotes.java
package com.ll;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public @Data class LifeQuotes {
    private Long id;
    private String author;
    private String quotes;
}
