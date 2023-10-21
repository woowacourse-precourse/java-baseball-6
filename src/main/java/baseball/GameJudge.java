package baseball;

public class GameJudge {
    private static int getStrikeCnt(ValidateNumbers computer, ValidateNumbers player) {
        int count = 0;
        for(int i = 0; i < computer.length() ; i++) {
            if (computer.getNumberAt(i) == player.getNumberAt(i))
                count++;
        }
        return count;
    }
    private static int getBallCnt(ValidateNumbers computer, ValidateNumbers player) {
        int count = 0;
        for(int i = 0; i < computer.length(); i++) {
            for(int j = 0; j < computer.length(); j++) {
                if(i==j) {
                    continue;
                }
                if (computer.getNumberAt(i) == player.getNumberAt(j)) {
                    count++;
                }
            }
        }
        return count;
    }

    public static String getResult (ValidateNumbers computer, ValidateNumbers player) {
        int strikeCnt = getStrikeCnt(computer, player);
        int ballCnt = getBallCnt(computer, player);
        if (strikeCnt == 0 && ballCnt == 0) {
            return "낫싱";
        }

        String result = "";
        if (ballCnt != 0) {
            result += ballCnt + "볼 ";
        }
        if (strikeCnt != 0) {
            result += strikeCnt + "스트라이크";
        }
        return result;
    }

    public static boolean isGameFinish (ValidateNumbers computer, ValidateNumbers player) {
        return getResult(computer, player).equals("3스트라이크");
    }
}
