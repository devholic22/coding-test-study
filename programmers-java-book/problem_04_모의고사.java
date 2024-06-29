import java.util.ArrayList;

// 24.06.15 (토)
// 24.06.29 (토) review
public class problem_04_모의고사 {

    // https://school.programmers.co.kr/learn/courses/30/lessons/42840
    // 시험: 최대 10,000 문제 -> O(NlogN) 까지만 써야 합니다.
    // 문제의 정답은 1 ~ 5 중 하나
    // 가장 높은 점수를 받은 사람이 여럿일 경우 오름차순 정렬하여 반환
    /*
    의사 코드
        1. 정수 배열을 받는다.
        2. 수포자들의 패턴을 분석한다.
            2-1. 1번 수포자: [1, 2, 3, 4, 5] (5개)
            2-2. 2번 수포자: [2, 1, 2, 3, 2, 4, 2, 5] (8개)
            2-3. 3번 수포자: [3, 3, 1, 1, 2, 2, 4, 4, 5, 5] (10개)
        3. 수포자들에 대한 클래스를 만든다. Person(사람 번호, 맞힌 갯수);
        4. 정수 배열 (문제)을 순차적으로 진행한다.
        5. 각 수포자들마다 특정 문제의 답과 자신의 패턴이 일치하면 맞힌 갯수를 증가시킨다.
            5-1. answers[문제 번호 % 사람에 해당하는 패턴 갯수]로 비교하면 된다.
        6. 가장 문제를 많이 맞춘 사람의 갯수를 구한다.
        7. ArrayList를 선언하여, 가장 문제를 많이 맞춘 사람의 인덱스들을 담는다.
        8. 해당 ArrayList를 int[]로 변환한 뒤 오름차순 정렬한다.
        9. 정렬된 배열을 반환한다.
    */
    // Person 클래스를 생성합니다. 우선순위를 가집니다.
    public class Person implements Comparable<Person> {
        int number;
        int count;
        public Person(int number, int count) {
            this.number = number;
            this.count = count;
        }
        @Override
        public int compareTo(Person other) {
            return Integer.compare(this.number, other.number);
        }
    }

    public int[] solution(int[] answers) {
        /*
        int[] one = {1, 2, 3, 4, 5};
        int[] two = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] three = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        학생 수가 늘어날수록 비효율적이게 됩니다. 미리 2차원 배열로 선언합니다.
        */
        int[][] patterns = {
                {1, 2, 3, 4, 5},
                {2, 1, 2, 3, 2, 4, 2, 5},
                {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
        };
        int max = Integer.MIN_VALUE;
        // Person 클래스를 초기화합니다.
        Person[] persons = new Person[3];
        for (int i = 0; i < 3; i++) {
            persons[i] = new Person(i + 1, 0);
        }
        for (int i = 0; i < answers.length; i++) {
            /*
            if (one[i % one.length] == answers[i]) {
                persons[0].count++;
            }
            if (two[i % two.length] == answers[i]) {
                persons[1].count++;
            }
            if (three[i % three.length] == answers[i]) {
                persons[2].count++;
            }
            */
            // 2중 for문을 이용하여 쉽게 count를 계산합니다.
            for (int j = 0; j < 3; j++) {
                if (answers[i] == patterns[j][i % patterns[j].length]) {
                    persons[j].count++;
                }
            }
        }
        // 최댓값을 구합니다.
        for (Person p : persons) {
            max = Math.max(max, p.count);
        }
        // 최댓값에 해당하는 수포자들만 저장합니다.
        ArrayList<Person> result = new ArrayList<>();
        for (Person p : persons) {
            if (max == p.count) {
                result.add(p);
            }
        }
        // 우선순위로 정렬하고, 인덱스만을 매핑한 배열을 반환하도록 합니다.
        return result.stream()
                .sorted()
                .mapToInt(p -> p.number)
                .toArray();

        /*
        더 나은 방식
        1. 일단 위 방식은 O(NlogN)에 해당됩니다.
        2. 굳이 별도의 클래스를 가질 필요가 없습니다.
        3. 순차적으로 정렬하는 것이기 때문에 정렬 알고리즘을 쓸 필요가 없었습니다.
        int[][] patterns = 이전과 동일하게 설정
        int[] scores = new int[3];
        for (int i = 0; i < answers.length; i++) {
            for (int j = 0; j < patterns.length; j++) {
                if (answers[i] == patterns[j][i % patterns[j].length]) {
                    scores[j]++;
                }
            }
        }
        int max = Arrays.stream(scores).max().getAsInt(); // 최댓값, Math.max 이용해도 됨
        ArrayList<Integer> answer = new ArrayList<>();
        for (int i = 0; i < scores.length; i++) {
            if (scores[i] == max) {
                answer.add(i + 1);
            }
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
        이 방식을 쓰면 O(N)으로 개선 가능합니다.
        결론: 정렬 알고리즘이 필요하다고 하더라도, 순차 탐색으로 가능할 것 같으면 굳이 정렬 알고리즘, 메서드를 이용하지 말자
         */
    }
}
