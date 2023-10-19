package baseball;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    private static int start_num = 1;
    private static int end_num = 9;
    private static int ascii_one = 49;
    private static int ascii_nine = 57;
    private static int num_length = 3;

    private static String make_random() {  // 랜덤 숫자를 만드는 함수
        int a = pickNumberInRange(start_num, end_num);  // 첫번째 자리 숫자 랜덤으로 생성

        int b = a;  // 두번째 자리 숫자를 첫번째 자리와 똑같이 선언 - 중복이 안되기 때문을 이용
        while (b == a) { // 중복이 안된다는 것은 새로운 숫자라는 뜻!
            b = pickNumberInRange(start_num, end_num);
        }

        int c = pickNumberInRange(start_num, end_num);  // 세번째 숫자
        while (c == a || c == b) {    // a, b와도 같으면 안되므로
            c = pickNumberInRange(start_num, end_num);
        }

        return Integer.toString(a) + Integer.toString(b) + Integer.toString(c);
    }

    private static void validate_answer(String random_number, String answer) {  // 사용자 입력 유효성 검증
        int size = random_number.length();

        // 1) 문자열 길이가 맞지 않을 경우
        if (answer.length() != size) {
            throw new IllegalArgumentException("3자리 숫자를 입력해주세요.");
        }

        char a = answer.charAt(0);
        char b = answer.charAt(1);
        char c = answer.charAt(2);

        // 2) 0이 들어갔을 경우, 문자열이 들어갔을 경우 모두 파악 해야함
        if (a < ascii_one || a > ascii_nine) {
            throw new IllegalArgumentException("올바른 입력 포맷이 아닙니다.");
        }
        if (b < ascii_one || b > ascii_nine) {
            throw new IllegalArgumentException("올바른 입력 포맷이 아닙니다.");
        }
        if (c < ascii_one || c > ascii_nine) {
            throw new IllegalArgumentException("올바른 입력 포맷이 아닙니다.");
        }

        // 3) 중복된 숫자가 들어갔을 경우
        if (a == b || b == c || c == a) {
            throw new IllegalArgumentException("중복된 숫자는 없어야합니다.");
        }
    }

    private static boolean check_answer(String random_number, String answer) {
        int ball = 0;
        int wrong = 0;
        int strike = 0;

        char answer_char;

        // 1) ball 찾기
        for (int i = 0; i < num_length; i++) {
            answer_char = answer.charAt(i);
            if (answer_char == random_number.charAt(0) || answer_char == random_number.charAt(1) || answer_char == random_number.charAt(2)) {
                ball += 1;
            } else {
                wrong += 1;
            }
        }

        // 2) ball 중에서 strike 찾기
        for (int i = 0; i < num_length; i++) {
            if (answer.charAt(i) == random_number.charAt(i)) {  // 각각 자리의 대응대는 위치가 같으면 strike! 그렇다면 ball의 개수를 줄이면 된다.
                ball -= 1;
                strike += 1;
            }
        }

        if (wrong == 3) {
            System.out.println("낫싱");
            return false;
        } else if (strike == 3) {
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        } else {
            System.out.println(ball + "볼 " + strike + "스트라이크");
            return false;
        }

    }


    public static void main(String[] args) {

        System.out.println("숫자 야구 게임을 시작합니다.");


        while (true) {

            String random_number = make_random();   // 랜덤값 생성

            boolean is_correct = false;

            while (is_correct == false) {
                System.out.print("숫자를 입력해주세요 : ");
                String answer = readLine();     // 입력 값 받아오기

                validate_answer(random_number, answer);    // 입력 값 유효한지 파악

                is_correct = check_answer(random_number, answer);    // 입력 값 스트라이크, 볼, 낫싱 파악
            }

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String regame = readLine();
            if (regame.equals("2")) {
                break;
            }
        }
    }
}


