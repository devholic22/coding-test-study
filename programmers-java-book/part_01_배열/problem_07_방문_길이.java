package part_01_배열;

import java.util.HashMap;
import java.util.HashSet;

// 24.06.17 (월)
// 24.06.29 (토) review
public class problem_07_방문_길이 {

    // dirs는 U, D, R, L 중 하나
    // dirs의 최대 길이 500, O(N^2)도 충분
    /*
    의사 코드
        1. dirs 입력 받음
        2. dirs를 각각의 문자열로 배열화
        3. dirs의 값에 따라서 좌표 이동 - 5 넘어가면 무시 (좌표평면 크기 제한)
        4. 시작 지점 - 종료 지점, 종료 지점 - 시작 지점 문자열을 만들고 Set에 저장
        5. set의 길이 / 2로 계산하여 반환
    시간 복잡도는 O(N)
    */
    public int solution(String dirs) {
        // 좌표 정보를 저장합니다.
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        int x = 0;
        int y = 0;
        // 상하좌우를 저장합니다.
        HashMap<Integer, String> map = new HashMap<>();
        map.put(0, "U");
        map.put(1, "R");
        map.put(2, "D");
        map.put(3, "L");
        String[] command = dirs.split("");
        HashSet<String> log = new HashSet<>();
        // 각 명령어를 토대로 좌표 정보를 저장합니다.
        for (String c : command) {
            for (int i = 0; i < 4; i++) {
                if (c.equals(map.get(i))) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];
                    // 문제가 되는 좌표는 건너뜁니다.
                    if (nx < -5 || nx > 5 || ny < -5 || ny > 5) {
                        continue;
                    }
                    log.add(x + ", " + y + " " + nx + ", " + ny);
                    log.add(nx + ", " + ny + " " + x + ", " + y);
                    x = nx;
                    y = ny;
                }
            }
        }
        // 두 번씩 들어갔으므로 / 2를 합니다.
        return log.size() / 2;
    }
}
