package ie.yawer.sound;

public class App {

    public static void main(String[] args) {

        final int NUMBER_OF_BUTTONS = 26;

        SoundGenerator.setSound(NUMBER_OF_BUTTONS,10, 8, 50);

        new GuiGenerator(NUMBER_OF_BUTTONS).setVisible(true);
    }
}
