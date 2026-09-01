class Solution {
    public int minMoves(String[] classroom, int energy) {

        int m = classroom.length;
        int n = classroom[0].length();

        int[][] litter = new int[m][n];

        int sr = 0, sc = 0;
        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                char ch = classroom[i].charAt(j);

                if (ch == 'S') {
                    sr = i;
                    sc = j;
                }

                if (ch == 'L') {
                    litter[i][j] = count++;
                }
            }
        }

        
        if (count == 0) {
            return 0;
        }

        int totalMask = (1 << count) - 1;

        
        boolean[][][][] visited =
            new boolean[m][n][energy + 1][1 << count];

        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[]{sr, sc, energy, totalMask});
        visited[sr][sc][energy][totalMask] = true;

        int[][] dir = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
        };

        int moves = 0;

        while (!q.isEmpty()) {

            int size = q.size();

            while (size-- > 0) {

                int[] curr = q.poll();

                int r = curr[0];
                int c = curr[1];
                int e = curr[2];
                int mask = curr[3];

               
                if (mask == 0) {
                    return moves;
                }

                
                if (e == 0) {
                    continue;
                }

                for (int[] d : dir) {

                    int nr = r + d[0];
                    int nc = c + d[1];

                   
                    if (nr < 0 || nr >= m ||
                        nc < 0 || nc >= n) {
                        continue;
                    }

                    
                    if (classroom[nr].charAt(nc) == 'X') {
                        continue;
                    }

                    int newEnergy = e - 1;
                    int newMask = mask;

                    char ch = classroom[nr].charAt(nc);

                    if (ch == 'R') {
                        newEnergy = energy;
                    }

                    
                    if (ch == 'L') {
                        int bit = litter[nr][nc];

                        newMask = newMask & ~(1 << bit);
                    }

                    if (!visited[nr][nc][newEnergy][newMask]) {

                        visited[nr][nc][newEnergy][newMask] = true;

                        q.offer(new int[]{
                            nr, nc, newEnergy, newMask
                        });
                    }
                }
            }

            moves++;
        }

        return -1;
    }
}