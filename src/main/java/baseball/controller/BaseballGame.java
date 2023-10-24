package baseball.controller;

import baseball.model.Array;
import baseball.model.Computer;
import baseball.model.Player;
import baseball.model.RandomNum;
import baseball.view.InputView;
import baseball.view.OutputView;
import java.util.List;

public class BaseballGame {
    private static final String CONTINUE = "1";
    private static final String QUIT = "2";
    private static String isContinue = CONTINUE;

    public BaseballGame() {
    }

    public List<Integer> setRandomNum() {
        return RandomNum.makeRandomNum();
    }

    public void checkInput(String userNumber) {
        Array.checkArrayNumber(userNumber);
        Array.checkArrayLength(userNumber);
        Array.checkRange(userNumber);
    }

    public String inputNumber() {
        OutputView.inputNumberMessage();
        String inputNum = InputView.input(); // 서로 다른 3개의 숫자 입력

        checkInput(inputNum);

        return inputNum;
    }

    public void getAnswer(Computer computer, Player player) {
        List<Integer> computerNumbers = computer.getComputerNumbers();
        List<Integer> userNum = player.getUserNum();
        // 컴퓨터가 만든 서로 다른 랜덤 3자리 수 computer 와 사용자 입력을 받은 서로 다른 3자리 수 userNum 비교
        for (int i = 0; i < computerNumbers.size(); i++) {
            if (userNum.get(i).equals(computerNumbers.get(i))) { // 같은 수가 같은 자리에 있으면 스트라이크
                player.addStrike();
            } else if (userNum.contains(computerNumbers.get(i))) {
                player.addBall();
            }
        }
    }

    public String startNewGame() {
        String userInput;
        OutputView.restartCheckMessage();

        userInput = InputView.input();
        Array.checkArrayNumber(userInput);
        Array.checkOneOrTwo(userInput);

        if (userInput.equals("2")) { // 1이면 게임 다시
            // 게임 다시
            return QUIT;
        }
        return CONTINUE;
    }

    public boolean isAllStrike(Player player) {
        if (player.getStrike() == 3 && player.getBall() == 0) { // 3개의 숫자를 모두 맞히면
            return true;
        }
        return false;
    }

    public void printAnswer(Player player) {

        if (player.getStrike() == 0 && player.getBall() == 0) { // 같은 수가 전혀 없으면
            System.out.println("낫싱");
        } else if (player.getStrike() == 3 && player.getBall() == 0) { // 3개의 숫자를 모두 맞히면
            System.out.println(player.getStrike() + "스트라이크");
            OutputView.allStrikeMessage();

            isContinue = startNewGame();
        } else if (player.getBall() > 0) { // 볼만 있을 경우, 스트라이크만 있을 경우, 볼, 스트라이크 둘 다 있으면
            System.out.print(player.getBall() + "볼 ");
            if (player.getStrike() > 0) {
                System.out.print(player.getStrike() + "스트라이크");
            }
            System.out.println();
        }
    }

    public void play() {
        OutputView.startGameMesssage();
        do {
            game();
        } while (isContinue.equals(CONTINUE));
    }

    public void game() {
        Computer computer = new Computer();
        computer.setComputerNumbers(setRandomNum());

        Player player;
        do {
            player = new Player();
            player.setUserNumber(inputNumber());
            player.setUserNum(Array.checkForDuplicateNumbers(player.getUserNumber()));

            getAnswer(computer, player); // 볼, 스트라이크 세기
            printAnswer(player); // 출력

        } while (!isAllStrike(player));
    }
}
