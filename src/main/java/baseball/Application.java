package baseball;

import camp.nextstep.edu.missionutils.*;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");
        int ball=0;int strike=0;
        while(true) {
            List<Integer> computer = new ArrayList<>();
            while (computer.size() < 3) {
                int randomNumber = Randoms.pickNumberInRange(1, 9);
                if (!computer.contains(randomNumber)) {
                    computer.add(randomNumber);
                }
            }
            while (true) {
                ball = 0;
                strike = 0;
                System.out.print("숫자를 입력해주세요 : ");
                String sub = Console.readLine();
                if(sub.length()>3)
                    throw new IllegalArgumentException();
                for (int i = 0; i < 3; i++) {
                    int cur;
                    try {
                        cur = Integer.parseInt(sub.substring(i, i + 1));
                    }catch (NumberFormatException ex){
                        throw new IllegalArgumentException();
                    }
                    if (cur == computer.get(i)) {
                        strike++;
                    }else if (computer.contains(cur)) {
                        ball++;
                    }
                }
                if(ball!=0||strike!=0) {
                    String reply = "";
                    if(ball!=0)
                        reply=reply+ball+"볼 ";
                    if(strike!=0)
                        reply=reply+strike+"스트라이크";
                    System.out.println(reply);
                }
                else
                    System.out.println("낫싱");
                if (strike == 3) {
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료");
                    break;
                }
            }
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            int fin = Integer.parseInt(Console.readLine());
            if(fin==1)
                continue;
            else if(fin==2) {
                System.out.println("게임 종료");
                return;
            }
            else
                throw new IllegalArgumentException();
        }
    }
}
