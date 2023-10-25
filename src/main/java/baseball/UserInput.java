package main.java.baseball;

import camp.nextstep.edu.missionutils.Console.readLine;

public class UserInput {

    public int getUserGuess() {
        System.out.print("숫자를 입력해주세요 : ");
        return Console.readLine();
    }

    public int getRestartOrExit() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return Console.readLine();
    }

}
