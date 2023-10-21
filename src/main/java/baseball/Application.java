package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구게임을 시작합니다.");

        // 1. 컴퓨터
        List<Integer> computer = new ArrayList<>();
        while(computer.size() < 3){
            int computerNumber = Randoms.pickNumberInRange(1,9);
            if(!computer.contains(computerNumber)){
                computer.add(computerNumber);
            }
        }

        // 2. 플레이어
        while(true) {
            List<Integer> player = new ArrayList<>();
            System.out.print("숫자를 입력해주세요 : ");
            String playerNumber = Console.readLine();
            if (playerNumber.length() != 3 || Integer.parseInt(playerNumber) < 0) {
                throw new IllegalArgumentException("잘못된 입력입니다.");
            }
            for (int i = 0; i < 3; i++) {
                int eachNumber = playerNumber.charAt(i) - '0';
                if (eachNumber == 0) {
                    throw new IllegalArgumentException("0을 포함할 수 없음");
                }
                if (!player.contains(eachNumber)) {
                    player.add(eachNumber);
                }
            }
            if (player.size() != 3) {
                throw new IllegalArgumentException("잘못된 입력입니다.");
            }
            // 3. 점수판별
            int ball = 0;
            int strike = 0;

            for (int i = 0; i < 3; i++) {
                if (computer.get(i) == player.get(i)) {
                    strike++;
                }
                if ((computer.get(i) != player.get(i)) && computer.contains(player.get(i))) {
                    ball++;
                }
            }
            if (ball != 0) {
                System.out.print(ball + "볼 ");
            }
            if (strike != 0) {
                System.out.print(strike + "스트라이크");
            }
            if (ball == 0 && strike == 0) {
                System.out.print("낫싱");
            }
            System.out.println();
            // 4. 종료
            if (strike == 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            } else {
                continue;
            }
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            if (Console.readLine().equals("1")) {
                computer.clear();
                while(computer.size() < 3){
                    int computerNumber = Randoms.pickNumberInRange(1,9);
                    if(!computer.contains(computerNumber)){
                        computer.add(computerNumber);
                    }
                }
            }
            if (Console.readLine().equals("2")) {
                break;
            }
            if (!Console.readLine().equals("1") && !Console.readLine().equals("2")){
                throw new IllegalArgumentException("잘못된 입력입니다.");
            }
        }
    }
}
