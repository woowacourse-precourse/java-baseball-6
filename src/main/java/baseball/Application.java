package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {

        int eog = 0; // end of game 게임 종료
        int strike = 0; // strike 횟수 체크
        int ball = 0; // ball 횟수 체크

        // 게임 시작
        System.out.println("숫자 야구 게임을 시작합니다.");

        while(eog == 0){ // 게임 완전히 안 끝남.

            // 랜덤 값 생성
            List<Integer> computer = valueHandler.createRandomVariable();

            while(strike != 3){

                // 이전 strike, ball 값 초기화
                strike = 0; ball = 0;

                System.out.print("숫자를 입력해주세요 : ");

                // user input이 담기는 장소
                int userInput = validCheck.isValidNumber();
                List<Integer> numberList = valueHandler.createUserVariable(userInput);

                // ball strike 결과 받아오기
                ball = valueHandler.getBallValue(computer, numberList);
                strike = valueHandler.getStrikeValue(computer, numberList);

                // 결과 출력문 작성
                // 볼, 스트라이크, 볼 스트라이크, 낫싱
                String result = genStr.getResult(strike, ball);
                System.out.println(result);

                // 정답의 경우?
                if(strike == 3){
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                    eog = valueHandler.endValueCheck();
                }
            }
            strike = 0;
        }
    }
}
