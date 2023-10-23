package baseball.domain;

import camp.nextstep.edu.missionutils.Console;

public class User {

    private String baseBallNumberString;

    public String getBaseballNumberList() {
        return baseBallNumberString;
    }

    public void readBaseballNumber() {
        baseBallNumberString = Console.readLine();
    }


}
