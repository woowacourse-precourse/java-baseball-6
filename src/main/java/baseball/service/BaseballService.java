package baseball.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class BaseballService {

    final String BALL = "볼";
    final String STRIKE = "스트라이크";

    public BaseballService() {

    }

    /**
     * 게임 결과를 구하는 메서드
     *
     * @param tryGame : player 가 시도하는 number, answer : 정답
     * @return 게임 결과
     */
    public String getGameResult(String tryGame, String answer) {
        String result = "낫싱";

        int strikeCnt = 0;
        int ballCnt = 0;

        for (int game = 0; game < tryGame.length(); ++game) {
            if (isStrike(game, tryGame.charAt(game), answer)) {
                strikeCnt++;
            } else if (isBall(tryGame.charAt(game), answer)) {
                ballCnt++;
            }
        }

        if (ballCnt > 0) {
            result = ballCnt + BALL + " ";
        } else if (strikeCnt != 0) {
            result = "";
        }
        if (strikeCnt > 0) {
            result += strikeCnt + STRIKE;
        }

        return result;
    }

    public String makeNewGame() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        return computer.toString().replaceAll("[^0-9]", "");
    }

    public Boolean isValid(String target) {
        if (target.length() != 3) {
            return false;
        }
        if (target.charAt(0) == target.charAt(1) || target.charAt(1) == target.charAt(2)
                || target.charAt(2) == target.charAt(0)) {
            return false;
        }

        return true;
    }

    private boolean isStrike(int point, char target, String answer) {
        return answer.charAt(point) == target;
    }

    private boolean isBall(char target, String answer) {
        for (int loop = 0; loop < answer.length(); ++loop) {
            if (answer.charAt(loop) == target) {
                return true;
            }
        }
        return false;
    }
}
