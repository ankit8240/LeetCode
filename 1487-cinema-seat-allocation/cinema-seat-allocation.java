class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();

        for (int[] seat : reservedSeats) {
            map.putIfAbsent(seat[0], new HashSet<>());
            map.get(seat[0]).add(seat[1]);
        }

        int ans = (n - map.size()) * 2;

        for (int row : map.keySet()) {
            HashSet<Integer> s = map.get(row);

            boolean left = true;   
            boolean mid = true;    
            boolean right = true;  

            for (int i = 2; i <= 5; i++)
                if (s.contains(i)) left = false;

            for (int i = 4; i <= 7; i++)
                if (s.contains(i)) mid = false;

            for (int i = 6; i <= 9; i++)
                if (s.contains(i)) right = false;

            if (left && right)
                ans += 2;
            else if (left || mid || right)
                ans += 1;
        }

        return ans;
    }
}