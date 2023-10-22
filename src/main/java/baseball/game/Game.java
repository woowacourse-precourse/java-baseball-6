package baseball.game;

import baseball.player.Player;
import baseball.computer.Computer;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Game extends GameConstants {
    private final Player player;
    private final Computer computer;
    private int strikeCount;
    private int ballCount;

    public Game() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        this.player = new Player();
        this.computer = new Computer();
        this.strikeCount = 0;
        this.ballCount = 0;
    }

    public void startGame() {
        play();
    }

    private void initStrikeBallCount() {
        strikeCount = 0;
        ballCount = 0;
    }
    private void initComputerAndPlayer() {
        computer.generateNewNumbers();
        player.inputNumbers();
    }

    private void play() {
        boolean isPlayGame = true;

        while (isPlayGame) {
            List<Integer> computerNumbers = computer.getNumbers();
            List<Integer> playerNumbers = player.getNumbers();

            initStrikeBallCount();

            compareNumbers(computerNumbers, playerNumbers);

            if (strikeCount == MAX_STRIKE_COUNT) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                isPlayGame = checkIsContinue();
            } else {
                player.inputNumbers();
            }
        }
    }

    private void compareNumbers(List<Integer> computerNumbers, List<Integer> playerNumbers) {
        // todo: 출력 삭제하기
        System.out.println("computerNumbers = " + computerNumbers);
        System.out.println("playerNumbers = " + playerNumbers);

        for (int i = 0; i < MAX_NUMBER_COUNT; i++) {
            if (computerNumbers.get(i) == playerNumbers.get(i)) {
                strikeCount++;
            } else if (computerNumbers.contains(playerNumbers.get(i))) {
                ballCount++;
            }
        }

        displayResult();
    }

    private void displayResult() {
        StringBuilder result = new StringBuilder();

        if (ballCount > 0) {
            result.append(ballCount).append("볼 ");
        }

        if (strikeCount > 0) {
            result.append(strikeCount).append("스트라이크");
        }

        if (strikeCount == 0 && ballCount == 0) {
            result.append("낫싱");
        }

        System.out.println(result.toString().trim());
    }

    private boolean checkIsContinue() {
        System.out.println("게임을 새로 시작하려면 " + RESTART + ", 종료하려면 " + END + "를 입력하세요.");

        String input = Console.readLine();

        if (input.equals(RESTART)) {
            initComputerAndPlayer();
            return true;
        } else if (input.equals(END)) {
            return false;
        } else {
            throw new IllegalArgumentException("Error: Input must be " + RESTART + " or " + END);
        }
    }
}
