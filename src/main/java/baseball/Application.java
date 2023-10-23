package baseball;


import baseball.ioSystem.InputVal;
import baseball.ioSystem.PlayerPoint;
import baseball.main.BaseballGame;


public class Application {
    public static boolean getEndGameFromInputVal() {
        String choice = InputVal.endGame();
        PlayerPoint.isNotValue(choice);
        if (choice.equals("2")) {
            return false;
        }
        return true;

    }
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");
        do {
            BaseballGame baseballGame = new BaseballGame();
            baseballGame.start();
        }
        while (getEndGameFromInputVal());
    }

}

