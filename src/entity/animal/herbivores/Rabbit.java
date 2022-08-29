package entity.animal.herbivores;

import island.Region;
import lombok.Getter;
import lombok.Setter;
import entity.animal.Animal;

@Getter
@Setter
public class Rabbit extends Animal {
    private double satiety;

    public Rabbit() {
    }

    public Rabbit(Region region) {
        super(region);
    }
}