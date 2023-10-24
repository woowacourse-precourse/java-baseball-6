package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");
        int execInput = 1;
        while (execInput == 1){
            int[] computerNumber = {
                    Randoms.pickNumberInRange(1, 9),
                    Randoms.pickNumberInRange(1, 9),
                    Randoms.pickNumberInRange(1, 9)
            };

            while(true) {
                System.out.print("숫자를 입력해주세요 : ");
                String userNumber = Console.readLine();
                if (userNumber.length() != 3) {
                    throw new IllegalArgumentException("세 자리 숫자를 입력해주세요.");
                }
                for (int i = 0; i < 3; i++) {
                    if (userNumber.charAt(i) > '0' && userNumber.charAt(i) <= '9') {
                        continue;
                    } else {
                        throw new IllegalArgumentException("모두 숫자를 입력해주세요.");
                    }
                }
                int[] cnt = {0, 0, 0};

                // 스트라이크
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (userNumber.charAt(i) - '0' == computerNumber[j]) {
                            if (i == j) {
                                cnt[0] += 1;
                            } else {
                                cnt[1] += 1;
                            }
                        }
                    }
                }



            }


            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            execInput = Integer.parseInt(Console.readLine());

            if (!(execInput == 1 || execInput == 2)){
                throw new IllegalArgumentException("1 또는 2 중에서 입력해주세요.");
            }

        }
    }
}
