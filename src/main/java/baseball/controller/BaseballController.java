package baseball.controller;

import baseball.model.Number;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class BaseballController {
    private static final int BASEBALL_LENGTH = 3;
    private static final int BASEBALL_STRIKE_COUNT = 3;
    private static final int ZERO = 0;
    private static final String STRIKE = "스트라이크";
    private static final String BALL = "볼";
    private static final String NOTHING = "낫싱";
    private int strikeCount;
    private int ballCount;

    Number number = new Number();
    Random random = new Random();

    public void start() {
        boolean state = true;
        OutputView.startMessge();
        while (state) {
            setPlayerNumbers();
            setComputerNumbers();
            compareNumber();

            state = false;
        }
    }

    //사용자가 입력한숫자 리스트로저장
    public void setPlayerNumbers() {
        number.setPlayerNumber(InputView.inputNumber());
        List<Integer> playerNumbers = new ArrayList<>();
        for (int i = 0; i < number.getPlayerNumber().length(); i++) {
            int num = Character.getNumericValue(number.getPlayerNumber().charAt(i));
            playerNumbers.add(num);
        }
        number.setPlayerNumbers(playerNumbers);
    }

    //컴퓨터 숫자 리스트 저장
    public void setComputerNumbers() {
        number.setComputerNumbers(random.createRandomNumbers());
    }

    //플레이어 숫자 와 컴퓨터 숫자 비교
    public void compareNumber() {
        List<Integer> computer = number.getComputerNumbers();
        List<Integer> player = number.getPlayerNumbers();
        strikeCount = ZERO;
        ballCount = ZERO;
        for (int i = 0; i < BASEBALL_LENGTH; i++) {
            strikeCount(computer.get(i), player.get(i));
            ballCount(computer, player.get(i), i);
        }

    }

    public void strikeCount(int computer, int player) {
        if (computer == player) {
            strikeCount++;
        }
    }

    public void ballCount(List<Integer> computer, int player, int index) {
        if (computer.get(index) != player && computer.contains(player)) {
            ballCount++;
        }

    }


}
