package baseball;

public class Inning {
    public static int[] getStrikeBallCount(Computer computer, PlayerNumber playerNumber) {
        int[] strikeBallCount = new int[2];
        for (int i = 0; i < 3; i++) {
            int cur = playerNumber.get(i) - '0';
            if (computer.get(i) == cur) {
                strikeBallCount[0]++;
            } else if (computer.contains(cur)) {
                strikeBallCount[1]++;
            }
        }
        return strikeBallCount;
    }
}
