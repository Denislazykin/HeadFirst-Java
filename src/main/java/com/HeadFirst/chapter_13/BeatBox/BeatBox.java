package main.java.com.HeadFirst.chapter_13.BeatBox;

import javax.sound.midi.*;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

public class BeatBox {
    JPanel mainPanel;
    ArrayList<JCheckBox> checkBoxList; //для хранения флажков
    Sequencer sequencer;
    Sequence sequence;
    Track track;
    JFrame theFrame;
    // Названия инструментов для создания меток в пользовательском интерфейсе
    String[] instrumentNames = {"Bass Drum", "Closed Hi-Hat", "Open Hi-Hat", "Acoustic Snare", "Crash Cymbal",
            "Hand Clap", "High Tom", "Hi Bongo", "Maracas", "Whistle", "Low Conga", "Cowbell", "Vibraslap",
            "Low-mid Tom", "High Agogo", "Open Hi Conga"};
    // числа представляют собой барабанные клавиши
    int[] instruments = {35, 42, 46, 38, 49, 39, 50, 60, 70, 72, 64, 56, 58, 47, 67, 63};

    public static void main(String[] args) {
        new BeatBox().buildGUI();
    }

    public void buildGUI() {
        theFrame = new JFrame("Cyber BeatBox");
        theFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        BorderLayout layout = new BorderLayout();
        JPanel background = new JPanel(layout);
        // пустая граница позволяет создать поля между краями панели и местом размещения компонентов
        background.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        checkBoxList = new ArrayList<JCheckBox>();
        Box buttonBox = new Box(BoxLayout.Y_AXIS);

        JButton start = new JButton("Start");
        start.addActionListener(new MyStartListener());
        buttonBox.add(start);

        JButton stop = new JButton("Stop");
        stop.addActionListener(new MyStopListener());
        buttonBox.add(stop);

        JButton upTempo = new JButton("Tempo Up");
        upTempo.addActionListener(new MyUpTempoListener());
        buttonBox.add(upTempo);

        JButton downTempo = new JButton("Tempo Down");
        downTempo.addActionListener(new MyDownTempoListener());
        buttonBox.add(downTempo);

        JButton setRandom = new JButton("Set Random");
        setRandom.addActionListener(new SetRandomListener());
        buttonBox.add(setRandom);

        JButton clear = new JButton("Clear");
        clear.addActionListener(new ClearListener());
        buttonBox.add(clear);

        JButton serialiseIt = new JButton("SerialiseIt");
        serialiseIt.addActionListener(new MySentListener());
        buttonBox.add(serialiseIt);

        JButton restore = new JButton("Restore");
        restore.addActionListener(new MyReadInListener());
        buttonBox.add(restore);


        Box nameBox = new Box(BoxLayout.Y_AXIS);
        for (int i = 0; i < 16; i++) {
            nameBox.add(new Label(instrumentNames[i]));
        }

        background.add(BorderLayout.EAST, buttonBox);
        background.add(BorderLayout.WEST, nameBox);

        theFrame.getContentPane().add(background);

        GridLayout grid = new GridLayout(16, 16);
        grid.setVgap(1);
        grid.setHgap(2);
        mainPanel = new JPanel(grid);
        background.add(BorderLayout.CENTER, mainPanel);

        for (int i = 0; i < 256; i++) {
            JCheckBox c = new JCheckBox(); // создаем флажки
            c.setSelected(false);   // присваиваем значение - не установлен
            checkBoxList.add(c);    // добавляем их в массив
            mainPanel.add(c);   // добавляем на панель
        }
        setUpMidi();

        theFrame.setBounds(50, 50, 300, 300);
        theFrame.pack();
        theFrame.setVisible(true);
    }

