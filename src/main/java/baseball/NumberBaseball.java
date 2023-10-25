package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

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

    public NumberBaseball(ComNumberGenerator comNumberGenerator, UserNumberGenerator userNumberGenerator) {
        this.comNumberGenerator = comNumberGenerator;
        this.userNumberGenerator = userNumberGenerator;
    }

    public NumberBaseball() {
        this(new ComNumberGenerator(), new UserNumberGenerator());
    }

    public void startGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        gameOn();
        loadComNumbers();
        playGame();
    }

    private void gameOn() {
        gameStatus = GameStatus.ON;
    }

    private void loadComNumbers() {
        List<Integer> comNumbers = getComNumber();
        computerBalls = BallContainer.getFromNumbers(comNumbers);
    }

    private List<Integer> getComNumber() {
        return comNumberGenerator.generate();
    }

    private void playGame() {
        while (GameStatus.isGameOn(gameStatus)) {
            BallContainer userBalls = createUserBalls();
            PitchResult result = computerBalls.pitch(userBalls);

            executeByResult(result);
        }
    }

    private BallContainer createUserBalls() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();

        List<Integer> userNumber = userNumberGenerator.generate(input);

        return BallContainer.getFromNumbers(userNumber);
    }

    private void executeByResult(PitchResult result) {
        System.out.println(result.getHint());

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

    private void gameOff() {
        gameStatus = GameStatus.OFF;
    }
}
