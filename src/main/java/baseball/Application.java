package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {

    public int solution(int[] num) throws IllegalArgumentException {

        int correct = 0;
        int[] trial = new int[3];
        System.out.print("숫자를 입력해주세요 : ");
        String str = Console.readLine(); // 숫자 입력
        if (!isValidInput(str)) {
            throw new IllegalArgumentException("올바른 숫자 입력이 아닙니다.");
        }

        int t = 0;
        for (String x : str.split("")) { // 문자열로 입력 받아 정수 배열로 변환
            trial[t] = Integer.parseInt(x);
            t++;
        }

        int strike = 0, ball = 0; // 스트라이크 개수와 볼 개수 변수 초기화
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == j && num[i] == trial[j]) { // 같은 수가 같은 자리에 있으면
                    strike++; // 스트라이크 1 증가
                } else if (i != j && num[i] == trial[j]) { // 같은 수가 다른 자리에 있으면
                    ball++; // 볼 1 증가
                }
            }
        }

        if (strike == 0 && ball == 0) { // 같은 수가 전혀 없을 때
            System.out.println("낫싱");
        } else if (strike == 3) { // 숫자를 모두 맞혔을 때
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            correct = 1; // 모두 맞혔을 때 게임 종료를 위한 변수 설정
        } else if (ball == 0) { // 볼 개수가 0인 경우, 스트라이크 개수만 출력
            System.out.println(strike + "스트라이크");
        } else if (strike == 0) { // 스트라이크 개수가 0인 경우, 볼 개수만 출력
            System.out.println(ball + "볼");
        } else { // 이외에는 볼 개수와 스트라이크 개수 출력
            //System.out.println(ball + "볼" + " " + strike + "스트라이크");
            System.out.print(ball);
            System.out.print("볼 ");
            System.out.print(strike);
            System.out.println("스트라이크");
        }
        return correct;
    }

    public static void main(String[] args) throws IllegalArgumentException {

        Application T = new Application();
        int[] num;
        num = new int[3];
        String re = "1";

        while (re.equals("1")) {
            for (int i = 0; i < 3; i++) {
                num[i] = Randoms.pickNumberInRange(1, 9); // 숫자 랜덤 생성
                for (int j = 0; j < i; j++) {
                    if (num[i] == num[j]) // 서로 다른 수 생성을 위한 중복 제거
                        i--;
                }
                // System.out.print(num[i] + " ");
            }

            System.out.println("숫자 야구 게임을 시작합니다.");

            while (true) {
                T.solution(num);
                if (T.solution(num) == 1)
                    break;
            }
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            re = Console.readLine();

            if (!isValidInput2(re)) { // 1 또는 2가 입력되지 않으면 Exception
                throw new IllegalArgumentException("1 또는 2가 입력되지 않았습니다.");
            }
            if (re.equals("2")) // 2가 입력되면 프로그램 종료
                break;
        }
    }

    private static boolean isValidInput(String str) throws IllegalArgumentException {
        if (!str.matches("\\d{3}")) { // 입력한 문자열이 3자리가 아니라면 Exception
            return false;
        }

        char[] strArr = str.toCharArray(); // 입력한 문자열을 배열로 한 자리씩 나눴을 때
        for (int i = 0; i < strArr.length - 1; i++) { // 각 자리 수를 비교하여 일치하는 수가 있다면 Exception
            for (int j = i + 1; j < strArr.length; j++) {
                if (strArr[i] == strArr[j])
                    return false;
            }
        }
        for(int i = 0; i < strArr.length; i++){
            if (strArr[i] < '1' && strArr[i] > '9') // 입력한 수가 1부터 9까지의 수 이외의 수라면 Exception
                return false;
        }
        return true;
    }

    private static boolean isValidInput2(String re) throws IllegalArgumentException {
        if (re.equals("1") || re.equals("2")) // 게임을 다시 시작하거나 완전히 종료하기 위해 입력받을 때
            return true; // 1 또는 2가 아닌 경우 Exception
        else
            return false;
    }
}
