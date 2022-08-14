package ru.javarush.golf.Medvedev.IslandModel.entity.animal.predators;

import lombok.Getter;
import lombok.Setter;
import ru.javarush.golf.Medvedev.IslandModel.entity.animal.Animal;

@Getter
@Setter
public class Bear extends Animal {
    private double satiety;
}