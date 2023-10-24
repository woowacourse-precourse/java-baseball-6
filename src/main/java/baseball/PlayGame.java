package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.HashSet;

public class PlayGame {

    public int ball;
    public int strike;
    public ArrayList<Integer> answerNumbers;

    public void run() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        this.answerNumbers = GenerateNum.makeAnswer();
        this.ball = 0;
        this.strike = 0;
        while (this.strike != 3) {
            startGame();
        }
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public void startGame() {
        this.ball = 0;
        this.strike = 0;
        System.out.println("숫자를 입력해주세요 : ");
        String originalInput = Console.readLine();
        validateInput(originalInput);
        ArrayList<Integer> userNumberList = inputToArrayList(originalInput);
        this.ball = Rule.countBalls(answerNumbers, userNumberList);
        this.strike = Rule.countStrikes(answerNumbers, userNumberList);
        printScore();
    }

    public boolean retryGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String retryInput = Console.readLine();

        if (retryInput.equals("1")) {
            return true;
        }
        if (retryInput.equals("2")) {
            return false;
        }
        throw new IllegalArgumentException("입력값을 1 또는 2만 입력하세요.");
    }

    public ArrayList<Integer> inputToArrayList(String numInput) {
        ArrayList<Integer> userNumbers = new ArrayList<>();

        for (char c : numInput.toCharArray()) {
            userNumbers.add(c - '0');
        }

        return userNumbers;
    }

    public void validateInput(String input) {
        validateNumberLength(input);
        validateIsZero(input);
        validateIntegerNumber(input);
        validateDuplicateNumbers(input);
    }

    public void validateNumberLength(String input) {
        if (input.length() != 3) {
            throw new IllegalArgumentException("입력값의 길이가 초과되었습니다.");
        }
    }

    public void validateIntegerNumber(String input) {
        for (char c : input.toCharArray()) {
            if (!Character.isDigit(c)) {
                throw new IllegalArgumentException("1~9 사이에 있는 정수만 입력해주세요.");
            }
        }
    }

    public void validateDuplicateNumbers(String input) {
        HashSet<Character> setNumbers = new HashSet<>();
        for (char c : input.toCharArray()) {
            setNumbers.add(c);
        }

        if (input.length() != setNumbers.size()) {
            throw new IllegalArgumentException("중복된 값을 입력하지 말아주세요.");
        }
    }

    public void validateIsZero(String input) {
        for (char c : input.toCharArray()) {
            if (c == '0') {
                throw new IllegalArgumentException("0을 입력하지 말아주세요");
            }
        }
    }

    public void printScore() {
        if (this.strike == 0 && this.ball == 0) {
            System.out.println("낫싱");
            return;
        }
        if (this.strike > 0 && this.ball > 0) {
            System.out.printf("%d볼 %d스트라이크\n", this.ball, this.strike);
            return;
        }
        if (this.strike > 0) {
            System.out.printf("%d스트라이크\n", this.strike);
            return;
        }
        if (this.ball > 0) {
            System.out.printf("%d볼\n", this.ball);
            return;
        }
    }
}
