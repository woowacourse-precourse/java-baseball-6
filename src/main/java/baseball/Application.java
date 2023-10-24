package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        new BaseballController().start();
    }
}

class BaseballModel {
    static final int NUM_DIGITS = 3;

    private List<Integer> computer;
    private int balls;
    private int strikes;

    public void generateRandomNumbers() {
        computer = new ArrayList<>();
        while (computer.size() < NUM_DIGITS) {
            addRandomNumber();
        }
    }

    private void addRandomNumber() {
        int randomNum = Randoms.pickNumberInRange(1, 9);
        if (!computer.contains(randomNum)) {
            computer.add(randomNum);
        }
    }

    public void check(String input) {
        balls = 0;
        strikes = 0;
        for (int i = 0; i < NUM_DIGITS; i++) {
            int inputDigit = Character.getNumericValue(input.charAt(i));
            if (computer.contains(inputDigit)) {
                strikes = updateStrikes(computer, inputDigit, i, strikes);
                balls = updateBalls(computer, inputDigit, i, balls);
            }
        }
    }

    private int updateStrikes(List<Integer> computer, int inputDigit, int index, int strikes) {
        if (computer.get(index).equals(inputDigit)) {
            strikes++;
        }
        return strikes;
    }

    private int updateBalls(List<Integer> computer, int inputDigit, int index, int balls) {
        if (!computer.get(index).equals(inputDigit)) {
            balls++;
        }
        return balls;
    }

    public int getBalls() {
        return balls;
    }

    public int getStrikes() {
        return strikes;
    }
}

class BaseballView {
    private static final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String RESTART_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n";
    private static final String FINISH_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    public void printStartMessage() {
        System.out.println(START_MESSAGE);
    }

    public void printFinishMessage() {
        System.out.println(FINISH_MESSAGE);
    }

    public void printResult(int balls, int strikes) {
        if (balls == 0 && strikes == 0) {
            System.out.println("낫싱");
            return;
        }
        if (strikes == 0) {
            System.out.printf("%d볼\n", balls);
            return;
        }
        if (balls == 0) {
            System.out.printf("%d스트라이크\n", strikes);
            return;
        }
        System.out.printf("%d볼 %d스트라이크\n", balls, strikes);
    }

    public String getUserInput() {
        System.out.print(INPUT_MESSAGE);
        return Console.readLine();
    }

    public boolean askRestart() {
        System.out.print(RESTART_MESSAGE);
        return "1".equals(Console.readLine());
    }
}

class BaseballController {
    private final BaseballModel model;
    private final BaseballView view;

    public BaseballController() {
        model = new BaseballModel();
        view = new BaseballView();
    }

    public void start() {
        view.printStartMessage();
        while (true) {
            model.generateRandomNumbers();
            if (!playRound()) break;
        }
    }

    private boolean playRound() {
        while (true) {
            String input = view.getUserInput();
            validateInput(input);
            model.check(input);
            view.printResult(model.getBalls(), model.getStrikes());
            if (model.getStrikes() == BaseballModel.NUM_DIGITS) {
                view.printFinishMessage();
                break;
            }
        }
        return view.askRestart();
    }

    private void validateInput(String input) {
        if (isInvalidLength(input) || !isAllDigits(input) || isDuplicateNumbers(input)) {
            throwInvalidInputException();
        }
    }

    private boolean isInvalidLength(String input) {
        return input.length() != BaseballModel.NUM_DIGITS;
    }

    private boolean isAllDigits(String input) {
        for (char ch : input.toCharArray()) {
            if (!Character.isDigit(ch)) {
                return false;
            }
        }
        return true;
    }

    private boolean isDuplicateNumbers(String input) {
        List<Character> characters = new ArrayList<>();
        for (char ch : input.toCharArray()) {
            if (characters.contains(ch)) {
                return true;
            }
            characters.add(ch);
        }
        return false;
    }

    private void throwInvalidInputException() {
        throw new IllegalArgumentException();
    }
}
