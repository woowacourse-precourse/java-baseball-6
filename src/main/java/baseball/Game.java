package baseball;

import java.util.List;

public class Game {
    public Game() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void run() {
        while (true) {
            if (gamePlay() == 2) {
                break;
            }
        }
    }

    private int gamePlay() {
        Computer computer = new Computer();
        Player player = new Player();

        while (true) {
            List<Integer> hintValues = computer.compareTargetNumbers(player.getNumbers());
            if (printResult(hintValues)) {
                break;
            }
        }

        return player.getWantEnd();
    }

    private boolean printResult(List<Integer> hintValues) {
        int balls = hintValues.get(Hints.BALL.ordinal());
        int strikes = hintValues.get(Hints.STRIKE.ordinal());
        int nothings = hintValues.get(Hints.NOTHING.ordinal());

        if (nothings == 3) {
            System.out.println("낫싱");
            return false;
        }

        if (balls != 0) {
            System.out.print(Integer.toString(balls) + "볼");
        }

        if (balls != 0 && strikes != 0) {
            System.out.print(" ");
        }

        if (strikes != 0) {
            System.out.print(Integer.toString(strikes) + "스트라이크");
        }

        System.out.println();

        if (strikes == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        }

        return false;
    }


}
