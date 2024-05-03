import java.awt.Color;

public class CharacterProperties {
    private String font;
    private String color;
    private int size;

    public CharacterProperties(String font, String color, int size) {
        this.font = font;
        this.color = color;
        this.size = size;
    }

    public String getFont() {
        return font;
    }

    public Color getColor() {
        if (color.equals("Red")) {
            return Color.RED;
        } else if (color.equals("Blue")) {
            return Color.BLUE;
        } else if (color.equals("Black")) {
            return Color.BLACK;
        }
        return Color.BLACK;
    }

    public int getSize() {
        return size;
    }
}
