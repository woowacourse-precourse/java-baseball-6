package baseball;

public class Inning {
    public static int[] getStrikeBallCount(ComputerNumber computerNumber, PlayerNumber playerNumber) {
        int[] strikeBallCount = new int[2];
        for (int i = 0; i < 3; i++) {
            int cur = playerNumber.get(i) - '0';
            if (computerNumber.get(i) == cur) {
                strikeBallCount[0]++;
            } else if (computerNumber.contains(cur)) {
                strikeBallCount[1]++;
            }
        }
        return strikeBallCount;
    }
}
