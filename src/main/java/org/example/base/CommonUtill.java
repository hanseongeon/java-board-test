package org.example.base;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class CommonUtill {
    Scanner sc = new Scanner(System.in);
    public Scanner getScanner(){
        return sc;
    }

    public String getCurrentTime(){

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm:ss");
        String regTime = now.format(formatter);
        return regTime;
    }
}
