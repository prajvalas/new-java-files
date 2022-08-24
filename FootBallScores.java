import java.util.Arrays;

public class FootBallScores {
    public static void main(String[] args) {
        int[] teamA = new int[] { 1, 4, 2, 4 };// { 2, 10, 5, 4, 8 };// { 1, 4, 2, 4 };// { 1, 2, 3 };
        int[] teamB = new int[] { 3, 5 };// { 3, 1, 7, 8 };// { 3, 5 };// { 2, 4 };
        int[] result = getScores(teamA, teamB);
        for (int elem : result) {
            System.out.println(elem);
        }
    }

    public static int[] getScores(int[] teamA, int[] teamB) {
        int[] answer = new int[teamB.length];
        Arrays.sort(teamA);

        int i = 0;
        for (int elem : teamB) {
            answer[i++] = binarySearch(teamA, elem);
        }
        return answer;
    }

    public static int binarySearch(int[] teamA, int target) {
        int low = 0;
        int high = teamA.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (teamA[mid] == target) {
                return mid + 1;
            } else if (teamA[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }

        }
        return high + 1;
    }
}
