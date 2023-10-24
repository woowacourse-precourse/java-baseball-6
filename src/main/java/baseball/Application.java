package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        Baseballgame game = new Baseballgame();

        // 0 : 게임 시작시 정답을 생성한다.
        List<Integer> answer = game.createAnswer();

        // 1 : 게임 시작 문구 출력
        System.out.println("숫자 야구 게임을 시작합니다.");

        // 반복문 제어를 위한 변수 선언 - 조건이 달성 된다면 false 로 전환
        boolean gameStatus = true;
        while (gameStatus) {

            // 2 : 정답 입력을 위한 문구 출력
            System.out.print("숫자를 입력해주세요 : ");

            // 2-1 : 정답을 입력 받고 검증을 통해 반환받는다.
            List<Integer> input = game.enterCorrectAnswer(Console.readLine());

            // 3 : 정답과 플레이어가 입력한 값의 일치 결과를 체크해서 결과를 반환한다.
            if (game.checkCorrectAnswer(answer, input)) {
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                if (!game.selectMenu(Console.readLine())) {
                    gameStatus = false;
                } else {
                    answer = game.createAnswer();
                }
            }
        }

    }
}

class Baseballgame {

    int strike = 0;
    int ball = 0;

    public List<Integer> createAnswer() {
        List<Integer> answer = new ArrayList<>();
        while (answer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!answer.contains(randomNumber)) {
                answer.add(randomNumber);
            }
        }
        return answer;
    }

    public List<Integer> enterCorrectAnswer(String var) {
        List<Integer> input = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            int num = var.charAt(i) - 48;
            if (var.length() == 3 && !input.contains(num) && Verification.numVerification(num)) {
                input.add(num);
            } else {
                throw new IllegalArgumentException();
            }
        }

        return input;
    }

    public boolean checkCorrectAnswer(List<Integer> answer, List<Integer> input) {
        for (int an = 0; an < 3; an++) {
            for (int in = 0; in < 3; in++) {
                if (answer.get(an).equals(input.get(in)) && an == in) {
                    strike++;
                } else if (answer.get(an).equals(input.get(in))) {
                    ball++;
                }
                //System.out.println(answer.get(an) + "/" + input.get(in));
            }
        }

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

    public boolean selectMenu(String var) {
        if (Verification.menuVerification(var)) {
            return var.equals("1");
        }
        throw new IllegalArgumentException();
    }

    public boolean compareVariables(String args, boolean args2) {
        strike = 0;
        ball = 0;
        System.out.println(args);
        return args2;
    }
}

class Verification {
    public static boolean numVerification(int var) {
        return var >= 1 && var <= 9;
    }

    public static boolean menuVerification(String var) {
        return var.equals("1") || var.equals("2");
    }
}