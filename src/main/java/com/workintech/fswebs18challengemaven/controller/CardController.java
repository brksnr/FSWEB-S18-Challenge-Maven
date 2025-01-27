package com.workintech.fswebs18challengemaven.controller;


import com.workintech.fswebs18challengemaven.Dao.CardRepository;
import com.workintech.fswebs18challengemaven.entity.Card;
import com.workintech.fswebs18challengemaven.exceptions.CardException;
import com.workintech.fswebs18challengemaven.repository.CardValidation;
import jakarta.persistence.PreUpdate;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cards")
@Slf4j
@Getter
public class CardController {

    private final CardRepository cardRepository;

    @Autowired
    public CardController(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    @Autowired


    @GetMapping
    public List<Card> findAll(){
        return cardRepository.findAll();
    }

    @PutMapping
    public Card update(@RequestBody Card card){
        return cardRepository.update(card);
    }

    @DeleteMapping("/{id}")
    public Card remove(@RequestBody Long id){
        return cardRepository.remove(id);
    }

    @GetMapping("/byColor/{color}")
    public List<Card> findByColor(@RequestBody String color){
        return cardRepository.findByColor(color);
    }

    @PostMapping
    public Card save(Card card){
        return cardRepository.save(card);
    }

    @GetMapping("/byValue/{value}")
    public List<Card> getByValue(Integer value){
        return cardRepository.findByValue(value);
    }

    @GetMapping("/byType/{type}")
    public List<Card> findByType(@PathVariable String type) {
        return cardRepository.findByType(type);
    }


}
