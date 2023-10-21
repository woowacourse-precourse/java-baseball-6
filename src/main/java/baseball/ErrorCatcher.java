package baseball;

public class ErrorCatcher {
    private static final String ERROR_MESSAGE_SIZE = "입력 숫자는 총 3개여야 합니다.";
    private static final String ERROR_MESSAGE_DIGIT = "입력은 숫자여야 합니다.";
    private static final String ERROR_MESSAGE_RANGE = "입력 숫자의 범위는 1~9입니다.";
    public static void errorCheck(String[] userInput, int maxBallSize, int minimumNum, int maximumNum){
        checkMaxBallSize(userInput, maxBallSize);
        checkIsInteger(userInput);
        checkInRange(userInput, minimumNum, maximumNum);
    }
    private static void checkMaxBallSize(String[] userInput, int maxBallSize){
        int count = 0;
        for(String s : userInput){
            count++;
        }
        if (count != maxBallSize) throw new IllegalArgumentException(ERROR_MESSAGE_SIZE);
    }
    private static void checkIsInteger(String[] userInput){
        for (String s : userInput){
            if(!s.matches("^[\\d]*$")){
                throw new IllegalArgumentException(ERROR_MESSAGE_DIGIT);
            }
        }
    }
    private static void checkInRange(String[] userInput, int minimumNum, int maximumNum){
        for (String s : userInput){
            int target = Integer.parseInt(s)
            if(target > maximumNum || target < minimumNum) throw new IllegalArgumentException(ERROR_MESSAGE_RANGE);
        }
    }
}
