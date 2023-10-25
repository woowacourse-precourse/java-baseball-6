package baseball;

public class ValidInputChecker {
    public static void checkUserInput(String userInput){
        checkInputLength(userInput);
        checkIsNumber(userInput);
        checkDuplicateInput(userInput);
    }

    public static void checkInputLength(String userInput){
        if(userInput.length() != 3){
            throw new IllegalArgumentException("세자리의 숫자를 입력해주세요.");
        }
    }

    public static void checkIsNumber(String userInput){
        for(char c : userInput.toCharArray()){
            if(c>'9' || c<'1'){
                throw new IllegalArgumentException("숫자를 입력해주세요.");
            }
        }
    }

    public static void checkDuplicateInput(String userInput) {
        for(int i=0; i<userInput.length()-1; i++){
            for(int j=i+1; j<userInput.length(); j++){
                if(userInput.charAt(i) == userInput.charAt(j)){
                    throw new IllegalArgumentException("중복되지 않는 숫자를 입력해주세요.");
                }
            }
        }
    }


}