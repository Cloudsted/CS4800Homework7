import java.util.HashMap;
import java.util.Map;

public class CharacterPropertiesFactory {
    private static final Map<CharacterProperties, CharacterProperties> propertiesMap = new HashMap<>();

    public static CharacterProperties getProperties(String font, String color, int size) {
        CharacterProperties properties = new CharacterProperties(font, color, size);
        propertiesMap.putIfAbsent(properties, properties);
        return propertiesMap.get(properties);
    }
}