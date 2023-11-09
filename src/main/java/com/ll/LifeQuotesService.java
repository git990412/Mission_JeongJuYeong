package com.ll;

import java.util.List;

public class LifeQuotesService {
    private final LifeQuotesRepository quotesRepository = new LifeQuotesRepository();

    public List<LifeQuotes> getAllQuotes() {
        return quotesRepository.getAllQuotes();
    }

    public LifeQuotes addQuote(String author, String quotes) {
        LifeQuotes newQuote = new LifeQuotes();
        newQuote.setAuthor(author);
        newQuote.setQuotes(quotes);
        quotesRepository.addQuote(newQuote);
        return newQuote;
    }

    public void deleteQuote(Long id) {
        quotesRepository.deleteQuote(id);
    }

    public LifeQuotes updateQuote(Long id, String author, String quotes) {
        return quotesRepository.updateQuote(id, author, quotes);
    }
}
