
package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;


public class GameController {

    private List<Integer> computer;
    private String input;
    private boolean isStarted;
    private final GameView gameView;
    private final GameModel gameModel;
    public GameController() {

        this.gameView= new GameView();
        this.gameModel = new GameModel();
        gameView.printMessage(GameModel.START_MESSAGE);
    }
    public void run() {
        isStarted = true;

        do {
            generateComputerNumber();
            play();
        } while (isStarted);

        gameView.printMessage(GameModel.END_MESSAGE);
    }

    public void play() {
        gameView.printMessage(GameModel.ASK_NUMBERS);
        input = Console.readLine();
        checkAnswer(input);
    }

    public void isStarted(String input) {
        if (input.equals("1")) {
           isStarted = true;
        } else if (input.equals("2")) {
            isStarted = false;
        }
    }

    public void generateComputerNumber() {
        computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
    }

    public void checkAnswer(String input) {
        if (input.length() != 3) {
            throw new IllegalArgumentException();
        }

        int strike = 0;
        int ball = 0;
        List<Integer> answer = new ArrayList<>();

        for (int i = 0; i < input.length(); i++) {
            answer.add(input.charAt(i) - '0');
        }
        for (int i = 0; i < answer.size(); i++) {
            if (answer.get(i) == computer.get(i)) {
                strike++;
            } else if (computer.contains(answer.get(i))) {
                ball++;
            }
        }
       printResult(strike, ball);

    }

    private void printResult(int strike, int ball) {
        if(strike == 0 && ball == 0) {
            System.out.println("낫싱");
        } else if (strike == 0 && ball != 0) {
            System.out.println(ball + "볼");
        } else if (strike != 0 && ball == 0) {
            System.out.println(strike + "스트라이크");
        } else if (strike != 0 && ball != 0) {
            System.out.println(ball + "볼 " + strike + "스트라이크");
        } else if (strike == 3 && ball == 0) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");

        }
        if(strike == 3) {
            isStarted = false;
            gameView.printMessage(GameModel.ASK_RESTART);
            input = Console.readLine();
            isStarted(input);

        } else {
            gameView.printMessage(GameModel.ASK_NUMBERS);
            input = Console.readLine();
            checkAnswer(input);
        }
    }
}

