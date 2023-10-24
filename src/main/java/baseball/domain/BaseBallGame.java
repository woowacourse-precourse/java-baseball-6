package baseball.domain;

import baseball.domain.computer.Computer;
import baseball.domain.computer.GameState;
import baseball.domain.player.Player;
import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static baseball.domain.GameResult.calculateBaseBallGame;

public class BaseBallGame {
    private static String INPUT_NUMBERS_MESSAGE = "숫자를 입력해주세요 : ";
    private static String INPUT_NUMBERS_DELIMITER = "";

    private static String LINE_BREAK = "%n";
    private static String BLANK = " ";

    private static String GAME_RESULT_NOTHING_MESSAGE = "낫싱";
    private static String GAME_RESULT_BALL_MESSAGE = "%d볼";
    private static String GAME_RESULT_STRIKE_MESSAGE = "%d스트라이크";
    private static String GAME_OVER_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static String INPUT_GAME_STATE_COMMAND_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

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
        while (!ongoing) {
            List<Integer> playerNumbers = inputNumbers();
            Computer computer = Computer.createComputerAnswerByRandomGenerator(GameState.RUNNING);
            Player player = Player.createPlayerByIntegerNumbers(playerNumbers);
            GameResult gameResult = calculateBaseBallGame(player, computer);
            gameResultMessage(gameResult);
            if (gameResult.getStrikeCount() == 3) {
                System.out.println(GAME_OVER_MESSAGE);
                ongoing = true;
            }
        }
    }

    public static List<Integer> inputNumbers() {
        System.out.print(INPUT_NUMBERS_MESSAGE);
        String inputBaseBallNumbers = Console.readLine();
        List<Integer> playerNumbers = Arrays.stream(inputBaseBallNumbers.split(INPUT_NUMBERS_DELIMITER))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        return playerNumbers;
    }

    public static void gameResultMessage(GameResult gameResult) {
        if (gameResult.isNothing()) {
            System.out.println(GAME_RESULT_NOTHING_MESSAGE);
            return;
        }
        if (gameResult.ballCount() == 0) {
            System.out.printf(GAME_RESULT_STRIKE_MESSAGE + LINE_BREAK, gameResult.strikeCount());
            return;
        }
        if (gameResult.strikeCount() == 0) {
            System.out.printf(GAME_RESULT_BALL_MESSAGE + LINE_BREAK, gameResult.ballCount());
            return;
        }
        System.out.printf(GAME_RESULT_BALL_MESSAGE + BLANK + GAME_RESULT_STRIKE_MESSAGE + LINE_BREAK, gameResult.ballCount(),
                gameResult.strikeCount());
    }

    private boolean askPlayAgain() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(INPUT_GAME_STATE_COMMAND_MESSAGE);
        int choice = scanner.nextInt();
        return choice == 1;
    }
    public static GameState inputGameStateCommand(GameResult gameResult) {
        if (!gameResult.isFinished()) {
            return GameState.init();
        }
        System.out.println(GAME_OVER_MESSAGE);
        System.out.println(INPUT_GAME_STATE_COMMAND_MESSAGE);
        return GameState.createByCommand(Integer.parseInt(Console.readLine()));
    }
}
