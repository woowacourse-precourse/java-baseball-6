package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class GameController {

    private List<Integer> computer, answer;
    private String input;
    private boolean isStarted;
    GameView gameView;
    public GameController() {

        this.gameView= new GameView();
        gameView.startGame(); // 문제 출력
    }
    public void run() {

        do {
            isStarted = true;
            createAnswer();
            System.out.println(computer);
            gameView.askNumbers();
            input = Console.readLine();
            checkAnswer(input);
        } while (isStarted);

    }





    public void isStarted(String input) {
        if (input.equals("1")) {
           isStarted = true;
        } else if (input.equals("2")) {
            isStarted = false;
            gameView.endGame();

        }
    }



    public void createAnswer() {
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

        answer = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            answer.add(input.charAt(i) - '0');
        }
        int strike = 0;
        int ball = 0;
        for (int i = 0; i < answer.size(); i++) {
            if (answer.get(i) == computer.get(i)) {
                strike++;
            } else if (computer.contains(answer.get(i))) {
                ball++;
            }
        }
        gameView.showResult(strike, ball);
        if (strike == 3) {
            isStarted = false;
            gameView.askRestart();
            input = Console.readLine();
            isStarted(input);

        } else {
            gameView.askNumbers();
            input = Console.readLine();
            checkAnswer(input);
        }
    }
}

