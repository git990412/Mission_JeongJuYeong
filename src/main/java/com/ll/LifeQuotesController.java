package com.ll;

import java.util.List;
import java.util.Scanner;

public class LifeQuotesController {
    private final LifeQuotesService quotesService = new LifeQuotesService();
    private final Scanner scanner = new Scanner(System.in);

    public void run() {
        System.out.println("== 명언 앱 ==");
        while (true) {
            System.out.print("명령) ");
            String command = scanner.next().trim();
            
            if(command.equals("목록")){
                displayQuotes();
            } else if (command.equals("등록")) {
                addQuote();
            } else if (command.equals("종료")) {
                return;
            } else if (command.contains("삭제")) {
                long idx = Integer.parseInt(command.split("=")[1]);
                deleteQuote(idx);
            } else if (command.contains("수정")) {
                long idx = Integer.parseInt(command.split("=")[1]);
                updateQuote(idx);
            }
        }
    }

    private void displayQuotes() {
        List<LifeQuotes> quotesList = quotesService.getAllQuotes();
        System.out.println("번호 / 작가 / 명언");
        System.out.println("----------------------");
        for (LifeQuotes quote : quotesList) {
            System.out.println(quote.getId() + " / " + quote.getAuthor() + " / " + quote.getQuotes());
        }
    }

    private void addQuote() {
        System.out.print("작가: ");
        String author = scanner.next().trim();
        System.out.print("명언: ");
        String quotes = scanner.next().trim();

        LifeQuotes newQuote = quotesService.addQuote(author, quotes);
        System.out.println(newQuote.getId() + "번 명언이 등록되었습니다.");
    }

    private void deleteQuote(Long id) {
        quotesService.deleteQuote(id);
        System.out.println(id + "번 명언이 삭제되었습니다.");
    }

    private void updateQuote(Long id) {
        System.out.print("새로운 작가: ");
        String author = scanner.next().trim();
        System.out.print("새로운 명언: ");
        String quotes = scanner.next().trim();

        LifeQuotes updatedQuote = quotesService.updateQuote(id, author, quotes);
        if (updatedQuote != null) {
            System.out.println(id + "번 명언이 수정되었습니다.");
        } else {
            System.out.println(id + "번 명언이 존재하지 않습니다.");
        }
    }
}
