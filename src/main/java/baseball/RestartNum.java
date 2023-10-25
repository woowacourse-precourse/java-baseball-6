package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class RestartNum {
    int number;

    public RestartNum() {
        String restartStr;

        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        restartStr = readLine();
        CheckRestartNum.isError(restartStr);
        number = Character.getNumericValue(restartStr.charAt(0));
    }

    int getRestartNum() {
        return (number);
    }
}
