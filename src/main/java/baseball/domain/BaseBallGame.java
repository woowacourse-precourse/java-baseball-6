package baseball.domain;

import baseball.domain.computer.Computer;
import baseball.domain.computer.GameState;
import baseball.domain.player.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static baseball.domain.GameResult.calculateBaseBallGame;

public class BaseBallGame {

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
            System.out.print("숫자를 입력해주세요: ");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            List<Integer> playerNumbers = new ArrayList<>();

            for (char c : input.toCharArray()) {
                if (Character.isDigit(c)) {
                    int digit = Character.getNumericValue(c);
                    playerNumbers.add(digit);
                }
            }
            Computer computerAnswerByRandomGenerator = Computer.createComputerAnswerByRandomGenerator(GameState.RUNNING);
            Player playerByIntegerNumbers = Player.createPlayerByIntegerNumbers(playerNumbers);
            String result = checkGuess(playerByIntegerNumbers, computerAnswerByRandomGenerator);
            System.out.println(result);
            if (result.equals("3스트라이크")) ongoing = true;
        }
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
