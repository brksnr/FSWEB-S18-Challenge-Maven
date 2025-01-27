package com.workintech.fswebs18challengemaven.Dao;

import com.workintech.fswebs18challengemaven.entity.Card;

import java.util.List;

public interface CardRepository {


    public Card save(Card card);

    List<Card> findByColor(String color);

    public Card findById(Long id);

    List<Card> findAll();

    List<Card> findByValue(Integer value);

    List<Card> findByType(String type);


    public Card update(Card card);

    public Card remove(Long id);
}
