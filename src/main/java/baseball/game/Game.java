package baseball.game;

import baseball.player.Player;
import baseball.computer.Computer;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Game {
    private final Player player;
    private final Computer computer;
    private int strikeCount;
    private int ballCount;

    public Game() {
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
        System.out.println("숫자 야구 게임을 시작합니다.");

        boolean isPlayGame = true;

        while (isPlayGame) {
            List<Integer> computerNumbers = computer.getNumbers();
            List<Integer> playerNumbers = player.getNumbers();

            initStrikeBallCount();

            compareNumbers(computerNumbers, playerNumbers);

            if (strikeCount == 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                isPlayGame = checkIsContinue();
            } else {
                player.inputNumbers();
            }
        }
    }

    private void compareNumbers(List<Integer> computerNumbers, List<Integer> playerNumbers) {
        System.out.println("computerNumbers = " + computerNumbers);
        System.out.println("playerNumbers = " + playerNumbers);

        for (int i = 0; i < playerNumbers.size(); i++) {
            if (computerNumbers.get(i) == playerNumbers.get(i)) {
                strikeCount++;
            } else if (computerNumbers.contains(playerNumbers.get(i))) {
                ballCount++;
            }
        }

        if (strikeCount > 0 || ballCount > 0) {
            if (strikeCount > 0 && ballCount > 0) {
                System.out.println(ballCount + "볼 " + strikeCount + "스트라이크");
            } else if (strikeCount > 0 && ballCount == 0) {
                System.out.println(strikeCount + "스트라이크");
            } else {
                System.out.println(ballCount + "볼");
            }
        } else {
            System.out.println("낫싱");
        }
    }

    private boolean checkIsContinue() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        String input = Console.readLine();

        if (input.equals("1")) {
            initComputerAndPlayer();
            return true;
        } else if (input.equals("2")) {
            return false;
        } else {
            throw new IllegalArgumentException("Error: Input must be 1 or 2");
        }
    }
}
