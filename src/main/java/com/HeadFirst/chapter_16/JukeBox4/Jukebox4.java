package main.java.com.HeadFirst.chapter_16.JukeBox4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Jukebox4 {
    ArrayList<Song> songList = new ArrayList<Song>();

    public static void main(String[] args) {
        new Jukebox4().go();
    }

    class ArtistCompare implements Comparator<Song> {

        @Override
        public int compare(Song o1, Song o2) {
            return o1.getArtist().compareTo(o2.getArtist());
        }
    }

    public void go() {
        getSong();
        System.out.println(songList);
        Collections.sort(songList);
        System.out.println(songList);
        ArtistCompare artistCompare = new ArtistCompare();
        songList.sort(artistCompare);
        System.out.println(songList);
    }

    private void getSong() {
        try {
            File file = new File("c:\\projects\\HeadFirst-Java\\src\\main\\" +
                    "java\\com\\HeadFirst\\chapter_16\\songs.txt");
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = null;
            while ((line = reader.readLine()) != null) {
                addSong(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void addSong(String lineToParse) {
        String[] tokens = lineToParse.split("/");
        Song nextSong = new Song(tokens[0], tokens[1], tokens[2], tokens[3]);
        songList.add(nextSong);
    }
}
