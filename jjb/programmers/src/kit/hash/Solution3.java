package kit.hash;

import java.util.HashSet;
import java.util.Set;

public class Solution3 {

    public static void main(String[] args) {
        Solution3 prob = new Solution3();
        String[] phoneBook = {"12", "123", "1235", "567", "88"};

        System.out.println(prob.solution(phoneBook));
    }

    private boolean solution(String[] phone_book) {
        Set<String> set = new HashSet<>();

        for (String exp : phone_book) {
            set.add(exp);
        }

        for (String exp : phone_book) {
            for (int i = 1; i < exp.length(); i++) {
                if (set.contains(exp.substring(0, i))) {
                    return false;
                }
            }
        }

        return true;
    }
}