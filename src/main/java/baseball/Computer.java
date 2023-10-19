package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;

public class Computer {

    private ArrayList<Integer> randomNums;

    public Computer() {
        this.randomNums = new ArrayList<>();

        while(this.randomNums.isEmpty() || this.randomNums.size() < 3) {
            int random_number = Randoms.pickNumberInRange(1, 9);
            if(!this.randomNums.contains(random_number)) this.randomNums.add(random_number);
        }
    }

    public boolean check_input(ArrayList<Integer> input) {
        int ball = this.count_ball(input);
        int strike = this.count_strike(input);

        if(ball != 0) {
            System.out.print(ball + "볼 ");
        }
        if(strike != 0) {
            System.out.println(strike + "스트라이크");
        }
        if(ball == 0 && strike == 0) {
            System.out.println("낫싱");
        }
        if(strike == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        }

        return false;
    }

    private int count_ball(ArrayList<Integer> input) {
        int balls = 0;
        for(int i = 0; i < 3; i++) {
            ArrayList<Integer> check_list = new ArrayList<>(this.randomNums);
            check_list.remove(this.randomNums.get(i));

            if(check_list.contains(input.get(i))) balls++;
        }

        return balls;
    }

    private int count_strike(ArrayList<Integer> input) {
        int strike = 0;
        for(int i = 0; i < 3; i++) {
            int check_num = this.randomNums.get(i);

            if(check_num == input.get(i)) strike++;
        }

        return strike;
    }
}