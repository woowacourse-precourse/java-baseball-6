package baseball;

public class UserInput {

    private final String input;
    public UserInput(String userInput) {
        this.input = userInput;
    }

    public static UserInput from(String userInput){
        checkLength(userInput);
        checkDuplication(userInput);
        return new UserInput(userInput);
    }

    private static void checkDuplication(String userInput) {
        String[] answerRepeat = userInput.split("");
        for(int i=0;i<2;i++){
            for(int j=i+1;j<3;j++){
                if(answerRepeat[i].equals(answerRepeat[j]))  throw new IllegalArgumentException("중복된 값이 있습니다.");
            }
        }
    }

    private static void checkLength(String userInput) {
        if(userInput.length() !=3){
            throw new IllegalArgumentException("입력값의 길이가 안맞습니다.:"+userInput);
        }
    }
    public String value() {
        return input;
    }

}
