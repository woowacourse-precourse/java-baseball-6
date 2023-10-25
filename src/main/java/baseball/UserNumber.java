package baseball;

import camp.nextstep.edu.missionutils.Console;


public class UserNumber {
    int[] userNumber = new int[3];

    public int inputUserNumber() {
        String input = Console.readLine();
        return Integer.parseInt(input);   
    }
}
    
