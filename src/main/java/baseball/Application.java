package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        /**
         * 1~9로 이루어진 서로 다른 3자리 수 생성
         * computer 리스트에 3개의 수를 저장
         */
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            System.out.print(randomNumber);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        String gameStatus = "";
        while(!gameStatus.equals("2")) { // 게임이 끝난 후, 2를 입력받으면 종료
            /**
             * 사용자의 입력을 받기
             */
            System.out.print("숫자를 입력해주세요 : ");
            String user = Console.readLine();

            /**
             * computer가 정한 3개의 숫자와 user의 입력 숫자를 비교하기
             * 1. 스트라이크의 수를 센다.
             * 2. 볼의 수를 센다.
             */
            int strike = 0;
            int ball = 0;
            for(int i=0; i<3; i++) {
                for(int j=0; j<3; j++) {
                    boolean isSameNum = computer.get(i) + '0' == user.charAt(j);
                    if(i == j) { // 스트라이크의 개수 세기
                        if(isSameNum)
                            strike++;
                    }
                    else { // 볼의 개수 세기
                        if(isSameNum)
                            ball++;
                    }
                }
            }
        }
    }
}