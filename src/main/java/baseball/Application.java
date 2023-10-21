package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        Game game = new Game();
        game.startGame();
    }
}

class Game {
    private List<Integer> answer;
    private int strikes;
    private int balls;

    public void startGame() {
        setNewAnswer();
        initResult();

        while (this.strikes != this.answer.size()) {
            List<Integer> input = getNewInput();
            initResult();
            checkResult(input);
            showResult();
        }

        if (checkRestart()) {
            startGame();
        }
    }

    private void setNewAnswer() {
        this.answer = new ArrayList<>();
        while (this.answer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!this.answer.contains(randomNumber)) {
                this.answer.add(randomNumber);
            }
        }
    }

    private List<Integer> getNewInput() {
        System.out.print("숫자를 입력해주세요 : ");
        String inputString = Console.readLine();
        validInput(inputString);

        List<Integer> input = new ArrayList<>();

        for (int i = 0; i < inputString.length(); i++) {
            char digitChar = inputString.charAt(i);
            int digitInt = Character.getNumericValue(digitChar);
            input.add(digitInt);
        }

        return input;
    }

    private void validInput(String inputString) {
        if (inputString.length() != 3) {
            throw new IllegalArgumentException();
        }

        try {
            int inputInt = Integer.parseInt(inputString);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }

        Set<Character> charSet = new HashSet<>();
        for (int i = 0; i < inputString.length(); i++) {
            char currentChar = inputString.charAt(i);
            if (charSet.contains(currentChar)) {
                throw new IllegalArgumentException();
            }
            charSet.add(currentChar);
        }
    }

    private void initResult() {
        this.balls = 0;
        this.strikes = 0;
    }

    private void checkResult(List<Integer> inputNumbers) {
        for (int i = 0; i < this.answer.size(); i++) {
            int answerDigit = this.answer.get(i);
            int inputDigit = inputNumbers.get(i);

            if (answerDigit == inputDigit) {
                this.strikes++;
            } else if (this.answer.contains(inputDigit)) {
                this.balls++;
            }
        }
    }

    private void showResult() {
        String result = "";
        if (this.balls != 0) {
            result += this.balls + "볼";
        }

        if (this.strikes != 0) {
            if (this.balls != 0) {
                result += " ";
            }
            result += this.strikes + "스트라이크";
        }

        if (this.balls == 0 && this.strikes == 0) {
            result = "낫싱";
        }

        System.out.println(result);

        if (this.strikes == this.answer.size()) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }
    }

    private boolean checkRestart() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = Console.readLine();
        if (input.equals("1")) {
            return true;
        } else if (input.equals("2")) {
            return false;
        } else {
            throw new IllegalArgumentException();
        }
    }
}