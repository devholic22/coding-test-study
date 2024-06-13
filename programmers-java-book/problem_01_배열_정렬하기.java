import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 24.06.14 (금)
public class problem_01_배열_정렬하기 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] numbers = Arrays.stream(reader.readLine().split(","))
                .mapToInt(Integer::parseInt)
                .toArray();
        System.out.println("solve(numbers) = " + Arrays.toString(solve(numbers)));
    }

    public static int[] solve(int[] numbers) {
        int[] sorted = numbers.clone();
        Arrays.sort(sorted);
        return sorted;
    }
}
