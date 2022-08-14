package ru.javarush.golf.Medvedev.IslandModel.entity.animal.predators;

import lombok.Getter;
import lombok.Setter;
import ru.javarush.golf.Medvedev.IslandModel.entity.animal.Animal;
import ru.javarush.golf.Medvedev.IslandModel.island.Region;

@Getter
@Setter
public class Wolf extends Animal {
    private double satiety;

    public Wolf() {
    }

    public Wolf(Region region) {
        super(region);
    }

    public double getSatiety() {
        return satiety;
    }

    public void setSatiety(double satiety) {
        this.satiety = satiety;
    }
}