package island;

import lombok.Getter;

import java.util.Objects;

@Getter
public class Coordinate {
    private int islandWidth;
    private int islandLenght;

    public Coordinate(int islandWidth, int islandLenght) {
        this.islandWidth = islandWidth;
        this.islandLenght = islandLenght;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Coordinate)) return false;
        Coordinate that = (Coordinate) o;
        return getIslandWidth() == that.getIslandWidth() && getIslandLenght() == that.getIslandLenght();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIslandWidth(), getIslandLenght());
    }
}
