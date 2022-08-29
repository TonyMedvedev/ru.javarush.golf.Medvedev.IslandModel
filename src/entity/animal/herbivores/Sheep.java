package entity.animal.herbivores;

import island.Region;
import lombok.Getter;
import lombok.Setter;
import entity.animal.Animal;

@Getter
@Setter
public class Sheep extends Animal {
    private double satiety;

    public Sheep() {
    }

    public Sheep(Region region) {
        super(region);
    }
}