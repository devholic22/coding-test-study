import java.util.ArrayList;

// 24.06.16 (일)
public class problem_05_행렬의_곱셈 {

    public int[][] solution(int[][] arr1, int[][] arr2) {
        // arr1 col = 2
        // arr1 row = 3

        // arr2 col = 2
        // arr2 row = 2

        // answer = new int[arr1.row][arr2.col];
        int row = arr1.length;
        int col = arr2[0].length;
        int[][] answer = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                answer[i][j] += calculate(arr1, arr2, i, j);
            }
        }
        return answer;
    }

    private int calculate(int[][] arr1, int[][] arr2, int row, int col) {
        int sum = 0;
        int[] r = arr1[row];
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < arr2.length; i++) {
            arr.add(arr2[i][col]);
        }
        int[] c = arr.stream().mapToInt(x -> x).toArray();
        for (int i = 0; i < r.length; i++) {
            sum += (r[i] * c[i]);
        }
        return sum;
    }

    /*
    더 쉬운 방법
    r1 = arr1.length;
    c1 = arr1[0].length;
    r2 = arr2.length;
    c2 = arr2[0].length;
    for (int i = 0; i < r1; i++) {
        for (int j = 0; j < c2; j++) {
            for (int k = 0; k < c1; k++) {
                answer[i][j] += arr1[i][k] * arr2[k][i];
            }
        }
    }
     */
}
