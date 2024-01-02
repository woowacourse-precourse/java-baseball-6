package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    public int[] inputNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        return validate(input);
    }

    private int[] validate(String input) {
        if (input.length() != 3) {
            throw new IllegalArgumentException("3자리가 아님");
        }
        if (!isAllNumber(input)){
            throw new IllegalArgumentException("숫자가 아님");
        }
        int[] numbers = this.convertToNumbers(input);
        if (!isAllDifferent(numbers)){
            throw new IllegalArgumentException("같은 숫자가 있음");
        }
        return numbers;
    }

    private boolean isAllNumber(String input){
        for(int i = 0;i < input.length();i++){
            if (!Character.isDigit(input.charAt(i)) || input.charAt(i) == '0'){
                return false;
            }
        }
        return true;
    }

    private int[] convertToNumbers(String input){
        int[] numbers = new int[3];
        for(int i = 0;i < 3;i++){
            numbers[i] = input.charAt(i);
        }
        return numbers;
    }
    private boolean isAllDifferent(int[] numbers){
        return numbers[0] != numbers[1] && numbers[1] != numbers[2] && numbers[0] != numbers[2];
    }
}
