package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        while(true){

            System.out.println("숫자 야구 게임을 시작합니다.");
            List<Integer> computer = new ArrayList<>();
            while (computer.size() < 3) {               // 임의의 컴퓨터 숫자 입력
                int randomNumber = Randoms.pickNumberInRange(1, 9);
                if (!computer.contains(randomNumber)) {
                    computer.add(randomNumber);
                }
            }


            while(true){

                System.out.print("숫자를 입력해주세요 : ");
                try {
                    int num = Integer.parseInt(Console.readLine());

                    if((int) (Math.log10(num)+1) != 3)    // 숫자가 3개 입력이 맞는지 확인
                        throw new IllegalArgumentException("숫자는 3개여야 합니다.");

                    List<Integer> inputNum = new ArrayList<>();
                    inputNum.add(num / 100);              // 1번째 자리 입력
                    inputNum.add((num % 100) / 10);       // 2번째 자리 입력
                    inputNum.add(num % 10);               // 3번째 자리 입력


                    for (int i = 0; i < 3; i++) {
                        for (int j = i+1; j < 3; j++) {

                            if(inputNum.get(i).equals(0)){             // 0 입력시 예외 발생
                                throw new IllegalArgumentException("숫자는 1 ~ 9 사이여야 합니다.");
                            }

                            if (inputNum.get(i).equals(inputNum.get(j))) {     // 중복 검사
                                throw new IllegalArgumentException("입력값 중 중복된 숫자가 있습니다.");
                            }
                        }
                    }
                    int strike =0, ball = 0;    // 스트라이크, 볼 개수 변수 선언

                    for(int i = 0; i < 3; i++){
                        if (computer.get(i) == inputNum.get(i)){
                            strike++;
                        }
                        else{
                            if(computer.contains(inputNum.get(i))){
                                ball++;
                            }
                        }
                    }

                    if(ball != 0){                 // 출력
                        if(strike != 0){
                            System.out.println(ball + "볼 " + strike + "스트라이크");
                        }
                        else{
                            System.out.println(ball + "볼");
                        }
                    }
                    else{
                        if(strike !=0){
                            System.out.println(strike + "스트라이크");
                        }
                        else{
                            System.out.println("낫싱");
                        }
                    }

                    if(strike ==3){
                        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                        int input = Integer.parseInt(Console.readLine());
                        if(input==1){
                            break;
                        }
                        if(input==2){
                            return;
                        }
                    }


                }catch (Exception e) {   // 문자 입력 시
                    throw new IllegalArgumentException("잘못된 값을 입력하였습니다.");
                }
            }


        }

    }
}
