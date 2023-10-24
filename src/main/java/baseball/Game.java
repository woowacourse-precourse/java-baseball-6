package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;

public class Game {
    private Player player;
    private Player computer;

    private Hint hint = new Hint();

    public Game() {
    }

    public void startGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");

        player = new Player();
        computer = new Player();
    }

    public void endGame() {
        System.out.println("숫자 야구 게임을 종료합니다.");
    }

    public void getGuessNums() {
        System.out.print("숫자를 입력해주세요 : ");
        int guessNumsInt = toValidInt(Console.readLine());
        ArrayList<Integer> guessNums = new ArrayList<Integer>();

        for (int i = 0; i < 3; i++) {
            int num = guessNumsInt % 100;
            guessNumsInt /= 100;
            guessNums.add(0, num);
        }

        player.setGuessNums(guessNums);
    }

    public int toValidInt(String guessNumsStr) {
        int guessNumsInt = 0;

        try {
            guessNumsInt = Integer.parseInt(guessNumsStr);

            // 0이 들어가지 않았는지
            if (guessNumsStr.contains("0")) {
                throw new IllegalArgumentException();
            }

            // 3자리의 숫자인지
            if (guessNumsInt / 100 < 1 || guessNumsInt / 100 > 9) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            System.exit(0);
        }

        return guessNumsInt;
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
            String valueStr = Console.readLine();
            int value = Integer.parseInt(valueStr);

            if (value == 1) {
                return true;
            } else if (value == 2) {
                return false;
            } else {
                System.out.println("잘못된 입력 값 입니다.");
            }
        }
    }
}
