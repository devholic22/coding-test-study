import java.util.HashMap;

// 24.08.03 (토)
public class problem_31_폰켓몬 {

    /*
    의사 코드
        1. nums를 입력받는다. nums의 길이를 N이라 한다.
        2. <번호, 갯수> 형태로 map을 저장한다.
        3. map의 키 갯수가 N/2 미만이라면 - map의 키 갯수를 반환한다. 어떤 조합으로 하든지 최대한 골라낼 수 있는 갯수는 map의 키 갯수이기 때문이다.
        4. map의 키 갯수가 N/2 이상이라면 - N/2를 반환한다. 원하고자 했던 갯수는 N/2이기 때문이다.
    시간 복잡도: O(N), N은 nums의 길이
    */
    public int solution(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        if (map.keySet().size() >= nums.length / 2) {
            return nums.length / 2;
        }
        return map.keySet().size();
    }
}
