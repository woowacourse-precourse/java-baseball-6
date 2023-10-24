package baseball.handler.io;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.stream.Collectors;

public class UserInputHandler {
    public static List<Integer> userSubmit(){
        System.out.println("숫자를 입력해주세요 : ");
        String answer = Console.readLine();
        return answer.chars().mapToObj(item -> item - '0')
                .collect(Collectors.toList());
    }
}
