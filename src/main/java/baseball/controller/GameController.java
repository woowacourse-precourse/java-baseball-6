package baseball.controller;

import baseball.domain.Game;
import baseball.view.GameView;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class GameController {

    private int gameRestart = 1;
    private Game game;
    private GameView view;

    public GameController() {
        game = new Game();
        view = new GameView();
    }

    public void startGame() {
        view.displayStartMessage();
        while (gameRestart == 1) {
            List<Integer> computer = game.getComputerNumber();
            while (true) {
                String userNumber = view.getUserInput();
                List<Integer> user = getUserInput(userNumber);
                game.calculateResult(computer, user);
                if (game.getStrike() == 3) {
                    finishGame();
                    break;
                }
            }
        }
    }

    public void finishGame() {
        view.displayFinishMessage();
        gameRestart = Integer.parseInt(Console.readLine());
        if (gameRestart != 1 && gameRestart != 2) {
            throw new IllegalArgumentException("1 또는 2를 입력해주세요.");
        }
    }

    private List<Integer> getUserInput(String userNumber) {
        List<Integer> user = new ArrayList<>();

        if (userNumber.length() != 3) {
            throw new IllegalArgumentException("세 자리 숫자를 입력해주세요.");
        }
        if (userNumber.charAt(0) == userNumber.charAt(1) ||
            userNumber.charAt(1) == userNumber.charAt(2) ||
            userNumber.charAt(2) == userNumber.charAt(0)) {
            throw new IllegalArgumentException("서로 다른 숫자 3개를 입력해주세요.");
        }

        String[] splitList = userNumber.split("");
        for (int i = 0; i < splitList.length; i++) {
            try {
                int digit = Integer.parseInt(splitList[i]);
                user.add(digit);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("올바른 숫자가 아닙니다.");
            }
        }
        return user;
    }
}