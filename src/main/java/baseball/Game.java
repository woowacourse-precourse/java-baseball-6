package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Game {
    GameState gameState = GameState.START;
    AnswerChecker answerChecker;

    public void play() {
        while (!gameState.equals(GameState.END)) {
            start();
            RandomNumber randomNumber = new RandomNumber();

            do {
                InputNumber inputNumber = getInput();
                answerChecker = new AnswerChecker();
                answerChecker.check(randomNumber, inputNumber);
            } while (!answerChecker.isAnswer());

            endOrRestart();
        }
    }
    public void start() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        gameState = GameState.ONGOING;
    }

    public InputNumber getInput() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        return new InputNumber(input);
    }
    public void endOrRestart() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");

        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String choice = Console.readLine();
        gameState = GameState.getByKey(choice);
    }
}
