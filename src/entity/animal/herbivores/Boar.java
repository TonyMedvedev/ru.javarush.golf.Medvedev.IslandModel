package entity.animal.herbivores;

import island.Region;
import lombok.Getter;
import lombok.Setter;
import entity.animal.Animal;

@Getter
@Setter
public class Boar extends Animal {
    private double satiety;

    public Boar() {
    }

    public Boar(Region region) {
        super(region);
    }
}