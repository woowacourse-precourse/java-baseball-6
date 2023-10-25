package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.HashSet;


public class Player {

    private int length;

    Player(int length){
        this.length = length;
    }

    private Player() {
    }

    public int readInput() {
        String input = Console.readLine();
        return validationCheck(input);

    }

    private int validationCheck(String input){
        int integerInput = changetoInt(input);
        integerInput = rangeCheck(integerInput);
        integerInput = duplicationCheck(integerInput);
        return integerInput;

    }

    private int changetoInt(String input) {
        try{
            return Integer.parseInt(input);
        }catch (IllegalArgumentException e){
            throw new IllegalArgumentException("숫자가 아닌 입력값입니다.");
        }
    }

    private int rangeCheck(int integerInput){
        if(integerInput>=Math.pow(10,length-1) && integerInput<Math.pow(10,length)){
            return integerInput;
        }

        throw new IllegalArgumentException("입력값이 적정 범위를 벗어난 값입니다.");
    }

    private int duplicationCheck(int integerInput){
        int toCheck = integerInput;
        HashSet<Integer> digits = new HashSet<>();
        while(toCheck > 0){
            int digit = toCheck%10;
            if(digits.contains(digit)){
                throw new IllegalArgumentException("입력값에 중복된 숫자가 있습니다.");
            }
            digits.add(digit);
            toCheck /= 10;
        }
        return integerInput;
    }

    public int readRestartInput(){
        String input = Console.readLine();
        int restart = changetoInt(input);
        return restartCheck(restart);

    }

    private int restartCheck(int restart) {
        if (restart == 1 || restart == 2) {
            return restart;
        }
        throw new IllegalArgumentException("입력 값은 1 또는 2만 가능합니다.");

    }

}
