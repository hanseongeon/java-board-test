package org.example.domain.model;

import org.example.base.CommonUtill;
import org.example.domain.controller.ArticleController;

import java.util.ArrayList;

public class ArticleRepository {
    ArrayList<Article> articleList = new ArrayList<>();
    CommonUtill commonUtill = new CommonUtill();
    int articleNum = 4;
    public ArticleRepository(){
        makeTestList();
    }
    public void makeTestList(){
        Article a1 = new Article(1,"자바","공부", commonUtill.getCurrentTime(), 0);
        articleList.add(a1);
        Article a2 = new Article(2,"자바","시험", commonUtill.getCurrentTime(), 0);
        articleList.add(a2);
        Article a3 = new Article(3,"오늘은","금요일", commonUtill.getCurrentTime(), 0);
        articleList.add(a3);
    }
    public void saveArticle(String title,String content){
        Article article = new Article();
        article.setTitle(title);
        article.setContent(content);
        article.setRegDate(commonUtill.getCurrentTime());
        article.setId(articleNum);
        articleList.add(article);
        articleNum++;
    }
    public ArrayList<Article> findAll(){
        return articleList;
    }

    public Article findArticleById(int index){
        for(Article article : articleList){
            if(article.getId() == index){
                return article;
            }
        }
        return null;
    }

    public void updateArticle(Article article,String title,String content){
        article.setTitle(title);
        article.setContent(content);
        article.setRegDate(commonUtill.getCurrentTime());
    }

    public void deleteArticle(Article article){
        articleList.remove(article);
    }

    public ArrayList<Article> findKeywordByArticle(String keyword){
        ArrayList<Article> searchArticle = new ArrayList<>();
        for(Article article : articleList){
            if(article.getTitle().contains(keyword)){
                searchArticle.add(article);
            }
        }
        return searchArticle;
    }

    public void hitPlus(Article article){
        int hit = article.getHit();
        hit++;
        article.setHit(hit);
    }
}
