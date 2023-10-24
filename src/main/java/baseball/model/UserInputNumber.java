package baseball.model;

public class UserInputNumber {
    String userInput;

    public UserInputNumber(String userInput) {
        checkTypeNumber(userInput);
        checkThreeNumber(userInput);
        checkOverlapNumber(userInput);
        this.userInput = userInput;
    }

    public String getUserInputNumber() {return userInput;}

    //    숫자 타입인지 확인 후 예외 처리
    public static void checkTypeNumber(String userInput) throws IllegalArgumentException {
        if (!userInput.matches("^[1-9]*$")) {
            throw new IllegalArgumentException("1-9까지의 숫자만 입력해주세요.");

        }
    }

    //    세자리 숫자인지 확인 후 예외 처리
    public static void checkThreeNumber(String userInput) throws IllegalArgumentException {
        if (userInput.length() != 3) {
            throw new IllegalArgumentException("세자리 숫자로 입력해주세요.");
        }
    }

    //    숫자 중 중복 숫자가 있는지 확인 후 예외 처리
    public static void checkOverlapNumber(String userInput) throws IllegalArgumentException {
        for(int i=0;i<3;i++){
            for(int j=0; j<3;j++) {
                if ((i != j) && (userInput.substring(i,i+1).equals(userInput.substring(j,j+1)))) throw new IllegalArgumentException("중복되지 않은 값을 입력해주세요.");
            }
        }
    }

}
