package algorithm_kit.해시;

import java.util.HashSet;

// 24.08.14 (수)
public class problem_01_폰켓몬 {

    public int solution(int[] nums) {
        // 구하고자 하는 폰켓몬 "선택" 수는 nums.length / 2, 문제에서 요구하는 것은 "최대 집합 수"
        // 폰켓몬들의 <집합> 수와 nums.length / 2 비교
        // <집합> 수 > nums.length / 2 -> nums.length / 2 반환
        // <집합> 수 == nums.length / 2 -> nums.length / 2 반환
        // <집합> 수 < nums.length / 2 -> <집합> 수
        // 집합을 이용하고 중복을 제거해야 하므로 HashSet 이용
        // 시간 복잡도 O(N), N은 nums.length
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        return set.size() >= nums.length / 2 ? nums.length / 2 : set.size();
    }
}
