package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        TException te = new TException();
        List<Integer> usr = new ArrayList<>();
        List<Integer> computer = new ArrayList<>();
        int num;

        System.out.println("숫자 야구 게임을 시작합니다.");

        while(true) {

            while (computer.size() < 3) {
                int randomNumber = Randoms.pickNumberInRange(1, 9);
                if (!computer.contains(randomNumber)) {
                    computer.add(randomNumber);
                }
            }

            System.out.print("숫자를 입력해주세요 : ");
            try {
                num = Integer.parseInt(Console.readLine());
                if(num < 111 || num > 999){
                    te.shoot();
                }
                while(num > 0){
                    usr.add(0, num%10);
                    num /= 10;
                }
            }catch(NumberFormatException e) {
                te.shoot();
            }



            while(!chk(usr, computer)){
                usr.clear();
                System.out.print("숫자를 입력해주세요 : ");
                try {
                    num = Integer.parseInt(Console.readLine());
                    if(num < 111 || num > 999){
                        te.shoot();
                    }

                    while(num > 0){
                        usr.add(0, num%10);
                        num /= 10;
                    }
                }catch(NumberFormatException e){
                    te.shoot();
                }
            }

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            try {
                num = Integer.parseInt(Console.readLine());
                if(num == 1){
                    computer.clear();
                    usr.clear();
                }else if(num == 2){
                    break;
                }else{
                    te.shoot();
                }
            }catch(NumberFormatException e){
                te.shoot();
            }
        }


    }

    static boolean chk(List<Integer> usr, List<Integer> com){
        int strike = 0;
        int ball = 0;

        for(int i = 0; i<3; i++){
            if(com.contains(usr.get(i))){
                if(usr.get(i).equals(com.get(i))){
                    strike++;
                }else{
                    ball++;
                }
            }
        }

        if(strike == 3){
            System.out.println("3스트라이크\n" +
                    "3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        }else if(strike > 0) {
            if (ball > 0) {
                System.out.println(ball + "볼 " + strike + "스트라이크");
            } else {
                System.out.println(strike + "스트라이크");
            }
        }else{
            if(ball > 0){
                System.out.println(ball + "볼");
            }else{
                System.out.println("낫싱");
            }
        }
        return false;
    }
}

class TException{
    public void shoot() throws IllegalArgumentException{
        throw new IllegalArgumentException();
    }
}
