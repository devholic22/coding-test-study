import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;

// 24.06.24 (월)
public class problem_21_오픈_채팅방 {

    public String[] solution(String[] record) {
        HashMap<String, String> user = new HashMap<>();
        ArrayDeque<String> code = new ArrayDeque<>();
        ArrayDeque<String> command = new ArrayDeque<>();
        ArrayList<String> list = new ArrayList<>();

        for (String r : record) {
            String[] split = r.split(" ");
            if (r.startsWith("Enter")) {
                user.put(split[1], split[2]);
                code.addLast(split[1]);
                command.addLast("Enter");
            } else if (r.startsWith("Leave")) {
                code.addLast(split[1]);
                command.addLast("Leave");
            } else {
                user.put(split[1], split[2]);
                code.addLast(split[1]);
                command.addLast("Change");
            }
        }
        while (!code.isEmpty() && !command.isEmpty()) {
            String c = code.pollFirst();
            String com = command.pollFirst();
            if (com.equals("Enter")) {
                list.add(user.get(c) + "님이 들어왔습니다.");
            } else if (com.equals("Leave")) {
                list.add(user.get(c) + "님이 나갔습니다.");
            }
        }

        String[] messages = new String[list.size()];
        for (int i = 0; i < messages.length; i++) {
            messages[i] = list.get(i);
        }
        return messages;
    }
}
