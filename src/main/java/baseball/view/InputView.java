package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    
    public String readBaseballNumber(){
        String inputNumber = Console.readLine();
        System.out.println(inputNumber);
        return inputNumber;
    }
}
