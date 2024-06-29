import java.io.*;

// 24.06.29 (토)
public class 알파벳_개수 {
    // 단어 S의 길이: ~100 -> O(N^2)도 충분
    // 단어 S의 구성: 알파벳 소문자만
    /*
    의사 코드
        1. 단어 S 입력받음, S를 문자열 배열로 나누기
        2. 알파벳 소문자 개수에 해당되는 만큼의 배열 선언
        3. 단어 S의 각 원소에 따라서 해당되는 배열 원소의 값을 증가
        4. 배열 반환
        5. 공백 기준으로 배열의 원소를 순차적으로 출력
    전체 시간 복잡도는 O(N)
    */
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] arr = new int[((int) 'z') - ((int) 'a') + 1]; // + 1을 해야 마지막 값을 포함
        char[] command = reader.readLine().toCharArray();
        for (char c : command) {
            int index = (int) c - (int) 'a'; // 'a'로부터 얼마나 떨어져 있는지 계산
            arr[index]++;
        }
        for (int number : arr) {
            System.out.print(number + " ");
        }
        writer.close();
        reader.close();
    }
}
