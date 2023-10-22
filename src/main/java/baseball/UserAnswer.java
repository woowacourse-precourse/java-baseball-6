package baseball;

public class UserAnswer {

    private String userInput;
    public UserAnswer(String userInput) {
        this.userInput = userInput;
    }

    public String checkUserInput() {

        if(userInput.length() !=3){
            throw new IllegalArgumentException("입력값의 길이가 안맞습니다.:"+userInput);
        }

        //중복검사
        String[] answerRepeat = userInput.split("");
        for(int i=0;i<2;i++){
            for(int j=i+1;j<3;j++){
                if(answerRepeat[i].equals(answerRepeat[j]))  throw new IllegalArgumentException("중복된 값이 있습니다.");
            }
        }
        return userInput;
    }

}
