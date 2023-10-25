package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static int strike;
    public static int ball;
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        List<Integer> computer = new ArrayList<>();
        int randomNumber;
        System.out.println("숫자 야구 게임을 시작합니다.");
        int order;

        while(true){
            strike=0;
            ball=0;
            order=0;
            while(computer.size()<3){
                randomNumber = Randoms.pickNumberInRange(1, 9);
                if (!computer.contains(randomNumber)) {
                    computer.add(randomNumber);
                }
            }
            while(true) {
                System.out.print("숫자를 입력해주세요 : ");
                int n = Integer.parseInt(Console.readLine());
                System.out.println();

                if(n>999){
                    throw new IllegalArgumentException();
                }

                int me[]=new int[3];
                for(int i=0;i<me.length;i++){
                    me[i]=n%10;
                    n/=10;
                }
                check(me,computer);

                if(strike==0 && ball==0) System.out.println("낫싱");
                else if(strike==0 && ball>0) System.out.println(ball+"볼");
                else if(strike>0 && ball>0) System.out.println(ball+"볼 "+strike+"스트라이크");
                else if(strike>0 && ball==0) {
                    System.out.println(strike+"스트라이크");
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");


                    if(order==1) break;
                    else if(order==2) break;
                }
            }
            if(order==2) break;
        }
    }
    public static void check(int me[],List<Integer>com){ //num:3자리 난수, n=1자리 난수(중복체크)
        for(int i=0;i< me.length;i++){
            if(me[i]==com.get(i)) {
                strike++;
                continue;
            }
            else{
                for(int j=0;j<i;j++){
                    if(me[i]==com.get(j)){
                        ball++;
                        break;
                    }
                }
            }
        }
    }
}