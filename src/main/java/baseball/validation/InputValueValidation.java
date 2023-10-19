package baseball.validation;

import camp.nextstep.edu.missionutils.Console;

public class InputValueValidation {

    public int valid(String input, int size) throws IllegalArgumentException{
        int inputValue = notNumber(input);
        notThreeNumber(input, size);
        includeZero(inputValue);
        notEachDifferent(inputValue);
        return inputValue;
    }

    //문자 포함일 때,
    private int notNumber(String input) throws IllegalArgumentException{
        try{
            return Integer.parseInt(input);
        } catch(NumberFormatException e){
            throw new IllegalArgumentException();
        }
    }

    //3의 자리가 아닐 때,
    private void notThreeNumber(String input, int size) throws IllegalArgumentException{
        if(input.length() != size){
            throw new IllegalArgumentException();
        }
    }

    //숫자 0을 포함하고 있는 경우
    private void includeZero(int num) throws IllegalArgumentException {
        if(num/100 == 0 || (num/10)%10 == 0 || num %10 == 0){
            throw new IllegalArgumentException();
        }
    }

    //서로 다른 3개의 숫자가 아닌 경우
    private void notEachDifferent(int num) throws IllegalArgumentException {
        int n1 = num/100;
        int n2 = (num/10)%10;
        int n3 = num %10;
        if(n1 == n2 || n1 == n3 || n2 == n3){
            throw new IllegalArgumentException();
        }
    }

}
