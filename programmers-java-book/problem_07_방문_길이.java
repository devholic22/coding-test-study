import java.util.HashMap;
import java.util.HashSet;

// 24.06.17 (월)
public class problem_07_방문_길이 {

    public int solution(String dirs) {
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        String[] commands = {"U", "D", "R", "L"};
        HashMap<String, Integer> dxMap = new HashMap<>();
        HashMap<String, Integer> dyMap = new HashMap<>();
        HashSet<String> answer = new HashSet<>();
        for (int i = 0; i < 4; i++) {
            dxMap.put(commands[i], dx[i]);
            dyMap.put(commands[i], dy[i]);
        }
        int x = 0;
        int y = 0;
        String[] inputs = dirs.split("");
        for (String input : inputs) {
            int nx = x + dxMap.get(input);
            int ny = y + dyMap.get(input);
            if (nx < -5 || ny < -5 || nx > 5 || ny > 5) {
                continue;
            }
            answer.add("(" + x + ", " + y + ") => " + "(" + nx + ", " + ny + ")");
            answer.add("(" + nx + ", " + ny + ") => " + "(" + x + ", " + y + ")");
            y = ny;
            x = nx;
        }
        return answer.size() / 2;
    }
}
