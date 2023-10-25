package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.stream.Stream;

public class Game {
    private final Computer computer = new Computer();
    private List<Integer> computerNumbers;

    public void start() {
        this.setComputerNumbers();
        this.readPlayerNumbers();
    }

    private void setComputerNumbers() {
        this.computerNumbers = computer.getComputerNumbers();
    }

    private void readPlayerNumbers() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        InputValidator.validatePlayerNumbers(input);

        List<Integer> playerNumbers = Stream.of(input.split("")).mapToInt(Integer::parseInt).boxed().toList();
        this.getResult(playerNumbers);
    }

    private void getResult(List<Integer> playerNumbers) {
        Baseball baseball = new Baseball(playerNumbers, this.computerNumbers);
        baseball.compare();

        String message = baseball.getMessage();
        System.out.println(message);

        boolean isSuccess = baseball.getIsSuccess();
        if (isSuccess) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            this.restart();
        } else {
            this.readPlayerNumbers();
        }
    }

    private void restart() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = Console.readLine();
        InputValidator.validateReplayChoice(input);

        if (input.equals("1")) {
            this.start();
        }
    }
}
