package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

class GameNumber {
    private final List<Integer> numbers;

    public GameNumber(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        List<Integer> compare = new ArrayList<>();
        for (Integer number: numbers) {
            if (compare.contains(number)) {
                throw new IllegalArgumentException();
            }
            compare.add(number);
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}

class GuessResult {
    private final int ballCount;
    private final int strikeCount;

    public GuessResult(int ballCount, int strikeCount) {
        this.ballCount = ballCount;
        this.strikeCount = strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public boolean hasBall() {
        return ballCount > 0;
    }

    public boolean hasStrike() {
        return strikeCount > 0;
    }

    public boolean isAllStrike() {
        return strikeCount == 3;
    }
}


public class Application {

    static GameNumber pickComputerNumber() {
        List<Integer> computerNumbers = new ArrayList<>();
        while (computerNumbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumbers.contains(randomNumber)) {
                computerNumbers.add(randomNumber);
            }
        }
        return new GameNumber(computerNumbers);
    }

    static int parseInt(String target) {
        try {
            return Integer.parseInt(target);
        } catch (Exception e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    static List<Integer> convertUserInput(String input) {
        List<Integer> user = new ArrayList<>();
        String[] numbers = input.split("");
        for (String element: numbers) {
            int number = parseInt(element);
            user.add(number);
        }
        return user;
    }

    static GameNumber readUserNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        List<Integer> userNumbers = convertUserInput(input);
        return new GameNumber(userNumbers);
    }

    static GuessResult createGuessResult(GameNumber computer, GameNumber user) {
        int ballCount = 0;
        int strikeCount = 0;
        List<Integer> userNumbers = user.getNumbers();
        List<Integer> computerNumbers = computer.getNumbers();

        for (int i = 0; i < 3; i++) {
            int userNumber = userNumbers.get(i);
            int computerNumber = computerNumbers.get(i);

            if (userNumber == computerNumber) {
                strikeCount++;
                continue;
            }

            if (computerNumbers.contains(userNumber)) {
                ballCount++;
            }
        }

        return new GuessResult(ballCount, strikeCount);
    }

    static void printGuessResult(GuessResult guessResult) {
        StringBuilder sb = new StringBuilder();
        if (guessResult.hasBall()) {
            sb.append(guessResult.getBallCount()).append("볼 ");
        }
        if (guessResult.hasStrike()) {
            sb.append(guessResult.getStrikeCount()).append("스트라이크");
        }
        if (sb.isEmpty()) {
            sb.append("낫싱");
        }

        System.out.println(sb.toString());
    }

    static void play() {
        GameNumber computer = pickComputerNumber();
        boolean isGameProceed = true;
        while (isGameProceed) {
            GameNumber user = readUserNumber();
            GuessResult guessResult = createGuessResult(computer, user);
            printGuessResult(guessResult);
            if (guessResult.isAllStrike()) {
                isGameProceed = false;
            }
        }
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    static int readReplayInput() {
        String input = Console.readLine();
        return parseInt(input);
    }

    static boolean checkShouldReplay() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int replay = readReplayInput();

        if (replay != 1 && replay != 2) {
            throw new IllegalArgumentException();
        }
        return replay == 1;
    }

    static void startGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        boolean shouldPlay = true;
        while (shouldPlay) {
            play();
            shouldPlay = checkShouldReplay();
        }
    }

    public static void main(String[] args) {
        startGame();
    }
}
