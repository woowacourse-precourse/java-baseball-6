package baseball;


import camp.nextstep.edu.missionutils.Console;


public class Input {
    public UserBaseballNumber getUserBaseballNumber(){
        String userInput = Console.readLine();
        return new UserBaseballNumber(userInput);
    }
    public boolean getResumeInput(){
        String userInput = Console.readLine();
        validateResumeInput(userInput);
        return parseResumeInput(userInput);
    }
    private void validateResumeInput(String userInput){
        checkIfInputNumberLength(userInput);
        checkIfInputNumberIsNotNumberFormat(userInput);
    }
    private void checkIfInputNumberLength(String userInput){
        if(userInput.length() != 1){
            throw new IllegalArgumentException("잘못된 사용자 입력입니다. : 입력의 길이가 1이 아닙니다.");
        }
    }
    private void checkIfInputNumberIsNotNumberFormat(String userInput){
        try{
            Integer.parseInt(userInput);
        } catch(NumberFormatException ex){
            throw new IllegalArgumentException("잘못된 사용자 입력입니다. : 숫자 형식의 입력이 아닙니다.");
        }
    }
    private boolean parseResumeInput(String userInput){
        if(userInput.equals("1")){
            return true;
        }
        if(userInput.equals("2")){
            return false;
        }
        throw new IllegalArgumentException("잘못된 입력입니다. : 1 또는 2 값이 아닙니다.");
    }
}