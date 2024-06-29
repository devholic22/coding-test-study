package suggestion_bonus;

// 24.06.30 (일)
public class problem_04_n2_배열_자르기 {
    // 1. n의 크기: 1 ~ 10,000,000 -> 즉, O(N^2)는 불가능
    // 2. 0 <= left <= right < n^2
    // 3. right - left < 100,000
    /*
    의사 코드
        1. n, left, right를 입력받는다.
        2. right - left + 1 만큼의 배열을 선언한다.
            2-1. n * n 2차원 배열을 하면 안 되는 이유는 시간 초과가 발생하기 때문이다.
        3. 2번 배열의 각 인덱스를 취한다.
        4. 인덱스를 이용하여 n * n 배열에서 몇 번째 행의 몇 번째 열에 해당되는 값인지 계산하고, 저장한다.
            4-1. n * n 배열은 일종의 패턴이 있다.
                4-1.1. 0행은 1이 1개 및 나머지 값들이 1개씩, 1행은 2가 2개 및 나머지 값들이 1개씩, 2행은 3이 3개 및 나머지 값들이 1개씩.. 이다.
            4-2. 예시로 n이 4일 때 10번째 값 (실제 11번째)을 구하려고 하면, 10/4 = 2이므로 2번째(실제 3번째) 행이다.
            4-3. 그리고 나머지가 2였으므로 2번째 (실제 3번째) 열의 값 (3)을 저장하게 된다.
        5. 해당 배열을 반환한다.
    */
    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int) right - (int) left + 1];
        // 전체적인 시간 복잡도: O(M * N) -> 10^5 * 10^7 = 10^12
        for (int i = 0; i < answer.length; i++) {
            int row = (int) (left / n); // 그룹을 구합니다.
            int col = (int) (left % n); // 그룹 안에서의 상대적인 위치를 의미합니다.
            answer[i] = val(row, col, n);
            left++;
        }
        return answer;
    }
    // 시간 복잡도: O(N)
    public int val(int row, int col, int n) {
        // 마지막 행일 경우 n을 반환합니다.
        if (row == n - 1) {
            return n;
        }
        // 각 행마다 n개의 데이터를 가집니다.
        int[] numbers = new int[n];
        // row번째 행은 row + 1의 값을 row + 1개 만큼 가집니다. 예를 들어 1번째 행은 2를 2개만큼 가지고, 나머지는 전부 하나씩 가집니다.
        for (int i = 0; i <= row; i++) {
            numbers[i] = row + 1;
            if (i >= col) {
                return numbers[col];
            }
        }
        int next = row + 2;
        for (int i = row + 1; i < n; i++) {
            numbers[i] = next;
            next++;
            if (i >= col) {
                return numbers[col];
            }
        }
        return numbers[col];
    }
    /*
    정답 코드
    private static int N;

    public int[] solution(int n, long left, long right) {
        N = n;

        int[] result = new int[(int) (right - left) + 1];
        int index = 0;

        for (long i = left; i <= right; i++) {
            int groupIndex = group(i);
            result[index] = get(i, groupIndex);
            index++;
        }

        return result;
    }

    // 그룹 인덱스 계산 함수
    private int group(long index) {
        return (int) (index / N);
    }

    // 그룹 안에서 구체적인 수를 제공하는 함수
    private int get(long index, int group) {
        if (group == N - 1) { // 맨 마지막 행의 원소는 전부 N
            return N;
        }
        if (index >= Integer.MAX_VALUE) {
            long position;
            if (group == 0) {
                position = index;
            } else {
                position = index % ((long) N * group);
            }

            if (position <= group) {
                return group + 1; // r번째 그룹에서는, r+1이 r+1 만큼 채워져있다. (ex: 1번째 그룹에는 2가 2개 있음)
            }

            long distance = position - group; // 시작점으로부터 더 나아가야 할 사이즈
            int value = group + 1; // 시작 값 (ex: 0번 그룹에서는 시작값이 1부터 됨)
            value += (int) distance;
            return value;
        }

        int pos; // 그룹 안에서의 상대적 인덱스 구하기 (ex: 10 % (4 * 2) = 2)
        if (group == 0) {
            pos = (int) index;
        } else {
            pos = (int) index % (N * group);
        }

        if (pos <= group) {
            return group + 1; // r번째 그룹에서는, r+1이 r+1 만큼 채워져있다. (ex: 1번째 그룹에는 2가 2개 있음)
        }

        int distance = pos - group; // 시작점으로부터 더 나아가야 할 사이즈
        int value = group + 1; // 시작 값 (ex: 0번 그룹에서는 시작값이 1부터 됨)
        for (int i = 0; i < distance; i++) {
            value++;
        }
        return value;
    }
    다른 점
        - 일단 크게 봤을 때 접근법은 같았다. n의 범위가 매우 크기 때문에 n * n 배열을 만들고 저장하기보다는 일련의 규칙을 발견한 뒤 부분적으로 배열을 생성해야 했다.
        - 실패 코드에서는 각 행마다 부분적으로 배열을 만들었으나, 성공 코드에서는 배열을 만들지 않고 직접 값만을 할당하는 식으로 했다.
     */
}
