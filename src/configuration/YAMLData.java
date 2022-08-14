package configuration;

import org.yaml.snakeyaml.Yaml;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;


public class YAMLData {
    private static final String PATH_ENTITY_FOOD =
            "Island/src/configuration/entityFood.yaml";
    private static final String PATH_MAX_COUNT_ENTITY =
            "Island/src/configuration/maxCountEntity.yaml";
    private static final String PATH_ICON =
            "Island/src//configuration/icon.yaml";
    public static final HashMap<String, HashMap<String, Integer>> entityFoodMap = mapper(PATH_ENTITY_FOOD);
    public static final HashMap<String, Integer> MAX_COUNT_ENTITY = mapper(PATH_MAX_COUNT_ENTITY);
    public static final HashMap<String, String> ICON = mapper(PATH_ICON);


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
