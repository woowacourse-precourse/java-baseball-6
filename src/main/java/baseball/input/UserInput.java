package baseball.input;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class UserInput {

    private String input;

    public UserInput() {
    }

    public void create(){
        input = readLine();
    }

    public void checking(){
        checkBlank(input);
        checkNum(input);
        checkRange(input);
        checkLength(input);
        checkDuplication(input);
    }

    private void checkBlank(String input) {
        checkLength(input.replaceAll(" ",""));
    }

    public String value() {
        return input;
    }

    private void checkNum(String userInput){
        for (char c: userInput.toCharArray()) {
            if(c<'0' || c>'9'){
                throw new IllegalArgumentException("숫자만 입력해야합니다."+userInput);
            }
        }
    }

    private void checkRange(String userInput){
        for (char c: userInput.toCharArray()) {
            if(c<'1' || c>'9'){
            throw new IllegalArgumentException("숫자는 1~9 사이여야합니다."+userInput);
            }
        }
    }

    private void checkLength(String userInput) {
        if(userInput.length() !=3){
            throw new IllegalArgumentException("입력값의 길이가 안맞습니다.:"+userInput);
        }
    }

    private void checkDuplication(String userInput) {
        String[] answerRepeat = userInput.split("");
        for(int i=0;i<2;i++){
            for(int j=i+1;j<3;j++){
                if(answerRepeat[i].equals(answerRepeat[j]))  throw new IllegalArgumentException("중복된 값이 있습니다.");
            }
        }
    }
}