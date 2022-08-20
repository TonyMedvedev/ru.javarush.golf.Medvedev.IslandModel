package entity.animal.herbivores;

import island.Region;
import lombok.Getter;
import lombok.Setter;
import entity.animal.Animal;

@Getter
@Setter
public class Mouse extends Animal {
    private double satiety;

    public Mouse() {
    }

    public Mouse(Region region) {
        super(region);
    }

    public double getSatiety() {
        return satiety;
    }

    public void setSatiety(double satiety) {
        this.satiety = satiety;
    }
}