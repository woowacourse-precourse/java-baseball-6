package baseball;

import camp.nextstep.edu.missionutils.Console;

public class RestartOrEnd {
    public int RestartOrEnd() {

        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int restartOrEndNum = Integer.parseInt(Console.readLine());

        return restartOrEndNum;
    }
}
