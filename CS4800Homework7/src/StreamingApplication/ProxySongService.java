package StreamingApplication;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProxySongService implements SongService {
    private RealSongService realService;
    private Map<Integer, Song> cacheById = new HashMap<>();
    private Map<String, List<Song>> cacheByTitle = new HashMap<>();
    private Map<String, List<Song>> cacheByAlbum = new HashMap<>();

    public ProxySongService(RealSongService realService) {
        this.realService = realService;
    }

    @Override
    public Song searchById(Integer songID) {
        if (!cacheById.containsKey(songID)) {
            cacheById.put(songID, realService.searchById(songID));
        }
        return cacheById.get(songID);
    }

    @Override
    public List<Song> searchByTitle(String title) {
        if (!cacheByTitle.containsKey(title)) {
            cacheByTitle.put(title, realService.searchByTitle(title));
        }
        return cacheByTitle.get(title);
    }

    @Override
    public List<Song> searchByAlbum(String album) {
        if (!cacheByAlbum.containsKey(album)) {
            cacheByAlbum.put(album, realService.searchByAlbum(album));
        }
        return cacheByAlbum.get(album);
    }
}