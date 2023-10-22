package baseball.game;

import baseball.player.Player;
import baseball.computer.Computer;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Game {
    private final Player player;
    private final Computer computer;

    public Game() {
        this.player = new Player();
        this.computer = new Computer();
    }

    public void startGame() {
        play();
    }

    private void play() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        boolean isPlayGame = true;
        boolean isFinished = false;
        while (isPlayGame) {
            List<Integer> computerNumbers = computer.getNumbers();
            List<Integer> playerNumbers = player.getNumbers();

            // 컴퓨터와 플레이어 숫자 비교 (스트라이크, 볼, 낫싱 출력)
            boolean check = compareNumbers(computerNumbers, playerNumbers);
            if (check == false) {
                break;
            }

            // 게임 결과 출력
            if (true) {
            }

            if (true) {

            }
            // 게임 재시작 여부 확인
            isPlayGame = checkIsContinue();
        }

    }

    private boolean compareNumbers(List<Integer> computerNumbers, List<Integer> playerNumbers) {
        System.out.println("computerNumbers = " + computerNumbers);
        System.out.println("playerNumbers = " + playerNumbers);

        return true;
    }

    private boolean checkIsContinue() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        String input = Console.readLine();

        if (input.equals("1")) {
            return false;
        } else if (input.equals("2")) {
            return true;
        } else {
            throw new IllegalArgumentException("Error: Input must be 1 or 2");
        }
    }
}
