package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        int eog = 0; // end of game 게임 종료
        int strike = 0;
        int ball = 0;

        // 게임 시작
        System.out.println("숫자 야구 게임을 시작합니다.");

        while(eog == 0){ // 게임 완전히 안 끝남.

            // 값 생성
            List<Integer> computer = valueHandler.createRandomVariable();

            while(strike != 3){

                // strike, ball 초기화
                strike = 0;
                ball = 0;

                System.out.print("숫자를 입력해주세요 : ");

                // user input이 담기는 장소
                int number = validCheck.isValidNumber();

                List<Integer> numberList = new ArrayList<>();
                ncgit umberList.add(number/100);
                numberList.add((number%100)/10);
                numberList.add(number%10);

                // ball strike 결과 받아오기
                ball = valueHandler.getBallValue(computer, numberList);
                strike = valueHandler.getStrikeValue(computer, numberList);

                // 결과 출력문 작성
                String result = genStr.getResult(strike, ball);

                System.out.println(result);
                // 정답의 경우?
                if(strike == 3){
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

                    // 콘솔에서 읽는 값.
                    String sfns = Console.readLine();

                    int fns = Integer.parseInt(sfns);

                    if(fns == 1)
                        eog = 0;
                    else if (fns == 2)
                        eog = 1;
                    else
                        throw new IllegalArgumentException("입력 범위를 넘어선 값입니다.");

                }
            }

            strike = 0;

        }
    }
}
