package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        //컴퓨터가 임의의 수 3개 랜덤 선택
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        int strikeCount = 0;
        int ballCount = 0;
        while (strikeCount != 3) {
            //사용자 입력 처리
            System.out.print("숫자를 입력해주세요 : ");
            String str = Console.readLine();
            if (str.length() != 3) { //3자리의 수가 아닐 때
                throw new IllegalArgumentException();
            }

            //사용자가 숫자를 입력하지 않았을 경우, 예외 처리
            try {
                int input = Integer.parseInt(str);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException();
            }

            //서로 다른 수로 이루어진 수가 아닐 때
            List<Integer> user = new ArrayList<>();
            while (user.size() < 3) {
                int inputNumber = str.charAt(user.size()) - '0';
                if (!user.contains(inputNumber)) {
                    user.add(inputNumber);
                } else {
                    throw new IllegalArgumentException();
                }
            }

            //숫자 야구 판단 로직
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (user.get(i) == computer.get(j)) {
                        if (i == j) {
                            strikeCount++;
                        } else {
                            ballCount++;
                        }
                    }
                }
            }

            //게임 결과 출력
            if (ballCount == 0 && strikeCount == 0) {
                System.out.println("낫싱");
            } else if (strikeCount == 0) {
                System.out.println(ballCount + "볼");
            } else if (ballCount == 0) {
                System.out.println(strikeCount + "스트라이크");
            } else {
                System.out.printf("%d볼 %d스트라이크\n", ballCount, strikeCount);
            }

            //3개의 숫자를 모두 맞힌 경우
            if (strikeCount == 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                int replay = Integer.parseInt(Console.readLine());
                if (replay == 1) { //게임을 다시 시작할 경우
                    strikeCount = 0; //스트라이크 개수 초기화
                    //컴퓨터가 임의의 수 3개 랜덤 선택
                    computer = new ArrayList<>();
                    while (computer.size() < 3) {
                        int randomNumber = Randoms.pickNumberInRange(1, 9);
                        if (!computer.contains(randomNumber)) {
                            computer.add(randomNumber);
                        }
                    }
                }
            } else { //숫자를 맞히지 못했을 경우
                //스트라이크와 볼 개수 초기화
                strikeCount = 0;
                ballCount = 0;
            }
        }
    }
}
