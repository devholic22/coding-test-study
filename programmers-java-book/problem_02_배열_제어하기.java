import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

// 24.06.14 (금)
public class problem_02_배열_제어하기 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] numbers = Arrays.stream(reader.readLine().split(","))
                .mapToInt(Integer::parseInt)
                .toArray();
        System.out.println("solve(numbers) = " + Arrays.toString(solve(numbers)));
    }

    public static int[] solve(int[] numbers) {
        ArrayList<Integer> arr = new ArrayList<>();
        for (int number : numbers) {
            if (arr.contains(number)) {
                continue;
            }
            arr.add(number);
        }
        Integer[] array = new Integer[arr.size()];
        for (int i = 0; i < array.length; i++) {
            array[i] = arr.get(i);
        }
        Arrays.sort(array, Collections.reverseOrder()); // Collections.reverseOrder를 하려면 Integer[] 타입으로 되어야 한다.
        return Arrays.stream(array)
                .mapToInt(x -> x)
                .toArray();

        /*
        더 쉬운 방법
        Arrays.stream(numbers).boxed().distinct().toArray(Integer[]::new);
        Arrays.sort(array, Collections.reverseOrder());
        return Arrays.stream(array).mapToInt(Integer::intValue).toArray();
         */
    }
}
