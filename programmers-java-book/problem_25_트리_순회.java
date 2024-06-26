import java.util.Arrays;

// 24.06.26 (수)
public class problem_25_트리_순회 {

    public static void main(String[] args) {
        System.out.println("solve(new int[] {1, 2, 3, 4, 5, 6, 7}) = " + Arrays.toString(solve(new int[] {1, 2, 3, 4, 5, 6, 7})));
    }

    public static String[] solve(int[] nodes) {
        // 전위 순회, 중위 순회, 후위 순회 반환
        String[] answer = new String[3];
        // 전위 순회: mid - left - right 반복
        answer[0] = preOrder(nodes, 0).trim();
        // 중위 순회: left - mid - right 반복
        answer[1] = midOrder(nodes, 0).trim();
        // 후위 순회: left - right - mid 반복
        answer[2] = postOrder(nodes, 0).trim();
        return answer;
    }

    private static String preOrder(int[] nodes, int index) {
        if (nodes.length <= index) {
            return "";
        }
        return nodes[index] + " " + preOrder(nodes, index * 2 + 1) + preOrder(nodes, index * 2 + 2);
    }

    private static String midOrder(int[] nodes, int index) {
        if (nodes.length <= index) {
            return "";
        }
        return midOrder(nodes, index * 2 + 1)+ nodes[index] + " " + midOrder(nodes, index * 2 + 2);
    }

    private static String postOrder(int[] nodes, int index) {
        if (nodes.length <= index) {
            return "";
        }
        return postOrder(nodes, index * 2 + 1) + postOrder(nodes, index * 2 + 2)+ nodes[index] + " ";
    }
}
