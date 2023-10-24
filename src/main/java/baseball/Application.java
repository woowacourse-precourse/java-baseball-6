package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

//
public class Application {
        public static void main(String[] args) {
                // TODO: 프로그램 구현
                System.out.println("숫자 야구 게임을 시작합니다.");
                playGame();
        }


        //예외 처리
        public static void check(String user) throws IllegalArgumentException {
                boolean isNumeric = true;
                for (int i = 0; i < user.length(); i++) {
                        if (!Character.isDigit(user.charAt(i))) {
                                isNumeric = false;
                        }
                }
                if (user.length() != 3 || !isNumeric) {
                        throw new IllegalArgumentException("3자리 정수를 입력해주세요");
                }
        }
        //게임시작
        public static void playGame() {
                boolean continueGame = true;
                while (continueGame){
                        List<Integer> computer = computerNumber();
                        while (true) {
                                List<Integer> user = userNumber();
                                int strike = countStrike(computer, user);
                                int ball = countBall(computer, user);
                                String answer = answer(strike, ball);
                                System.out.println(answer);
                                if (strike == 3) {
                                        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                                        break;
                                }
                        }
                        continueGame = gameSet();

                }
        }
        // 컴퓨터 부분
        public static List<Integer> computerNumber() {
                List<Integer> computer = new ArrayList<>();
                while (computer.size() < 3) {
                        int randomNumber = Randoms.pickNumberInRange(1, 9);
                        if (!computer.contains(randomNumber)) {
                                computer.add(randomNumber);
                        }
                }

                return computer;
        }

        //입력 부분
        public static List<Integer> userNumber() {
                System.out.print("숫자를 입력해주세요 : ");
                List<Integer> user = new ArrayList<>();
                String input = Console.readLine();


                for (String number : input.split("")) {
                        user.add(Integer.parseInt(number));
                }
                check(input);
                return user;
        }

        //스트라이크
        public static int countStrike(List<Integer> computer, List<Integer> user) {
                int strike = 0;
                for (int i = 0; i < user.size(); i++) {
                        if (computer.get(i) == user.get(i)) {
                                strike++;
                        }
                }
                return strike;
        }

        //볼
        public static int countBall(List<Integer> computer, List<Integer> user) {
                int ball = 0;
                for (int i = 0; i < user.size(); i++) {
                        if (computer.contains(user.get(i)) && computer.get(i) != user.get(i)) {
                                ball++;
                        }
                }
                return ball;
        }

        //출력
        public static String answer(int strike, int ball) {
                if (strike == 0 && ball == 0) {
                        return "낫싱";
                } else if (strike == 0) {
                        return ball + "볼";
                } else if (ball == 0) {
                        return strike + "스트라이크";
                }
                return ball + "볼" + " "+strike + "스트라이크 ";
        }

        //게임 종료
        public static boolean gameSet() {

                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
                char answer = Console.readLine().charAt(0);
                if (answer == '2') {
                        System.out.print("게임 종료");
                        return false;
                }
                return true;
        }
}

