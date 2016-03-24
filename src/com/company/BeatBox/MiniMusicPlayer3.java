package com.company.BeatBox;

import javax.sound.midi.*;
import javax.swing.*;
import java.awt.*;

/**
 * Created by Андрей on 24.03.2016.
 */
public class MiniMusicPlayer3 {
    //рисование графики в такт музыки
    static JFrame f = new JFrame("Фигуры под музыку");
    static MyDrawePanel ml;

    public static void main(String[] args) {
        MiniMusicPlayer3 mini = new MiniMusicPlayer3();
        mini.go();

    }
    public void setUpGui(){
        ml = new MyDrawePanel();
        f.setContentPane(ml);
        f.setBounds(30,30,300,300);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    private void go() {
        setUpGui();

        try {
            Sequencer sequencer = MidiSystem.getSequencer();
            sequencer.open();
            int[] eventsIWait = {127};
            sequencer.addControllerEventListener(ml, eventsIWait);
            Sequence seq = new Sequence(Sequence.PPQ, 4);
            Track track = seq.createTrack();

            int r = 0;
            for (int i = 0; i < 60; i+=4){
                r = (int)((Math.random()*50)+1);
                track.add(makeEvent(144, 1, r, 100, i));
                track.add(makeEvent(176, 1, 127, 0, i));
                track.add(makeEvent(128, 1, r, 100, i+2));
            }

            sequencer.setSequence(seq);
            sequencer.start();
            sequencer.setTempoInBPM(120);
        } catch (MidiUnavailableException e) {
            e.printStackTrace();
        } catch (InvalidMidiDataException e) {
            e.printStackTrace();
        }
    }
    public static MidiEvent makeEvent(int comd, int chan, int one, int two, int tick){
        MidiEvent event = null;
        try {
            ShortMessage a = new ShortMessage();
            a.setMessage(comd, chan, one, two);
            event = new MidiEvent(a, tick);
        } catch (InvalidMidiDataException e) {
            e.printStackTrace();
        }
        return event;
    }

    class MyDrawePanel extends JPanel implements ControllerEventListener {
        boolean msg = false;

        @Override
        public void controlChange(ShortMessage event) {
            msg = true;
            repaint();
        }

        public void paintComponent(Graphics g){
            if (msg){
                Graphics2D g2 = (Graphics2D) g;
                int r = (int)(Math.random()*250);
                int gr = (int)(Math.random()*250);
                int b = (int)(Math.random()*250);

                g.setColor(new Color(r+b+gr));

                int height = (int)((Math.random()*120)+10);
                int weight = (int)((Math.random()*120)+10);
                int x = (int)((Math.random()*40)+10);
                int y = (int)((Math.random()*40)+10);

                g.fillRect(x,y,height,weight);
                msg = false;
            }
        }

    }
}
