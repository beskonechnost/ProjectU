package com.company.BeatBox;

import javax.sound.midi.*;


/**
 * Created by Андрей on 03.03.2016.
 */
public class MusicText1 {
    public void play() {
        try {
            Sequencer sequencer = MidiSystem.getSequencer();
            System.out.println("Получен синтезатор!");
            sequencer.open();
            Sequence seq = new Sequence(Sequence.PPQ, 4);

            Track track = seq.createTrack();
            ShortMessage sm1 = new ShortMessage();
            sm1.setMessage(144, 1, 44, 100);
            MidiEvent noteOn1 = new MidiEvent(sm1, 1);
            track.add(noteOn1);
            ShortMessage sm2 = new ShortMessage();
            sm2.setMessage(128, 1, 44, 100);
            MidiEvent noteOn2 = new MidiEvent(sm2, 16);
            track.add(noteOn2);

            sequencer.setSequence(seq);
            sequencer.start();

        }
        catch (Exception ex){
            System.out.println("Неудача!");
        }

    }

    public static void main(String[] args) {
        MusicText1 mt = new MusicText1();
        mt.play();
    }
}
