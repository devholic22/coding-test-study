import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;

// 24.06.15 (토)
public class problem_03_두_개_뽑아서_더하기 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] numbers = Arrays.stream(reader.readLine().split(","))
                .mapToInt(Integer::parseInt)
                .toArray();
        System.out.println("solve(numbers) = " + Arrays.toString(solve(numbers)));
    }

    public static int[] solve(int[] numbers) {
        HashSet<Integer> arr = new HashSet<>();
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers.length; j++) {
                if (i == j) {
                    continue;
                }
                arr.add(numbers[i] + numbers[j]);
            }
        }
        return arr.stream()
                .mapToInt(x -> x)
                .sorted()
                .toArray();
    }
}
