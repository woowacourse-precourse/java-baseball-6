package baseball;
import camp.nextstep.edu.missionutils.Console;

public class Player {
    public static String input;
    int START_INCLUSIVE = Constants.START_INCLUSIVE;
    int END_INCLUSIVE = Constants.END_INCLUSIVE;
    int ANSWER_DIGIT = Constants.ANSWER_DIGIT;

    public void setInput(){
        String input = Console.readLine();

        // 유효성 검사 후 통과 못하면 에러 후 리턴
        validateInput(input);
        Player.input = input;
    }

    private void validateInput(String input) {
        // 입력값이 3자리 숫자인지 확인
        if (input.length() != ANSWER_DIGIT) {
            throw new IllegalArgumentException();
        }

        for (int i = 0; i < input.length(); i++) {
            char digit = input.charAt(i);

            // 입력값이 숫자가 아닌 경우
            if (digit < (char) ('0' + START_INCLUSIVE) || digit > (char) ('0' + END_INCLUSIVE)) {
                throw new IllegalArgumentException();
            }

            // 입력값 중복 확인
            for (int j = 0; j < i; j++) {
                if (input.charAt(j) == digit) {
                    throw new IllegalArgumentException();
                }
            }
        }
    }
}
