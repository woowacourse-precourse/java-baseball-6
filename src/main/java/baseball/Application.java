package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Application {
    public static void main(String[] args) {
        // 게임 변수
        int strikeCount = 0, ballCount = 0;

        // 컴퓨터의 값, 게임 전체 반복
        while (true) {
            List<Integer> computer = new ArrayList<>();
            while (computer.size() < 3) {
                int randomNumber = Randoms.pickNumberInRange(1, 9);
                if (!computer.contains(randomNumber)) {
                    computer.add(randomNumber);
                }
            }
            System.out.println("숫자 야구 게임을 시작합니다.");
            //게임 시작
            while (true) {
                System.out.printf("숫자를 입력해주세요 : ");

                // 사용자의 입력값
                List<Integer> player = new ArrayList<>();
                int input = Integer.parseInt(readLine());
                int userFirstNum = input / 100;
                int userSecondNum = (input - 100*userFirstNum) / 10;
                int userThirdNum = input % 10;
                player.add(userFirstNum);
                player.add(userSecondNum);
                player.add(userThirdNum);

                //입력값이 잘못된 경우
                if (player.get(0) == player.get(1) || player.get(1) == player.get(2) ||
                    player.get(0) == player.get(2) || input < 100 || input > 999 ||
                    player.get(0) == 0 || player.get(1) == 0 || player.get(2) == 0 ) {
                    throw new IllegalArgumentException("잘못된 값이 입력되었습니다. 게임을 종료합니다.");
                }

                //스트라이크 카운트
                if (player.get(0) == computer.get(0)) strikeCount++;
                if (player.get(1) == computer.get(1)) strikeCount++;
                if (player.get(2) == computer.get(2)) strikeCount++;

                //볼 카운트
                if (player.get(0) == computer.get(1) || player.get(0) == computer.get(2)) ballCount++;
                if (player.get(1) == computer.get(0) || player.get(1) == computer.get(2)) ballCount++;
                if (player.get(2) == computer.get(0) || player.get(2) == computer.get(1)) ballCount++;

                if (strikeCount == 3) {
                    // 모든 숫자를 맞힌 경우
                    System.out.println("3스트라이크");
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    break;
                } else {
                    // 맞힌 숫자가 없는 경우
                    if (strikeCount == 0 && ballCount == 0) {
                        System.out.println("낫싱");
                    } else {
                        System.out.printf("%d볼 %d스트라이크 \n",
                                ballCount, strikeCount);
                    }
                    //스트라이크, 볼 카운트 초기화
                    strikeCount = 0;
                    ballCount = 0;
                }
            }
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            Scanner sc = new Scanner(System.in);
            String reGame = readLine();
            int reGameInt = Integer.parseInt(reGame);
            if (reGameInt == 1) {
                strikeCount = 0;
                ballCount = 0;
            } else if (reGameInt == 2) {
                System.out.println("숫자 야구 게임을 종료합니다.");
                return;
            } else {
                throw new IllegalArgumentException("잘못된 값이 입력되었습니다. 게임을 종료합니다.");
            }
        }
    }
}