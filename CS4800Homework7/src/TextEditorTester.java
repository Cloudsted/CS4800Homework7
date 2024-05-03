public class TextEditorTester {
    public static void main(String[] args) {
        CharacterProperties props1 = CharacterPropertiesFactory.getProperties("Arial", "Red", 12);
        CharacterProperties props2 = CharacterPropertiesFactory.getProperties("Calibri", "Blue", 14);
        CharacterProperties props3 = CharacterPropertiesFactory.getProperties("Verdana", "Black", 16);
        CharacterProperties props4 = CharacterPropertiesFactory.getProperties("Arial", "Black", 16);
    }
}