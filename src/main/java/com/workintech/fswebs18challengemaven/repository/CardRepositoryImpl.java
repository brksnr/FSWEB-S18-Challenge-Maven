package com.workintech.fswebs18challengemaven.repository;

import com.workintech.fswebs18challengemaven.Dao.CardRepository;
import com.workintech.fswebs18challengemaven.entity.Card;
import com.workintech.fswebs18challengemaven.exceptions.CardException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CardRepositoryImpl implements CardRepository {

    private final EntityManager entityManager;

    public CardRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public Card remove(Long id) {
        Card found = findById(id);
        entityManager.remove(found);
        return found;

    }

    @Override
    public Card findById(Long id) {
        return entityManager.find(Card.class, id);
    }

    @Override
    public Card update(Card card) {
       return entityManager.merge(card);

    }

    @Override
    public List<Card> findByType(String type) {
        TypedQuery<Card> query = entityManager.createQuery("SELECT c FROM Card c WHERE c.type = type", Card.class);
        query.setParameter("type", type);
        return query.getResultList();
    }

    @Override
    public List<Card> findByValue(Integer value) {
        TypedQuery<Card> query = entityManager.createQuery("SELECT c FROM Card c WHERE c.value = value", Card.class);
        query.setParameter("value", value);
        return query.getResultList();
    }

    @Override
    public List<Card> findAll() {
        TypedQuery<Card> query = entityManager.createQuery("SELECT c FROM Card c", Card.class);
        return query.getResultList();
    }

    @Override
    public List<Card> findByColor(String color) {
        TypedQuery<Card> query = entityManager.createQuery("SELECT c FROM Card c WHERE c.color = :color", Card.class);
        query.setParameter("color", color);

        if (color.isEmpty()) {
            throw new CardException("No cards found with color: " + color, HttpStatus.NOT_FOUND);
        }
        return query.getResultList();
    }

    @Override
    public Card save(Card card) {
        entityManager.persist(card);
        return card;
    }
}
