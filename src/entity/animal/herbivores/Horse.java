package entity.animal.herbivores;

import island.Region;
import lombok.Getter;
import lombok.Setter;
import entity.animal.Animal;

@Getter
@Setter
public class Horse extends Animal {
    private double satiety;

    public Horse() {
    }

    public Horse(Region region) {
        super(region);
    }

    public double getSatiety() {
        return satiety;
    }

    public void setSatiety(double satiety) {
        this.satiety = satiety;
    }
}