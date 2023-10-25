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
        if(getInput().length() != 3) throw new IllegalArgumentException("3자리 숫자를 입력하세요.");
        return input;
    }
}
