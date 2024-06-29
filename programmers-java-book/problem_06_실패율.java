import java.util.Arrays;

// 24.06.16 (일)
// 24.06.29 (토) review
public class problem_06_실패율 {

    // 스테이지 N: 1 ~ 500
    // stages: 1 ~ 200,000 -> O(N^2)까지 가면 안 됩니다. 여기에서의 N은 stages의 길이를 의미
    // stages 값: 1 ~ N + 1
    // 사용자가 현재 도전 중인 스테이지의 번호
    // N + 1이라면 마지막 스테이지까지 클리어 한 사용자
    /*
    의사 코드
    1. N과 stages를 받는다.
    2. 각 스테이지를 나타내는 Stage 클래스를 생성하고, 배열 (N개)에 인스턴스를 만들어둔다.
        -> 실제로 클래스가 필요한 이유는, 인덱스-값처럼 단순한 게 아니라 인덱스, 스테이지, 실패율 등 세 가지 이상의 값을 가져야 하기 때문
        -> Stage 클래스를 생성할 때는 인덱스, 도전, 클리어 수를 저장하도록 한다.
        -> 그러나 맨 아래 더 나은 방법을 보면 클래스가 또 필요 없게 된다.
    3. 순차적으로 stages를 돌면서 각 Stage에 따른 실패율을 계산한다.
    4. 문제 조건에 맞게 정렬시킨다.
    5. 정렬시킨 Stage 배열에서 인덱스 값들만을 반환하도록 한다.
    전체 시간 복잡도는 O(MN + NlogN)이 됩니다.
    */
    public class Stage implements Comparable<Stage> {
        int index;
        int total;
        int value;
        public Stage(int index, int total, int value) {
            this.index = index;
            this.total = total;
            this.value = value;
        }
        public double getRate() {
            if (value == 0 || total == 0) {
                return 0; // 스테이지에 도달한 유저가 없는 경우 해당 스테이지의 실패율은 0
            }
            return (double) value / total;
        }
        @Override
        public int compareTo(Stage other) {
            if (Double.compare(other.getRate(), this.getRate()) == 0) {
                return Integer.compare(this.index, other.index);
            }
            // 틀렸던 이유: (int) (other.getRate() - this.getRate())로 했었습니다. 이렇게 소수점 계산을 할 때 (int)로 해 버리면 정확하지 않습니다.
            // 따라서 1, -1, 0만을 반환하는 Double.compare를 적용하였습니다.
            return Double.compare(other.getRate(), this.getRate());
        }
    }
    public int[] solution(int N, int[] stages) {
        Stage[] stage = new Stage[N];
        // Stage 초기화
        for (int i = 0; i < N; i++) {
            stage[i] = new Stage(i + 1, 0, 0);
        }
        for (int s : stages) {
            for (int i = 0; i < stage.length; i++) {
                // 각 스테이지를 돌면서 실패율을 계산하도록 합니다.
                if (s >= stage[i].index) {
                    stage[i].total++;
                    if (s == stage[i].index) {
                        stage[i].value++;
                    }
                }
            }
        }
        // 문제 조건에 맞추어 정렬한 뒤 반환합니다.
        Arrays.sort(stage);
        int[] answer = new int[N];
        for (int i = 0; i < N; i++) {
            answer[i] = stage[i].index;
        }
        return answer;
    }
    /*
    더 나은 방법
    int[] challenger = new int[N + 2]; // challenger: 각 스테이지에 도전하는 사용자 수를 저장하는 데 사용하는 배열
    for (int i = 0; i < stages.length; i++) {
        challenger[stages[i]] += 1; // 예시로 stages[i]가 4라면, challenger[4] += 1이 된다.
    }
    HashMap<Integer, Double> fails = new HashMap<>();
    double total = stages.length;
    for (int i = 1; i <= N; i++) {
        if (challenger[i] == 0) { // 도전한 사람이 없다면 0으로 한다.
            fails.put(i, 0.);
        } else {
            fails.put(i, challenger[i] / total); // 그게 아니라면 도전한 사람과 남은 사람을 이용하여 실패율을 넣는다.
            total -= challenger[i]; // 스테이지가 "점점 높아지기 때문에", 남은 사람들을 제거할 수 있다.
        }
    }
    // HashMap에서 정렬을 바로 적용할 수 있는 코드는 처음 알았다.
    return fails.entrySet().stream().sorted((o1, o2) -> Double.compare(o2.getValue(), o1.getValue())).mapToInt(HashMap.Entry::getKey).toArray();
    시간 복잡도는 challenger를 적용할 때 O(N + M), 스테이지별로 실패율을 계산할 때 O(N), 이를 정렬할 때 O(NlogN)이므로 O(M + NlogN)이 된다.
     */
}
