package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        boolean game = true;
        while (game) {
            //컴퓨터 숫자 생성
            List<Integer> computer = new ArrayList<>();
            while (computer.size() < 3) {
                int random = Randoms.pickNumberInRange(1, 9);
                if (!computer.contains(random)) {
                    computer.add(random);
                }
            }
            boolean progress = true;

            ArrayList<Integer> user = new ArrayList<>();
            System.out.println("숫자 야구 게임을 시작합니다.");
            while (progress) {
                System.out.printf("숫자를 입력하세요: ");
                //사용자로부터 입력받기 & 입력값 검증

                String input = Console.readLine();


                    if (input.length() != 3) {
                        throw new IllegalArgumentException();
                    }

                    for (int i = 0; i < input.length(); i++) {
                        int num = Character.getNumericValue(input.charAt(i));
                        if (num <= 0 || num > 9) { //getNumericValue는 숫자로 변환되지 않을 경우, 경우에 따라 -1 이나 2를 반환함
                            throw new IllegalArgumentException();

                        }
                        if (!user.contains(num)) {
                            user.add(num);
                        } else { //입력값이 서로 다른 3자리 수가 아님
                            throw new IllegalArgumentException();
                        }
                    }


                //숫자 비교
                int ball = 0;
                int strike = 0;
                int nothing = 0;
                for (int num : user) {
                    if (computer.contains(num)) {
                        if (computer.indexOf(num) == user.indexOf(num)) {
                            strike++;
                        } else {
                            ball++;
                        }
                    } else {
                        nothing++;
                    }
                }

                //결과 출력
                if (nothing == 3) {
                    System.out.println("낫싱");
                } else {
                    if (strike == 3) {
                        System.out.println("3스트라이크");
                        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                        System.out.println("게임으로 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                        progress = false;
                        String answer = Console.readLine();
                        if (answer.equals("1")) {
                            continue;
                        } else if (answer.equals("2")) {
                            game = false;
                        } else {
                            throw new IllegalArgumentException();
                        }

                    } else if (ball == 3) {
                        System.out.println("3볼");
                    } else if (ball != 0) {
                        if (strike != 0) {
                            System.out.printf("%d볼 %d스트라이크\n", ball, strike);
                        } else {
                            System.out.printf("%d볼\n", ball);
                        }
                    } else if (strike != 0) {
                        if (ball == 0) {
                            System.out.printf("%d스트라이크\n", strike);
                        }
                    }
                }
                user.clear();
            }

        }
    }


}
