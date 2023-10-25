package baseball.game;

import camp.nextstep.edu.missionutils.Console;

public class User {

    public String getInput() {

        System.out.print("숫자를 입력해주세요 : ");

        return Console.readLine();
    }

    public boolean checkInput(String input) {

        if(input.length() != 3) {
            throw new IllegalArgumentException("3자리의 숫자가 입력되어야 합니다.");
        }

        try {
            Integer.parseInt(input);
        } catch(NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닌 값이 입력되었습니다.");
        }

        return true;
    }

}
