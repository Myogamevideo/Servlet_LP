package com.alexandre.servlet_tp3;

import java.util.List;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Alexandre
 */
@Stateful
public class DataService {

    @PersistenceContext(unitName = "samplePersistence")
    EntityManager entityManager;

    public List<Item> getListItem() {
        entityManager.persist(new Item());
        
        System.out.println("- Lecture de tous les articles -----------");
        List<Item> items = entityManager.createQuery("SELECT f FROM Item f", Item.class).getResultList();
        items.forEach(article -> {
            System.out.println(article);
        });
        return items;
    }

    public void addListItem(Item newArticle) {
        System.out.println("- Insertion d'un nouvel article ----------");
        entityManager.persist(newArticle);
    }

    public void removeListItem(Item newArticle) {
        System.out.println("- Suppression d'un article ---------------");
        entityManager.remove(newArticle);
    }

}
