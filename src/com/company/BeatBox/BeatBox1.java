package com.company.BeatBox;

import javax.sound.midi.*;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

/**
 * Created by Андрей on 07.04.2016.
 */
public class BeatBox1 implements Serializable{
    JPanel mainPanel;
    Sequencer sequencer;
    Sequence sequence;
    ArrayList<JCheckBox> checkboxList;
    Track track;
    JFrame theFrame;
    String[] instrumentNames = {"Bass Drum", "Closet Hi-Hat","Open Hi-Hat","Acoustic Snare",
    "Crash Cymbal","Hard Clap","High Tom","Hi Bongo","Maracas","Whistle","Low Conga",
    "Cowbell","Vibraslap","Low-mid Tom","High Agogo","Open Hi Conga"};
    int[] instruments = {35,42,46,38,49,39,50,60,70,72,64,56,58,47,67,63};

    public static void main(String[] args) {
        new BeatBox1().bildGUI();
    }

    private void bildGUI() {
        theFrame = new JFrame("Cuber BeatBox");
        theFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        BorderLayout layout = new BorderLayout();
        JPanel background = new JPanel(layout);
        background.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

        checkboxList = new ArrayList<JCheckBox>();
        Box buttonBox = new Box(BoxLayout.Y_AXIS);

        JButton start = new JButton("Start");
        start.addActionListener(new MyStartListener());
        buttonBox.add(start);
        buttonBox.add(Box.createVerticalStrut(7));

        JButton stop = new JButton("Stop");
        stop.addActionListener(new MyStopListener());
        buttonBox.add(stop);
        buttonBox.add(Box.createVerticalStrut(7));

        JButton upTempo = new JButton("Tempo up");
        upTempo.addActionListener(new MyUpTempoListener());
        buttonBox.add(upTempo);
        buttonBox.add(Box.createVerticalStrut(7));

        JButton downTempo = new JButton("Tempo down");
        downTempo.addActionListener(new MyDownTempoListener());
        buttonBox.add(downTempo);
        buttonBox.add(Box.createVerticalStrut(7));

        JButton serializeIt = new JButton("Serialize It");
        serializeIt.addActionListener(new MySendListener());
        buttonBox.add(serializeIt);
        buttonBox.add(Box.createVerticalStrut(7));

        JButton restore = new JButton("Restore");
        restore.addActionListener(new MyRearInListener());
        buttonBox.add(restore);
        buttonBox.add(Box.createVerticalStrut(7));

        Box nameBox = new Box(BoxLayout.Y_AXIS);
        for (int i = 0; i<instrumentNames.length; i++){
            nameBox.add(new JLabel(instrumentNames[i]));
            nameBox.add(Box.createVerticalStrut(7));
        }
        background.add(BorderLayout.EAST,buttonBox);
        background.add(BorderLayout.WEST, nameBox);

        theFrame.getContentPane().add(background);

        GridLayout grid = new GridLayout(16, 16);
        grid.setVgap(1);
        grid.setHgap(2);
        mainPanel = new JPanel(grid);
        background.add(BorderLayout.CENTER,mainPanel);

        for (int i = 0; i<256; i++){
            JCheckBox c = new JCheckBox();
            c.setSelected(false);
            checkboxList.add(c);
            mainPanel.add(c);
        }

        setUpMidi();

        theFrame.setBounds(50,50,300,300);
        theFrame.pack();
        theFrame.setVisible(true);

    }

    private void setUpMidi() {
        try {
            sequencer = MidiSystem.getSequencer();
            sequencer.open();
            sequence = new Sequence(Sequence.PPQ,4);
            track = sequence.createTrack();
            sequencer.setTempoInBPM(120);
        } catch (MidiUnavailableException e) {
            e.printStackTrace();
        } catch (InvalidMidiDataException e) {
            e.printStackTrace();
        }
    }


    private class MyStartListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            bildTrackAndStart();
        }

        private void bildTrackAndStart() {
            int[] trackList = null;
            sequence.deleteTrack(track);
            track = sequence.createTrack();
            for (int i = 0; i < 16; i++){
                trackList = new int[16];
                int key = instruments[i];
                for(int j = 0; j < 16; j++){
                    JCheckBox jc = checkboxList.get(j+(16*i));
                    if (jc.isSelected()){
                        trackList[j] = key;
                    } else{
                        trackList[j] = 0;
                    }
                }
                makeTrack(trackList);
                track.add(makeEvent(176,1,127,0,16));
            }
            track.add(makeEvent(192,9,1,0,15));
                    try{
                       sequencer.setSequence(sequence);
                        sequencer.setLoopCount(sequencer.LOOP_CONTINUOUSLY);
                        sequencer.start();
                        sequencer.setTempoInBPM(120);
                    } catch (InvalidMidiDataException e) {
                        e.printStackTrace();
                    }
        }
    }

    private void makeTrack(int[] list) {
        for (int i = 0; i < 16; i++){
            int key = list[i];
            if (key != 0){
                track.add(makeEvent(144,9,key,100,i));
                track.add(makeEvent(144,9,key,100,i+1));
            }
        }
    }

    private MidiEvent makeEvent(int comd, int chan, int one, int two, int tick) {
        MidiEvent event = null;
        try{
            ShortMessage a = new ShortMessage();
            a.setMessage(comd,chan,one,two);
            event = new MidiEvent(a,tick);
        } catch (InvalidMidiDataException e) {
            e.printStackTrace();
        }
        return event;
    }

    private class MyStopListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            sequencer.stop();
        }
    }

    private class MyUpTempoListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            float tempoFactor = sequencer.getTempoFactor();
            sequencer.setTempoFactor((float)(tempoFactor*1.03));
        }
    }

    private class MyDownTempoListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            float tempoFactor = sequencer.getTempoFactor();
            sequencer.setTempoFactor((float)(tempoFactor*0.97));
        }
    }

    private class MySendListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            boolean[] chetBoxState = new boolean[256];
            for(int i = 0; i < 256; i++){
                JCheckBox s = checkboxList.get(i);
                if (s.isSelected()){
                    chetBoxState[i] = true;
                }
            }
            JFileChooser fc = new JFileChooser();
            if (fc.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
                try {
                    FileOutputStream fileStream = new FileOutputStream(fc.getSelectedFile());
                    ObjectOutputStream os = new ObjectOutputStream(fileStream);
                    os.writeObject(chetBoxState);
                }
                catch (Exception e2) {
                    System.out.println("Что-то пошло не так...");
                }
            }
        }
    }

    private class MyRearInListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            boolean[] chetBoxState = null;
            JFileChooser jfc = new JFileChooser();
            if(jfc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                try {
                    FileInputStream fis = new FileInputStream(jfc.getSelectedFile());
                    ObjectInputStream ois = new ObjectInputStream(fis);
                    chetBoxState = (boolean[]) ois.readObject();
                } catch (FileNotFoundException e1) {
                    e1.printStackTrace();
                } catch (IOException e1) {
                    e1.printStackTrace();
                } catch (ClassNotFoundException e1) {
                    e1.printStackTrace();
                }
            }
            for (int i = 0; i < 256; i++){
                if(chetBoxState[i]){
                    checkboxList.get(i).setSelected(true);
                } else checkboxList.get(i).setSelected(false);
            }
            sequencer.stop();
            new MyStartListener();
        }
    }
}
