package baseball.gameRule;

import baseball.constants.Constants;
import java.util.List;

public class GameRule {
    public boolean checkEndGame(int strikes) { // strikes 가 3 일 경우에 게임을 종료시키는 메서드
        if (strikes == Constants.STRIKE_FOR_ENDGAME) {
            return true;
        }
        return false;
    }

    public int checkStrike(List<Integer> playerInput, List<Integer> cpuInput) { // 스트라이크를 체크
        int strikes = 0;
        for (int i = 0; i < Constants.INPUT_LENGTH; i++) {
            if (playerInput.get(i) == cpuInput.get(i)) {
                strikes++;
            }
        }
        return strikes;
    }

    public int checkBall(List<Integer> playerInput, List<Integer> cpuInput) { // 볼을 체크
        int balls = 0;
        for (int i = 0; i < Constants.INPUT_LENGTH; i++) {
            if (playerInput.get(i) != cpuInput.get(i) && cpuInput.contains(playerInput.get(i))) {
                balls++;
            }
        }
        return balls;
    }

    public String checkNothing(List<Integer> playerInput, List<Integer> cpuInput) { // 낫싱인지 체크
        int nothingCount = 0;
        String nothing = "낫싱";
        for (int i = 0; i < Constants.INPUT_LENGTH; i++) {
            if (!cpuInput.contains(playerInput.get(i))) {
                nothingCount++;
            }
        }
        if (nothingCount == 3) {
            return nothing;
        }
        return "낫싱 아님";
    }

    public boolean playGameAgain() {
        boolean check = true;

        while (true) {
            String gameContinue = camp.nextstep.edu.missionutils.Console.readLine();
            if (gameContinue.equals("1")) {
                check = true;
                break;
            }
            if (gameContinue.equals("2")) {
                check = false;
                break;
            }
            System.out.println(Constants.INSERT_ONE_OR_TWO);
        }
        return check;
    }
}
