package baseball.game;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import util.NumberGenerator;

public class BaseballGame implements Game {
    private final NumberGenerator numberGenerator;
    private int strikeCount;
    private int ballCount;
    private List<Integer> user;
    private List<Integer> computer;
    private final int numberLength;

    public BaseballGame(int numberLength) {
        this.numberGenerator = new NumberGenerator(numberLength, 1, 9);
        this.numberLength = numberLength;
        this.ballCount = 0;
        this.strikeCount = 0;
    }

    @Override
    public void start() {
        this.computer = this.numberGenerator.generate();
        System.out.println("숫자 야구 게임을 시작합니다.");
        do {
            this.refresh();
            this.readUserInput();
            this.countStrikeAndBall();
            this.printResult();
        } while (!this.isWin());
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    @Override
    public void end() {
        System.out.println("게임 종료");
    }

    @Override
    public boolean restart() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String restart = Console.readLine();
        if (!restart.equals("1") && !restart.equals("2")) {
            throw new IllegalArgumentException();
        }
        if (restart.equals("1")) {
            this.refresh();
            return true;
        }
        return false;
    }

    private boolean isWin() {
        if (this.strikeCount == this.numberLength) {
            return true;
        }
        return false;
    }

    private boolean isNoting() {
        if (this.strikeCount == 0 && this.ballCount == 0) {
            return true;
        }
        return false;
    }

    private void printResult() {
        if (this.isNoting()) {
            System.out.println("낫싱");
            return;
        }
        this.printBallCount();
        this.printStrikeCount();
        System.out.println();
    }

    private void printBallCount() {
        if (this.ballCount != 0) {
            System.out.print(this.ballCount + "볼 ");
        }
    }

    private void printStrikeCount() {
        if (this.strikeCount != 0) {
            System.out.print(this.strikeCount + "스트라이크");
        }
    }

    private boolean isStringAllDigits(String input) {
        if (input == null || input.isEmpty()) {
            return false;
        }
        for (char c : input.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

    private void countStrikeAndBall() {
        for (int i = 0; i < this.numberLength; i++) {
            if (this.computer.get(i) == this.user.get(i)) {
                this.strikeCount++;
            } else if (this.computer.contains(this.user.get(i))) {
                this.ballCount++;
            }
        }
    }

    private void readUserInput() {
        System.out.print("숫자를 입력해주세요 : ");
        this.user = new ArrayList<>();
        String input;
        input = Console.readLine();
        if (input.length() != this.numberLength || !isStringAllDigits(input)) {
            throw new IllegalArgumentException(input);
        }
        for (char c : input.toCharArray()) {
            this.user.add(Character.getNumericValue(c));
        }
    }

    private void refresh() {
        this.strikeCount = 0;
        this.ballCount = 0;
    }
}
