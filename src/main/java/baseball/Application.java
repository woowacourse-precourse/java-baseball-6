package baseball;
import baseball.domain.Computer;
import baseball.domain.Player;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        boolean isContinue = true;

        System.out.println("숫자 야구 게임을 시작합니다.");

        while (isContinue) {
            Computer computer = new Computer();
            computer.randComNumber();
            String comNumber = computer.getNumber();

            Player player = new Player();
            while (true) {
                System.out.print("숫자를 입력해주세요 : ");
                player.inputNumber();
                String playerNumber = player.getNumber();

                ArrayList<Integer> b_s = count_B_S(comNumber, playerNumber);
                int count_ball = b_s.get(0);
                int count_strike = b_s.get(1);

                String answer = "";
                if (count_ball == 0 && count_strike == 0) {
                    answer = "낫싱";
                }
                if (count_ball > 0) {
                    answer += count_ball + "볼 ";
                }
                if (count_strike > 0) {
                    answer += count_strike + "스트라이크";
                }
                System.out.println(answer);

                if (playerNumber.equals(comNumber)) {
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                    String input = Console.readLine();
                    if (input.equals("2")) /* ""없애보기*/ {
                        isContinue = false;
                        System.out.println("게임 종료");
                        break;
                    }else if(input.equals("1")){
                        computer.randComNumber();
                    }
                }
            }
        }
    }
    static ArrayList<Integer> count_B_S(String computer, String user){
        ArrayList<Integer> b_s = new ArrayList<>();
        int ball = 0;
        int strike = 0;
        String[] com = new String[3];
        String[] usr = new String[3];

        for(int i=0;i<3;i++){
            com[i] = computer.charAt(i)+"";
            usr[i] = user.charAt(i)+"";
        }

        for(int i=0;i<3;i++) {
            if (computer.contains(usr[i]) && !com[i].equals(usr[i]))
                ball++;
            if(com[i].equals(usr[i]))
                strike++;
        }
        b_s.add(ball);
        b_s.add(strike);
        return b_s;
    }
}
