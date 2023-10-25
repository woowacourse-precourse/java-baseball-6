package baseball.domain.user;


import baseball.domain.game.GameOption;
import baseball.domain.game.Input;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class User {

    // 재시작 여부 값 사용자로부터 입력받고, 검증 후, 이를 반환
    public static Integer getWouldRestartGame(String userOption) throws IllegalArgumentException {
        // 입력
        int numericInput = Integer.parseInt(userOption);

        // 검증
        GameOption option = validateGameOption(numericInput);

        // 반환
        return option.getOption();
    }

    // 재시작 여부 값 검증
    public static GameOption validateGameOption(int numericInput) {
        GameOption option = Arrays.stream(GameOption.values())
                .filter(gameOption -> gameOption.getOption() == numericInput)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("재시작 여부는 1(재시작)과 2(종료) 중 하나만 입력해주세요."));
        return option;
    }

    // 입력한 세자리 수 문자열을 검증하고, 각 자리 수의 숫자를 리스트에 추가하기
    public static List<Integer> parseUserAnswer(String userAnswer) throws IllegalArgumentException {
        List<Integer> parsedUserAnswers = new ArrayList<>();

        // 입력문자열이 야구게임 정책인 3자리를 넘어가는 경우, 예외처리를 합니다.
        validateUserInput(userAnswer.length() != Input.NUMLENGTH.getLength(),
                String.format("%s자리의 숫자를 입력해주세요", Input.NUMLENGTH.getLength()));

        for (int i = 0; i < userAnswer.length(); i++) {
            // 각 수에 접근
            char eachNumber = userAnswer.charAt(i);

            // 숫자가 아닌 문자가 포함 되어있는 경우, 예외처리를 합니다.
            boolean isDigit = Character.isDigit(eachNumber);
            validateUserInput(isDigit != true, "숫자만 입력해주세요");

            // char를 int로 변환한 뒤, userInputs 리스트에 추가합니다.
            int eachInputNumber = Character.getNumericValue(eachNumber);
            parsedUserAnswers.add(eachInputNumber);
        }

        return parsedUserAnswers;
    }

    // 조건식에 따른 예외메세지 가지는 예외처리
    private static void validateUserInput(boolean condition, String exceptionMessage) {
        if (condition) {
            throw new IllegalArgumentException(exceptionMessage);
        }
    }

}
