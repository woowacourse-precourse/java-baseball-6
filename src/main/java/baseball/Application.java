package baseball;

import java.util.ArrayList;

public class Application {
    static int SIZE = 3;
    public static void main(String[] args) {
/*
        camp.nextstep.edu.missionutils에서 제공하는 Randoms 및 Console API를 사용하여 구현해야 한다.
        Random 값 추출은 camp.nextstep.edu.missionutils.Randoms의 pickNumberInRange()를 활용한다.
        사용자가 입력하는 값은 camp.nextstep.edu.missionutils.Console의 readLine()을 활용한다.
        */

        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");
        while(true){
            //1. 컴퓨터 답 : answer 변수에 저장
            ArrayList<Integer> answer = RandomNumbers.getRandomNumbers(SIZE);
            //System.out.println("정답:"+answer);

            while(true){
                //2. 사용자 입력 : userInput 변수에 저장
//              System.out.print(SIZE + "자리 숫자를 입력해주세요 :");
                System.out.print("숫자를 입력해주세요 : ");
                ArrayList<Integer> userInput = user.userInput(SIZE);
                //3. 스트라이크/볼/아웃 비교
                int[] result = new int[2];
                result = Judge.BallAndStrike(userInput, answer);
                Judge.printResult(result);
                if(Judge.correct(result)){
                    break;
                }
                else{
                    continue;
                }
        }
            if(Game.playOrNot()){
                break;
            };
        }

    }
}
