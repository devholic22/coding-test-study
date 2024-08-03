import java.util.ArrayList;

// 24.08.03 (토)
public class problem_30_간단한_유니온_파인드_알고리즘_구현하기 {

    /*
    상호배타적 집합을 표현하고 관리하는 데 다음 두 연산이 필요합니다.
    - union(x, y): x와 y가 속한 두 집합을 합칩니다.
    - find(x): x가 속한 집합의 대표 원소를 찾습니다.
    operations라는 배열은 수행할 연산을 의미합니다. 연산 종류는 2개입니다.
    - [0, 1, 2]는 노드 1과 노드2에 대해 union 연산 수행
    - [1, 1, 3] 노드 1과 3이 같은 집합에 속해 있으면 true 아니면 false를 반환하는 equals 연산
    초기의 노드는 부모 노드를 자신의 값으로 설정했다고 가정하며, 여기서는 각 집합의 루트 노드를 기준으로 루트 노드가 작은 노드를 더 큰 노드의 자식으로 연결하는
    방법을 사용합니다. operations에 있는 연산에 대한 결과를 연산 순서대로 담은 Boolean 배열을 반환하는 solution() 메서드를 구현해주세요.
     */

    /*
    입출력 예
    k: 3, operations: [[0, 0, 1], [0, 1, 2], [1, 1, 2]], result: [true]
    k: 4, operations: [[0, 0, 1], [1, 1, 2], [0, 1, 2], [1, 0, 2]], result: [false, true]
     */

    // 0 <= k <= 1,000: 노드의 갯수
    // 1 <= len(operations) <= 100,000
    // operations[i][0]은 'u' 또는 'f'

    // 시간 복잡도: O(NlogN)

    static int[] nodes;

    public static Boolean[] solution(int k, int[][] operations) {
        // 노드 초기화
        nodes = new int[k];
        for (int i = 0; i < k; i++) {
            nodes[i] = i;
        }

        ArrayList<Boolean> answer = new ArrayList<>();

        // union-find 구분
        for (int[] operation : operations) {
            if (operation[0] == 0) {
                // union
                union(operation[1], operation[2]);
            } else {
                // find
                answer.add(find(operation[1]) == find(operation[2]));
            }
        }

        return answer.toArray(new Boolean[0]);
    }

    private static void union(int target1, int target2) {
        int root1 = find(target1);
        int root2 = find(target2);
        nodes[root2] = root1;
    }

    // 재귀를 진행한다.
    private static int find(int target) {
        if (nodes[target] == target) {
            return target;
        }
        nodes[target] = find(nodes[target]); // ex: nodes[2] = find(nodes[2])
        return nodes[target];
    }
}
