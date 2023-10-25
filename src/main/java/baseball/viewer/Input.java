package baseball.viewer;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    public String readNumbers() {
        return Console.readLine();
    }

    public boolean gameContinue() {
        String decision = Console.readLine();
        if(decision.equals("1")){
           return false;
        }
        else if(decision.equals("2")){
            return true;
        }
        else{
            throw new IllegalArgumentException();
        }

    }
}
