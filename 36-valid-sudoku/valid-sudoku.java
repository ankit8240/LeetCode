
class Solution {
    public boolean isValidSudoku(char[][] board) {

        HashSet<String> set = new HashSet<>();

        for (int i = 0; i < 9; i++) {

            for (int j = 0; j < 9; j++) {

                if (board[i][j] == '.') {
                    continue;
                }

                char num = board[i][j];

                String row = num + " row " + i;
                String col = num + " col " + j;
                String box = num + " box " + (i / 3) + "-" + (j / 3);

                if (!set.add(row)) {
                    return false;
                }

                if (!set.add(col)) {
                    return false;
                }

                if (!set.add(box)) {
                    return false;
                }
            }
        }

        return true;
    }
}