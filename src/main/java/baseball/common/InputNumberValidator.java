package baseball.common;

public class InputNumberValidator {

    public static final String WRONG_INPUT_TYPE_MESSAGE = "1~9 사이의 숫자만 입력 가능합니다.";
    public static final String WRONG_INPUT_SIZE_MESSAGE = "세자리를 입력해주세요.";
    public static final String WRONG_INPUT_UNIQUE_MESSAGE = "서로 다른 숫자만 입력 가능합니다.";

    public static void validate(String inputNumber) {
        //1. 숫자인지 확인
        //2. 세 자리인지 확인
        //3. 서로 다른 숫자인지 확인

        if(!isNumber(inputNumber)) {
            throw new IllegalArgumentException(WRONG_INPUT_TYPE_MESSAGE);
        }
        if(!isThreeLetters(inputNumber)) {
            throw new IllegalArgumentException(WRONG_INPUT_SIZE_MESSAGE);
        }
        if(!isUniqueCharacters(inputNumber)) {
            throw new IllegalArgumentException(WRONG_INPUT_UNIQUE_MESSAGE);
        }

    }

    private static boolean isNumber(String inputNumber) {
        for(int i = 0; i< inputNumber.length(); i++) {
            char number = inputNumber.charAt(i);
            if(number < Character.forDigit(NumberConstants.NUMBER_RANGE_MIN.getValue(), 10) || number > Character.forDigit(NumberConstants.NUMBER_RANGE_MAX.getValue(), 10)) {
                return false;
            }
        }

        return true;
    }

    private static boolean isThreeLetters(String inputNumber) {
        if(inputNumber.isEmpty() || inputNumber.length() != 3) {
            return false;
        }
        return true;
    }

    private static boolean isUniqueCharacters(String inputNumber) {
        boolean[] isContained = new boolean[NumberConstants.NUMBER_RANGE_MAX.getValue()+1];

        for(int i=0; i<inputNumber.length(); i++) {
            int number = Character.getNumericValue(inputNumber.charAt(i));
            if(isContained[number]) {
                return false;
            }
            isContained[number] = true;
        }

        return true;
    }

}
