package baseball.domain;

import baseball.domain.computer.Computer;
import baseball.domain.computer.GameState;
import baseball.domain.player.Player;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static baseball.domain.GameResult.calculateBaseBallGame;

public class BaseBallGame {
    private static String INPUT_NUMBERS_MESSAGE = "숫자를 입력해주세요 : ";
    private static String INPUT_NUMBERS_DELIMITER = "";
    public void startGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        boolean playAgain = true;

        while (playAgain) {
            playRound();
            playAgain = askPlayAgain();
        }
    }

    private void playRound() {
        boolean ongoing = false;
        while(!ongoing) {
            List<Integer> playerNumbers = InputNumbers();

            Computer computerAnswerByRandomGenerator = Computer.createComputerAnswerByRandomGenerator(GameState.RUNNING);
            Player playerByIntegerNumbers = Player.createPlayerByIntegerNumbers(playerNumbers);
            String result = checkGuess(playerByIntegerNumbers, computerAnswerByRandomGenerator);
            System.out.println(result);
            if (result.equals("3스트라이크")) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                ongoing = true;
            }
        }
    }

    private static List<Integer> InputNumbers() {
        System.out.print(INPUT_NUMBERS_MESSAGE);
        String inputBaseBallNumbers = Console.readLine();
        List<Integer> playerNumbers = Arrays.stream(inputBaseBallNumbers.split(INPUT_NUMBERS_DELIMITER))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        return playerNumbers;
    }

    private String checkGuess(Player player, Computer computer) {
        GameResult gameResult = calculateBaseBallGame(player, computer);
        System.out.println(computer.getAnswerNumbers());
        if (gameResult.getStrikeCount() == 0 && gameResult.getBallCount() == 0) {
            return "낫싱";
        } else if (gameResult.getStrikeCount() > 0 && gameResult.getBallCount() == 0) {
            return gameResult.getStrikeCount() + "스트라이크";
        } else if (gameResult.getStrikeCount() == 0 && gameResult.getBallCount() > 0) {
            return gameResult.getBallCount() + "볼";
        } else {
            return gameResult.getStrikeCount() + "스트라이크 " + gameResult.getBallCount() + "볼";
        }
    }

    private boolean askPlayAgain() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요: ");
        int choice = scanner.nextInt();
        return choice == 1;
    }

}
