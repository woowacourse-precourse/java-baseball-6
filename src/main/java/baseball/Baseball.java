package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Baseball {
    private static int target100, target10, target1;
    private static int userInput;

    private List<Integer> result = new ArrayList<>(Arrays.asList(0, 0));

    public void play(){
        initGame();
        while(result.get(0) != 3) {
            inputNumber();
            result = referee();
            printResult();
        }
    }

    private void inputNumber() throws IllegalArgumentException{
        System.out.print(Messages.USER_INPUT_NUMBER);
        String input = Console.readLine();

        if(input.length() != 3)
            throw new IllegalArgumentException(Messages.NOT_THREE_DIGIT);

        try{
            int number = Integer.parseInt(input);

            if(!isValidNumber(number))
                throw new IllegalArgumentException(Messages.INVALID_NUMBER_INPUT);

            userInput = number;
        } catch (NumberFormatException e){
            throw new IllegalArgumentException(Messages.INVALID_NUMBER_FORMAT);
        }
    }

    private boolean isValidNumber(int number){
        if(number < 123 || number > 987)
            return false;

        int num100 = number / 100;
        int num10 = number / 10 % 10;
        int num1 = number % 10;

        return num100 != num10 && num100 != num1 && num10 != num1;
    }

    private void initGame(){
        target1 = Randoms.pickNumberInRange(1, 9);
        target10 = Randoms.pickNumberInRange(1, 9);
        target100 = Randoms.pickNumberInRange(1, 9);

        while(target100 == target10 || target100 == target1 || target10 == target1){
            if(target100 == target10)
                target10 = Randoms.pickNumberInRange(1, 9);
            if(target10 == target1)
                target1 = Randoms.pickNumberInRange(1, 9);
            if(target100 == target1)
                target1 = Randoms.pickNumberInRange(1, 9);
        }
    }

    private List<Integer> referee(){
        int user100 = userInput / 100;
        int user10 = userInput / 10 % 10;
        int user1 = userInput % 10;

        int strike = 0, ball = 0;

        if(user100 == target100) strike++;
        else if (user100 == target10 || user100 == target1) ball++;

        if(user10 == target10) strike++;
        else if (user10 == target100 || user10 == target1) ball++;

        if(user1 == target1) strike++;
        else if (user1 == target10 || user1 == target100) ball++;

        return Arrays.asList(strike, ball);
    }

    private void printResult(){
        if(result.get(0) == 3)
            System.out.println(Messages.SUCCESS);
        else if (result.get(0) + result.get(1) == 0)
            System.out.println(Messages.FAIL);
        else
            System.out.println(Messages.STRIKE_AND_BALL(result));
    }
}
