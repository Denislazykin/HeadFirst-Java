package main.java.com.HeadFirst.chapter_11.Music;

import javax.sound.midi.*;

public class MiniMusicCmdLine {
    public static void main(String[] args) {
        MiniMusicCmdLine mini = new MiniMusicCmdLine();
        if (args.length < 2) {
            System.out.println("Не забудьте аргументы для инструмента и ноты");
        } else {
            int instrument = Integer.parseInt(args[0]);
            int note = Integer.parseInt(args[1]);
            mini.play(instrument, note);
        }
    }

    public void play(int instrument, int note) {
        try {
            Sequencer player = MidiSystem.getSequencer();   //получаем синтезатор
            player.open(); // открываем его, чтобы начать использовать
            Sequence seq = new Sequence(Sequence.PPQ, 4); // создадим последовательность
            Track track = seq.createTrack(); // заправшиваем трек у последовательности
            // трек находится внутри последовательности, а MIDI-данные - в треке

            MidiEvent event = null;

            ShortMessage first = new ShortMessage();    // помещаем в трек MIDI-события
            first.setMessage(192, 1, instrument, 0);
            MidiEvent changeInstrument = new MidiEvent(first, 1);
            track.add(changeInstrument);

            ShortMessage a = new ShortMessage();    // помещаем в трек MIDI-события
            a.setMessage(144, 1, note, 100);
            MidiEvent noteOn = new MidiEvent(a, 1);
            track.add(noteOn);

            ShortMessage b = new ShortMessage();    // помещаем в трек MIDI-события
            b.setMessage(128, 1, note, 100);
            MidiEvent noteOff = new MidiEvent(b, 16);
            track.add(noteOff);

            player.setSequence(seq); // передаем последовательность синтезатору

            player.start(); // запускаем синтезатор
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

