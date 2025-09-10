package ie.yawer.sound;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.sound.midi.Instrument;
import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Synthesizer;
import javax.swing.*;

public class Sound extends JFrame{
    Synthesizer syn;
    MidiChannel[] midChannel;
    Instrument[] instrument;

    public Sound() {

        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        List<JButton> listOfBtns = new ArrayList<>();
        JButton button1 = new JButton("A");
        JButton button2 = new JButton("B");
        JButton button3 = new JButton("C");
        this.add(panel);
        panel.add(button1);
        panel.add(button2);
        panel.add(button3);
        listOfBtns.add(button1);
        listOfBtns.add(button2);
        listOfBtns.add(button3);
        this.pack();

        try {
            syn = MidiSystem.getSynthesizer();
            syn.open();
            midChannel = syn.getChannels();

            instrument = syn.getDefaultSoundbank().getInstruments();
            syn.loadInstrument(instrument[90]);

            for(JButton button : listOfBtns){
                button.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        makeASound(listOfBtns.indexOf(button));
                    }
                });
            }

        } catch (MidiUnavailableException ex) {
            ex.printStackTrace();
        }
    }

    void makeASound(int sound) {
        switch(sound){
            case 0: this.midChannel[5].noteOn(55,200);
            break;
            case 1: this.midChannel[5].noteOn(70,200);
                break;
            case 2: this.midChannel[5].noteOn(85,200);
                break;
        }
    }
}