    public void setUpMidi() {
        try { // получаем синтезатор, секвенсор и дорожки
            sequencer = MidiSystem.getSequencer();
            sequencer.open();
            sequence = new Sequence(Sequence.PPQ, 4); // создадим последовательность
            track = sequence.createTrack(); // создадим трек и свяжем его с последовательностью
            sequencer.setTempoInBPM(120);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void buildTrackAndStart() {
        int[] trackList = null; //создаем массив из 16 элементов, чтобы хранить значения для каждого
        // инструмента на все 16 тактов

        sequence.deleteTrack(track); //удаляем старую дорожку
        track = sequence.createTrack(); // создаем новую

        for (int i = 0; i < 16; i++) { //делаем это для каждого из 16 рядов
            trackList = new int[16];

            int key = instruments[i]; // задаем клавишу, которая представляет инстумент.
            // массив содержит MIDI-числа для каждого инструмента
            for (int j = 0; j < 16; j++) { // делаем это для каждого такта текущего ряда
                JCheckBox jc = (JCheckBox) checkBoxList.get(j + (16 * i));
                if (jc.isSelected()) {
                    trackList[j] = key;
                } else {
                    trackList[j] = 0;
                }
            }

            makeTracks(trackList); // для этого инструмента и для всех 16 тактов создаем события
            track.add(makeEvent(176, 1, 127, 0, 16)); // и добавляем их на дорожку
        }

        track.add(makeEvent(192, 9, 1, 0, 15));
        try {
            sequencer.setSequence(sequence);
            sequencer.setLoopCount(sequencer.LOOP_CONTINUOUSLY); // задаем бесконечный цикл повторений
            sequencer.start();
            sequencer.setTempoInBPM(120);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public class MyStartListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            buildTrackAndStart();
        }
    }

    public class MyStopListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            sequencer.stop();
        }
    }

    public class MyUpTempoListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            float tempoFactor = sequencer.getTempoFactor();
            sequencer.setTempoFactor((float) (tempoFactor * 1.03)); // изменим коэффициет темпа синтезатора
            // 1.0 стандартное значение
        }
    }

    public class MyDownTempoListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            float tempoFactor = sequencer.getTempoFactor();
            sequencer.setTempoFactor((float) (tempoFactor * .97));
        }
    }

    public class ClearListener implements ActionListener { //сброс установленных флажков
        @Override
        public void actionPerformed(ActionEvent e) {
            for (int i = 0; i < 256; i++) {
                checkBoxList.get(i).setSelected(false);
            }
        }
    }

    public class SetRandomListener implements ActionListener { // произвольная установка флажков
        @Override
        public void actionPerformed(ActionEvent e) {
            for (int i = 0; i < 256; i++) {
                int onOff = (int) (Math.random() * 2);
                System.out.println(i + " = " + onOff);
                if (onOff == 1) {
                    checkBoxList.get(i).setSelected(true);   // присваиваем значение - не установлен
                } else {
                    checkBoxList.get(i).setSelected(false);   // присваиваем значение - не установлен
                }
            }
        }
    }

    /*
     *Метод создает события для одного инструмента за каждый проход цикла для всех 16 тактов.
     *получив значение из массива для текущего инстумента (0 или 1) можно определить будет или нет
     *играть инстумент. Если 1, то нужно создать событие и добавить его в дорожку
     */
    public void makeTracks(int[] list) {
        for (int i = 0; i < 16; i++) {
            int key = list[i];
            if (key != 0) {
                track.add(makeEvent(144, 9, key, 100, i)); // создаем события включения и выключения
                track.add(makeEvent(128, 9, key, 100, i + 1));// и добавляем их в дорожку
            }
        }
    }

    public MidiEvent makeEvent(int comd, int chan, int one, int two, int tick) {
        MidiEvent event = null;
        try {
            ShortMessage a = new ShortMessage();
            a.setMessage(comd, chan, one, two);
            event = new MidiEvent(a, tick);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return event;
    }

    public class MySentListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            boolean[] checkboxState = new boolean[256];
            for (int i = 0; i < 256; i++) {
                JCheckBox check = (JCheckBox) checkBoxList.get(i);
                if (check.isSelected()) {
                    checkboxState[i] = true;
                }
            }
            try {
                JFileChooser fileSave = new JFileChooser();
                fileSave.showSaveDialog(theFrame);
                //fileSave.setFileFilter(new FileNameExtensionFilter("Serialization data","ser"));
                FileOutputStream fileStream = new FileOutputStream(fileSave.getSelectedFile());
                ObjectOutputStream os = new ObjectOutputStream(fileStream);
                os.writeObject(checkboxState);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    public class MyReadInListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            boolean[] checkboxState = null;
            try {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.showOpenDialog(theFrame);
                //fileChooser.setFileFilter(new FileNameExtensionFilter("Serialization data","ser"));
                FileInputStream fileIn = new FileInputStream(fileChooser.getSelectedFile());
                ObjectInputStream is = new ObjectInputStream(fileIn);
                checkboxState = (boolean[]) is.readObject();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            for (int i = 0; i < 256; i++) {
                JCheckBox check = (JCheckBox) checkBoxList.get(i);
                if (checkboxState[i]) {
                    check.setSelected(true);
                } else {
                    check.setSelected(false);
                }
            }
            sequencer.stop();
            buildTrackAndStart();
        }
    }
}