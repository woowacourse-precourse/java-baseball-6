package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {

    public static final String GAME_START = "숫자 야구 게임을 시작합니다.";
    public static final String INPUT_START = "숫자를 입력 해주세요 : ";
    public static final String GAME_FINISH = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    public static final String RESTART = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    public static final String NOTHING = "낫싱";
    public static final String STRIKE = "스트라이크";
    public static final String BALL = "볼";
    public static void main(String[] args) {

        Boolean restart = true;
        Boolean game = true;

        System.out.println(GAME_START);

        while (restart) {

            List<Integer> computer = new ArrayList<Integer>();
            while (computer.size() < 3) {
                int randomNumber = Randoms.pickNumberInRange(1, 9);
                if (!computer.contains(randomNumber)) {
                    computer.add(randomNumber);
                }
            }

            ArrayList<Integer> computerArray = new ArrayList<Integer>(computer);
            game = true;
            System.out.println("컴퓨터 입력" + computerArray);

            while (game) {
                System.out.print(INPUT_START);
                String inputNum = Console.readLine();


                int inputNumInt = Integer.parseInt(inputNum);

                int a = inputNumInt / 100;
                int b = inputNumInt / 10 % 10;
                int c = inputNumInt % 100 % 10;

                int strike = 0;
                int nothing = 0;

                ArrayList<Integer> userInputArray = new ArrayList<Integer>(Arrays.asList(a, b, c));


                for (int i = 0; i < 3; i++) {
                    if (!computerArray.contains(userInputArray.get(i))) {
                        // 숫자가 존재 하지 않으면 낫씽
                        nothing += 1;
                    } else if (computerArray.get(i) == userInputArray.get(i)) {
                        // 숫자가 존재하고 위치가 같으면 strike
                        strike += 1;
                    }
                }

                int ball = 3 - strike - nothing;

                if (nothing != 3) {
                    if (strike == 3) {
                        game = false;
                        System.out.println(strike + STRIKE);
                        System.out.println(GAME_FINISH);
                        System.out.println(RESTART);
                        String IsReGame = Console.readLine();
                        restart = (Integer.parseInt(IsReGame) == 1) ? true : false;
                    } else if (ball > 0 && strike == 0) {
                        System.out.println(ball + BALL);
                    } else if (ball == 0 && strike > 0) {
                        System.out.println(strike + STRIKE);
                    } else if (strike > 0 && ball > 0) {
                        System.out.println(ball + BALL + " " + strike + STRIKE);
                    }
                } else {
                    System.out.println(NOTHING);
                }
            }
        }
    }
        }
    }
}
