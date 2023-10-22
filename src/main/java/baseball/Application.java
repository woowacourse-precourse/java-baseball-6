package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Application {

    static HashSet<Integer> set;
    static boolean correct;
    static int game;

    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        startGame();
    }

    private static void startGame() {
        game = 1;

        while (game == 1) {
            String nums = generateNumber();
            correct = false;
            while (true) {
                System.out.print("숫자를 입력해주세요 : ");
                String guess = Console.readLine();
                checkNumberLength(guess);
                checkSameNumber(guess);
                try {
                    Integer.parseInt(guess);
                } catch (Exception e) {
                    throw new IllegalArgumentException("잘못된 입력값입니다. 프로그램을 종료합니다.");
                }

                String ans = check(nums, guess);
                System.out.println(ans);
                if (correct) {
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    break;
                }
            }
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

            try {
                game = Integer.parseInt(Console.readLine());
            } catch (Exception e) {
                throw new IllegalArgumentException("잘못된 입력값입니다. 프로그램을 종료합니다.");
            }
        }
    }

    private static void checkNumberLength(String guess) {
        if (guess.length() != 3) {
            throw new IllegalArgumentException("3자리만 입력해주세요. 프로그램을 종료합니다.");
        }
    }

    private static void checkSameNumber(String guess) {
        HashSet<Integer> check = new HashSet<>();
        for (int i = 0; i < 3; i++) {
            int num = guess.charAt(i) - '0';
            if (check.contains(num)) {
                throw new IllegalArgumentException("중복된 숫자를 입력하셨습니다. 프로그램을 종료합니다.");
            }
            check.add(num);
        }
    }

    private static String check(String nums, String guess) {
        int strike = 0;
        for (int i = 0; i < 3; i++) {
            if (nums.charAt(i) == guess.charAt(i)) {
                strike++;
            }
        }
        int ball = 0;
        for (int i = 0; i < 3; i++) {
            if (set.contains(guess.charAt(i) - '0')) {
                ball++;
            }
        }
        ball -= strike;

        if (strike == 0 && ball == 0) {
            return "낫싱";
        } else if (ball == 0) {
            if (strike == 3) {
                correct = true;
            }
            return strike + "스트라이크";
        } else if (strike == 0) {
            return ball + "볼";
        } else {
            return ball + "볼 " + strike + "스트라이크";
        }
    }

    private static String generateNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return toString(computer);
    }

    private static String toString(List<Integer> list) {
        StringBuilder sb = new StringBuilder();
        set = new HashSet<>();
        for (int num : list) {
            sb.append(num);
            set.add(num);
        }
        return sb.toString();
    }
}
