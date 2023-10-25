package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Application {

    private static final String greeting = "숫자 야구 게임을 시작합니다.";
    private static final String winPrompt = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String playAgainPrompt = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Game.testMode = false;
        System.out.println(greeting);

        do {
            //Game.rigGuess(7, 1, 3);
            Game.generateNewNumber();
            Game.getPlayerGuess();

            while (!Game.evaluatePlayAndWinCondition()) {
                Game.getPlayerGuess();
            }

            System.out.println(winPrompt);
            System.out.println(playAgainPrompt);
            
        } //input of 1 means play again, 2 means end game
        while (Game.getPlayAgainInput() != 2);

    }
}
