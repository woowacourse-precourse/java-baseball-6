package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        List<Integer> computer = new ArrayList<>();
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        System.out.println("computer : " + computer);
        List<Integer> user = new ArrayList<>();
        while(true) {
            user.clear();
            System.out.print("숫자를 입력해주세요 : ");
            String[] numbers = Console.readLine().split("");
            for(int i=0;i<numbers.length;i++) {
                user.add(Integer.parseInt(numbers[i]));
            }
            int strike = 0;
            int ball = 0;
            for(int i=0;i<3;i++) {
                int idx = user.indexOf(computer.get(i));
                if(idx==i) {
                    strike+=1;
                }
                else if(idx!=-1) {
                    ball+=1;
                }
            }
            if(strike==0 && ball==0) {
                System.out.println("낫싱");
            }
            else {
            System.out.println(ball+"볼 "+strike+"스트라이크");
            }
            if(strike==3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                String userinput = Console.readLine();
                if(userinput.equals("1")) {
                    computer.clear();
                    while (computer.size() < 3) {
                        int randomNumber = Randoms.pickNumberInRange(1, 9);
                        if (!computer.contains(randomNumber)) {
                            computer.add(randomNumber);
                        }
                    }
                    System.out.println("computer : " + computer);
                }
                if(userinput.equals("2")) {
                    break;
                }
            }
        }
    }
}
