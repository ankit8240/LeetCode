import java.util.*;

class Solution {

    public int[] maximumWeight(List<List<Integer>> intervals) {

        int n = intervals.size();

        
        int[][] arr = new int[n][4];

        for (int i = 0; i < n; i++) {
            arr[i][0] = intervals.get(i).get(0);
            arr[i][1] = intervals.get(i).get(1);
            arr[i][2] = intervals.get(i).get(2);
            arr[i][3] = i;
        }

        
        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));

        int[] starts = new int[n];

        for (int i = 0; i < n; i++) {
            starts[i] = arr[i][0];
        }

    
        int[] next = new int[n];

        for (int i = 0; i < n; i++) {

            int left = i + 1;
            int right = n;

            while (left < right) {

                int mid = left + (right - left) / 2;

                
                if (starts[mid] > arr[i][1]) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }

            next[i] = left;
        }

        
        State[][] dp = new State[n + 1][5];

        for (int k = 0; k <= 4; k++) {
            dp[n][k] = new State(0, new ArrayList<>());
        }

        for (int i = n - 1; i >= 0; i--) {

            dp[i][0] = new State(0, new ArrayList<>());

            for (int k = 1; k <= 4; k++) {

            
                State skip = dp[i + 1][k];

                
                State after = dp[next[i]][k - 1];

                List<Integer> list = new ArrayList<>(after.indices);
                list.add(arr[i][3]);

                Collections.sort(list);

                State take = new State(
                    after.weight + arr[i][2],
                    list
                );

                dp[i][k] = better(skip, take);
            }
        }

        List<Integer> answer = dp[0][4].indices;

        int[] result = new int[answer.size()];

        for (int i = 0; i < answer.size(); i++) {
            result[i] = answer.get(i);
        }

        return result;
    }


    
    private State better(State a, State b) {

        if (a.weight > b.weight) return a;
        if (b.weight > a.weight) return b;

        
        int size = Math.min(a.indices.size(), b.indices.size());

        for (int i = 0; i < size; i++) {

            if (!a.indices.get(i).equals(b.indices.get(i))) {

                return a.indices.get(i) < b.indices.get(i)
                        ? a
                        : b;
            }
        }


        return a.indices.size() <= b.indices.size() ? a : b;
    }


    static class State {

        long weight;
        List<Integer> indices;

        State(long weight, List<Integer> indices) {
            this.weight = weight;
            this.indices = indices;
        }
    }
}