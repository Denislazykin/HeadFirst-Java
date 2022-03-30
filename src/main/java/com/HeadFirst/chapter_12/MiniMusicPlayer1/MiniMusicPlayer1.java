package main.java.com.HeadFirst.chapter_12.MiniMusicPlayer1;

import javax.sound.midi.*;

public class MiniMusicPlayer1 {
    public static void main(String[] args) {
        try {
            /*
             * Cоздаем и открываем синтезатор
             */
            Sequencer sequencer = MidiSystem.getSequencer();
            sequencer.open();
            /*
             * Cоздаем последовательность и дорожку
             */
            Sequence seq = new Sequence(Sequence.PPQ, 4);
            Track track = seq.createTrack();
            for (int i = 5; i < 61; i += 4) {
                /*
                 * Cоздаем группу событий, чтобы ноты фортепиано поднимались
                 */
                track.add(makeEvent(144, 1, i, 100, i));
                track.add(makeEvent(128, 1, i, 100, i + 2));
            }
            /*
             * Запускаем фортепьяно
             */
            sequencer.setSequence(seq);
            sequencer.setTempoInBPM(220);
            sequencer.start();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Вызваем новый метод, что бы создать сообщение и событие, а затем добавляем результат
     * @return возвращает событие
     */
    public static MidiEvent makeEvent(int comd, int chan, int one, int two, int tick) {
        MidiEvent event = null;
        try {
            ShortMessage a = new ShortMessage();
            a.setMessage(comd, chan, one, two);
            event = new MidiEvent(a, tick);
        } catch (Exception e) {

        }
        return event;
    }
}
