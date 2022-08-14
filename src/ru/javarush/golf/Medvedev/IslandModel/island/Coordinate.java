package ru.javarush.golf.Medvedev.IslandModel.island;

import lombok.Getter;

@Getter
public class Coordinate {
    private int islandWidth;
    private int islandLenght;

    public Coordinate(int islandWidth, int islandLenght) {
        this.islandWidth = islandWidth;
        this.islandLenght = islandLenght;
    }
}
