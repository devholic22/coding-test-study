import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 24.06.15 (토)
public class problem_04_모의고사 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] numbers = Arrays.stream(reader.readLine().split(","))
                .mapToInt(Integer::parseInt)
                .toArray();
        System.out.println("solve(numbers) = " + Arrays.toString(solve(numbers)));
    }

    public static int[] solve(int[] numbers) {
        // 1번: 1, 2, 3, 4, 5 반복
        // 2번: 2, 1, 2, 3, 2, 4, 2, 5 반복
        // 3번: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 반복
        int[] one = {1, 2, 3, 4, 5};
        int[] two = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] three = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int[] cnt = {0, 0, 0};

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == one[i % one.length]) {
                cnt[0]++;
            }
            if (numbers[i] == two[i % two.length]) {
                cnt[1]++;
            }
            if (numbers[i] == three[i % three.length]) {
                cnt[2]++;
            }
        }
        int max = Math.max(cnt[0], Math.max(cnt[1], cnt[2]));
        int size = 0;
        for (int c : cnt) {
            if (c == max) {
                size++;
            }
        }
        int[] answer = new int[size];
        for (int i = 0; i < cnt.length; i++) {
            if (cnt[i] == max) {
                answer[i] = i + 1;
            }
        }
        Arrays.sort(answer);
        return answer;
    }
}
