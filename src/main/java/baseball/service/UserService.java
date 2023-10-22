package baseball.service;

import static baseball.exceptionHandler.ExecptionHandler.exceptionHandlingForUserNumber;
import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.ArrayList;
import java.util.List;

public class UserService {
    // 사용자 입력을 받는 메소드이다.
    public static List<Integer> receiveUserNumber() {
        //선언부
        List<Integer> userNumList = new ArrayList<>();
        String userInput;

        //출력
        System.out.print("숫자를 입력해주세요 : ");

        //입력을 받는다.
        userInput = readLine();

        // 입력 예외 처리
        exceptionHandlingForUserNumber(userInput);
        // 예외 처리 끝

        //입력을 분리한다.
        for (String s : userInput.split("")) {
            userNumList.add(Integer.parseInt(s));
        }

        return userNumList;
    }
}
