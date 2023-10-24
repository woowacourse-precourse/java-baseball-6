package baseball;

import baseball.players.Computer;
import baseball.players.User;
import camp.nextstep.edu.missionutils.Console;
import game.Game;
import java.util.ArrayList;
import java.util.List;
import util.NumberGenerator;
import util.StringChecker;

/**
 * description: 숫자 야구 게임을 진행하는 클래스
 */
public class BaseballGame implements Game {
    /**
     * description: 사용자를 나타내는 객체
     */
    private User user;

    /**
     * description: 컴퓨터를 나타내는 객체
     */
    private Computer computer;

    /**
     * description: 생성할 숫자의 길이
     */
    private final int numberLength;

    /**
     * description: 사용자의 입력을 검증하는 객체
     */
    private final StringChecker stringChecker;

    /**
     * description: 랜덤한 숫자들을 생성하는 객체
     */
    private final NumberGenerator numberGenerator;

    /**
     * description: 스트라이크의 개수
     */
    private int strikeCount;

    /**
     * description: 볼의 개수
     */
    private int ballCount;

    /**
     * description: BaseballGame의 생성자
     *
     * @param numberLength 생성할 숫자의 길이
     */
    public BaseballGame(int numberLength) {
        this.user = new User();
        this.computer = new Computer();
        this.stringChecker = new StringChecker();
        this.numberLength = numberLength;
        this.numberGenerator = new NumberGenerator(numberLength, 1, 9);
        this.ballCount = 0;
        this.strikeCount = 0;
    }

    /**
     * description: 게임을 시작하는 메소드
     */
    @Override
    public void start() {
        this.computer.setNumbers(this.numberGenerator.generate());
        System.out.println("숫자 야구 게임을 시작합니다.");
        do {
            this.refresh();
            System.out.print("숫자를 입력해주세요 : ");
            this.setUserNumber(Console.readLine());
            this.countStrikeAndBall();
            this.printResult();
        } while (!this.isWin());
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    /**
     * description: 게임을 종료하는 메소드
     */
    @Override
    public void end() {
        System.out.println("게임 종료");
    }

    /**
     * description: 게임을 재시작할지 여부를 반환하는 메소드
     *
     * @return 게임을 재시작할지 여부
     */
    @Override
    public boolean isRestart() {
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

    /**
     * description: 사용자의 입력을 받아 user의 numbers를 설정하는 메소드
     *
     * @param number 사용자의 입력
     * @throws IllegalArgumentException 사용자의 입력이 유효하지 않을 때
     */
    private void setUserNumber(String number) {
        if (!this.validateInputFormat(number)) {
            throw new IllegalArgumentException();
        }
        List<Integer> numbers = new ArrayList<>();
        for (char c : number.toCharArray()) {
            numbers.add(Character.getNumericValue(c));
        }
        this.user.setNumbers(numbers);
    }

    /**
     * description: 사용자의 입력이 유효한지 확인하는 메소드
     *
     * @param number 사용자의 입력
     * @return 사용자의 입력이 유효하면 true, 아니면 false
     */
    private boolean validateInputFormat(String number) {
        if (!this.stringChecker.isValidNumberFormat(number, this.numberLength)) {
            return false;
        }
        return true;
    }

    /**
     * description: 스트라이크와 볼의 개수를 세는 메소드
     */
    private void countStrikeAndBall() {
        for (int i = 0; i < this.numberLength; i++) {
            if (this.computer.getNumber(i) == this.user.getNumber(i)) {
                this.strikeCount++;
            } else if (this.computer.isContain(this.user.getNumber(i))) {
                this.ballCount++;
            }
        }
    }

    /**
     * description: user가 computer의 숫자를 모두 맞혔는지 확인하는 메소드
     *
     * @return user가 computer의 숫자를 모두 맞혔으면 true, 아니면 false
     */
    private boolean isWin() {
        if (this.strikeCount == this.numberLength) {
            return true;
        }
        return false;
    }

    /**
     * description: nothing인지 확인하는 메소드
     *
     * @return nothing이면 true, 아니면 false
     */
    private boolean isNoting() {
        if (this.strikeCount == 0 && this.ballCount == 0) {
            return true;
        }
        return false;
    }

    /**
     * description: 볼의 개수를 출력하는 메소드
     */
    private void printBallCount() {
        if (this.ballCount != 0) {
            System.out.print(this.ballCount + "볼 ");
        }
    }

    /**
     * description: 스트라이크의 개수를 출력하는 메소드
     */
    private void printStrikeCount() {
        if (this.strikeCount != 0) {
            System.out.print(this.strikeCount + "스트라이크");
        }
    }

    /**
     * description: 결과를 출력하는 메소드
     */
    private void printResult() {
        if (this.isNoting()) {
            System.out.println("낫싱");
            return;
        }
        this.printBallCount();
        this.printStrikeCount();
        System.out.println();
    }

    /**
     * description: 스트라이크와 볼의 개수를 초기화하는 메소드
     */
    private void refresh() {
        this.strikeCount = 0;
        this.ballCount = 0;
    }
}
