package baseball.service;

import static baseball.exceptionHandler.ExecptionHandler.exceptionHandlingForUserInput;
import static camp.nextstep.edu.missionutils.Console.readLine;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class GameService {
    // 컴퓨터가 랜덤 숫자 3개를 골라서 저장하는 메소드
    public static List<Integer> generateComputerNumber() {
        List<Integer> computerNumList = new ArrayList<>();
        while (computerNumList.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumList.contains(randomNumber)) {
                computerNumList.add(randomNumber);
            }
        }

        return computerNumList;
    }



    public static int[] compare(List<Integer> computerNumList, List<Integer> userNumList) {
        //변수 선언
        // resultArray의 인덱스 0은 stikeNum을 위한 자리, 인덱스 1은 ballNum을 위한 자리이다.
        int[] resultArray;
        int strikeNum = 0;
        int ballNum = 0;
        int[] userNumberCheckArray = new int[10];
        int[] computerNumberCheckArray = new int[10];

        //스트라이크 개수 체크
        for (int i = 0; i < computerNumList.size(); i++) {
            userNumberCheckArray[userNumList.get(i)] = userNumberCheckArray[userNumList.get(i)] + 1;
            computerNumberCheckArray[computerNumList.get(i)] = computerNumberCheckArray[computerNumList.get(i)] + 1;
            if (computerNumList.get(i) == userNumList.get(i)) {
                strikeNum++;
            }
        }

        //볼 개수 체크
        for (int i = 0; i < userNumberCheckArray.length; i++) {
            if ((userNumberCheckArray[i] == computerNumberCheckArray[i]) && computerNumberCheckArray[i] != 0) {
                ballNum++;
            }

        }
        ballNum = ballNum - strikeNum;

        //배열에 저장
        resultArray = new int[]{strikeNum, ballNum};
        //반환
        return resultArray;
    }


    public static boolean checkResult(int[] resultArray) {
        //스트라이크 개수가 3개면 true리턴 아니면 false 리턴
        if (resultArray[0] == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        } else {
            return false;
        }
    }


    public static void printResult(int[] resultArray) {
        int strikeNum = resultArray[0];
        int ballNum = resultArray[1];

        if (ballNum != 0 && strikeNum == 0) {
            System.out.println(ballNum + "볼");
        }
        if (ballNum == 0 && strikeNum != 0) {
            System.out.println(strikeNum + "스트라이크");
        }
        if (ballNum != 0 && strikeNum != 0) {
            System.out.println(ballNum + "볼 " + strikeNum + "스트라이크");
        }
        if (strikeNum == 0 && ballNum == 0) {
            System.out.println("낫싱");
        }
    }

    public static boolean askForRegame() {
        //출력
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        String userInput = readLine();
//      예외 처리
        exceptionHandlingForUserInput(userInput);
//        예외처리 끝
        int checkValue = Integer.parseInt(userInput);

//        체크밸류가 1이면 true(재시작), 0이면 false(종료)리턴
        if (checkValue == 1) {
            return true;
        } else {
            return false;
        }
    }

}
