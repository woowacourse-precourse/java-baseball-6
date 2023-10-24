package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import static camp.nextstep.edu.missionutils.Console.readLine;


class Baseball{
    List<Integer> computer = new ArrayList<>();
    List<Boolean> check = new ArrayList<>(); //스트라이크일 경우 true 저장

    Baseball(){
        //Random 값 3개 저장

        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);

            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
                check.add(false);
            }
        }
    }

    public boolean isStrike(int num, int index){
        if (index == computer.indexOf(num) && num == computer.get(index)) {
            check.set(index,true);
            return true;
        } else {
            check.set(index,false);
            return false;
        }
    }
    public boolean isBall(int num){
        for (int i = 0; i < 3; i++) {
            if (num == computer.get(i))
                return true;
        }
        return false;
    }

    public boolean threeStrike(){
        for (boolean b : check){
            if(!b)
                return false;
        }
        return true;
    }
}
public class Application {
    public static void main(String[] args) throws IllegalArgumentException {
        Baseball computer = new Baseball(); //난수 값 3개를 가진 computer
        System.out.println("숫자 야구 게임을 시작합니다.");

        while(true){
            System.out.print("숫자를 입력해주세요 : ");
            String input = "";

            int strikeCount = 0;
            int ballCount = 0;

            //사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.
            try{
                input = readLine();

                runException(input);
                //strike, ball 판단
                for (int i = 0; i < input.length(); i++) {
                    /*if(input.charAt(i) < '0' || input.charAt(i) > '9' || input.length() !=3) {
                        throw new IllegalArgumentException();
                        //return;
                    }*/
                    int num = input.charAt(i) - '0';
                    if (computer.isStrike(num, i))
                        strikeCount++;
                    else if (computer.isBall(num))
                        ballCount++;
                }
            } catch (IllegalArgumentException e) {
                System.out.println("잘못된 값 입력" );
                return;
            }
            //결과 출력
            print(strikeCount,ballCount);

            //3스트라이크 한 경우 재시작/종료
            if(computer.threeStrike()){
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
                String j = readLine();
                if (j.equals("2"))
                    return;
                computer = new Baseball();  //새로운 난수 저장
            }
        }
    }
    static void print(int strike, int ball){
        if (strike == 0 && ball == 0)
            System.out.println("낫싱");
        else {
            if (ball != 0)
                System.out.print(ball + "볼 ");
            if(strike != 0)
                System.out.print(strike + "스트라이크");
            //else
            //  System.out.println(ball + "볼 " + strike + "스트라이크");
            System.out.println();
        }
    }
    static void runException(String num){
        for (int i = 0; i < num.length(); i++) {
            if (num.charAt(i) < '1' || num.charAt(i) > '9' || num.length() != 3) {
                throw new IllegalArgumentException();
            }
        }
    }
}
