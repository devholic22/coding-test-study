import java.util.ArrayList;
import java.util.HashMap;

// 24.06.23 (일)
public class problem_20_할인_행사 {

    public int solution(String[] want, int[] number, String[] discount) {
        // 각 discount마다 몇 일째에는 뭘 할인하는지를 담아두기
        // 각각의 want[i]가 number[i]개를 충족하는지 살펴보기
        ArrayList<Integer> days = new ArrayList<>();
        HashMap<Integer, String> dayAndProduct = new HashMap<>();
        for (int i = 0; i < discount.length; i++) {
            dayAndProduct.put(i, discount[i]);
        }
        // 0일 째 부터 discount.length - 1일 째 까지 탐색
        for (int i = 0; i < discount.length; i++) {
            boolean value = true;
            for (int j = 0; j < want.length; j++) {
                if (!isValid(dayAndProduct, want[j], i, number[j])) {
                    value = false;
                }
            }
            if (value) {
                days.add(i);
            }
        }
        return days.size();
    }
    private boolean isValid(HashMap<Integer, String> map, String w, int day, int goal) {
        int size = 0;
        for (int i = day; i < day + 10; i++) {
            if (!map.containsKey(i)) {
                continue;
            }
            if (map.get(i).equals(w)) {
                size++;
            }
        }
        return size >= goal;
    }
}
