package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    static final int NUM_OF_DIGITS = 3;

    public static void main(String[] args) {
        GameState gameState = new GameState();
        System.out.println("숫자 야구 게임을 시작합니다.");

        while (gameState.isGameOn()) {
            List<Integer> computerNumber = createRandomNumbers();
            while (!gameState.isWin()) {
                int[] userNumber = getUserInput();
                String ballStrikeCheck = checkNumber(userNumber, computerNumber, gameState);
                System.out.println(ballStrikeCheck);
            }
            askForRestart(gameState);
        }
    }

    private static List<Integer> createRandomNumbers() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < NUM_OF_DIGITS) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    private static int[] getUserInput() {
        int[] userNumberDigits = new int[NUM_OF_DIGITS];
        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
            String userNumberString = readLine();
            if (isValidInput(userNumberString)) {
                for (int i = 0; i < NUM_OF_DIGITS; i++) {
                    userNumberDigits[i] = userNumberString.charAt(i) - '0';
                }
                return userNumberDigits;
            }
            throw new IllegalArgumentException();
        }
    }

    private static boolean isValidInput(String input) {
        if (input.length() != NUM_OF_DIGITS) {
            return false;
        }
        for (char ch : input.toCharArray()) {
            if (ch < '0' || ch > '9') {
                return false;
            }
        }
        return true;
    }

    private static String checkNumber(int[] userNumbers, List<Integer> computerNumbers, GameState gameState) {
        int ballCount = 0;
        int strikeCount = 0;
        for (int i = 0; i < NUM_OF_DIGITS; i++) {
            for (int j = 0; j < NUM_OF_DIGITS; j++) {
                if (userNumbers[i] == computerNumbers.get(j)) {
                    if (i == j) {
                        strikeCount++;
                    } else {
                        ballCount++;
                    }
                }
            }
        }
        if (strikeCount == NUM_OF_DIGITS) {
            gameState.rightAnswer();
            return String.format("%d스트라이크\n%d개의 숫자를 모두 맞히셨습니다! 게임종료", NUM_OF_DIGITS, NUM_OF_DIGITS);
        }
        if (ballCount == 0 && strikeCount == 0) {
            return "낫싱";
        }
        if (ballCount == 0) {
            return String.format("%d스트라이크", strikeCount);
        }
        if (strikeCount == 0) {
            return String.format("%d볼", ballCount);
        }
        return String.format("%d볼 %d스트라이크", ballCount, strikeCount);
    }

    private static void askForRestart(GameState gameState) {
        while (true) {
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String option = readLine();
            if ("1".equals(option)) {
                gameState.reset();
                return;
            } else if ("2".equals(option)) {
                gameState.endGame();
                System.out.println("게임 종료");
                return;
            } else {
                throw new IllegalArgumentException();
            }
        }
    }
}

class GameState {
    private boolean gameOn = true;
    private boolean win = false;

    public boolean isGameOn() {
        return gameOn;
    }

    public boolean isWin() {
        return win;
    }

    public void endGame() {
        this.gameOn = false;
    }

    public void rightAnswer() {
        this.win = true;
    }

    public void reset() {
        this.win = false;
    }
}
