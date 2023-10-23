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


        // 게임 프로그램
        while(run) {



            // 숫자 야구 게임 숫자 만들기
            List<Integer> computer = new ArrayList<>();
            while (computer.size() < 3) {
                int randomNumber = Randoms.pickNumberInRange(1, 9);
                if (!computer.contains(randomNumber)) {
                    computer.add(randomNumber);
                }
            }

            while(true) {

                int ball = 0;
                int strike = 0;

                // 숫자 게임 입력 받기
                System.out.println(computer);
                System.out.print("숫자를 입력해주세요 : ");

                answer = Console.readLine();
                System.out.println(answer);
                // 사용자 숫자 받는 것 구분 필요
                if(answer.length() != 3){
                    throw new IllegalArgumentException("입력값은 3자리수만 됩니다.");
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
}
