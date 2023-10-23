package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {
    static List<Integer> computer = new ArrayList<>();
    static boolean check_make_computer,strike_check,continue_check;
    static int[] user;
    static int input_num,cnt_strike,cnt_ball;
    static String answer,str_ball,str_strike;
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (true) {
            if(!check_make_computer){
                make_random_num();
                check_make_computer=true;
            }
            count_strike_ball();
            judge_strike_ball();
            if(continue_check){
                break;
            }
        }
    }

    public static void count_strike_ball(){
        // 3개의 숫자를 입력받는다.
        System.out.print("숫자를 입력해주세요 : ");
        input_num = Integer.parseInt(readLine());
        check_error();
        user = new int[3];
        cnt_strike = 0;
        cnt_ball = 0;
        user[0] = input_num / 100;
        user[1] = (input_num / 10) % 10;
        user[2] = input_num % 10;
        for (int i = 0; i < 3; i++) {
            if (user[i] == computer.get(i)) {
                cnt_strike++;
            } else {
                for (int j = 0; j < 3; j++) {
                    if (i != j && user[i] == computer.get(j)) {
                        cnt_ball++;
                    }
                }
            }
        }
    }

    public static void judge_strike_ball(){
        // 낫싱, 오직 볼, 오직 스트라이크, 볼&스트라이크, 정답
        answer = "";
        strike_check = false;
        if (cnt_strike == 0 && cnt_ball == 0) {
            answer += "낫싱";
        } else if (cnt_strike == 0 && cnt_ball > 0) {
            str_ball = String.valueOf(cnt_ball);
            answer += str_ball + "볼";
        } else if (cnt_strike > 0 && cnt_ball == 0) {
            str_strike = String.valueOf(cnt_strike);
            answer += str_strike + "스트라이크";
            if (cnt_strike == 3) {
                strike_check = true;
            }
        } else if (cnt_strike > 0 && cnt_ball > 0) {
            str_strike = String.valueOf(cnt_strike);
            str_ball = String.valueOf(cnt_ball);
            answer += str_ball + "볼 " + str_strike + "스트라이크";
        }
        System.out.println(answer);
        if (strike_check) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            check_make_computer=false;
            int continue_num = Integer.parseInt(readLine());
            if (continue_num == 2) {
                System.out.println("게임을 종료합니다.");
                continue_check=true;
            }
        }
    }


    public static void make_random_num() {
        computer.clear();
        // 우테코에서 제공하는 라이브러리 중 Randoms를 이용하여 컴퓨터에게 난수 제공
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
    }

    public static void check_error(){
        if(input_num >999 || input_num<111){
            throw new IllegalArgumentException("3자리 숫자를 입력해주세요.");
        }
    }
}