package algorithm_kit.해시;

import java.util.HashMap;

// 24.08.15 (목)
public class problem_04_의상 {

    public int solution(String[][] clothes) {
        // <의상의 이름>, <의상의 종류>로 구성되므로 <의상의 종류, 갯수>로 관리하기 위해 HashMap 이용
        // 기본적으로 모든 원소를 한 가지만 선택했을 때의 가짓수 더해짐
        HashMap<String, Integer> map = new HashMap<>();
        int size = 1;
        for (String[] cloth : clothes) {
            if (map.containsKey(cloth[1])) {
                map.put(cloth[1], map.get(cloth[1]) + 1);
            } else {
                map.put(cloth[1], 1);
            }
        }
        // 두 개 이상 있는 종류의 경우 - 갯수 + 1개 (이유: 그 종류를 선택하지 않는 경우 존재함)
        // 하나 있는 종류의 경우 - 2개 (이유: 선택 or 선택 x)
        // 이것들을 전부 곱한 뒤, 모두를 선택하지 않는 1가지를 제외
        for (String key : map.keySet()) {
            if (map.get(key) > 1) {
                size *= (map.get(key) + 1);
            } else {
                size *= 2;
            }
        }
        return size - 1;
        // 시간 복잡도 O(N), N은 종류의 갯수
    }
}
