package kit.hash;

import java.util.*;

public class Solution2 {

    public static void main(String[] args) {
        Solution2 prob = new Solution2();
        String[] participant = {"leo", "kiki", "eden", "kiki"};
        String[] completion = {"eden", "kiki", "leo"};

        System.out.println(prob.solution(participant, completion));
    }

    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> participantMap = new HashMap<>();

        for (String name : participant) {
            participantMap.put(name, participantMap.getOrDefault(name, 0) + 1);
        }

        for (String name : completion) {
            participantMap.put(name, participantMap.get(name) - 1);
        }

        Map.Entry<String, Integer> result = participantMap.entrySet()
                .stream()
                .filter(entry -> entry.getValue() != 0)
                .findAny()
                .get();

        return result.getKey();
    }

}