package algorithm_kit.해시;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

// 24.08.15 (목)
public class problem_05_베스트_앨범 {

    // 정렬 기준
    // 1. 속한 노래 많은 장르
    // 2. 많이 재생된 노래
    // 3. 고유 번호가 낮은 노래
    // 최대 두 개까지만 모음
    private class Song implements Comparable<Song> {

        private String gen;
        private int genre;
        private int play;
        private int index;

        public Song(String gen, int genre, int play, int index) {
            this.gen = gen;
            this.genre = genre;
            this.play = play;
            this.index = index;
        }

        @Override
        public int compareTo(Song other) {
            if (this.genre == other.genre) {
                if (this.play == other.play) {
                    return Integer.compare(this.index, other.index);
                }
                return Integer.compare(other.play, this.play);
            }
            return Integer.compare(other.genre, this.genre);
        }
    }

    public int[] solution(String[] genres, int[] plays) {
        // 장르에 속한 노래의 개수를 알아야 하므로 HashMap 관리
        HashMap<String, Integer> map = new HashMap<>();
        Song[] songs = new Song[genres.length];
        for (int i = 0; i < genres.length; i++) {
            if (map.containsKey(genres[i])) {
                map.put(genres[i], map.get(genres[i]) + plays[i]);
            } else {
                map.put(genres[i], plays[i]);
            }
        }
        for (int i = 0; i < genres.length; i++) {
            songs[i] = new Song(genres[i], map.get(genres[i]), plays[i], i);
        }
        Arrays.sort(songs);
        ArrayList<Integer> result = new ArrayList<>();
        HashMap<String, Integer> records = new HashMap<>();
        for (Song song : songs) {
            if (records.containsKey(song.gen) && records.get(song.gen) >= 2) {
                continue;
            }
            if (!records.containsKey(song.gen)) {
                records.put(song.gen, 1);
            } else {
                records.put(song.gen, records.get(song.gen) + 1);
            }
            result.add(song.index);
        }
        return result.stream().mapToInt(x -> x).toArray(); // ArrayList -> int[] 잊지 말기
        // 전체 시간 복잡도 O(NlogN), N은 genres (plays) 길이
    }
}
