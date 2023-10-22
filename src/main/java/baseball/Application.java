package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        StringBuilder sb;
        //사용자가 제시하는 숫자를 저장할 변수
        String user_guess_input;
        //게임이 끝난 후 사용자가 계속 게임을 할 지에 대한 변수
        int continue_game;


        System.out.println("숫자 야구 게임을 시작합니다.");

        while (true){
            List<Integer> computer = new ArrayList<>();
            List<Integer> user_guess = new ArrayList<>();


            while (computer.size() < 3) {
                int randomNumber = Randoms.pickNumberInRange(1, 9);
                if (!computer.contains(randomNumber)) {
                    computer.add(randomNumber);
                }
            }

            while (true) {
                int strike = 0;
                int ball = 0;
                sb = new StringBuilder();
                user_guess = new ArrayList<>();
                user_guess_input = readLine();

                for (char c : user_guess_input.toCharArray()) {

                    user_guess.add(Integer.parseInt(String.valueOf(c)));
                }

                for (int i = 0; i < computer.size(); i++) {

                    int now_com_num = computer.get(i);
                    int now_com_index = i;

                    for (int j = 0; j < user_guess.size(); j++) {

                        int now_user_num = user_guess.get(j);
                        int now_user_index = j;

                        if ((now_com_index == now_user_index) && (now_com_num == now_user_num)) {

                            strike++;
                        } else if (now_com_num == now_user_num) {

                            ball++;
                        }

                    }
                }
                if (strike == 3) {
                    sb.append(strike).append("스트라이크\n");
                    sb.append("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    System.out.println(sb);
                    break;
                }

                if (strike > 0 && ball > 0) {
                    sb.append(strike).append("스트라이크 ").append(ball).append("볼");
                } else if (strike > 0) {
                    sb.append(strike).append("스트라이크");
                } else if (ball > 0) {
                    sb.append(ball).append("볼");
                } else sb.append("낫싱");
                System.out.println(sb);
            }

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            continue_game = Integer.parseInt(readLine());

            if (continue_game == 1) continue;
            if(continue_game == 2) break;
        }
    }
}
