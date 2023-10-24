package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        Baseballgame game = new Baseballgame();

        // 0 : 컴퓨터가 게임을 위한 정답을 생성한다.
        List<Integer> answer = game.createAnswer();

        // 1 : 게임 시작 문구 출력
        System.out.println("숫자 야구 게임을 시작합니다.");

        // 반복문 제어를 위한 변수 선언 - 조건이 달성 된다면 false 로 전환
        boolean gameStatus = true;
        while (gameStatus) {

            // 2 : 정답 입력을 위한 문구 출력
            System.out.print("숫자를 입력해주세요 : ");

            // 2-1 : 정답을 입력 받고 검증을 통해 올바른 값인지 확인 후 값을 저장한다.
            List<Integer> input = game.enterCorrectAnswer(Console.readLine());

            // 3 : 컴퓨터와 플레이어의 정답을 비교해서 정답이면 조건문에 진입 아니면 2번부터 다시 반복한다.
            if (game.checkCorrectAnswer(answer, input)) {
                // 3-1 : 정답이면 다음 게임을 위한 문구 출력
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                // 3-1 : 게임 선택 값을 입력받는다.
                if (!game.selectMenu(Console.readLine())) {
                    // 2가 입력되면 게임을 종료한다.
                    gameStatus = false;
                } else {
                    // 1이 입력되면 정답을 다시 생성한다.
                    answer = game.createAnswer();
                }
            }
            // 4 : 정답이 될 때까지 반복...
        }

    }
}

class Baseballgame {

    int strike = 0;
    int ball = 0;

    // 컴퓨터의 정답 생성을 위한 메서드
    public List<Integer> createAnswer() {
        List<Integer> answer = new ArrayList<>();
        // 3자리 수의 값을 정답으로 가진다.
        while (answer.size() < 3) {
            // Randoms 라이브러리를 통한 1부터 9까지의 수중에 하나를 생성
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            // 생성된 수가 존재하지 않으면 리스트에 값을 추가 -> 중복되지 않는 값의 3자리 수
            if (!answer.contains(randomNumber)) {
                answer.add(randomNumber);
            }
        }
        // 반복문 종료후 올바른 3자리의 값을 가진 리스트를 반환
        return answer;
    }

    public List<Integer> enterCorrectAnswer(String args) {
        List<Integer> input = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            // 입력해서 불러온 인덱스 값을 문자열 -> 정수형으로 변환한다.
            int num = args.charAt(i) - 48;
            // 입력된 정답값은 길이가 3 , 값이 중복되지 않고, 정수 1 에서 9 까지의 범위를 가진다.
            if (args.length() == 3 && !input.contains(num) && Verification.numVerification(num)) {
                input.add(num);
            } else {
                // 잘못 된 값은 IllegalArgumentException 예외를 던진다.
                throw new IllegalArgumentException();
            }
        }
        // 반복문 종료후 올바른 3자리의 값을 가진 리스트를 반환
        return input;
    }

    public boolean checkCorrectAnswer(List<Integer> answer, List<Integer> input) {
        // 중첩 반복문을 통해서 두개의 값을 비교한다.
        for (int an = 0; an < 3; an++) {
            for (int in = 0; in < 3; in++) {
                // 값과 위치가 모두 동일하면 1스트라이크
                if (answer.get(an).equals(input.get(in)) && an == in) {
                    strike++;
                    // 값만 동일하면 1볼
                } else if (answer.get(an).equals(input.get(in))) {
                    ball++;
                }
            }
        }

        // 반복문으로 연산된 변수 값에 대한 올바른 조건 결과를 반환한다.
        if (strike == 3 && ball == 0) {
            return compareVariables("3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료", true);
        } else if (strike >= 1 && ball >= 1) {
            return compareVariables(ball + "볼 " + strike + "스트라이크", false);
        } else if (strike >= 1 && ball == 0) {
            return compareVariables(strike + "스트라이크", false);
        } else if (strike == 0 && ball >= 1) {
            return compareVariables(ball + "볼", false);
        } else if (strike == 0 && ball == 0) {
            return compareVariables("낫싱", false);
        }

        return false;
    }

    // 게임 메뉴 검증과 선택을 위한 메서드
    public boolean selectMenu(String args) {
        // 입력받은 값이 1인지 2인지 체크하고 다른 값이 입력되면 예외를 던진다.
        if (Verification.menuVerification(args)) {
            return args.equals("1");
        }
        throw new IllegalArgumentException();
    }

    // 비교한 값을 초기화하고 반환하기 위한 메서드
    public boolean compareVariables(String args, boolean args2) {
        strike = 0;
        ball = 0;
        System.out.println(args);
        return args2;
    }
}

class Verification {
    // 입력된 값이 1 또는 9의 값 범위안에 들어갔는지 체크하는 검증 메서드
    public static boolean numVerification(int args) {
        return args >= 1 && args <= 9;
    }

    // 입력된 값이 1또는 2인지 체크하는 검증 메서드
    public static boolean menuVerification(String args) {
        return args.equals("1") || args.equals("2");
    }
}