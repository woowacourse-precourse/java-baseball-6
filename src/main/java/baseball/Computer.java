package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;

public class Computer {

    private ArrayList<Integer> random_numbers;
    private int ball;
    private int strike;

    public Computer() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        this.random_numbers = new ArrayList<>();

        while (this.random_numbers.isEmpty() || this.random_numbers.size() < 3) {
            int random_number = Randoms.pickNumberInRange(1, 9);
            if (!this.random_numbers.contains(random_number)) {
                this.random_numbers.add(random_number);
            }
        }

        this.ball = 0;
        this.strike = 0;
    }

    public boolean check_input(ArrayList<Integer> input) {
        this.count_ball(input);
        this.count_strike(input);

        if (this.ball == 0 && this.strike == 0) {
            System.out.println("낫싱");
        }
        if (this.strike == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        }

        return false;
    }

    private void count_ball(ArrayList<Integer> input) {
        this.ball = 0;
        for (int i = 0; i < 3; i++) {
            ArrayList<Integer> check_list = new ArrayList<>(this.random_numbers);
            check_list.remove(this.random_numbers.get(i));

            if (check_list.contains(input.get(i))) {
                this.ball++;
            }
        }

        if (this.ball != 0) {
            System.out.print(this.ball + "볼 ");
        }
    }

    private void count_strike(ArrayList<Integer> input) {
        this.strike = 0;
        for (int i = 0; i < 3; i++) {
            int check_num = this.random_numbers.get(i);

            if (check_num == input.get(i)) {
                this.strike++;
            }
        }

        if (this.strike != 0) {
            System.out.println(this.strike + "스트라이크");
        }
    }
}