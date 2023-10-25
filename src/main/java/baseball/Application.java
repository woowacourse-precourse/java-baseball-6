package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import jdk.jshell.spi.ExecutionControl;

import java.util.ArrayList;
import java.util.LinkedList;

public class Application {
    public static void main(String[] args) {

        int finish = 0;

        while (finish == 0) {
            System.out.println("숫자 야구 게임을 시작합니다.");
            game();
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            finish= Integer.valueOf(Console.readLine());
            if(finish == 2) return;
            else if(finish==1) {finish=0; continue;}
            else throw new IllegalArgumentException();
        }

    }


    public static void game() {
        ArrayList<Integer> comNum = new ArrayList<Integer>();
        LinkedList<Integer> ans = new LinkedList<Integer>();
        int userNum = 0;
        int right = 0;
        for (int i = 0; i < 3; i++) {
            comNum.add(Randoms.pickNumberInRange(1, 9));
        }
        while (right == 0) {
            System.out.print("숫자를 입력해주세요 : ");
            userNum = Integer.valueOf(Console.readLine());
            if (!(userNum > 100 && userNum < 999)) {
                throw new IllegalArgumentException();
            }
            ans.add(userNum / 100);
            ans.add((userNum) / 10 - ans.get(0) * 10);
            ans.add((userNum) - ans.get(0) * 100 - ans.get(1) * 10);
            int n = ok(comNum,ans);
            if(n==1){
                ans.clear();
                comNum.clear();
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;

            }
            ans.clear();
        }
        comNum.clear();
    }

    public static int ok(ArrayList<Integer> comNum, LinkedList<Integer> ans) {
        int strike=0,ball=0,nothing=0;
        for (int i = 0; i < ans.size(); i++) {
            for (int j = 0; j < ans.size(); j++) {
                if (ans.get(i) == comNum.get(j))
                    if (i == j) {
                        strike++;
                    }else ball++;
                else {
                    nothing++;
                }
            }
        }
        if(ball!=0) System.out.print(ball+"볼 ");
        if(strike!=0) System.out.print(strike+"스트라이크 ");
        if(nothing==9) System.out.print("낫싱");

        if(strike==3) return 1;
        else return 0;
    }
}