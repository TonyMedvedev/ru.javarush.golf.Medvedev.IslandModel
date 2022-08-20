package entity.animal.herbivores;

import entity.animal.Animal;
import island.Region;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Buffalo extends Animal {
    private double satiety;

    public Buffalo() {
    }

    public Buffalo(Region region) {
        super(region);
    }

    public double getSatiety() {
        return satiety;
    }

    public void setSatiety(double satiety) {
        this.satiety = satiety;
    }
}