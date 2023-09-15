package kit.hash;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Solution5 {

    public static void main(String[] args) {
        Solution5 prob = new Solution5();
        String[] genres = {"A", "B", "C", "A", "B"};
        int[] plays = {500, 600, 150, 800, 2500};

        int[] solution = prob.solution(genres, plays);
        for (int result : solution) {
            System.out.println("result = " + result);
        }
    }

    private int[] solution(String[] genres, int[] plays) {
        int length = genres.length;
        boolean[] visited = new boolean[length];
        Map<String, Integer> sumMap = new HashMap<>();
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < length; i++) {
            sumMap.put(genres[i], sumMap.getOrDefault(genres[i], 0) + plays[i]);
        }

        ArrayList<Map.Entry<String, Integer>> entries = new ArrayList<>(sumMap.entrySet());
        entries.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

        for (Map.Entry<String, Integer> entry : entries) {
            String genre = entry.getKey();
            ArrayList<Integer> list = new ArrayList<>();

            for (int i = 0; i < length; i++) {
                if (genres[i].equals(genre)) {
                    list.add(plays[i]);
                }
            }

            list.sort(Comparator.reverseOrder());

            Integer play1 = list.get(0);
            for (int i = 0; i < length; i++) {
                if (plays[i] == play1 && !visited[i]) {
                    result.add(i);
                    visited[i] = true;
                }
            }

            if (list.size() > 1) {
                Integer play2 = list.get(1);
                for (int i = 0; i < length; i++) {
                    if (plays[i] == play2 && !visited[i]) {
                        result.add(i);
                        visited[i] = true;
                    }
                }
            }
        }

        return result.stream()
                .mapToInt(n -> n)
                .toArray();
    }

}