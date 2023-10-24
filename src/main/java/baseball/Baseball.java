package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

/**
 * Baseball 클래스는 숫자야구 게임을 할 수 있게 하는 클래스입니다.
 *
 * @author Hyune0129
 * @version 1.0 2023년 10월 25일
 */
public class Baseball {

    /**
     * List인 numbers는 숫자 야구의 답을 담고있는 변수입니다. 안에는 중복되는 수가 없으며, 1~9의 범위를 가집니다.
     */
    private final List<Integer> numbers = new ArrayList<>();

    /**
     * 생성자를 호출하면 게임 시작을 콘솔로 알립니다.
     */
    Baseball() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    /**
     * @param num numbers 리스트에 num 이 중복이 아니라면 num 을 numbers 리스트에 추가합니다.
     */
    private void addNumbersWithoutDuplicate(int num) {
        if (!numbers.contains(num)) {
            /* num 이 numbers 리스트에 없을 떄 */
            numbers.add(num);
        }
    }

    /**
     * 숫자야구의 답인 numbers를 초기화하는 함수입니다.
     */
    private void initNumbers() {
        if (!numbers.isEmpty()) {
            /* 게임을 재시작할 경우 numbers는 이곳에서 초기화합니다. */
            numbers.clear();
        }
        while (numbers.size() < 3) {
            /*숫자 야구의 답이 중복되지 않고, 3개가 나오도록 설정 */
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            addNumbersWithoutDuplicate(randomNumber);
        }
    }

    /**
     * @param inputNumber  길이가 3인 사용자가 입력한 값 중 하나가 char 로 들어갑니다.
     * @param inputNumbers inputNumber 가 정상적인 입력값이면 inputNumbers 리스트에 추가합니다.
     * @throws IllegalArgumentException inputNumber 가 숫자가 아니거나, 0이라면 에러를 발생시킵니다.
     */
    private void addInputNumbers(char inputNumber, List<Integer> inputNumbers) throws IllegalArgumentException {
        if (!Character.isDigit(inputNumber) || (Character.digit(inputNumber, 10) == 0)) {
            throw new IllegalArgumentException("Error : 3자리의 숫자가 아닌 값 입력");
        }
        inputNumbers.add(Character.digit(inputNumber, 10));
    }

    /**
     * 사용자가 입력한 문자열을 int 값인 리스트로 변환하는 함수입니다.
     *
     * @param input 사용자가 숫자야구의 정답을 맞히기 위해 입력한 String 타입의 값입니다.
     * @return int 값으로 된 리스트를 반환합니다.
     * @throws IllegalArgumentException 사용자가 입력한 값이 3이 아니라면 발생하는 에러입니다.
     */
    private List<Integer> inputToInputNumbers(String input) throws IllegalArgumentException {
        if (input.length() != 3) {
            /* 입력문자의 길이가 3이 아닌 경우 */
            throw new IllegalArgumentException("Error : 3자리의 숫자가 아닌 값 입력");
        }
        List<Integer> inputNumbers = new ArrayList<>();
        for (char inputNumber : input.toCharArray()) {
            addInputNumbers(inputNumber, inputNumbers);
        }
        return inputNumbers;
    }

    /**
     * @param index  사용자가 입력한 번호의 자리를 의미합니다. 0~2의 값 중 하나입니다.
     * @param number 사용자가 입력한 값 중 index 자리의 값을 나타냅니다. 0~9의 값 중 하나입니다.
     * @return 스트라이크라면 true, 아니라면 false를 반환합니다.
     */
    private boolean isStrike(int index, int number) {
        return numbers.get(index) == number;
    }

    /**
     * @param number 사용자가 입력한 값 중 하나의 값을 나타냅니다. 0~9의 값 중 하나입니다.
     * @return 볼이라면 true, 아니라면 false를 반환합니다.
     */
    private boolean isBall(int number) {
        return numbers.contains(number);
    }

    /**
     * @param index          사용자가 입력한 번호의 자리를 의미합니다. 0~2의 값 중 하나입니다.
     * @param number         사용자가 입력한 값 중 index 자리의 값을 나타냅니다. 0~9의 값 중 하나입니다.
     * @param baseballResult 볼 혹은 스트라이크의 정보를 적용합니다.
     */
    private void calculateNumber(int index, int number, BaseballResult baseballResult) {
        if (isStrike(index, number)) {
            baseballResult.addStrike();
        } else if (isBall(number)) {
            baseballResult.addBall();
        }
    }

    /**
     * @param inputNumbers int 값인 리스트로 되어있는 사용자의 정답 입력값입니다.
     * @return 계산을 전부 마친 결과인 BaseballResult 클래스를 반환합니다.
     */
    private BaseballResult getBaseballResult(List<Integer> inputNumbers) {
        BaseballResult baseballResult = new BaseballResult();
        for (int i = 0; i < 3; i++) { // index : 0~2
            calculateNumber(i, inputNumbers.get(i), baseballResult);
        }
        return baseballResult;
    }

    /**
     * main 에서 사용시 게임을 시작합니다.
     *
     * @throws IllegalArgumentException 사용자가 정답을 추리할 떄 0을 제외한 3자리의 수를 입력하지 않으면 발생됩니다.
     */
    public void startBaseball() throws IllegalArgumentException {
        initNumbers();
        BaseballResult baseballResult = null;
        do {
            System.out.print("숫자를 입력해주세요 : ");
            String input = Console.readLine();
            List<Integer> inputNumbers = inputToInputNumbers(input);
            baseballResult = getBaseballResult(inputNumbers);
            System.out.println(baseballResult);
        } while (!baseballResult.isSuccess());
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

}
