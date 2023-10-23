package baseball.view;

import baseball.view.ViewResult;
import camp.nextstep.edu.missionutils.Console;

public class UserRandomBalls {
    public String input(){
        ViewResult viewResult = new ViewResult();
        System.out.print(viewResult.userInput);

        return Console.readLine();
    }
}
