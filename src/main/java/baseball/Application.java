package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.*;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        String scanner;
        System.out.println("숫자 야구 게임을 시작합니다.");
        int num;
        List<Integer> computer;
        computer = getBall();
        //System.out.println(computer);

        while(true){
            int set;

            try {
                System.out.print("숫자를 입력하세요: ");
                scanner = Console.readLine();
                num = Integer.parseInt(scanner);
                if (num > 999) {
                    throw new IllegalArgumentException();
                }
            } catch (IllegalArgumentException e) {
                break;
            }

            set = checkBall(computer,num);
            if(set == 3){
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                String str = Console.readLine();
                if(str.equals("2")){
                    break;
                }
                else{
                    computer = getBall();
                }
            }

        }
    }

    // 볼, 스트라이크 갯수 확인
    public static int checkBall(List computer,int num){
        int idx[] = new int[3];
        idx[0] = num/100;
        idx[1] = (num%100)/10;
        idx[2] = num%10;

        int ball=0;
        int strike=0;

        for(int i=0; i<3; i++){
            if(computer.contains(idx[i])){
                if(computer.indexOf(idx[i])==i){
                    strike++;
                }
                else{
                    ball++;
                }
            }
        }

        if((ball != 0) || (strike !=0)){
            if(strike == 3){
                System.out.println("3스트라이크");
            }
            else if(ball==0){
                System.out.println(strike+"스트라이크");
            }
            else if(strike==0){
                System.out.println(ball+"볼");
            }
            else{
                System.out.println(ball+"볼 "+strike+"스트라이크");
            }
        }
        else{
            System.out.println("낫싱");
        }

        return strike;
    }

    // 새로운 숫자 만들기
    public static List getBall(){
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }
}
