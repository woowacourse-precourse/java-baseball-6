package baseball.error;

public class RetryInpurErrorException implements ErrorException{
    private final static int GAME_RETRY_INT_VALUE = 1;
    private final static int GAME_END_INT_VALUE = 2;
    private final static String IS_NOT_NUMERIC_MESSAGE = "숫자만 입력이 가능합니다. 애플리케이션을 종료합니다.";
    private final static String IS_NOT_ONE_OR_TWO_MESSAGE = "1이나 2만 입력이 가능합니다. 애플리케이션을 종료합니다.";
    @Override
    public void checkUserInputValidate(String checkNumber) {
        if(!isNumeric(checkNumber)){
            throw new IllegalArgumentException(IS_NOT_NUMERIC_MESSAGE);
        }
        if(!isNumberOneOrTwo(checkNumber)){
            throw new IllegalArgumentException(IS_NOT_ONE_OR_TWO_MESSAGE);
        }
    }

    private static boolean isNumeric(String checkNumber) {
        return checkNumber.matches("-?\\d+(\\.\\d+)?");
    }

    private static boolean isNumberOneOrTwo(String checkNumber){
        int checkingNumber = Integer.parseInt(checkNumber);
        return checkingNumber == GAME_RETRY_INT_VALUE || checkingNumber == GAME_END_INT_VALUE;
    }
}
