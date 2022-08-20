package island;


import entity.Direction;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Island {


    private List<Region> regions = new ArrayList<>();
    private Coordinate maxCoordinates;


    public Island(int width, int length) {
        maxCoordinates = new Coordinate(width, length);
        generateRegions();
    }


    public List<Region> getRegions() {
        return regions;
    }

    private void generateRegions() {
        for (int i = 0; i < maxCoordinates.getIslandWidth(); i++) {
            for (int j = 0; j < maxCoordinates.getIslandLenght(); j++) {
                regions.add(new Region(new Coordinate(i, j),this));
            }
        }
    }

    public void bringAnimalToLive() {

        int CORE_POOL_SIZE = 4;
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(CORE_POOL_SIZE);
        while (!fixedThreadPool.isShutdown()) {
            for (Region region : regions) {
                fixedThreadPool.submit(region);
            }
            fixedThreadPool.shutdown();
        }
        fixedThreadPool.shutdown();
    }

    public Region getRegion(Region currentRegion, Direction direction, int step) {
        Coordinate coordinate = currentRegion.getCoordinate();
        Coordinate newCoordinate;
        switch (direction) {
            case UP -> {
                int newLenght = coordinate.getIslandLenght() + step;
                if (newLenght > 0 && newLenght < maxCoordinates.getIslandLenght()) {
                    newCoordinate = new Coordinate(coordinate.getIslandWidth(), newLenght);
                } else {
                    return currentRegion;
                }
            }
            case DOWN -> {
                int newLenght = coordinate.getIslandLenght() - step;
                if (newLenght > 0 && newLenght < maxCoordinates.getIslandLenght()) {
                    newCoordinate = new Coordinate(coordinate.getIslandWidth(), newLenght);
                } else {
                    return currentRegion;
                }
            }
            case LEFT -> {
                int newWidth = coordinate.getIslandWidth() - step;
                if (newWidth > 0 && newWidth < maxCoordinates.getIslandWidth()) {
                    newCoordinate = new Coordinate(newWidth, coordinate.getIslandLenght());
                } else {
                    return currentRegion;
                }
            }
            case RIGHT -> {
                int newWidth = coordinate.getIslandWidth() + step;
                if (newWidth > 0 && newWidth < maxCoordinates.getIslandWidth()) {
                    newCoordinate = new Coordinate(newWidth, coordinate.getIslandLenght());
                } else {
                    return currentRegion;
                }
            }
            case STAY -> {
                return currentRegion;
            }
            default -> throw new RuntimeException();
        }

        for (Region region : regions) {
            if (region.getCoordinate().equals(newCoordinate)) {
                return region;
            }
        }
        return null;
    }
////        return regions.stream().filter(region -> coordinate.equals(region.getCoordinate()));
}