/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jarry.jsp.tp.two.data;

import com.jarry.jsp.tp.two.model.Article;
import java.util.ArrayList;

/**
 *
 * @author aj-al
 */
public class ArticleStub {
    public static ArrayList<Article> getAll() {
        ArrayList<Article> articles = new ArrayList<>();
        articles.add(new Article(123, "Article 1", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua."));
        articles.add(new Article(456, "Article 2", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua."));
        articles.add(new Article(789, "Article 3", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua."));
 
        return articles;
    }
}
