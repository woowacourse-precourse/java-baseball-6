package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        List<Integer> computer = generateRandom3Numbers();
        String gameStatus = "";
        while(!gameStatus.equals("2")) { // 게임이 끝난 후, 2를 입력받으면 종료

            /**
             * 게임 재시작시 새로운 3개의 숫자를 생성
             */
            if(gameStatus.equals("1")) {
                computer = generateRandom3Numbers();
                gameStatus = "";
            }

            /**
             * 사용자의 입력을 받기
             */
            System.out.print("숫자를 입력해주세요 : ");
            String user = Console.readLine();
            try {
                if(!(user.length() == 3 && 0 <=Integer.parseInt(user) && Integer.parseInt(user) <= 999)) {
                    throw new IllegalArgumentException();
                }
            } catch(RuntimeException e) {
                throw new IllegalArgumentException();
            }

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

            /**
             * 스트라이크와 볼의 개수에 따라 출력
             * 스트라이크 3개 -> 새로운 게임 및 종료
             */
            if(strike == 3) {
                System.out.println(strike + "스트라이크");
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                gameStatus = Console.readLine();
                continue;
            }

            if(strike != 0 && ball != 0) {
                System.out.println(ball + "볼" + " " + strike + "스트라이크");
            }
            else if(strike != 0) {
                System.out.println(strike + "스트라이크");
            }
            else if(ball != 0) {
                System.out.println(ball + "볼");
            }
            else {
                System.out.println("낫싱");
            }
        }
    }

    /**
     * 0~9로 이루어진 서로 다른 3자리 수 생성
     */
    private static List<Integer> generateRandom3Numbers() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }
}