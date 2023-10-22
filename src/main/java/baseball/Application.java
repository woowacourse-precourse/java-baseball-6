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
        }
    }
}