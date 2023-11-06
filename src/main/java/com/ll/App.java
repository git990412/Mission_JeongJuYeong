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


<<<<<<< HEAD
        try{
            lqList = objectMapper.readValue(new File("List.json"),
                    objectMapper.getTypeFactory().constructCollectionType(List.class, LifeQuotes.class));
        }catch (IOException e){
            e.printStackTrace();
        }
=======
>>>>>>> main

        System.out.println("== 명언 앱 ==");
        while (true){
            System.out.print("명령)");
<<<<<<< HEAD
            command = sc.next().trim();
=======
            command = sc.next();
>>>>>>> main

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
<<<<<<< HEAD

                        return;
                    }catch (IOException e){
                        e.printStackTrace();

                        return;
                    }
                default:
                    if(command.contains("삭제")){
                        int tempIdx = Integer.parseInt(command.split("=")[1]);

                        for(int i = 0; i < lqList.size(); i++){
                            if(lqList.get(i).getId() == tempIdx){
                                lqList.remove(i);
                                System.out.println(Integer.toString(tempIdx) + "번 명언이 삭제되었습니다.");
                            }
                            else{
                                System.out.println(Integer.toString(tempIdx) + "번 명언은 존재하지 않습니다.");
                            }
                        }
                    } else if (command.contains("수정")) {
                        int tempIdx = Integer.parseInt(command.split("=")[1]);
                        String prevQuotes = "";
                        String prevAuthor = "";

                        for(int i = 0; i < lqList.size(); i++){
                            if(lqList.get(i).getId() == tempIdx){
                                prevQuotes = lqList.get(i).getQuotes();
                                prevAuthor = lqList.get(i).getAuthor();
                            }
                        }

                        System.out.println("명언(기존) : " + prevQuotes);
                        System.out.print("명언 : ");
                        String tempQuotes = sc.next();

                        System.out.println("작가(기존) : " + prevAuthor);
                        System.out.print("작가 : ");
                        String tempAuthor = sc.next();

                        for(int i = 0; i < lqList.size(); i++){
                            if(lqList.get(i).getId() == tempIdx){
                                lqList.get(i).setQuotes(tempQuotes);
                                lqList.get(i).setAuthor(tempAuthor);
                                System.out.println(Integer.toString(tempIdx) + "번 명언이 수정되었습니다.");
                            }
                            else{
                                System.out.println(Integer.toString(tempIdx) + "번 명언은 존재하지 않습니다.");
                            }
                        }
                    }
=======
                    }catch (IOException e){
                        e.printStackTrace();
                    }
                default:

>>>>>>> main
            }
        }
    }
}
