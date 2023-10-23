package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
public class Application {
    public static void main(String[] args) {
        /**String input = Console.readLine();
        if(input.length() != 3){
            System.exit(0);
        }
        List<Integer> userNumberList = new ArrayList<Integer>();
        for(int i = 0; i < input.length(); i++){
            if(!('1' <= input.charAt(i) && input.charAt(i) <= '9') || userNumberList.contains((int) input.charAt(i))){
                System.exit(0);
            }
            else{
                userNumberList.add((int) input.charAt(i));
            }
        } */


        List<Integer> computer = new ArrayList<Integer>();
        while(computer.size() < 3){
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if(!computer.contains(randomNumber)){
                computer.add(randomNumber);
            }
        }
        System.out.println("숫자 야구 게임을 시작합니다.");
        while(true){
            System.out.println("숫자를 입력해주세요 : ");
            String input = Console.readLine();
            if(input.length() != 3){
                System.exit(0);
            }
            List<Integer> userNumberList = new ArrayList<Integer>();
            for(int i = 0; i < input.length(); i++){
                if(!('1' <= input.charAt(i) && input.charAt(i) <= '9') || userNumberList.contains((int) input.charAt(i))){
                    System.exit(0);
                }
                else{
                    userNumberList.add((int) (input.charAt(i) - '0'));
                }
            }

            int ball = 0;
            int strike = 0;
            for(int i = 0; i < userNumberList.size(); i++){
                int num = userNumberList.get(i);
                if(computer.contains(num)){
                    if(computer.indexOf(num) == i)
                        strike++;
                    else
                        ball++;
                }
            }
            if(ball == 0 && strike == 0){
                System.out.println("낫싱");
            }
            else if (ball != 0 && strike == 0) {
                System.out.println(Integer.toString(ball) + "볼");
            }
            else if (ball == 0 && strike != 0){
                System.out.println(Integer.toString(strike) + "스트라이크");
            }
            else{
                System.out.println(Integer.toString(ball) + "볼" + " " + Integer.toString(strike) + "스트라이크");
            }

            if(strike == 3){
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                String regame = Console.readLine();
                if(regame.equals("1")){
                    continue;
                } else if (regame.equals("2")) {
                    break;
                }
                else{ // 잘못 입력
                    break;
                }
            }
        }
    }
}
