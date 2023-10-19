package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");
        try{
            while(true){
                List<Integer> computer = new ArrayList<>();
                while (computer.size() < 3) {
                    int randomNumber = Randoms.pickNumberInRange(1, 9);
                    if (!computer.contains(randomNumber)) {
                        computer.add(randomNumber);
                    }
                }
                while(true){
                    System.out.print("숫자를 입력해주세요 :");
                    String input = Console.readLine();
                    if(isNumber(computer, input) == 3){
                        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                        break;
                    }
                }
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                int s = Integer.parseInt(Console.readLine());
                if(s == 1) continue;
                else if(s == 2) break;
            }
        }catch(IllegalArgumentException e) {
            System.out.println(e.toString());
        }
    }
    static int isNumber(List<Integer> computer, String input) throws IllegalArgumentException{
        if(input.length() > 3) throw new IllegalArgumentException("입력된 값이 3개보다 많습니다. : "+input);
        if(input.length() < 3) throw new IllegalArgumentException("입력된 값이 3개보다 적습니다. : "+input);
        for(int i=0;i<input.length();i++){
            if(input.charAt(i) < '0' || input.charAt(i) > '9') throw new IllegalArgumentException("입력된 값이 숫자가 아닙니다. : "+input);
        }
        int number = Integer.parseInt(input);
        int strike = 0, ball = 0;
        Integer[] list = {number/100, number%100/10, number%10};
        for(int i = 0;i<computer.size();i++){
            for(int j=0;j<list.length;j++){
                if(computer.get(i).equals(list[j])){
                    if(i == j) strike++;
                    else ball++;
                }
            }
        }
        if(ball != 0) System.out.print(ball+"볼 ");
        if(strike != 0) System.out.println(strike+"스트라이크");
        if(ball == 0 && strike == 0) System.out.println("낫싱");
        System.out.println();
        return strike;
    }
}
