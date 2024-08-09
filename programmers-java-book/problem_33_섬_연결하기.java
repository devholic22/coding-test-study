import java.util.Arrays;

// 24.08.09 (금)
public class problem_33_섬_연결하기 {

    private static int[] parent;

    /*
    최소 신장 트리 (MST)의 개념 문제와 같음, 본 해설은 크루스칼 알고리즘의 대표적인 문제
    최소 신장 트리: 네트워크의 모든 정점을 최소 비용으로 연결. 이때 사이클을 형성하지 않는다.
        * 그래프의 간선들을 가중치의 오름차순으로 정렬
        * 정렬된 간선 리스트에서 순서대로 사이클을 형성하지 않는 간선을 선택
        * 해당 간선을 현재의 최소 신장 트리에 추가
        * 사이클을 형성하지 않도록 할 때 유니온 파인드 알고리즘을 이용
     * 시간 복잡도는 N은 노드 개수, E는 간선 개수라고 할 때 간선 정렬 알고리즘 O(ElogE), costs 순회하며 유니온 파인드 적용 시 O(ElogE), 최종 O(ElogE)
     */
    public int solution(int n, int[][] costs) {
        // 가중치는 costs[i][2]에 속함: 가장 작은 것부터 이용하도록 함
        Arrays.sort(costs, (o1, o2) -> Integer.compare(o1[2], o2[2]));

        // 유니온 파인드 초기화
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i; // 자기 자신을 부모로 설정
        }

        int answer = 0; // 응답할 가중치 합
        int edges = 0; // 선택한 간선 개수

        for (int[] edge: costs) {
            if (edges == n - 1) {
                break; // 최소 신장 트리 조건 충족, 탈출 (N개의 정점을 잇기 위해서는 N-1 개의 간선이 필요)
            }

            // edge[0]의 부모와 edge[1]의 부모가 다르다면 union 진행 후 answer에 가중치 덧셈, edges + 1
            if (find(edge[0]) != find(edge[1])) {
                union(edge[0], edge[1]);
                answer += edge[2];
                edges++;
            }
        }
        return answer;
    }

    private int find(int x) {
        // x가 속한 집합의 루트 노드 조회
        if (parent[x] == x) {
            return x;
        }
        // 경로 압축: x의 부모를 루트로 설정
        return parent[x] = find(parent[x]);
    }

    private void union(int x, int y) {
        // 두 집합을 하나의 집합으로 합침
        int root1 = find(x);
        int root2 = find(y);
        parent[root2] = root1;
    }
}
