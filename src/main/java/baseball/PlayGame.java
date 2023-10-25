package baseball;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
public class PlayGame {
    private static ExceptionHandler exceptionHandler = ExceptionHandler.getInstance();
    private static String inputMent = "숫자를 입력해주세요 : ";
    private static String nothing = "낫싱";
    private static String answer = "3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    //상대방(컴퓨터) 및 유저 입력에 대한 세자리 수를 관리할 List
    private static List<Integer> computers, users;

    public PlayGame(List<Integer> computers) {
        this.computers = computers;
    }


    public boolean game() {
        //실질적인 게임 로직
        while(true) {

            System.out.print(inputMent);

            //사용자 입력
            String input = Console.readLine();

            //길이에 대한 유효성 검사 체크
            exceptionHandler.userInputLengthValidation(input);

            //입력값
            users = new ArrayList<>();

            for (int i = 0; i < 3; i++) {
                users.add(input.charAt(i) - '0');
            }

            //유효성 검사
            exceptionHandler.userInputValidation(users);

            //체크변수 초기화
            int ballCount = 0;
            int strikeCount = 0;

            //체크 로직
            for(int i=0; i<3; i++) {
                if(isStrike(users.get(i), i)) {
                    strikeCount += 1;
                    continue;
                }
                if(isBall(users.get(i), i)) {
                    ballCount += 1;
                }
            }

            //입력값에 대한 검증 로직
            if(ballCount == 0 && strikeCount == 0) { //낫싱 Case
                System.out.println(nothing);
                continue;
            }

            else if(strikeCount == 3) { //정답 Case
                System.out.println(answer);
                return true;
            }

            else if(ballCount == 0) {
                System.out.println(strikeCount + "스트라이크");
                continue;
            }

            else if(strikeCount == 0) {
                System.out.println(ballCount + "볼");
                continue;
            }

            System.out.println(ballCount + "볼 " + strikeCount + "스트라이크");
        }

    }

    //Strike 검사 로직
    private static boolean isStrike(int idx, int point) {

        int comNumber = computers.get(point);
        return idx == comNumber;
    }

    //Ball 검사 로직
    private static boolean isBall(int idx, int point) {

        return computers.contains(idx);
    }


}
