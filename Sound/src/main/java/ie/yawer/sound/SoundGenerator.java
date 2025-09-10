package ie.yawer.sound;

import javax.sound.midi.*;

public class SoundGenerator {

    static int numberOfButtons;
    static int instrumentNumber;
    static int midiChannelNumber;
    static int keyVelocity;

    static void setSound(int setNumberOfButtons,
                     int setInstrumentNumber,
                     int setMidiChannelNumber,
                     int setKeyVelocity){
        numberOfButtons = setNumberOfButtons;
        instrumentNumber = setInstrumentNumber;
        midiChannelNumber = setMidiChannelNumber;
        keyVelocity = setKeyVelocity;
    };

    private final int KEY_NOTE_NUMBER;

    static MidiChannel[] midChannel;

    static {

        try {
            Synthesizer syn = MidiSystem.getSynthesizer();
            syn.open();
            midChannel = syn.getChannels();

            Instrument[] instrument = syn.getDefaultSoundbank().getInstruments();
            syn.loadInstrument(instrument[instrumentNumber]);
            System.out.println("Static block done");
        } catch (MidiUnavailableException ex) {
            ex.printStackTrace();
        }
    }

    public SoundGenerator(int keyNoteNumber) {
        int interval = 108 / (numberOfButtons + 1);
        this.KEY_NOTE_NUMBER =  (keyNoteNumber + 1) * interval;
        System.out.println(this.toString());
    }

    public void makeASound() {
        midChannel[midiChannelNumber].noteOn(this.KEY_NOTE_NUMBER,keyVelocity);
    }

    @Override
    public String toString() {
        return "numberOfButtons: " + numberOfButtons +
                "\ninstrumentNumber: " + instrumentNumber +
                "\nmidiChannelNumber: " + midiChannelNumber +
                "\nkeyVelocity: " + keyVelocity +
                "\nkeyNoteNumber: " + KEY_NOTE_NUMBER;
    }
}
