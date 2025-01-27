package com.workintech.fswebs18challengemaven.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "value")
    private Integer value;
    @Column(name ="type")
    @Enumerated(EnumType.STRING)
    private Type type;
    @Enumerated(EnumType.STRING)
    @Column(name = "color")
    private Color color;


    public Card(long id, Integer value, Type type, Color color) {
        this.id = id;
        this.value = value;
        this.type = type;
        this.color = color;

        if(type == Type.JOKER){
            this.value = null;
            this.color = null;

        }else if(value != null){
            this.type = null;
            this.value = value;

        }else if(type != null){
            this.value = null;
            this.type = type;

        }else if(type != null && value != null){
            throw new IllegalArgumentException("A card cannot have both a type and a value.");
        }
    }
}
