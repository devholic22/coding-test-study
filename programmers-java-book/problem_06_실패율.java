import java.util.Arrays;

// 24.06.16 (일)
public class problem_06_실패율 {

    private static class Result implements Comparable<Result> {
        double score;
        int stage;

        public Result(double score, int stage) {
            this.score = score;
            this.stage = stage;
        }

        @Override
        public int compareTo(Result other) {
            if (other.score == this.score) {
                return Integer.compare(this.stage, other.stage);
            }
            return Double.compare(other.score, this.score);
        }
    }

    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        Result[] results = new Result[N];
        for (int i = 1; i <= N; i++) {
            int total = calculatePerson(i, stages);
            int not = calculateNotCleared(i, stages);
            if (total != 0) { // ArithmeticException 방지
                results[i - 1] = new Result((double) not / total, i);
            } else {
                results[i - 1] = new Result(0, i);
            }
        }
        Arrays.sort(results);
        for (int i = 0; i < N; i++) {
            answer[i] = results[i].stage;
        }
        return answer;
    }
    private int calculatePerson(int stage, int[] stages) {
        int count = 0;
        for (int s : stages) {
            if (s >= stage) {
                count++;
            }
        }
        return count;
    }
    private int calculateNotCleared(int stage, int[] stages) {
        int count = 0;
        for (int s : stages) {
            if (s == stage) {
                count++;
            }
        }
        return count;
    }
}
