package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {
    private String computerNumber;

    /**
     * 숫자 야구 진행 함수
     * 입력: 없음
     * 출력: 없음
     */
    void gameManager() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        // 게임 시작 전 랜덤한 컴퓨터값 저장
        computerNumber = randomNumber();
        // 사용자에게서 값을 입력받을 string 배열
        String userNumber = "";

        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
            userNumber = Console.readLine().strip();

            if (!isValid(userNumber))
                throw new IllegalArgumentException();

            if (is3Strike(userNumber)) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                userNumber = Console.readLine().strip();

                if (userNumber.charAt(0) == '1')
                    computerNumber = randomNumber();
                else if (userNumber.charAt(0) == '2')
                    break;
                else
                    throw new IllegalArgumentException();
            }
        }
    }

    /**
     * 랜덤 컴퓨터 값 생성 함수
     * 입력: 없음
     * 출력: String(랜덤한 숫자값 문자열)
     */
    String randomNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber))
                computer.add(randomNumber);
        }

        return computer.get(0) + "" + computer.get(1) + "" + computer.get(2);
    }

    /**
     * 입력 값 검증 함수
     * 입력: userNumber(사용자의 입력 값)
     * 출력: boolean(입력 값이 유효 범위 내에 존재하는 값일 경우 true 반환)
     */
    boolean isValid(String userNumber) {
        // 사용자가 입력한 값이 3자리인지 확인
        if (userNumber.length() != 3)
            return false;

        // 사용자가 입력한 문자열이 1~9사이의 숫자들로 이루어져있는지 확인
        for (int i = 0 ; i < 3 ; i++)
            if (userNumber.charAt(i) < '1' || userNumber.charAt(i) > '9')
                return false;

        // 세 자리 숫자 중 같은 숫자가 포함되어 있는지 확인
        if (userNumber.charAt(0) == userNumber.charAt(1)
                || userNumber.charAt(1) == userNumber.charAt(2)
                || userNumber.charAt(0) == userNumber.charAt(2))
            return false;

        return true;
    }

    /**
     * 입력 값과 컴퓨터 값 비교 함수
     * 입력: userNumber(사용자의 입력 값)
     * 출력: boolean(3 스트라이크일 경우 true 반환)
     */
    boolean is3Strike(String userNumber) {
        int result[] = new int[2];
        result[0] = countStrike(userNumber);
        // 볼의 개수를 셀 때, 스트라이크도 볼로 카운트하므로 스트라이크 개수 제외
        result[1] = countBall(userNumber) - result[0];

        String print = "";
        if (result[1] > 0) {
            print += result[1] + "볼";
            if (result[0] > 0)
                print += " " + result[0] + "스트라이크";
        } else if (result[0] > 0) {
            print += result[0] + "스트라이크";
        } else {
            print += "낫싱";
        }
        System.out.println(print);

        if (result[0] != 3)
            return false;

        return true;
    }

    /**
     * 스트라이크 개수 확인 함수
     * 입력: userNumber(사용자의 입력 값)
     * 출력: int(스트라이크 개수)
     */
    int countStrike(String userNumber) {
        int result = 0;
        for (int i = 0; i < userNumber.length(); i++)
            // 자릿수마다 똑같은 숫자가 있는지 확인
            if (userNumber.charAt(i) == computerNumber.charAt(i))
                result++;

        return result;
    }

    /**
     * 볼 개수 확인 함수
     * 입력: userNumber(사용자의 입력 값)
     * 출력: int(볼 개수)
     */
    int countBall(String userNumber) {
        int result = 0;
        for(int i = 0 ; i < userNumber.length() ; i++)
            // 사용자의 숫자를 포함하고 있는지 확인
            if (computerNumber.contains(userNumber.charAt(i) + ""))
                result++;

        return result;
    }

    public static void main(String[] args) throws IllegalArgumentException{
        // TODO: 프로그램 구현
        Application application = new Application();
        application.gameManager();
    }
}
