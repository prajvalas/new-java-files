public class CanReach {
    public static void main(String[] args) {
        int x1 = 1;
        int y1 = 4;
        int x2 = 7;
        int y2 = 6;
        int c = 1;
        String res = canReach(c, x1, y1, x2, y2);
        System.out.println(res);
    }

    public static String canReach(int c, int x1, int y1, int x2, int y2) {
        if (dfs(c, x1, y1, x2, y2)) {
            return "Yes";
        }
        return "No";
    }

    public static boolean dfs(int c, int x1, int y1, int x2, int y2) {
        if (x1 == x2 && y1 == y2) {
            return true;
        }

        if (Math.sqrt(x1 + y1) == (int) (Math.sqrt(x1 + y1))) {
            return false;
        }

        if (x1 > x2 || y1 > y2) {
            return false;
        }

        return dfs(c, x1 + y1, y1, x2, y2) || dfs(c, x1, x1 + y1, x2, y2) || dfs(c, x1 + c, y1 + c, x2, y2);
    }
}
