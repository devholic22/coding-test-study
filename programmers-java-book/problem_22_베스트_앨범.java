import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

// 24.06.24 (월)
// 24.07.02 (화) review
public class problem_22_베스트_앨범 {

    // 1 <= genres.length = plays.length <= 10,000
    // 장르 종류는 100개 미만
    // 자르에 속한 곡이 하나면 하나의 곡만 선택
    // 모든 장르는 재생된 횟수가 다름
    /*
    의사 코드
        1. genres, plays 배열 받음
        2. 노래 클래스 생성: 이유는 정렬 기준이 여러 개이기 때문
            2-1. 장르 총 재생 횟수, 노래 재생 횟수, 고유 번호를 저장하도록 설정
        3. 장르가 몇 번 재생되었는지를 담은 HashMap 선언 및 저장
        4. genres, plays 정보를 토대로 노래 배열을 저장 및 정렬
        5. 정렬된 노래를 돌면서 인덱스 담고 반환
            5-1. 각 장르가 몇 개 수록되었는지 기록하는 HashMap 선언
            5-2. 각 노래를 담을 때 마다 장르 기록, 2개까지만 저장되도록 설정
    시간 복잡도: O(NlogN) 최대 10,000
    */
    public class Song implements Comparable<Song> {
        String genreName;
        int genre;
        int play;
        int index;
        public Song(String genreName, int genre, int play, int index) {
            this.genreName = genreName;
            this.genre = genre;
            this.play = play;
            this.index = index;
        }
        @Override
        public int compareTo(Song other) {
            // 1. 속한 노래가 많이 재생된 장르
            // 2. 장르 내에서 많이 재생된 노래
            // 3. 장르 내에서 재생 횟수가 같은 노래 중에서는 고유 번호가 낮은 노래 먼저
            if (this.genreName.equals(other.genreName)) {
                if (this.play == other.play) {
                    return Integer.compare(this.index, other.index);
                }
                return Integer.compare(other.play, this.play);
            }
            return Integer.compare(other.genre, this.genre);
        }
    }
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String, Integer> log = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            if (log.containsKey(genres[i])) {
                log.put(genres[i], log.get(genres[i]) + plays[i]);
            } else {
                log.put(genres[i], plays[i]);
            }
        }
        Song[] songs = new Song[genres.length];
        for (int i = 0; i < genres.length; i++) {
            songs[i] = new Song(genres[i], log.get(genres[i]), plays[i], i);
        }
        Arrays.sort(songs);
        HashMap<String, Integer> used = new HashMap<>();
        ArrayList<Integer> result = new ArrayList<>();
        for (Song song : songs) {
            if (!used.containsKey(song.genreName)) {
                used.put(song.genreName, 1);
                result.add(song.index);
            } else {
                if (used.get(song.genreName) == 2) {
                    continue;
                }
                used.put(song.genreName, used.get(song.genreName) + 1);
                result.add(song.index);
            }
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
