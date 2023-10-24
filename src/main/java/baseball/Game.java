package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Game {
    static List<Integer> computer = new ArrayList<>();
    static boolean end;
    static void compare(List<Integer> input, List<Integer> computer){
        int ball=0, strike=0;

        if(input.size() != 3){
            throw new IllegalArgumentException();
        }

        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(input.get(i) == computer.get(j)){
                    if(i==j) strike++;
                    else ball++;
                }
            }
        }
        if(ball == 0 && strike == 0) {
            System.out.println("낫싱");
        }else{
            if(ball > 0){
                System.out.printf("%d볼 ",ball);
            }
            if(strike > 0){
                System.out.printf("%d스트라이크",strike);
            }
            System.out.println();
        }
    }
    static void init(){
        end = false;
        computer.clear();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
    }
public void run(){
        init();
        System.out.println("숫자 야구 게임을 시작합니다.");
        while(true){
            if(end){
                System.out.println("게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                int choice = Integer.parseInt(Console.readLine());
                if(choice == 1){
                    init();
                }else if(choice == 2){
                    return;
                }else{
                    throw new IllegalArgumentException();
                }
            }
            System.out.printf("숫자를 입력해주세요 : ");
            String in = Console.readLine();
            List<Integer> input = new ArrayList<Integer>();
            for(int i=0;i<in.length();i++){
                Integer a = (int)in.charAt(i)-48;
                input.add(a);
            }

            compare(input,computer);
            if(input.equals(computer)){
                System.out.printf("3개의 숫자를 모두 맞히셨습니다! ");
                end = true;
            }
        }
    }
}
