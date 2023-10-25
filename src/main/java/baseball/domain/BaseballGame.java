package baseball.domain;

import static baseball.constant.Baseball.NUMBER_SIZE;
import static baseball.constant.GameMessage.INPUT_ERROR_MESSAGE;
import static baseball.constant.GameMessage.RESTART_CHECK_MESSAGE;
import static baseball.constant.GameMessage.START_MESSAGE;

import camp.nextstep.edu.missionutils.Console;

public class BaseballGame {
    private Computer computer;
    private Player player;
    private int ballCount;
    private int strikeCount;

    public BaseballGame() {
        this.computer = new Computer();
        this.player = new Player();
        this.ballCount = 0;
        this.strikeCount = 0;
    }

    public void start() {
        System.out.println(START_MESSAGE);
        do {
            play();
        } while (checkRestart());
    }

    public void play() {
        computer.init();
        player.inputNumbers();
        compareNumbers();
    }

    // 플레이어가 입력한 수와 컴퓨터가 선택한 수를 비교하여 스트라이크 / 볼 판정
    public void compareNumbers() {
        for (int i = 0; i < NUMBER_SIZE; i++) {
            int computerNumber = computer.getNumberOf(i);
            int playerNumber = player.getNumberOf(i);

            if (computerNumber == playerNumber) {
                // 같은 숫자가 같은 위치에 있으면 스트라이크
                strikeCount++;
            } else if (computer.contains(playerNumber)) {
                // 같은 숫자가 다른 위치에 있으면 볼
                ballCount++;
            }
        }
    }

    // 게임 종료 OR 재시작 확인
    public boolean checkRestart() {
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
