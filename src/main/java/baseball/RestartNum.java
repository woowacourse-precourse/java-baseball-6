package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class RestartNum {
    int number;

    public RestartNum() throws IllegalArgumentException {
        String restartStr;

        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        restartStr = readLine();
        if (CheckRestartNum.isError(restartStr)) {
            throw new IllegalArgumentException("RestartNum 입력값 오류.");
        }
        number = Character.getNumericValue(restartStr.charAt(0));
    }

    int getRestartNum() {
        return (number);
    }
}
