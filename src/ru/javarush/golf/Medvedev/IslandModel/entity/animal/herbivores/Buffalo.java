package ru.javarush.golf.Medvedev.IslandModel.entity.animal.herbivores;

import lombok.Getter;
import lombok.Setter;
import ru.javarush.golf.Medvedev.IslandModel.entity.animal.Animal;

@Getter
@Setter
public class Buffalo extends Animal {
    private double satiety;
}