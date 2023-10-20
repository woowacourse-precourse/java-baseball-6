package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        System.out.println("숫자 야구 게임을 시작합니다.");

        int continueGame = 1;
        // 켬퓨터 3자리 수
        while (continueGame == 1) {
            List<Integer> computer = new ArrayList<>();
            while (computer.size() < 3) {
                int randomNumber = Randoms.pickNumberInRange(1, 9);
                if (!computer.contains(randomNumber)) {
                    computer.add(randomNumber);
                }
            }

            while (continueGame != 2) {
                System.out.print("숫자를 입력해주세요 : ");

                String input = Console.readLine();
                int[] numList = {input.charAt(0) - '0', input.charAt(1) - '0', input.charAt(2) - '0'};

                // 입력값이 3자리이면서, 서로 다른 수이면서, 각 수가 0이 아닐 때
                if (input.length() == 3 && numList[0] != numList[1] && numList[1] != numList[2] && numList[0] != numList[2] && numList[0] != 0 && numList[1] != 0 && numList[2] != 0 ) {
                    int ballNum = 0;
                    int strikeNum = 0;

                    for (int i=0; i<3; i++) {
                        if (computer.contains(numList[i])) {
                            if (computer.get(i) == numList[i]) {
                                strikeNum++;
                            } else {
                                ballNum++;
                            }
                        }
                    }

                    if (ballNum == 0 && strikeNum == 0) {
                        System.out.println("낫싱");
                    } else if (strikeNum == 0) {
                        System.out.printf("%d볼 %n", ballNum);
                    } else if (ballNum == 0) {
                        System.out.printf("%d스트라이크 %n", strikeNum);
                        if (strikeNum == 3) {
                            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

                            String numInput = Console.readLine();
                            if (!numInput.equals("1") && !numInput.equals("2")) {
                                throw new IllegalArgumentException();
                            } else if (numInput.equals("2")) {
                                continueGame = 2;
                            }
                            break;
                        }
                    } else {
                        System.out.printf("%d볼 %d스트라이크 %n", ballNum, strikeNum);
                    }
                } else {
                    throw new IllegalArgumentException();
                }

            }
        }

    }
}
