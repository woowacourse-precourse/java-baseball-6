package baseball;

import java.util.List;

public class BaseballUmpire {

    public static GameStatus judge(List<Integer> botNumbers, List<Integer> playerNumbers) {

        int strikes = 0;
        int balls = 0;

        for (int i = 0; i < botNumbers.size(); i++) {
            if (botNumbers.get(i).equals(playerNumbers.get(i))) {
                strikes++;
            } else if (botNumbers.contains(playerNumbers.get(i))) {
                balls++;
            }
        }

        if (strikes == 3) {
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return GameStatus.END;
        } else if (strikes == 0 && balls == 0) {
            System.out.println("낫싱");
            return GameStatus.CONTINUE;
        } else {
            System.out.println(balls + "볼 " + strikes + "스트라이크");
            return GameStatus.CONTINUE;
        }
    }
}
