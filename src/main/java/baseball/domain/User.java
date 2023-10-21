package baseball.domain;

import camp.nextstep.edu.missionutils.Console;

public class User {

    private String baseBallNumberString;

    public String getBaseballNumberList() {
        return baseBallNumberString;
    }

    public void readBaseballNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        baseBallNumberString = Console.readLine();

    }


}
