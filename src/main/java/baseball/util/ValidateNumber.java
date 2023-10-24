package baseball.util;

public class ValidateNumber {

    public void Validator(String playerNumber){
        isInRange(playerNumber);
        isLengthCorrect(playerNumber);
        isNotDuplicate(playerNumber);
    }

    public void isInRange(String playerNumber) throws IllegalArgumentException {
        try {
            Integer.parseInt(playerNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("유효하지 않은 입력값입니다. 정수를 입력하세요.");
        }
    }

    public void isLengthCorrect(String playerNumber) throws IllegalArgumentException {
        if (playerNumber.length() != 3) {
            throw new IllegalArgumentException("유효하지 않은 입력값입니다. 3자리의 정수를 입력하세요.");
        }
    }

    public void isNotDuplicate(String playerNumber) throws IllegalArgumentException {
        if (playerNumber.charAt(0) == playerNumber.charAt(1) && playerNumber.charAt(1) == playerNumber.charAt(2) && playerNumber.charAt(0) == playerNumber.charAt(2)) {
            throw new IllegalArgumentException("유효하지 않은 입력값입니다. 중복되지 않은 숫자를 입력하세요.");
        }
    }

    public void isEndNumber(String endNumber) throws IllegalArgumentException {
        if(!(endNumber.equals("1")||endNumber.equals("2"))){
            throw new IllegalArgumentException("유효하지 않은 입력값입니다.");
        }
    }
}
