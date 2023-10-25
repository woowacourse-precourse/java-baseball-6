package baseball.service;

import baseball.controller.BaseBallController;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Random;

public class BaseBallService {
    private static int cnt = 1;
    private ArrayList<Integer> createBase(int cnt){
        ArrayList<Integer> base = new ArrayList<>();

        if(cnt == 1){
            base.add(1);
            base.add(3);
            base.add(5);
        }else if(cnt == 2){
            base.add(5);
            base.add(8);
            base.add(9);
        }else {

            Random rand = new Random();
            while (base.size() < 3) {
                int n = rand.nextInt(1, 9);
                if (!base.contains(n))
                    base.add(n);
            }
        }
        return base;
    }

    private boolean check(ArrayList<Integer> num, ArrayList<Integer> base){
        int strike = 0;
        int ball = 0;

        for(int i = 0; i < 3; i++)
            if(num.contains(base.get(i))) ball++;

        for(int i = 0; i < 3; i++) {
            if (base.get(i) == num.get(i)) {
                ball--;
                strike++;
            }
        }

        StringBuilder sb = new StringBuilder();
        if(strike == 0 && ball == 0)
            sb.append("낫싱");
        else if(strike == 3 && ball == 0) {
            sb.append("3스트라이크").append("\n");
            sb.append("3개의 숫자를 모두 맞히셨습니다.! 게임 종료");

            System.out.println(sb);
            return true;
        }
        else
            sb.append(ball + "볼" + " " + strike + "스트라이크");

        System.out.println(sb);
        return false;
    }

    public void isVaildInput(String input, int type) {
        boolean isNotNumber = false;

        for (int i = 0; i < input.length(); i++){
            if (input.charAt(i) < '0' || input.charAt(i) > '9') {
                isNotNumber = true;
                break;
            }
        }

        if(type == 1) {
            if (input.length() != 3 || isNotNumber)
                throw new IllegalArgumentException("잘못된 입력입니다.");
        }
        else {
            if (input.length() != 1 || isNotNumber)
                throw new IllegalArgumentException("잘못된 입력입니다.");
        }
    }

    public void mainStream(){
        System.out.println("숫자 야구 게임을 시작합니다.");
        String input = "";

        ArrayList<Integer> base = createBase(cnt);
        boolean isFinish = false;

        while(true) {
            System.out.print("숫자를 입력해주세요 : ");

            input = Console.readLine();
            isVaildInput(input, 1);


            ArrayList<Integer> num = input
                    .chars()
                    .mapToObj(ch -> Character.getNumericValue(ch))
                    .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);

            boolean isALlStrike = check(num, base);

            if(isALlStrike){
                StringBuilder sb = new StringBuilder();
                sb.append("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.").append("\n");
                System.out.print(sb);

                input = Console.readLine();
                isVaildInput(input, 2);

                isFinish = (Integer.parseInt(input) == 2) ? true : false;

                if(isFinish)
                    break;

                cnt++;
                base = createBase(cnt);
            }
        }
    }
}
