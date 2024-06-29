import java.util.Arrays;

// 24.06.14 (금)
// 24.06.29 (토) review
public class problem_01_배열_정렬하기 {

    // 정수 배열을 정렬해서 반환하는 solution() 함수를 완성하세요.
    // 정수 배열의 길이 = 2 ~ 10^5 (100,000)
    // 정수 배열의 각 데이터 값 = -100,000 ~ 100,000
    // 제한 시간: 3초
    /*
    의사 코드
        1. 정수 배열을 받는다.
        2. 배열을 정렬한다.
        3. 정렬된 배열을 반환한다.
     */
    public static void main(String[] args) {
        // 데이터 셋
        int[][] numbers = {{1, -5, 2, 4, 3}, {2, 1, 1, 3, 2, 5, 4}, {6, 1, 7}};
        for (int[] test : numbers) {
            System.out.println("solve(test) = " + Arrays.toString(solve(test)));
        }
    }

    public static int[] solve(int[] test) {
        // 접근 방법
        // 1. 배열의 길이가 100,000까지 갈 수 있으므로 위 제한 시간에서는 O(N^2)부터는 불가능합니다.
        // 2. 따라서 시간 복잡도를 낮추면서 정렬하기 위해서, 기본 내장 정렬 함수를 이용하겠습니다.
        Arrays.sort(test); // 본 메서드의 시간 복잡도는 O(NlogN) 입니다.
        return test;

        // 또는, 만약 원본 배열을 그대로 두면서 정렬된 배열을 반환해야 할 경우에는 clone() 메서드를 이용하여 복사한 뒤 진행할 수 있습니다.
        // int[] temp = test.clone(); // 이때 시간 복잡도는 O(N)이 됩니다. 배열만큼 복사하기 때문입니다.
        // Arrays.sort(temp); // 복사된 데이터를 정렬시킵니다. 이 때는 시간 복잡도가 O(NlogN)이 되므로 최종적으로 O(NlogN)으로 동일합니다.
        // return temp;
    }
}
