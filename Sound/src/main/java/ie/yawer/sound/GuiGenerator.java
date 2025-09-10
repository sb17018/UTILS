package ie.yawer.sound;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiGenerator extends JFrame {

    public GuiGenerator(int numberOfButtons) {
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        for (int i = 0; i < numberOfButtons; i++) {
            String markOnButton = String.valueOf((char)(i + 65));
            JButton button = new JButton(markOnButton);
            SoundGenerator sound = new SoundGenerator(i);
            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    sound.makeASound();
                }
            });
            panel.add(button);
        }
        this.add(panel);
        this.pack();
    }
}
