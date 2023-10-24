package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class BaseballGame {
    private GameState gameState; // NewGame(1), Finished(2)
    private String stateNum;
    private String inputStrNum;
    private boolean isVictory = false;


    /**
     * BaseballGame을 시작하기 위한 함수입니다. 게임시작의 기능을 수행합니다.
     *
     * @see BaseballGame#generateRandomNumbers()
     * @see Utils#isValidInput(String)
     * @see BaseballGame#numCheckAndPrintResult(String, List)
     * @see BaseballGame#checkRestart()
     */
    public void startGame() {

        List<Integer> computer = generateRandomNumbers();

        while (!isVictory) {
            System.out.print("숫자를 입력해주세요 : ");
            inputStrNum = Console.readLine();

            if (Utils.isValidInput(inputStrNum)) {
                numCheckAndPrintResult(inputStrNum, computer);
            }
            ;
        }
        checkRestart();
    }

    /**
     * 0~9까지의 숫자중 중복을 허용하지 않고 3개의 숫자를 뽑아 리스트에 저장하고 해당 리스트를 반환하는 함수입니다.
     *
     * @return 추출한 숫자 3개를 포함하는 리스트를 반환합니다.
     */
    private List<Integer> generateRandomNumbers() {

        List<Integer> numbers = new ArrayList<>();

        while (numbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
        return numbers;
    }

    /**
     * 사용자의 숫자와 컴퓨터의 숫자를 비교하여 스트라이크와 볼의 개수를 출력하는 함수입니다.
     *
     * @param inputStrNum 사용자가 입력한 숫자 문자열.
     * @param computer    컴퓨터의 난수 숫자 리스트.
     * @see BaseballGame#printResult(int, int)
     */
    private void numCheckAndPrintResult(String inputStrNum, List<Integer> computer) {

        int strike = 0;
        int ball = 0;

        for (int i = 0; i < computer.size(); i++) {
            int inputDigit = Character.getNumericValue(inputStrNum.charAt(i));
            if (computer.get(i) == inputDigit) {
                strike++;
            } else if (computer.contains(inputDigit)) {
                ball++;
            }
        }

        printResult(strike, ball);
    }

    /**
     * strike , ball 의 개수에 따라 값을 출력해주는 함수입니다.
     *
     * @param strike
     * @param ball
     */
    private void printResult(int strike, int ball) {

        if (strike == 3) {
            isVictory = true;
            System.out.println(strike + "스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return;
        }
        if (ball > 0) {
            System.out.print(ball + "볼 ");
        }
        if (strike > 0) {
            System.out.print(strike + "스트라이크");
        }
        if (strike == 0 && ball == 0) {
            System.out.print("낫싱");
        }
        System.out.println();
    }

    /**
     * 입력값에 따라 게임을 재시작할지, 종료할지를 결정하는 메서드입니다.
     *
     * @see GameState#from(String stateNum)
     */
    private void checkRestart() {

        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        stateNum = Console.readLine();

        gameState = GameState.from(stateNum);

        if (gameState == GameState.NewGame) {
            isVictory = false;
            startGame();
        }
    }
}


/**
 * GameState 클래스는 baseBallGame의 상태를 정의하고, 상태와 관련된 기능들을 정의합니다.
 */
enum GameState {
    NewGame(1), Finished(2);
    private final int value;

    private GameState(int value) {
        this.value = value;
    }

    /**
     * 해당 함수는 파라미터로 받는 stateNum이 유효한 값인지 확인하는 기능을 수행합니다.
     *
     * @param stateNum
     * @return stateNum이 정의된 상태중 하나를 의미하는 유효한 값이라면, 해당값에 맞는 상태반환, 아니면 IllegalArgumentException을 발생시킵니다.
     */
    public static GameState from(String stateNum) {
        for (GameState state : values()) {
            if (Integer.toString(state.value).equals(stateNum)) {
                return state;
            }
        }
        throw new IllegalArgumentException("input number is not valid");
    }
}


/**
 * Utils 클래스는 BaseballGame 에 입력값 검증에 대한 필요한 기능들을 제공합니다.
 */
class Utils {

    /**
     * 입력값이 유효한 숫자인지 확인합니다. <br> 1. 3자리 수인지 확인 <br> 2. 각 자리에 있는 숫자중 중복된 숫자가 있는지 확인
     *
     * @param inputStrNum
     * @return true if inputStrNum is valid , false otherwise
     * @see Utils#isValidDigit(String)
     * @see Utils#isNotDuplicatedDigits(String)
     */
    public static boolean isValidInput(String inputStrNum) {
        return isValidDigit(inputStrNum) && isNotDuplicatedDigits(inputStrNum);
    }

    /**
     * 해당 함수는 파라미터로 받는 입력값이 유효한 세자리 숫자인지 판단하는 기능을 수행합니다.
     *
     * @param inputStrNum
     * @return inputStrNum이 세자리의 유효한 숫자이면 true , 아니면 IllegalArgumentException을 발생시킵니다.
     */
    public static boolean isValidDigit(String inputStrNum) {

        int inputNum = Integer.parseInt(inputStrNum);

        if (100 <= inputNum && inputNum <= 999) {
            return true;
        } else {
            throw new IllegalArgumentException("input number is not valid");
        }
    }

    /**
     * 해당 함수는 파라미터로 받는 입력값의 각 인덱스에 중복된 값이 있는지 확인하는 기능을 수행합니다.
     *
     * @param inputStrNum
     * @return 각자리에 중복된 수가 없다면 true , 아니면 IllegalArgumentException을 발생시킵니다.
     */
    public static boolean isNotDuplicatedDigits(String inputStrNum) {

        for (int i = 0; i < inputStrNum.length(); i++) {
            char currentDigit = inputStrNum.charAt(i);
            if (inputStrNum.indexOf(currentDigit) != inputStrNum.lastIndexOf(currentDigit)) {
                throw new IllegalArgumentException("input number is not valid");
            }
        }
        return true;
    }
}