package view;

import camp.nextstep.edu.missionutils.Console;
import controller.ComputerController;
import dto.GuessResultDto;
import global.Constants;

public class GameView {
    private static GameView instance = new GameView();
    private static ComputerController computerController = ComputerController.getInstance();

    private GameView() { }

    public static GameView getInstance() {
        if (instance == null) {
            instance = new GameView();
        }
        return instance;
    }

    public void startGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void guessNumber() {
        System.out.println("숫자를 입력해주세요 : ");
        computerController.guessNumber(Console.readLine());
    }

    public void guessResult(GuessResultDto guessResultDto) {
        int ball = guessResultDto.getBall();
        int strike = guessResultDto.getStrike();

        if (ball == 0 && strike != 0) {
            System.out.println(strike + "스트라이크");
        }
        else if (ball != 0 && strike == 0) {
            System.out.println(ball + "볼");
        }
        else if (ball == 0 && strike == 0) {
            System.out.println("낫싱");
        }
        else {
            System.out.println(ball + "볼 " + strike + "스트라이크");
        }

        if (strike == Constants.RANDOM_NUM_LENGTH) {
            endGame();
        }
    }

    public void endGame() {
        System.out.println(Constants.RANDOM_NUM_LENGTH + "개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        String choice = Console.readLine();
        validateChoice(choice);
        if (choice.equals(Constants.GAME_RESTART_FLAG)) {
            computerController.restartGame();
        }
        else if (choice.equals(Constants.GAME_END_FLAG)) {
            computerController.endGame();
        }
    }

    private void validateChoice(String choice) {
        if (!(choice.equals("1") || choice.equals("2"))) {
            throw new IllegalArgumentException("1 또는 2의 숫자만 입력할 수 있습니다.");
        }
    }
}
