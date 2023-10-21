package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NumberBaseball {
    private enum GameStatus {
        ON,
        OFF;

        public static boolean isGameOn(GameStatus gameStatus) {
            return ON.equals(gameStatus);
        }
    }

    private static final int RESTART_OPTION = 1;
    private static final int END_OPTION = 2;

    private final ComNumberGenerator comNumberGenerator;
    private final UserNumberGenerator userNumberGenerator;

    private GameStatus gameStatus;
    private BallContainer computerBalls;

    public NumberBaseball() {
        this.comNumberGenerator = new ComNumberGenerator();
        this.userNumberGenerator = new UserNumberGenerator();
    }

    public void startGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        gameOn();
        loadComNumbers();
        playGame();
    }

    private void loadComNumbers() {
        List<Integer> comNumbers = comNumberGenerator.generate();
        computerBalls = BallContainer.getFromNumbers(comNumbers);
    }

    private void playGame() {
        while (GameStatus.isGameOn(gameStatus)) {
            BallContainer userBalls = createUserBalls();
            PitchResult result = computerBalls.pitch(userBalls);
            System.out.println(result.getHint());

            restartOrExit(result);
        }
    }

    private BallContainer createUserBalls() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        validateInput(input);

        List<Integer> userNumber = userNumberGenerator.generate(input);

        return BallContainer.getFromNumbers(userNumber);
    }

    private void validateInput(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException("입력값이 존재하지 않습니다");
        }
        if (input.contains("0")) {
            throw new IllegalArgumentException("0은 입력할 수 없습니다.");
        }
        if (input.contains("-")) {
            throw new IllegalArgumentException("음수값은 입력이 불가능합니다.");
        }
        if (input.length() != 3) {
            throw new IllegalArgumentException("3자리의 숫자를 입력해주세요");
        }

        String distincted = Arrays.stream(input.split(""))
                .distinct()
                .collect(Collectors.joining());

        if (!distincted.equals(input)) {
            throw new IllegalArgumentException("중복은 허용되지 않습니다.");
        }
    }

    private void restartOrExit(PitchResult result) {
        if (result.isGameEnd()) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            questIfRestart();
        }
    }

    private void questIfRestart() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int option = Integer.parseInt(Console.readLine());
        validateOption(option);

        if (option == RESTART_OPTION) {
            loadComNumbers();
            return;
        }
        gameOff();
    }

    private void validateOption(int option) {
        if (option == RESTART_OPTION || option == END_OPTION) {
            return;
        }
        throw new IllegalArgumentException("입력은 1 또는 2만 가능합니다.");
    }

    private void gameOn() {
        gameStatus = GameStatus.ON;
    }

    private void gameOff() {
        gameStatus = GameStatus.OFF;
    }
}
