package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");

        // 게임 시작과 종료
        boolean run = true;
        String answer;


        // 숫자 야구 게임 프로그램
        while(run) {

            // 컴퓨터 : 숫자 야구 게임 숫자 만들기
            List<Integer> computer = new ArrayList<>();
            while (computer.size() < 3) {
                int randomNumber = Randoms.pickNumberInRange(1, 9);
                if (!computer.contains(randomNumber)) {
                    computer.add(randomNumber);
                }
            }

            // 하나의 게임 진행
            while(true) {

                int ball = 0;       // 볼 수
                int strike = 0;     // 스트라이크 수

                // 숫자 게임 입력 받기
                // System.out.println(computer);
                System.out.print("숫자를 입력해주세요 : ");

                answer = Console.readLine();
                System.out.println(answer);

                // 입력값이 서로 다른 3자리의 숫자인지 판별
                if(!numberCheck(answer)){
                    throw new IllegalArgumentException("입력값은 서로 다른 3자리 수만 됩니다.");
                }

                // 결과 분석
                for(int i =0; i <3; i++){
                    // 스트라이크인 경우
                    int answer_value = answer.charAt(i) - '0';

                    if(answer_value == computer.get(i)){
                        strike++;
                    } else {
                        // 볼인 경우
                        for(int j=0; j<3; j++) {
                            if(answer_value == computer.get(j)){
                                ball++;
                            }
                        }
                    }
                }

                if(strike == 0) {
                    switch(ball){
                        case 0 :
                            System.out.println("낫싱");
                            break;
                        case 1 :
                            System.out.println("1볼");
                            break;
                        case 2 :
                            System.out.println("2볼");
                            break;
                        default:
                            System.out.println("3볼");
                            break;
                    }

                } else if(strike == 1) {
                    switch(ball){
                        case 0 :
                            System.out.println("1스트라이크");
                            break;
                        case 1 :
                            System.out.println("1볼 1스트라이크");
                            break;
                        default :
                            System.out.println("2볼 1스트라이크");
                            break;
                    }
                } else if(strike == 2) {
                    System.out.println("2스트라이크");
                } else {
                    System.out.println("3스트라이크");
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
                    answer = Console.readLine();
                    System.out.println(answer);
                    if(answer.equals("1")){
                        break;
                    } else if(answer.equals("2")){
                        run = false;
                        return;
                    }
                }



            } // 야구 한 게임 종료

        } // 게임 프로그램 종료


    }

    /**
     *  입력값이 서로 다른 3자리 숫자인 지 비교하는 메서드
     * */
    public static boolean numberCheck(String answer){

        // 3자리가 아닌 경우
        if(answer.length() != 3) {
            return false;
        }

        // 3자리인 경우
        for(int i=0; i < 3; i++) {
            char digit = answer.charAt(i);

            // 숫자가 아닌 경우
            if(!Character.isDigit(digit)) {
                return false;
            }

            // 숫자인 경우 각 자리수 비교
            for(int j = i+1 ; j < 3; j++) {
                // 같은 숫자가 존재할 경우
                if(digit == answer.charAt(j)){
                    return false;
                }
            }
        }
        return true;
    }
}
