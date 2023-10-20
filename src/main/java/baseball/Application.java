package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.*;
public class Application {
    public static void main(String[] args){
        System.out.println("숫자 야구 게임을 시작합니다.");

        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        while (true){
            int strike = 0;
            int ball = 0;
            List<Integer> overlap = new ArrayList<>();
            System.out.print("숫자를 입력해주세요 : ");
            String str = Console.readLine();
            if(str.length()!=3){
                throw new IllegalArgumentException("Invalid argument: "+str);
            }
            for(int i=0; i<3; i++){
                int num = (int) str.charAt(i)-'0';
                if (num> 9 || num < 1 || overlap.contains(num)){
                    throw new IllegalArgumentException("Invalid argument: "+str);
                }
                overlap.add(num);
                if (computer.get(i) == num){
                    strike++;
                } else if (computer.contains(num)) {
                    ball++;
                }
            }
            if (strike == 0 && ball == 0){
                System.out.println("낫싱");
            } else if (strike == 3) {
                System.out.println("3스트라이크");
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                String choose = Console.readLine();
                if (choose.equals("1")) {
                    computer.clear();
                    while (computer.size() < 3) {
                        int randomNumber = Randoms.pickNumberInRange(1, 9);
                        if (!computer.contains(randomNumber)) {
                            computer.add(randomNumber);
                        }
                    }
                } else if(choose.equals("2")){
                    break;
                }else {
                    throw new IllegalArgumentException("Invalid argument: "+str);
                }
            } else if (strike == 0) {
                System.out.printf("%d볼\n",ball);
            } else if (ball == 0) {
                System.out.printf("%d스트라이크\n",strike);
            } else {
                System.out.printf("%d볼 %d스트라이크\n",ball,strike);
            }
        }
    }
}