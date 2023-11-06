package com.ll;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    static void run(){
        Scanner sc = new Scanner(System.in);
        List<LifeQuotes> lqList = new ArrayList<>();
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        String command = "";
        String quotes = "";
        String author = "";



        System.out.println("== 명언 앱 ==");
        while (true){
            System.out.print("명령)");
            command = sc.next();

            switch (command){
                case "등록":
                    System.out.print("명언 : ");
                    quotes = sc.next();

                    System.out.print("작가 : ");
                    author = sc.next();

                    lqList.add(new LifeQuotes(lqList.size() + 1, author, quotes));

                    int index = lqList.size();
                    System.out.println(Integer.toString(index) + "번 명언이 등록되었습니다.");

                    break;
                case "목록":
                    System.out.println("번호 / 작가 / 명언");
                    System.out.println("----------------------");

                    for (LifeQuotes temp : lqList) {
                        String idx = Integer.toString(temp.getId());
                        System.out.println(idx + " / " + temp.getAuthor() + " / " + temp.getQuotes());
                    }

                    break;
                case "종료":
                    try{
                        objectMapper.writeValue(new File("List.json"), lqList);
                    }catch (IOException e){
                        e.printStackTrace();
                    }
                default:

            }
        }
    }
}
