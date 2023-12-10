package view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String pickThreeNumber(){
        String threeNumbers = Console.readLine();
        return threeNumbers;
    }

    public int tobeContinueNumber(){
        String finishOrOneMore = Console.readLine();
        return Integer.parseInt(finishOrOneMore);
    }
}

