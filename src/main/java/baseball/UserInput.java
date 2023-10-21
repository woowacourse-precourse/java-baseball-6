package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;

public class UserInput {

    // 사용자의 입력값을 받는 함수
    public static ArrayList<Integer> userInput() {

        System.out.print("숫자를 입력해주세요 : ");

        String userStr = Console.readLine();

        // 사용자 입력값 오류 검사
        vaildLenth(userStr);

        ArrayList<Integer> userInputList = new ArrayList<>();
        int inputNum = Integer.parseInt(userStr);
        userInputList.add(inputNum);

        return userInputList;
    }


    // 사용자 입력값 오류 처리
    public static void vaildLenth(String inputStr){
        if(inputStr.length() != 3){
            throw new IllegalArgumentException("사용자 입력값 오류");
        }

    }

}
