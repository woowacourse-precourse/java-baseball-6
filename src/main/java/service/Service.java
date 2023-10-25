package service;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Service {


    public static void gameStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static List<Integer> setNumber() {


        List<Integer> numList = new ArrayList<>();
        int randomNumber;

        while(numList.size() < 3){
            randomNumber = Randoms.pickNumberInRange(0, 9);
            numList.add(randomNumber);
        }
        return numList;
    }

    public static String inputNumber() {
        System.out.println("숫자를 입력해주세요 : ");
        return Console.readLine();

    }

    public static int[] checkNum(List<Integer> userArr, List<Integer> comArr) {

        int[] answer_list = new int[2];

        for (Integer tmpInt : userArr) {
            int bool = comArr.indexOf(tmpInt);

            String answer = compareIndex(bool, tmpInt, userArr);

            answer_list = answerList(answer_list, answer);
        }
        return answer_list;
    }

    private static String compareIndex(int bool, Integer tmpInt, List<Integer> userArr) {
        if (bool == -1) {
            return "None";
        }
        if (bool == userArr.indexOf(tmpInt)) {
            return "Strike";
        }
        return "Ball";
    }

    private static int[] answerList(int[] answer_list, String answer) {
        //index 0 : ball, index 1 : strike

        if (answer.equals("Ball")) {
            answer_list[0] += 1;
        } else if (answer.equals("Strike")) {
            answer_list[1] += 1;
        }

        return answer_list;
    }


    public static List<Integer> strToInt(String userInput) {
        validateInputNumber(userInput);

        String[] strArr = userInput.split("");

        List<Integer> intArr = new ArrayList<>();

        for (String str : strArr) {
            intArr.add(Integer.parseInt(str));
        }

        return intArr;
    }

    public static String output(int[] answerList) {

        if (answerList[0] == 0 && answerList[1] == 0) {
            return "낫싱";
        }
        if (answerList[0] != 0 && answerList[1] != 0) {
            return Integer.toString(answerList[0]) + "볼 " + Integer.toString(answerList[1]) + "스트라이크";
        }
        if (answerList[0] == 0) {
            return Integer.toString(answerList[1]) + "스트라이크";
        }
        return Integer.toString(answerList[0]) + "볼";

    }

    public static boolean continueOrExit() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n" +
                "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        try {
            int continueOrExit_int = Integer.parseInt(Console.readLine());

            if (continueOrExit_int == 1) {
                return true;
            } else if (continueOrExit_int == 2) {
                return false;
            } else {
                throw new IllegalArgumentException("1 또는 2만을 입력해야합니다.");
            }
        } catch (NumberFormatException e) {
            System.out.println("숫자만 입력해주세요.");
        }
        return true;
    }




    public static void validateInputNumber(String userInput) {
        try {
            int userInputToInt = Integer.parseInt(userInput);

            if (100 > userInputToInt | 999 < userInputToInt) {
                throw new IllegalArgumentException("세 자리 수를 입력하세요.");
            } else if (userInputToInt / 100 == userInputToInt % 10 |
                    userInputToInt / 100 == (userInputToInt % 100) / 10 |
                    (userInputToInt % 100) / 10 == userInputToInt % 10) {
                throw new IllegalArgumentException("서로 다른 세 자리 수를 입력하세요.");
            }
        } catch (NumberFormatException e) {
            System.out.println("숫자만 입력해주세요.");
        }
    }
}
