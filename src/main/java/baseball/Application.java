package baseball;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static void main(String[] args) {
        Event numberBaseball = new Event();

        System.out.println("숫자 야구 게임을 시작합니다.");
        numberBaseball.play_game();
    }
}

class Event {
    String filter, guess, secret;

    // 1. 숫자 선택
    void select_number() {
        secret = "";

        while (secret.length() != 3) {
            filter = Integer.toString(Randoms.pickNumberInRange(1,9));

            if (secret.contains(filter)) {
                continue;
            }

            secret += filter;
        }
    }

    // 2. 숫자 입력
    void input_number() {
        System.out.print("숫자를 입력해주세요 : ");
        guess = Console.readLine();

        if (guess.length() != 3) {
            throw new IllegalArgumentException("잘못된 값입니다.");
        }
    }

    // 3. 볼 카운트
    boolean count_ball() {
        int balls = 0;
        int strikes = 0;

        for (int i = 0 ; i < 3 ; i++) {
            if (secret.equals(guess)) {
                System.out.println("3스트라이크");
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                return true;
            }
            else if (secret.charAt(i)== guess.charAt(i)) {
                strikes += 1;
            }
            else if (guess.contains(String.valueOf(secret.charAt(i)))) {
                balls += 1;
            }
        }

        if (balls > 0 && strikes > 0) {
            System.out.print(balls + "볼 " + strikes + "스트라이크");
        }
        else if (balls > 0) {
            System.out.print(balls + "볼");
        }
        else if (strikes > 0) {
            System.out.print(strikes + "스트라이크");
        }
        if (balls==0 && strikes==0) {
            System.out.print("낫싱");
        }

        System.out.println("");
        return false;
    }

    // 4. 게임 실행
    void play_game() {
        select_number();

        while (true) {
            input_number();

            if (!count_ball()) {
                continue;
            }

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

            if (Integer.parseInt(Console.readLine()) == 2) {
                break;
            }

            select_number();
        }
    }
}