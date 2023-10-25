package baseball;

import camp.nextstep.edu.missionutils.Console;

public class GameManager {
    private Match match;

    public void runGame() throws IllegalArgumentException {
        while(true) {
            displayGameStart();

            match = new Match(new Catcher(), new Pitcher(), new Referee());
            match.init();
            match.run();

            displayGameEnd();
            String choice = askForRestart();

            if (isInValidChoice(choice)) {
                throw new IllegalArgumentException("올바르지 않은 입력입니다.");
            }

            if (isGameEnd(choice)) {
                break;
            }
        }
    }

    public void displayGameStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void displayGameEnd() {
        System.out.println(Constant.MAX_NUMBER_SIZE + "개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public String askForRestart() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return Console.readLine();
    }

    public boolean isInValidChoice(String choice) {
        return !(isGameEnd(choice) || isGameRestart(choice));
    }

    public boolean isGameEnd(String choice) {
        return choice.equals(Constant.EXIT);
    }

    public boolean isGameRestart(String choice) {
        return choice.equals(Constant.RESTART);
    }
}
