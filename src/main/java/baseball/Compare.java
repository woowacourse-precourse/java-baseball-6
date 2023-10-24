package baseball;

import java.util.List;

public class Compare {

    public void isSame() {
        Computer computer = new Computer();
        User user = new User();
        List<Integer> computerNum = computer.getComputerNum();
        int strikes = 0, balls = 0;
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (strikes < 3) {
            List<Integer> userNum = user.getUserNum();
            strikes = 0;
            balls = 0;
            for (int i = 0; i < 3; i++) {
                if (computerNum.get(i) == userNum.get(i)) {
                    strikes++;
                } else {
                    for (int j = 0; j < 3; j++) {
                        if (userNum.get(i) == computerNum.get(j)) {
                            balls++;
                        }
                    }
                }
            }

            if (strikes == 3) {
                System.out.println(strikes + "스트라이크");
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                return; // 게임 종료
            } else if (strikes > 0 || balls > 0) {
                System.out.println(balls + "볼 " + strikes + "스트라이크 ");
            } else {
                System.out.println("낫싱");
            }

        }
    }
}
