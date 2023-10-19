package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashMap;

enum Status {
    START, EXIT, CONTINUE, DONE
}

class game {

    private static final int NUM_LENGTH = 3;
    private static Status user_status;
    private static String user_num;
    private static String com_num;

    public static void run() {
        init_status();
        while (check_status(user_status)) {
            input_num();
            check_input();
            print_result(play_game());
            end_routine();
        }
    }

    private static void init_status() {
        user_status = Status.START;
    }

    private static void print_result(String result) {
        final int nothing = result.charAt(0) - '0';
        final int ball = result.charAt(1) - '0';
        final int strike = result.charAt(2) - '0';
        if (nothing == NUM_LENGTH) {
            System.out.print("낫싱");
        }
        if (ball != 0) {
            System.out.print(ball + "볼 ");
        }
        if (strike != 0) {
            System.out.print(strike + "스트라이크");
        }

        System.out.println("");
        check_done(strike);
    }

    private static void check_input() {
        HashMap<Character, Boolean> check = new HashMap<>();
        if (user_num.length() != NUM_LENGTH) {
            throw new IllegalArgumentException("length of input isn't 3");
        }
        for (int i = 0; i < NUM_LENGTH; i++) {
            char ch = user_num.charAt(i);
            if (ch >= '1' && ch <= '9' && check.get(ch) == null) {
                check.put(ch, true);
                continue;
            }
            throw new IllegalArgumentException("No Duplication and Only number");
        }
    }

    private static boolean check_status(Status status) {
        switch (status) {
            case CONTINUE:
                return true;
            case START:
                init();
                return true;
            case EXIT:
                return false;
        }
        return false;
    }

    private static void init() {
        com_num = "";
        while (com_num.length() != 3) {
            String temp = Integer.toString(Randoms.pickNumberInRange(1, 9));
            if (com_num.indexOf(temp.charAt(0)) == -1) {
                com_num += temp;
            }
        }
    }

    private static void input_num() {
        System.out.print("숫자를 입력해주세요 : ");
        user_num = Console.readLine();
    }

    private static String play_game() {
        int ball_cnt = 0;
        int strike_cnt = 0;

        for (int i = 0; i < NUM_LENGTH; i++) {
            for (int j = 0; j < NUM_LENGTH; j++) {
                if (user_num.charAt(i) == com_num.charAt(j) && i == j) {
                    strike_cnt += 1;
                }

                if (user_num.charAt(i) == com_num.charAt(j) && i != j) {
                    ball_cnt += 1;
                }
            }
        }

        return make_result(strike_cnt, ball_cnt);
    }

    private static String make_result(int strike_cnt, int ball_cnt) {
        String result = "";
        result += Integer.toString(NUM_LENGTH - (ball_cnt + strike_cnt));
        result += Integer.toString(ball_cnt);
        result += Integer.toString(strike_cnt);

        return result;
    }

    private static void check_done(int strikeCnt) {
        if (strikeCnt == 3) {
            user_status = Status.DONE;
        }
        if (strikeCnt != 3) {
            user_status = Status.CONTINUE;
        }
    }

    private static void end_routine() {
        if (user_status == Status.DONE) {
            done_routine();
        }
    }

    private static void done_routine() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int input = Integer.parseInt(Console.readLine());
        if (input == 1) {
            user_status = Status.START;
            return;
        }

        if (input == 2) {
            user_status = Status.EXIT;
            return;
        }

        throw new IllegalArgumentException("Only input 1 or 2");
    }
}

public class Application {

    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        game.run();
    }
}
