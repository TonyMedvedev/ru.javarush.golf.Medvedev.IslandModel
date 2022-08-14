package entity.animal.predators;

import entity.animal.Animal;
import lombok.Getter;
import lombok.Setter;
import island.Region;

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