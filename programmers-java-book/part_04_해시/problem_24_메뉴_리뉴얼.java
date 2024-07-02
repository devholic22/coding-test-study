package part_04_해시;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Arrays;
// 24.06.25 (화)
// 24.07.02 (화) review
public class problem_24_메뉴_리뉴얼 {
    // 2 <= orders.length <= 20
    // 각 원소 크기는 2 ~ 10, 알파벳 대문자, 중복 X
    // 1 <= course.length <= 10
    // 각 원소 2 ~ 10, 오름차순, 중복 X
    // 사전 순으로 오름차순
    /*
    의사 코드
        1. orders, course 입력받음
        2. 코스, 갯수 형태로 관리할 HashMap 선언
        3. 각 order를 돌면서 만들 수 있는 가짓수 생성하여 2번에 저장 (ex: ABCFG일 시 AB, ABC..)
            3.1. 음식 조합을 만들어내는 함수 작성
            3-2. 이때 make(orders, course) 이런 식으로 반복되도록 orders 반복문 안에 course 반복문이 있어야 함
        4. course를 돌면서 각 course 길이에 맞는 것 중 가장 많이 시킨 걸 가져오는 함수 작성 (List<String>)
        5. 4번 결괏값들을 하나의 List<String>에 두고 이를 String[] 화 한뒤 정렬, 반환
    백트래킹에서의 효율성을 높여야 했다.
    시간 복잡도는 O(N * K * M * 2^M), N은 orders (최대 20), K는 course (최대 10), M은 order 길이 (최대 10)를 의미
    */
    static String[] temp;

    public String[] solution(String[] orders, int[] course) {
        HashMap<String, Integer> map = new HashMap<>();
        ArrayList<String> result = new ArrayList<>();
        for (int i = 0; i < orders.length; i++) {
            for (int j = 0; j < course.length; j++) {
                if (orders[i].length() < course[j]) {
                    continue;
                }
                ArrayList<String> foods = make(orders[i], course[j]);
                for (String food : foods) {
                    String[] tokens = food.split("");
                    Arrays.sort(tokens);
                    String r = String.join("", tokens);
                    if (map.containsKey(r)) {
                        map.put(r, map.get(r) + 1);
                    } else {
                        map.put(r, 1);
                    }
                }
            }
        }

        for (int size : course) {
            ArrayList<String> extracted = extract(map, size);
            result.addAll(extracted);
        }
        return result.stream().map(s -> s).sorted().distinct().toArray(String[]::new);
    }

    public ArrayList<String> make(String order, int size) {
        String[] tokens = order.split("");
        boolean[] used = new boolean[order.length()];
        temp = new String[size];
        HashSet<String> answer = new HashSet<>();
        HashSet<String> result = new HashSet<>();
        backtracking(tokens, used, 0, size, answer);
        for (String a : answer) {
            String[] r = a.split("");
            Arrays.sort(r);
            result.add(String.join("", r));
        }
        return new ArrayList<>(result);
    }

    public void backtracking(String[] tokens, boolean[] used, int depth, int size, HashSet<String> answer) {
        if (depth == size) {
            // Arrays.sort(temp);
            answer.add(String.join("", temp));
            // temp = new String[tokens.length];
            // used = new boolean[size];
            return;
        }
        for (int i = 0; i < tokens.length; i++) {
            if (used[i]) {
                continue;
            }
            temp[depth] = tokens[i];
            used[i] = true;
            backtracking(tokens, used, depth + 1, size, answer);
            used[i] = false;
        }
    }

    public ArrayList<String> extract(HashMap<String, Integer> map, int size) {
        int max = 0;
        HashSet<String> answer = new HashSet<>();
        for (String key : map.keySet()) {
            if (key.length() == size) {
                max = Math.max(max, map.get(key));
            }
        }
        if (max < 2) {
            return new ArrayList<>();
        }
        for (String key : map.keySet()) {
            if (key.length() == size && map.get(key) == max) {
                answer.add(key);
            }
        }
        return new ArrayList<>(answer);
    }
    /*
    정답 코드
    전체적인 흐름은 같았으나, 백트래킹의 효율이 좋지 못했다.
    import java.util.HashMap;
    import java.util.ArrayList;
    import java.util.HashSet;
    import java.util.Arrays;

    class Solution {
        public String[] solution(String[] orders, int[] course) {
            HashMap<String, Integer> map = new HashMap<>();
            ArrayList<String> result = new ArrayList<>();

            for (String order : orders) {
                for (int c : course) {
                    if (order.length() < c) {
                        continue;
                    }
                    char[] orderArr = order.toCharArray();
                    Arrays.sort(orderArr);
                    boolean[] used = new boolean[orderArr.length];
                    combine(orderArr, used, 0, 0, c, new StringBuilder(), map);
                }
            }

            for (int size : course) {
                ArrayList<String> extracted = extract(map, size);
                result.addAll(extracted);
            }

            return result.stream().sorted().distinct().toArray(String[]::new);
        }

        private void combine(char[] order, boolean[] used, int start, int depth, int size, StringBuilder current, HashMap<String, Integer> map) {
            if (depth == size) {
                String combination = current.toString();
                map.put(combination, map.getOrDefault(combination, 0) + 1);
                return;
            }

            for (int i = start; i < order.length; i++) {
                if (used[i]) continue;
                used[i] = true;
                current.append(order[i]);
                combine(order, used, i + 1, depth + 1, size, current, map);
                current.deleteCharAt(current.length() - 1);
                used[i] = false;
            }
        }

        private ArrayList<String> extract(HashMap<String, Integer> map, int size) {
            int max = 0;
            HashSet<String> answer = new HashSet<>();

            for (String key : map.keySet()) {
                if (key.length() == size) {
                    max = Math.max(max, map.get(key));
                }
            }

            if (max < 2) {
                return new ArrayList<>();
            }

            for (String key : map.keySet()) {
                if (key.length() == size && map.get(key) == max) {
                    answer.add(key);
                }
            }

            return new ArrayList<>(answer);
        }
    }
     */
}
