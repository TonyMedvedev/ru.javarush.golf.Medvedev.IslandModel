package entity.animal.predators;

import entity.animal.Animal;
import island.Region;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Fox extends Animal {
    private double satiety;

    public Fox() {
    }

    public Fox(Region region) {
        super(region);
    }
}