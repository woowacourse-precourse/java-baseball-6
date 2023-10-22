package baseball;

import java.util.List;


import static baseball.service.GameService.*;
import static baseball.service.UserService.receiveUserNumber;


public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");

        List<Integer> computerNumList;
        List<Integer> userNumList;
        int[] resultArray;

        do {
            computerNumList = generateComputerNumber();
            do {
                userNumList = receiveUserNumber();
                resultArray = compare(userNumList, computerNumList);
                printResult(resultArray);

            } while (!checkResult(resultArray));

        } while (askForRegame());


    }




}


