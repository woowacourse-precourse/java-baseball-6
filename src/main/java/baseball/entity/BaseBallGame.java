package baseball.entity;

import static baseball.util.Validator.checkValidEndGameInput;
import static baseball.util.Validator.checkValidInput;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class BaseBallGame {

    private boolean gameEnd;
    private CorrectNumber correctNumber;

    public BaseBallGame() {
        this.gameEnd = false;
        this.correctNumber = new CorrectNumber();
    }

    private boolean isGameEnd() {
        return gameEnd;
    }

    public void startGame() {
        System.out.println("숫자 야구 게임을 시작합니다");
        correctNumber.generateNewCorrectNum();
        while (!isGameEnd()) {
            System.out.println("숫자를 입력해주세요 :");
            String input = readLine();
            checkValidInput(input);

            Result result = correctNumber.compareToInput(input);
            System.out.println(result.toString());

            if (result.isAllCorrect()) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                askUserToEndGame();
            }
        }
    }

    private void completeGame() {
        this.gameEnd = true;
    }

    private void askUserToEndGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = readLine();
        checkValidEndGameInput(input);
        if (input.equals("2")) {
            this.completeGame();
        }
        if (input.equals("1")) {
            correctNumber.generateNewCorrectNum();
        }
    }
}
