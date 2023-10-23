package baseball.controller;

import baseball.domain.ComputerNumber;
import baseball.view.InputView;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GameMachine {

    public static final String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";

    private final InputView inputView;

    public GameMachine() {
        inputView = new InputView();
    }

    public void start() {
        System.out.println(GAME_START_MESSAGE);

        // 컴퓨터의 무작위 숫자
        ComputerNumber computerNumber = new ComputerNumber();
        List<Integer> randomNumber = computerNumber.getComputer();
        System.out.println(randomNumber);

        while (true) {
            // 사용자 숫자 입력
            List<Integer> inputNumber = inputView.inputNumber();

            // 심판
            String referee = referee(randomNumber, inputNumber);
            System.out.println(referee);

            // 3개의 숫자 모두 맞췄을 때
            if (randomNumber.equals(inputNumber)) {
                break;
            }
        }

        restart();
    }

    // 재시작
    private void restart() {
        if (inputView.restartCheck()) {
            start();
        }
    }

    // 심판
    public String referee(List<Integer> randomNumber, List<Integer> inputNumber) {
        // 볼
        int balls = randomNumber.size() + inputNumber.size();
        Set<Integer> addNumber = new HashSet<>();
        addNumber.addAll(randomNumber);
        addNumber.addAll(inputNumber);
        balls = balls - addNumber.size();

        // 스트라이크
        int strikes = 0;
        for (int i = 0; i < randomNumber.size(); i++) {
            if (randomNumber.get(i).equals(inputNumber.get(i))) {
                strikes++;
            }
        }

        // 판별
        if (strikes == 0 && balls == 0) {
            return "낫싱";
        }

        if (balls - strikes == 0) {
            return strikes + "스트라이크";
        }

        if (strikes == 0) {
            return balls - strikes + "볼";
        }

        return balls - strikes + "볼 " + strikes + "스트라이크";
    }


}
