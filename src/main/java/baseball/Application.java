package baseball;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        boolean isContinue = true;

        System.out.println("숫자 야구 게임을 시작합니다.");

        while (isContinue) {
            String computer = "";

            while(computer.length()!=3){
                int n = Randoms.pickNumberInRange(1,9);
                if(!computer.contains(String.valueOf(n))){
                    computer += n;
                }
            }
            String user = null;

            while (true) {
                System.out.print("숫자를 입력해주세요 : ");
                try {
                    user = Console.readLine();
                    int num = Integer.parseInt(user);
                    if(user==null || num<123 || num>987) throw new IllegalArgumentException();
                }catch (IllegalArgumentException illegalArgumentException){
                    illegalArgumentException = new IllegalArgumentException("잘못 입력 게임 종료");
                    throw illegalArgumentException;
                }


                ArrayList<Integer> b_s = count_B_S(computer, user);
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

                if (user.equals(computer)) {
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                    String input = Console.readLine();
                    if (input.equals("2")) /* ""없애보기*/ {
                        isContinue = false;
                        System.out.println("게임 종료");
                        break;
                    }else if(input.equals("1")){
                        computer = "";
                        for (int i = 0; i < 3; i++) {
                            int n = Randoms.pickNumberInRange(1, 9);
                            computer += n;
                        }
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
