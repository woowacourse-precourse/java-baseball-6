package baseball;

public class NumberInput {
    private String numberInput;
    NumberInput(String numberInput){
        validateUserInputSize(numberInput);
        this.numberInput = numberInput;
    }
    public void validateUserInputSize(String input){
        if(input.length() != 3){
            throw new IllegalArgumentException("3자리 숫자를 입력해주세요.");
        }
    }
    public int getNumberByIndex(int index){
        return numberInput.charAt(index) - '0';
    }
}
