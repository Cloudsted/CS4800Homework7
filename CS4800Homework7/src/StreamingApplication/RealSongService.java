package StreamingApplication;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RealSongService implements SongService {
    private Map<Integer, Song> songsDatabase = new HashMap<>();

    public RealSongService() {
        songsDatabase.put(1, new Song(1, "Song One", "Artist One", "Album One", 210));
        songsDatabase.put(2, new Song(2, "Song Two", "Artist Two", "Album Two", 190));
        songsDatabase.put(3, new Song(3, "Song Three", "Artist Three", "Album One", 180));
        songsDatabase.put(4, new Song(4, "Song Four", "Artist Four", "Album Two", 220));
        songsDatabase.put(5, new Song(5, "Song Five", "Artist One", "Album Three", 200));
        songsDatabase.put(6, new Song(6, "Song Six", "Artist Two", "Album Four", 210));
        songsDatabase.put(7, new Song(7, "Song Seven", "Artist Five", "Album Five", 195));
        songsDatabase.put(8, new Song(8, "Song Eight", "Artist Six", "Album Six", 205));
        songsDatabase.put(9, new Song(9, "Song Nine", "Artist Seven", "Album Seven", 215));
        songsDatabase.put(10, new Song(10, "Song Ten", "Artist Eight", "Album Eight", 185));
    
    }

    private void simulateNetworkLatency() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    @Override
    public Song searchById(Integer songID) {
        simulateNetworkLatency();
        return songsDatabase.get(songID);
    }

    @Override
    public List<Song> searchByTitle(String title) {
        simulateNetworkLatency();
        List<Song> results = new ArrayList<>();
        for (Song song : songsDatabase.values()) {
            if (song.getTitle().equals(title)) {
                results.add(song);
            }
        }
        return results;
    }

    @Override
    public List<Song> searchByAlbum(String album) {
        simulateNetworkLatency();
        List<Song> results = new ArrayList<>();
        for (Song song : songsDatabase.values()) {
            if (song.getAlbum().equals(album)) {
                results.add(song);
            }
        }
        return results;
    }
}