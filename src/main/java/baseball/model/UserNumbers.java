package baseball.model;

public class UserNumbers {
    public Number[] numbers;

    public UserNumbers(String inputStr) {
        if(!isValidInput(inputStr)){
            throw new IllegalArgumentException("입력 값은 3자리 숫자여야 합니다.");
        }
        if(!isNotDuplicate(inputStr)){
            throw new IllegalArgumentException("입력 값은 중복된 숫자를 포함할 수 없습니다.");
        }
        Number[] inputNumbers = turnToNumberList(inputStr);

        this.numbers = inputNumbers;
    }

    public UserNumbers(Number[] nums){
        this.numbers=nums;
    }

    public boolean isValidInput(String inputStr){
        if (inputStr==null || inputStr.length() !=3){
            return false;
        }
        return true;
    }

    public boolean isNotDuplicate(String inputStr){
        for(int i=0;i< inputStr.length();i++){
            for(int j=i+1;j< inputStr.length();j++){
                if(inputStr.charAt(i)==inputStr.charAt(j)){
                    return false;
                }
            }
        }
        return true;
    }

    public static Number[] turnToNumberList(String numbers){
        Number[] returnNumberList = new Number[numbers.length()];

        for (int i = 0; i < numbers.length(); i++) {
            returnNumberList[i] = new Number(Character.getNumericValue(numbers.charAt(i)));
        }
        return returnNumberList;
    }

}
