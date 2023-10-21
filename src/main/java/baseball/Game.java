package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;

public class Game {
    private Player player = new Player();
    private Player computer = new Player();

    private Hint hint = new Hint();

    public Game() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void getGuessNums() {
        System.out.print("숫자를 입력해주세요 : ");
        String guessNumsStr = Console.readLine();
        ArrayList guessNums = new ArrayList<>();
        for (int i = 0; i < guessNumsStr.length(); i++) {
            guessNums.add(guessNumsStr.charAt(i));
        }

        player.setGuessNums(guessNums);
    }

    public int getHint() {
        hint.makeHint(player.getGuessNums(), computer.getNums());
        int ball = hint.getBall();
        int strike = hint.getStrike();
        // 낫싱: 0, 볼 또는 스트라이크: 1, 3개의 숫자를 모두 맞힐 경우: 2
        int result = -1;

        if (strike == 3) {
            System.out.println(strike + "스트라이크");
            System.out.println(strike + "개의 숫자를 모두 맞히셨습니다! 게임 종료");

            result = 2;
        } else if (ball >= 1 || strike >= 1) {
            System.out.println(ball + "볼 " + strike + "스트라이크");

            result = 1;
        } else if (ball == 0 && strike == 0) {
            System.out.println("낫싱");

            result = 0;
        }

        return result;
    }

    public boolean isRestart() {
        while (true) {
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String value = Console.readLine();

            if (value == "1") {
                return true;
            } else if (value == "2") {
                return false;
            } else {
                System.out.println("잘못된 입력 값 입니다.");
            }
        }
    }
}
