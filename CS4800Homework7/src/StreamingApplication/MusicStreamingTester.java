package StreamingApplication;

import java.util.List;

public class MusicStreamingTester {
    public static void main(String[] args) {
        RealSongService realService = new RealSongService();
        ProxySongService proxyService = new ProxySongService(realService);

        System.out.println("Testing search by ID:");
        printSongDetails(proxyService.searchById(1));
        printSongDetails(proxyService.searchById(3));

        System.out.println("\nTesting search by Title:");
        printSongListDetails(proxyService.searchByTitle("Song One"));
        printSongListDetails(proxyService.searchByTitle("Song Five"));
        printSongListDetails(proxyService.searchByTitle("Song Nine"));

        System.out.println("\nTesting search by Album:");
        printSongListDetails(proxyService.searchByAlbum("Album One"));
        printSongListDetails(proxyService.searchByAlbum("Album Two"));
        printSongListDetails(proxyService.searchByAlbum("Album Eight"));

        System.out.println("\nTesting caching functionality by repeating searches:");
        long startTime = System.currentTimeMillis();
        printSongListDetails(proxyService.searchByTitle("Song Two"));
        long endTime = System.currentTimeMillis();
        System.out.println("Time taken without cache (expected longer): " + (endTime - startTime) + " ms");

        startTime = System.currentTimeMillis();
        printSongListDetails(proxyService.searchByTitle("Song Two"));
        endTime = System.currentTimeMillis();
        System.out.println("Time taken with cache (expected shorter): " + (endTime - startTime) + " ms");
    }

    private static void printSongDetails(Song song) {
        if (song != null) {
            System.out.println("Song ID: " + song.getId() + ", Title: " + song.getTitle() +
                               ", Artist: " + song.getArtist() + ", Album: " + song.getAlbum() +
                               ", Duration: " + song.getDuration() + " seconds");
        } else {
            System.out.println("No song found.");
        }
    }

    private static void printSongListDetails(List<Song> songs) {
        if (songs.isEmpty()) {
            System.out.println("No songs found.");
        } else {
            for (Song song : songs) {
                printSongDetails(song);
            }
        }
    }
}
