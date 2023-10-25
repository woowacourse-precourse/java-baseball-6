package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {

    private static final int number_length = 3;

    public static void main(String[] args) {
        play_game();
    }

    /*
        public static void play_game() {
            System.out.println("숫자 야구 게임을 시작합니다.");
            boolean play_ing = true;

            while (play_ing) {
                int computer_number = generate_random_number();
                boolean finished_game = false;

                while (!finished_game) {
                    int user_number = check_user_input();
                    int[] counting_ball_strike = count_ball_strike(computer_number, user_number);
                    String message = result_message(counting_ball_strike);
                    System.out.println(message);

                    if (counting_ball_strike[0] == 3) {
                        finished_game = true;
                    }
                }

                System.out.println("3 스트라이크! 게임 종료!");
                System.out.println("새 게임을 시작하려면 1, 종료하려면 2를 입력하세요.");
                String user_answer = Console.readLine();

                if (user_answer.equals("2")) {
                    play_ing = false;
                    System.out.println("게임이 완전히 종료되었습니다.");
                }
            }
        }
    */

    public static void play_game() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        boolean play_ing = true;

        while (play_ing) {
            int computerNumber = generate_random_number();
            boolean finished_game = one_set(computerNumber);

            if (finished_game) {
                play_ing = ask_play_continue();
            }
        }
    }

    public static boolean one_set(int computer_number) {
        boolean finished_game = false;

        while (!finished_game) {
            int user_number = check_user_input();
            int[] counting_ball_strike = count_ball_strike(computer_number, user_number);
            String message = result_message(counting_ball_strike);
            System.out.println(message);

            if (counting_ball_strike[0] == number_length) {
                finished_game = true;
            }
        }

        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        return finished_game;
    }

    public static boolean ask_play_continue() {
        while (true) {
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String user_answer = Console.readLine();

            if (user_answer.equals("2")) {
                System.out.println("게임이 완전히 종료되었습니다.");
                return false;
            } else if (user_answer.equals("1")) {
                return true;
            } else {
                throw new IllegalArgumentException();
            }
        }
    }

    public static int generate_random_number() {
        List<Integer> computer_number_list = new ArrayList<>();
        while (computer_number_list.size() < number_length) {
            int random_number = Randoms.pickNumberInRange(1, 9);
            if (!computer_number_list.contains(random_number)) {
                computer_number_list.add(random_number);
            }
        }
        StringBuilder string_builder = new StringBuilder();
        for (Integer number : computer_number_list) {
            string_builder.append(number);
        }
        int computer_number = Integer.parseInt(string_builder.toString());
        return computer_number;
    }

    public static int check_user_input() {
        System.out.print("숫자를 입력해주세요 : ");
        String user_number = Console.readLine();

        if (!number_or_not(user_number)) {
            throw new IllegalArgumentException();
        }

        if (user_number.length() != number_length) {
            throw new IllegalArgumentException();
        }

        char[] user_input_list = user_number.toCharArray();
        if (user_input_list[0] == user_input_list[1]
                || user_input_list[1] == user_input_list[2]
                || user_input_list[2] == user_input_list[0]) {
            throw new IllegalArgumentException();
        }
        return Integer.parseInt(user_number);
    }

    public static boolean number_or_not(String user_number) {
        return user_number.matches("\\d+");
    }

    public static int[] count_ball_strike(int computer_number, int user_number) {
        String computer_number_string = String.valueOf(computer_number);
        String user_number_string = String.valueOf(user_number);

        int strike = 0;
        int ball = 0;

        for (int i = 0; i < 3; i++) {
            if (computer_number_string.charAt(i) == user_number_string.charAt(i)) {
                strike++;
            } else if (computer_number_string.contains(String.valueOf(user_number_string.charAt(i)))) {
                ball++;
            }
        }

        int[] result = {strike, ball};
        return result;
    }

    public static String result_message(int[] count) {
        int strike = count[0];
        int ball = count[1];

        if (strike > 0 && ball > 0) {
            return ball + "볼" + " " + strike + "스트라이크";
        } else if (strike > 0) {
            return strike + "스트라이크";
        } else if (ball > 0) {
            return ball + "볼";
        } else {
            return "낫싱";
        }
    }

    /*
    public static boolean ask_play_continue() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요. : ");
        String user_answer = Console.readLine();

        if (user_answer.equals("1")) {
            return true;
        } else if (user_answer.equals("2")) {
            System.out.println("게임이 완전히 종료되었습니다.");
            return false;
        } else {
            throw new IllegalArgumentException("1 또는 2를 바르게 입력해주세요.");
        }
    }

    public static boolean three_strike(int[] count) {
        if (count[0] == 3) {
            System.out.println("3 스트라이크! 게임 종료!");
            return ask_play_continue();
        }
        return true;
    }

     */
}
