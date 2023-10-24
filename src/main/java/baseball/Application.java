package baseball;

import java.util.List;


public class Application {
    static RandomNum rn = new RandomNum();
    static List<Integer> nums = rn.randomNum();
    public static void main(String[] args) {
        InputNum in = new InputNum();

        System.out.println("숫자 야구 게임을 시작합니다.");

        while (true) {
            nums = rn.randomNum();
            while (true) {
                System.out.print("숫자를 입력해주세요 : ");
                String inputNum = in.getInputNum();

                if (ballCount(inputNum)) {
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    break;
                }
            }
        }
    }

    //플레이
    static boolean ballCount(String inputNum) {
        int strike = 0;
        int ball = 0;

        for (int i = 0; i < 3; i++) {
            if (inputNum.charAt(i) - '0' == nums.get(i)) {
                strike += 1;
            } else if (nums.contains(inputNum.charAt(i) - '0')) {
                ball += 1;
            }
        }
        if (ball != 0) {
            System.out.print(ball + "볼 ");
            System.out.println(nums);
        }
        if (strike != 0) {
            System.out.print(strike + "스트라이크");
            System.out.println(nums);
        }
        if (ball == 0 && strike == 0) {
            System.out.print("낫싱");
            System.out.println(nums);
        }
        System.out.println();

        if (strike == 3) {
            return true;
        }
        return false;
    }

}
