package baseball.util;

import baseball.model.NumberModel;

/**
 * NumberModel로 변환
 *
 * @see NumberModel
 * @see Verifier
 */
public class ToNumberModel {
    /**
     * 사용자 입력을 검증 후 NumberModel로 변환
     * @param userInput 사용자 입력
     * @return NumberModel로 반환
     */
    public static NumberModel userInputToNumberModel(String userInput) {
        Verifier.verifyUserInput(userInput);

        int firstNumber = Integer.parseInt(String.valueOf(userInput.charAt(0)));
        int secondNumber = Integer.parseInt(String.valueOf(userInput.charAt(1)));
        int thirdNumber = Integer.parseInt(String.valueOf(userInput.charAt(2)));

        return new NumberModel(firstNumber, secondNumber, thirdNumber);
    }
}
