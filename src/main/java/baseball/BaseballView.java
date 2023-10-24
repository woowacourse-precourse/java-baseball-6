package baseball;

import camp.nextstep.edu.missionutils.Console;

/* input, output 화면(메세지) 출력 */
public class BaseballView {
    public static final String INPUT_VALID_FORMAT_OF_NUMBER = "1~9 사이의 서로 다른 세 개의 숫자를 공백없이 입력하세요.";
    public static final String INPUT_VALID_RANGE_OF_OPTION = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    // 게임 시작 메세지
    public void outputGameStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    // 유저 숫자 입력 요청 메세지
    public void outputUserNumber() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    // 판정 결과 출력 - 볼, 스트라이크, 낫싱
    public void outputCount(int count) {
        System.out.print(count);
    }

    public void outputResultBallWithoutStrike() {
        System.out.println("볼");
    }

    public void outputResultBallWithStrike() {
        System.out.print("볼 ");
    }

    public void outputResultStrike() {
        System.out.println("스트라이크");
    }

    public void outputResultNothing() {
        System.out.println("낫싱");
    }

    // 게임 종료 메세지
    public void outputFinishGame() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    // 게임 재시작 혹은 종료 선택 입력 요청 메세지
    public void outputSelectRestartOrEnd() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    /* 값을 입력 받을 때 사용 */
    // 유저 숫자 입력
    public String inputUserNumber() {
        outputUserNumber();
        String input = Console.readLine();
        checkValidNumberFormat(input);
        return input;
    }

    // 게임 재시작 혹은 종료 선택 입력
    public String inputSelectRestartOrEnd() {
        outputSelectRestartOrEnd();
        String input = Console.readLine();
        checkValidOptionRange(input);
        return input;
    }

    /* 입력 값 예외처리 */
    private void checkValidNumberFormat(String input) {
        isCorrectLength(input);
        isExistChar(input);
        isExistRepeatedNumber(input);
    }

    private void checkValidOptionRange(String input) {
        if (!input.equals("1") && !input.equals("2")) {
            throw new IllegalArgumentException(INPUT_VALID_RANGE_OF_OPTION);
        }
    }

    private void isExistChar(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) < 48 || input.charAt(i) > 57) {
                throw new IllegalArgumentException(INPUT_VALID_FORMAT_OF_NUMBER);
            }
        }
    }

    private void isCorrectLength(String input) {
        if (input.length() != 3) {
            throw new IllegalArgumentException(INPUT_VALID_FORMAT_OF_NUMBER);
        }
    }

    private void isExistRepeatedNumber(String input) {
        if (input.length() != 3) {
            throw new IllegalArgumentException(INPUT_VALID_FORMAT_OF_NUMBER);
        }
    }
}
