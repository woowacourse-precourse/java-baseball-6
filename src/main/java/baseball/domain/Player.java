package baseball.domain;

import camp.nextstep.edu.missionutils.Console;

public class Player {

    private String input;

    public String getInput() {
        return input;
    }

    public String enterInput() {
        this.input = Console.readLine();
        //에러처리(잘못입력)
        return input;
    }
}
