package baseball.domain;

import static baseball.constant.Baseball.NUMBER_SIZE;
import static baseball.constant.GameMessage.END_MESSAGE;
import static baseball.constant.GameMessage.INPUT_ERROR_MESSAGE;
import static baseball.constant.GameMessage.RESTART_CHECK_MESSAGE;
import static baseball.constant.GameMessage.START_MESSAGE;

import camp.nextstep.edu.missionutils.Console;

public class BaseballGame {
    private Computer computer;
    private Player player;
    private int ball;
    private int strike;

    public BaseballGame() {
        this.computer = new Computer();
        this.player = new Player();
    }

    public void start() {
        System.out.println(START_MESSAGE);
        do {
            play();
        } while (confirmRestartOrExit());
    }

    public void play() {
        computer.init();
        do {
            player.inputNumbers();
            compareNumbers();
            printHint();
        } while (!isGameComplete());
    }

    // 플레이어가 입력한 수와 컴퓨터가 선택한 수를 비교하여 스트라이크 / 볼 판정
    public void compareNumbers() {
        ball = 0;
        strike = 0;

        for (int i = 0; i < NUMBER_SIZE; i++) {
            int computerNumber = computer.getNumberOf(i);
            int playerNumber = player.getNumberOf(i);

            if (computerNumber == playerNumber) {
                // 같은 숫자가 같은 위치에 있으면 스트라이크
                strike++;
            } else if (computer.contains(playerNumber)) {
                // 같은 숫자가 다른 위치에 있으면 볼
                ball++;
            }
        }
    }

    // 스트라이크 / 볼 결과를 바탕으로 힌트를 출력
    public void printHint() {
        String result = "";

        if (ball != 0) {
            result += ball + "볼";
        }
        if (strike != 0) {
            result += (result.isEmpty() ? "" : " ") + strike + "스트라이크";
        }
        if (result.isEmpty()) {
            result = "낫싱";
        }

        System.out.println(result);
    }

    // 정답 확인. 3개의 숫자를 모두 맞힌 경우 true 반환
    public boolean isGameComplete() {
        if (strike == 3) {
            System.out.println(END_MESSAGE);
            return true;
        }
        return false;
    }

    // 게임 종료 OR 재시작 확인
    public boolean confirmRestartOrExit() {
        System.out.println(RESTART_CHECK_MESSAGE);
        String input = Console.readLine();

        if (input.equals("1")) {
            return true;
        }
        if (input.equals("2")) {
            return false;
        }
        throw new IllegalArgumentException(INPUT_ERROR_MESSAGE);
    }
}
