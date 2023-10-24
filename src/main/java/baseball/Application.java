package baseball;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
public class Application {
    /**랜덤한 3자리 숫자를 생성하는 함수*/
    List<Integer> makeRandomNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }
    /**랜덤한 숫자와 입력한 숫자를 비교하는 함수*/
    int baseball(String inputNum, List<Integer> randomNumber) {
        // 잘못된 입력값 예외 처리
        for (int i = 0; i < inputNum.length(); i++) {
            char num1 = inputNum.charAt(i);
            for (int j = i + 1; j < inputNum.length(); j++) {
                if (num1 == inputNum.charAt(j)) {
                    throw new IllegalArgumentException("중복된 수가 존재합니다.");
                }
            }
        }
        if (inputNum.length() != 3) {
            throw new IllegalArgumentException("3자리 수가 아닙니다.");
        }
        try {
            int number = Integer.parseInt(inputNum);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자 형식이 아닙니다.");
        }
        // 스트라이크 볼 카운트 초기화
        int strike = 0;
        int ball = 0;
        // 정답과 입력 숫자 비교
        for (int i = 0; i < inputNum.length(); i++) {
            int userNum = Integer.parseInt(String.valueOf(inputNum.charAt(i)));
            if (randomNumber.get(i).equals(userNum)) {
                strike++;
            } else if (randomNumber.contains(userNum)) {
                ball++;
            }
        }
        // 스트라이크 및 볼 카운트에 따른 출력
        if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
        } else if (strike == 3) {
            System.out.println(strike + "스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return strike; // 정답시 스트라이크 갯수 리턴
        } else {
            System.out.println((ball > 0 ? ball + "볼 " : "") + (strike > 0 ? strike + "스트라이크" : ""));
        }
        return 0;
    }
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다");
        Application app = new Application();
        String restratOrEnd = "1";
        // 정답이 나올때까지 게임 반복
        while (restratOrEnd.equals("1")) {
            List<Integer> randomNumber = app.makeRandomNumber();
            int result = 0;
            while (!(result == 3)) {
                System.out.print("숫자를 입력해주세요 : ");
                String inputNum = Console.readLine();
                result = app.baseball(inputNum, randomNumber);
            }
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            restratOrEnd = Console.readLine();
            if (!restratOrEnd.equals("1") && !restratOrEnd.equals("2")) {
                throw new IllegalArgumentException("1 또는 2를 입력해주세요.");
            }
        }
    }
}
