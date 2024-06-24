import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

// 24.06.24 (월)
public class problem_22_베스트_앨범 {

    private static class Song implements Comparable<Song> {
        int index;
        int play;
        int genreTotal;
        String genre;

        public Song(int index, int play, int genreTotal, String genre) {
            this.index = index;
            this.play = play;
            this.genreTotal = genreTotal;
            this.genre = genre;
        }

        @Override
        public int compareTo(Song other) {
            // 1. 장르 기준
            if (other.genreTotal == this.genreTotal) {
                // 2. 재생 기준 V
                if (this.play == other.play) {
                    // 3. 고유 번호 낮은 기준 V
                    return Integer.compare(this.index, other.index);
                } else {
                    return Integer.compare(other.play, this.play);
                }
            } else {
                return Integer.compare(other.genreTotal, this.genreTotal);
            }
        }
    }

    public int[] solution(String[] genres, int[] plays) {
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            if (map.containsKey(genres[i])) {
                map.put(genres[i], map.get(genres[i]) + plays[i]);
            } else {
                map.put(genres[i], plays[i]);
            }
        }

        Song[] songs = new Song[plays.length];
        for (int i = 0; i < plays.length; i++) {
            songs[i] = new Song(i, plays[i], map.get(genres[i]), genres[i]);
        }
        Arrays.sort(songs);

        HashMap<String, Integer> collect = new HashMap<>();
        ArrayList<Integer> answer = new ArrayList<>();
        for (Song song : songs) {
            if (collect.containsKey(song.genre)) {
                collect.put(song.genre, collect.get(song.genre) + 1);
            } else {
                collect.put(song.genre, 1);
            }

            if (!isFull(collect, song.genre)) {
                answer.add(song.index);
            }
        }
        return answer.stream()
                .mapToInt(x -> x)
                .toArray();
    }
    private boolean isFull(HashMap<String, Integer> collect, String genre) {
        if (collect.containsKey(genre) && collect.get(genre) > 2) {
            return true;
        }
        return false;
    }
}
