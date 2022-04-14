package main.java.com.HeadFirst.chapter_12.MiniMusicPlayer2;

import javax.sound.midi.*;

/*
 * Для отслеживания события ControllerEvent
 * реализуем интерфейс слушателя
 */
public class MiniMusicPlayer2 implements ControllerEventListener {
    public static void main(String[] args) {
        MiniMusicPlayer2 mini = new MiniMusicPlayer2();
        mini.go();
    }

    public void go() {
        try {
            Sequencer sequencer = MidiSystem.getSequencer();
            sequencer.open();
            /*
             *Регистрируем события синтезатором. Метод, отвечающий за регистрацию, принимает объект
             *слушателя и целочисленный массив, представляющий собой список событий ControllerEvent,
             *которые нам нужны. Нас интересует только одно событие - № 127
             */
            int[] eventsIWant = {127};
            sequencer.addControllerEventListener(this, eventsIWant);
            /*
             * Создаем последовательность и дорожку
             */
            Sequence seq = new Sequence(Sequence.PPQ, 4);
            Track track = seq.createTrack();
            for (int i = 5; i < 61; i += 4) {
                /*
                 * Создаем группу событий, чтобы ноты фортепиано поднимались
                 */
                track.add(makeEvent(144, 1, i, 100, i));
                track.add(makeEvent(176, 1, 127, 0, i));
                track.add(makeEvent(128, 1, i, 100, i + 2));
            }
            sequencer.setSequence(seq);
            sequencer.setTempoInBPM(220);
            sequencer.start();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * метод обработки события (из интерфейса слушателя события ControllerEvent)
     * при каждом получении события выводим ссобщение
     *
     * @param event принимает событие
     */
    public void controlChange(ShortMessage event) {
        System.out.println("труньк");
    }

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
