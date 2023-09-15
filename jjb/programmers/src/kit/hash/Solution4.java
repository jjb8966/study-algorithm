package kit.hash;

import java.util.HashMap;
import java.util.Map;

public class Solution4 {

    public static void main(String[] args) {
        Solution4 prob = new Solution4();
        String[][] clothes = {
                {"yellow_hat", "headgear"},
                {"blue_sunglasses", "eyewear"},
                {"green_turban", "headgear"}
        };

        System.out.println(prob.solution(clothes));
    }

    public int solution(String[][] clothes) {
        int answer = 1;
        Map<String, Integer> clothMap = new HashMap<>();

        for (String[] cloth : clothes) {
            int count = clothMap.getOrDefault(cloth[1], 1);

            clothMap.put(cloth[1], count + 1);
        }

        for (Integer value : clothMap.values()) {
            answer *= value;
        }

        return answer - 1;
    }
}