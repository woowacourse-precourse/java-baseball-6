package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;


public class Game {
    Player user;
    Player computer;
    GameRestartState gameRestartState;

    public Game() {
        this.user = new Player();
        this.computer = new Player();
        this.gameRestartState = GameRestartState.GAME_CONTINUE;
    }

    public void startGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        initComputerNumbers();
        while (this.gameRestartState != GameRestartState.GAME_STOP) {
            inProgressGame();
        }
    }

    public void inProgressGame() {
        inputUser();
        String result = printResult();
        System.out.println(result);
        if (checkEndGame()) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            questionRestartGame();
        }

    }

    public void inputUser() {
        System.out.print("숫자를 입력해주세요 : ");
        String inputData = Console.readLine();
        Validate.isValidUserInput(inputData);
        String[] inputNumbers = inputData.split("");
        List<Integer> userNumbers = new ArrayList<>(3);
        for (int i = 0; i < 3; i++) {
            int tempNumber = Integer.parseInt(inputNumbers[i]);
            userNumbers.add(tempNumber);
        }
        this.user.setPlayerNumbers(userNumbers);
    }

    public void initComputerNumbers() {
        List<Integer> computerNumbers = new ArrayList<>(3);
        while (computerNumbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumbers.contains(randomNumber)) {
                computerNumbers.add(randomNumber);
            }
        }
        this.computer.setPlayerNumbers(computerNumbers);
    }

    public int countStrike() {
        int strikeCount = 0;
        List<Integer> computerNumbers = this.computer.getPlayerNumbers();
        List<Integer> userNumbers = this.user.getPlayerNumbers();
        for (int i = 0; i < 3; i++) {
            if (computerNumbers.get(i) == userNumbers.get(i)) {
                strikeCount++;
            }
        }
        return strikeCount;
    }

    public int countBall() {
        int ballCount = 0;
        List<Integer> computerNumbers = this.computer.getPlayerNumbers();
        List<Integer> userNumbers = this.user.getPlayerNumbers();
        for (int i = 0; i < 3; i++) {
            int currentNumber = userNumbers.get(i);
            if (computerNumbers.contains(currentNumber) && userNumbers.indexOf(currentNumber) != computerNumbers.indexOf(currentNumber)) {
                ballCount++;
            }
        }
        return ballCount;
    }

    public boolean checkNothing() {
        if (countBall() == 0 && countStrike() == 0) {
            return true;
        }
        return false;
    }

    public String printResult() {
        String result = "";
        if (checkNothing()) {
            return Number.NOTHING.getTitle();
        }
        if (countBall() != 0) {
            result += countBall() + Number.BALL.getTitle() + " ";
        }
        if (countStrike() != 0) {
            result += countStrike() + Number.STRIKE.getTitle() + " ";
        }
        return result;
    }

    public boolean checkEndGame() {
        if (countStrike() == 3) {
            return true;
        }
        return false;
    }

    public void questionRestartGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String userInput = Console.readLine();
        if (!userInput.equals(GameRestartState.GAME_CONTINUE.getGameState()) && !userInput.equals(GameRestartState.GAME_STOP.getGameState())) {
            throw new IllegalArgumentException("잘못된 값을 입력하여서 프로그램을 종료합니다.");
        }
        if (userInput.equals(GameRestartState.GAME_CONTINUE.getGameState())) {
            this.gameRestartState = GameRestartState.GAME_CONTINUE;
            initComputerNumbers();
        }
        if (userInput.equals(GameRestartState.GAME_STOP.getGameState())) {
            this.gameRestartState = GameRestartState.GAME_STOP;
        }

    }


}
