package org.example.base;

import org.example.domain.controller.ArticleController;

import java.util.Scanner;

public class BoardApp {
    ArticleController articleController = new ArticleController();
    CommonUtill commonUtill = new CommonUtill();
    Scanner sc = commonUtill.getScanner();
    public void run(){
        while(true){
            System.out.print("명령어 : ");
            String cmd = sc.nextLine();
            if(cmd.equals("exit")){
                System.out.println("시스템을 종료합니다.");
                break;
            }else if(cmd.equals("add")){
                articleController.add();
            }else if(cmd.equals("list")){
                articleController.list();
            }else if(cmd.equals("update")){
                articleController.update();
            }else if(cmd.equals("delete")){
                articleController.delete();
            }else if(cmd.equals("detail")){
                articleController.detail();
            }else if(cmd.equals("search")){
                articleController.search();
            }
        }
    }
}
