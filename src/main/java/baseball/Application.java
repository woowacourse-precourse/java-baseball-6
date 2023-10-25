package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        Compare compare = new Compare();
        while (true) {
            compare.isSame();

            System.out.println("게임을 다시 시작하려면 1, 종료하려면 2를 입력하세요: ");
            String restartNum = Console.readLine();

            if ("2".equals(restartNum)) {
                System.out.println("게임을 종료합니다.");
                break;
            }
        }
    }

}