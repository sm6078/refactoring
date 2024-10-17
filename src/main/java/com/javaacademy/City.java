package com.javaacademy;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

/**
 * Город
 */
@AllArgsConstructor
@Getter
@ToString(exclude = {"peopleCount"})
public class City {
    @NonNull
    public final String name;
    @Setter
    public int peopleCount;

    public Garbage[] createGarbage() {
        return new Garbage[] {
            new Garbage(GarbageType.GLASS, 1000, this.name),
            new Garbage(GarbageType.PAPER, 15000, this.name),
            new Garbage(GarbageType.MIXED, 200000, this.name),
        };
    }
}
