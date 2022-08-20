package configuration;

import org.yaml.snakeyaml.Yaml;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;


public class Characteristic {
    private static final String PATH_CHARACTERISTICS =
            "IslandModel/src/configuration/Characteristics.yaml";
    private static final HashMap<String, Object> CHARACTERISTICS = mapper(PATH_CHARACTERISTICS);

    public static final HashMap<String, String> ICON = (HashMap<String, String>) CHARACTERISTICS.get("icon");
    public static final HashMap<String, Double> WEIGHT = (HashMap<String, Double>) CHARACTERISTICS.get("weight");
    public static final HashMap<String, Integer> MAX_COUNT_ENTITY = (HashMap<String, Integer>) CHARACTERISTICS.get("maxCountEntity");
    public static final HashMap<String, Integer> MAX_COUNT_STEP = (HashMap<String, Integer>) CHARACTERISTICS.get("maxCountStep");
    public static final HashMap<String, Double> MAX_SATIETY = (HashMap<String, Double>) CHARACTERISTICS.get("maxSatiety");
    public static final HashMap<String, Integer> SUCCESS_OF_REPRODUCE = (HashMap<String, Integer>) CHARACTERISTICS.get("successOfReproduce");
    public static final HashMap<String, HashMap<String, Integer>> CHANCE_OF_GETTING_FOOD = (HashMap<String, HashMap<String, Integer>>) CHARACTERISTICS.get("chanceOfGettingFood");


    private static <T> T mapper(String path) {
        Yaml yaml = new Yaml();
        try {
            InputStream in = Files.newInputStream(Paths.get(path).toAbsolutePath());
            return yaml.load(in);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
