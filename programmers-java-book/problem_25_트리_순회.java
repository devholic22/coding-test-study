import java.util.Arrays;

// 24.06.26 (수)
// 24.07.04 (목) review
public class problem_25_트리_순회 {

    // 이진 트리를 표현한 리스트 nodes를 인자로 받습니다.
    // 예를 들어서 nodes가 [1, 2, 3, 4, 5, 6, 7]이면 다음과 같은 트리를 표현한 것입니다. (그림)
    // 해당 이진 트리에 대하여 전위 순회, 중위 순회, 후위 순회 결과를 반환하는 solution() 함수를 구현하세요.
    // 입력 노드값의 개수는 1개 이상 1,000개 이하이다.
    // 노드값은 정수형이며, 중복되지 않는다.
    // 권장 시간 복잡도 O(N)
    /*
    의사 코드
        1. nodes를 입력 받는다.
        2. 세 가지 순회를 문자열로 저장할 배열을 선언한다.
        3. 전위 순회 값을 2번 배열의 0번째 요소에 담는다. parent - left - right
        4. 중위 순회 값을 2번 배열의 1번째 요소에 담는다. left - parent - right
        5. 후위 순회 값을 2번 배열의 2번째 요소에 담는다. left - right - parent
     시간 복잡도: O(N)
     */
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7}; // zero-index 고려해야 함
        System.out.println("solution(numbers) = " + Arrays.toString(solution(numbers)));
    }

    public static String[] solution(int[] nodes) {
        String[] answer = new String[3];
        // 전위 순회: parent - left - right
        answer[0] = preOrder(nodes, 0).trim();
        // 중위 순회: left - parent - right
        answer[1] = inOrder(nodes, 0).trim();
        // 후위 순회: left - right - parent
        answer[2] = postOrder(nodes, 0).trim();
        return answer;
    }

    public static String preOrder(int[] nodes, int index) {
        if (index >= nodes.length) {
            return "";
        }
        return nodes[index] + " " + preOrder(nodes, index * 2 + 1) + preOrder(nodes, index * 2 + 2);
    }

    public static String inOrder(int[] nodes, int index) {
        if (index >= nodes.length) {
            return "";
        }
        return inOrder(nodes, index * 2 + 1) + " " + nodes[index] + inOrder(nodes, index * 2 + 2);
    }

    public static String postOrder(int[] nodes, int index) {
        if (index >= nodes.length) {
            return "";
        }
        return postOrder(nodes, index * 2 + 1) + postOrder(nodes, index * 2 + 2) + " " + nodes[index];
    }
}
