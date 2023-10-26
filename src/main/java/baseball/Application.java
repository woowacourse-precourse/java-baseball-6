package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        //(게임 시작 문구 출력)
        System.out.println("숫자 야구 게임을 시작합니다");

        Game game = new Game();
        game.play();
    }
}

class Game {
    private static final int NUMBER_LENGTH = 3;

    public void play() {
        List<Integer> computerNumber = generateComputerNumber();

        while (true) {
            List<Integer> userGuess = getUserInput();
            GameOutcome outcome = checkOutcome(computerNumber, userGuess);
            printOutcome(outcome);

            if (!outcome.isThreeStrikes())
                continue;

            if (askRestart()) {
                computerNumber = generateComputerNumber();
            } else {
                System.out.println("게임 종료");
                break;
            }
        }
    }

    private static List<Integer> generateComputerNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < NUMBER_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber))
                computer.add(randomNumber);
        }
        return computer;
    }

    //user input
    private static List<Integer> getUserInput() {
        System.out.print("숫자를 입력해주세요: ");
        String input = Console.readLine();
        InputValidator.validateInput(input);

        List<Integer> parseInput = new ArrayList<>();
        for (char ch : input.toCharArray()) {
            parseInput.add(ch - '0'); //char to integer
        }
        return parseInput;
    }

    //check&return the number of strike and ball
    private GameOutcome checkOutcome(List<Integer> computerNumber, List<Integer> userGuess) {
        int ball = 0, strike = 0;

        for (int i = 0; i < NUMBER_LENGTH; i++) {
            if (computerNumber.get(i).equals(userGuess.get(i))) {
                strike++;
            } else if (computerNumber.contains(userGuess.get(i))) {
                ball++;
            }
        }

        return new GameOutcome(ball, strike);
    }

    private void printOutcome(GameOutcome outcome) {
        if (outcome.ball == 0 && outcome.strike == 0) {
            System.out.println("낫싱");
            return;
        }
        if (outcome.ball > 0)
            System.out.print(outcome.ball + "볼 ");
        if (outcome.strike > 0)
            System.out.print(outcome.strike + "스트라이크");

        System.out.println();
    }


    private boolean askRestart() {
        while (true) {
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String input = Console.readLine();

            if ("1".equals(input)) {
                return true;
            } else if ("2".equals(input)) {
                return false;
            } else {
                System.out.println("잘못된 입력입니다.");
            }
        }
    }

}

class GameOutcome {
    int ball, strike;

    public GameOutcome(int ball, int strike) {
        this.ball = ball;
        this.strike = strike;
    }

    public boolean isThreeStrikes(){
        return strike==3;
    }
}

class InputValidator{
    private static final int VALID_INPUT_LENGTH = 3;

    public static void validateInput(String input) {
        //\\d will match a single digit (0-9).
        if (input.length() != VALID_INPUT_LENGTH || !input.matches("\\d+") || hasDuplicateCharacters(input))
            throw new IllegalArgumentException("3자리의 서로 다른 숫자를 입력해 주세요!");
    }

    private static boolean hasDuplicateCharacters(String input) {
        return input.chars().distinct().count() != input.length();
    }
}