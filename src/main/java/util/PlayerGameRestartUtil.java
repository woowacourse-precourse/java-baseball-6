package util;

import camp.nextstep.edu.missionutils.Console;

public class PlayerGameRestartUtil {
    public static String gameRestartQuestion() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String ballNumber = Console.readLine();
        if (!(ballNumber.equals("1") || ballNumber.equals("2"))) {
            throw new IllegalArgumentException("숫자 1과 2중 하나만을 선택해주셔야해요.");
        }
        return ballNumber;
    }
}