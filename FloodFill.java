public class FloodFill {

    public static void main(String[] args) {
        int[][] image = new int[][] { { 1, 1, 1 }, { 1, 1, 0 }, { 1, 0, 1 } };
        int sr = 1;
        int sc = 1;
        int color = 2;
        int[][] res = floodFill(image, sr, sc, color);

        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[0].length; j++) {
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if (image[sr][sc] == color) {
            return image;
        }
        int initial = image[sr][sc];
        image[sr][sc] = color;

        if (sr - 1 > -1 && image[sr - 1][sc] == initial) {
            floodFill(image, sr - 1, sc, color);
        }
        if (sc - 1 > -1 && image[sr][sc - 1] == initial) {
            floodFill(image, sr, sc - 1, color);
        }
        if (sr + 1 < image.length && image[sr + 1][sc] == initial) {
            floodFill(image, sr + 1, sc, color);
        }
        if (sc + 1 < image[0].length && image[sr][sc + 1] == initial) {
            floodFill(image, sr, sc + 1, color);
        }

        return image;

    }
}
