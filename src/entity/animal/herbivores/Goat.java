package entity.animal.herbivores;

import island.Region;
import lombok.Getter;
import lombok.Setter;
import entity.animal.Animal;

@Getter
@Setter
public class Goat extends Animal {
    private double satiety;

    public Goat() {
    }

    public Goat(Region region) {
        super(region);
    }
}