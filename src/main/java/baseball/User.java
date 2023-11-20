package baseball;

import camp.nextstep.edu.missionutils.Console;


public class User {
    private String myNumber;

    public String getMyNumber() {
        return myNumber;
    }

    public void setMyNumber() {
        this.myNumber = Console.readLine();
    }
}
