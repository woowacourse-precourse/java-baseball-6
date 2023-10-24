package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Game {
    int ball;
    int strike;
    int status = 0;
    List<Integer> computer = new ArrayList<>();
    List<Integer> baseball = new ArrayList<>();

    public void recursion(int number, List<Integer> baseball) {
        if (number > 0) {
            recursion(number / 10, baseball);
            baseball.add(number % 10);
        }
    }

    public void random(){
        computer.clear();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
    }

    public void number(){
        baseball.clear();
        strike = 0;
        ball = 0;
        System.out.print("숫자를 입력해주세요 : ");
        String number = Console.readLine();
        int userNumber = Integer.parseInt(number);
        recursion(userNumber, baseball);
        if(baseball.size() != 3){
            throw new IllegalArgumentException();
        }
        else if(baseball.get(0).equals(baseball.get(1)) || baseball.get(1).equals(baseball.get(2))
                || baseball.get(0).equals(baseball.get(2))){
            throw new IllegalArgumentException();
        }
    }

    public void count(){
        for(int i = 0; i < computer.size(); i++){
            for(int j = 0; j< baseball.size(); j++){
                if(computer.get(i).equals(baseball.get(j))){
                    if(i == j)
                        strike++;
                    else if(i != j){
                        ball++;
                    }
                }
            }
        }
    }
    public void compare(){
        if(strike == 3){
            System.out.println(strike+"스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            while(true){
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                status = Integer.parseInt(Console.readLine());
                if(status == 2) {
                    break;
                }
                else if(status == 1){
                    break;
                }
                System.out.println("다시 입력하세요.");
            }
        }else if(ball == 0 && strike ==0){
            System.out.println("낫싱");
        }
        else if(ball == 0){
            System.out.println(strike+"스트라이크");
        }else if(strike == 0){
            System.out.println(ball+"볼");
        }else{
            System.out.println(ball+"볼 "+strike+"스트라이크");
        }
    }

    public void run(){
        while(true){
            random();
            do{
                number();
                count();
                compare();
            }while(strike<3);
            if(status == 2)
                break;
        }
    }
}
