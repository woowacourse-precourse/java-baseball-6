package baseball.game;

import baseball.util.NumberValidator;
import camp.nextstep.edu.missionutils.Console;

/**
 * 프로그램 총 생명 주기를 담당하는 클래스이다. 게임의 시작, 재시작, 끝을 담당한다.
 *
 * @author Seongha Park
 */
public class Game {
    private Inning inning;

    /**
     * 게임을 시작하기에 앞서 문제에서 요구하는 출력문을 출력한다.
     */
    public Game() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    /**
     * 이닝을 초기화하고 시작한다.
     */
    public void startGame() {
        inning = new Inning();
        inning.startInning();
    }

    /**
     * 이닝을 재시작할지 사용자에게 입력을 받아 확인한다.
     *
     * @return 재시작 여부를 반환한다. 재시작할 경우 true, 아니면 false를 반환한다.
     */
    public boolean checkRestart() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        String input = inputNumber();

        int inputNumber = NumberValidator.convertToNumber(input).number();
        NumberValidator.validateInput(inputNumber);

        return isRestart(inputNumber);
    }

    /**
     * 게임을 완전히 종료한다.
     */
    public void endGame() {
        System.out.println("게임 종료");
    }

    private boolean isRestart(int inputNumber) {
        return inputNumber == GameCommand.RESTART.getCommandValue();
    }

    private String inputNumber() {
        return Console.readLine();
    }

}
