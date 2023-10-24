package baseball;

import baseball.Common.Messages;
import baseball.View.GameView;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class GameService {
    private static final GameService instance = new GameService();

    public static final GameService getInstance(){
        return instance;
    }

    private static int target100, target10, target1;
    private static int userInput;

    public void inputNumber() throws IllegalArgumentException{
        GameView.printInputRequest();
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

        return (num100 != num10) && (num100 != num1) && (num10 != num1) && (num100 * num10 * num1 != 0);
    }

    public void initGame(){
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

    public List<Integer> referee(){
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
}
