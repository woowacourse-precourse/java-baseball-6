package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class User {
    Number userNum = new Number();

    public void start_user() {
        System.out.print("숫자를 입력해주세요 : ");
        userNum = new Number(readLine());
    }


    public boolean restart() {
        String restart = readLine();
        if (restart.equals("1")) {
            return true;
        } else if (restart.equals("2")) {
            return false;
        } else {
            throw new IllegalArgumentException("잘못된 입력값 입니다.");
        }
    }
}
