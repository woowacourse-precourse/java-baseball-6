package baseball;

import camp.nextstep.edu.missionutils.Console;

import static baseball.ComputerRandomNumber.computerRandomNumber;
import static baseball.InputValidator.validateInput;
import static baseball.MessageManager.*;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        getStartingMessage();
        while(true){
            boolean play = PlayBaseballGame.play();
            if(play){
                break;
            }
        }

    }
}









