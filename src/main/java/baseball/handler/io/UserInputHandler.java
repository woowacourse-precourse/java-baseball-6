package baseball.handler.io;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.stream.Collectors;

public class UserInputHandler {
    public static List<Integer> userSubmit() {
        System.out.print("숫자를 입력해주세요 : ");
        String answer = Console.readLine();
        return answer.chars().mapToObj(item -> item - '0')
                .collect(Collectors.toList());
    }

    public static boolean isContinue() {
        String isReTry;

        do {
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            isReTry = Console.readLine();
        } while (!isReTry.equals("1") && !isReTry.equals("2"));

        if (isReTry.equals("1")) {
            return true;
        } else {
            return false;
        }
    }

}
