public class IsPossible {
    public static void main(String[] args) {
        int a = 1;
        int b = 1;
        int c = 5;
        int d = 10;
        String res = isPoss(a, b, c, d);
        System.out.println(res);
    }

    public static String isPoss(int sx, int sy, int tx, int ty) {
        while (sx < tx && sy < ty)
            if (tx < ty)
                ty %= tx;
            else
                tx %= ty;

        if (sx == tx && sy <= ty && (ty - sy) % sx == 0)
            return "Yes";

        if (sy == ty && sx <= tx && (tx - sx) % sy == 0) {
            return "Yes";
        }
        return "No";
    }
}
