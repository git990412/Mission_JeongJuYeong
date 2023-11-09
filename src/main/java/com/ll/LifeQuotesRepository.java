package com.ll;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LifeQuotesRepository {
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final File jsonFile = new File("quotes.json");
    private List<LifeQuotes> quotesList;

    public LifeQuotesRepository() {
        loadQuotes();
    }

    private void loadQuotes() {
        try {
            quotesList = objectMapper.readValue(jsonFile, new TypeReference<List<LifeQuotes>>() {});
        } catch (IOException e) {
            e.printStackTrace();
            quotesList = new ArrayList<>();
        }
    }

    public List<LifeQuotes> getAllQuotes() {
        return Collections.unmodifiableList(quotesList);
    }

    public void addQuote(LifeQuotes newQuote) {
        if (quotesList == null) {
            quotesList = new ArrayList<>();
        }
        newQuote.setId((long) (quotesList.size() + 1));
        quotesList.add(newQuote);
        saveQuotes(); // 변경된 명언을 즉시 저장
    }

    public void deleteQuote(Long id) {
        quotesList.removeIf(quote -> quote.getId().equals(id));
        saveQuotes(); // 변경된 명언을 즉시 저장
    }

    public LifeQuotes updateQuote(Long id, String author, String quotes) {
        for (LifeQuotes quote : quotesList) {
            if (quote.getId().equals(id)) {
                quote.setAuthor(author);
                quote.setQuotes(quotes);
                saveQuotes(); // 변경된 명언을 즉시 저장
                return quote;
            }
        }
        return null;
    }

    private void saveQuotes() {
        try {
            objectMapper.writeValue(jsonFile, quotesList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
