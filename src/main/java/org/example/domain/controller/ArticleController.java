package org.example.domain.controller;

import org.example.base.CommonUtill;
import org.example.domain.model.Article;
import org.example.domain.model.ArticleRepository;
import org.example.domain.view.ArticleView;

import java.util.ArrayList;
import java.util.Scanner;

public class ArticleController {
    ArticleRepository articleRepository = new ArticleRepository();
    ArticleView articleView = new ArticleView();
    CommonUtill commonUtill = new CommonUtill();
    Scanner sc = commonUtill.getScanner();

    public void add(){
        System.out.print("게시물 제목을 입력해주세요 : ");
        String title = sc.nextLine();
        System.out.print("게시물 내용을 입력해주세요 : ");
        String content = sc.nextLine();

        articleRepository.saveArticle(title,content);
        System.out.println("게시물이 등록되었습니다.");
    }
    public void list(){
        ArrayList<Article> articles = articleRepository.findAll();
        articleView.listArticle(articles);
    }
    public void update(){
        System.out.print("수정할 게시물 번호 : ");
        int index = getParmIndex(sc.nextLine());
        if(index == -1){
            return;
        }
        Article article = articleRepository.findArticleById(index);
        if(article == null){
            System.out.println("없는 게시물 번호입니다.");
            return;
        }

        System.out.print("제목 : ");
        String setTitle = sc.nextLine();
        System.out.print("내용 : ");
        String setContent = sc.nextLine();

        articleRepository.updateArticle(article,setTitle,setContent);
        System.out.printf("%d번 게시물이 수정되었습니다.\n",article.getId());
    }

    public void delete(){
        System.out.print("삭제할 게시물 번호 : ");
        int index = getParmIndex(sc.nextLine());
        if(index == -1){
            return;
        }
        Article article = articleRepository.findArticleById(index);
        if(article == null){
            System.out.println("없는 게시물 번호입니다.");
            return;
        }
        articleRepository.deleteArticle(article);
        System.out.printf("%d번 게시물이 삭제되었습니다.\n",article.getId());
    }
    public void detail(){
        System.out.print("상세보기 할 게시물 번호를 입력해주세요 : ");
        int index = getParmIndex(sc.nextLine());
        if(index == -1){
            return;
        }
        Article article = articleRepository.findArticleById(index);
        if(article == null){
            System.out.println("존재하지 않는 게시물 번호입니다.");
            return;
        }
        articleRepository.hitPlus(article);
        articleView.detailArticle(article);
    }
    public void search(){
        System.out.print("검색 키워드를 입력해주세요 : ");
        String keyword = sc.nextLine();
        ArrayList<Article> articles = articleRepository.findKeywordByArticle(keyword);
        if(articles == null){
            System.out.println("검색 결과가 없습니다.");
            return;
        }
        articleView.listArticle(articles);
    }



    public int getParmIndex(String num){
        try{
            return Integer.parseInt(num);
        }catch (NumberFormatException e){
            System.out.println("숫자를 입력하세요");
            return -1;
        }
    }
}
