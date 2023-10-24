package baseball.exception;


import java.util.List;

public class UserInputException {
    private final int listLength = 3;
    private final int startPoint = 1;
    private final int endPoint = 9;

    public boolean Validation(List<Integer> userNumber) {
        return isDigit(userNumber) && isDuplicate(userNumber) && isRange(userNumber);
    }
    private boolean isDigit(List<Integer> userNumber){
        return userNumber.size() == listLength;
    }

    private boolean isDuplicate(List<Integer> userNumber) {
        return userNumber.size() == userNumber.stream().distinct().count();
    }
    private boolean isRange(List<Integer> userName) {
        return userName.stream()
                .allMatch(num -> num >= startPoint && num <= endPoint);

    }

}
