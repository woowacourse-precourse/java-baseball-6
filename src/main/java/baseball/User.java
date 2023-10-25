package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class User {
    private BaseballNum userNum;

    public User() {
        inputNum();
    }

    void inputNum() {
        System.out.print("숫자를 입력해주세요 : ");
        userNum = new BaseballNum(readLine());
    }

    static boolean chooseRestart() {
        RestartNum restartNum = new RestartNum();
        return (restartNum.getRestartNum() == 1);
    }

    BaseballNum getUserNum() {
        return (userNum);
    }
}
