package baseball;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        baseball.Baseball_Game baseballGame = new baseball.Baseball_Game();

        baseballGame.Game();


    }

    class Baseball_Game {
        private String computer_nums;
        private String player_num;
        private int[] correct_number;

        void ComputerNum() {
            // 랜덤값 생성
            List<Integer> computer_nums = new ArrayList<>();
            while (computer_nums.size() < 3) {
                int randomNumber = Randoms.pickNumberInRange(1, 9);
                if (!computer_nums.contains(randomNumber)) {
                    computer_nums.add(randomNumber);
                }
            }
        }

        // 값 입력받기
        void Input_number(String[] args) {
            System.out.println("숫자 야구 게임을 시작합니다.");
            System.out.print("숫자를 입력해주세요: ");
            List<Integer> PlayerNum = new ArrayList<>();
            String input = Console.readLine();


            if (input.length() != 3 || input.contains("0")) {
                System.out.println("잘못된 값을 입력했습니다.");
                throw new IllegalArgumentException();
            }
        }


        void Play_game() {
            while (true) {
                for (int i = 0; i < 3; i++)
                    correct_number = new int[]{0, 0};

                int strike = 0, ball = 0, nothing = 0;

                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (computer_nums.charAt(i) == player_num.charAt(j) && i == j) {
                            strike++;
                        } else if (computer_nums.charAt(i) == player_num.charAt(j) && i != j) {
                            ball++;
                        } else if (computer_nums.charAt(i) != player_num.charAt(j)) {
                            System.out.println("낫싱");
                        }
                    }
                }

                if (strike == 3) {
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    break;
                } else {
                    strike = 0;
                    ball = 0;
                    nothing = 0;
                    System.out.println(strike + "스트라이크" + ball + "볼");
                }
            }
        }

        boolean restart() {
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                char answer = Console.readLine().charAt(0);
                if (answer == '1') {
                    System.out.println("게임을 다시 시작합니다.");
                    return true;
                }
                else {
                    return false;
                }
                }
            }
        }
