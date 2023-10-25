package baseball;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
public class Application {

    private static List<Integer> computer = new ArrayList<>();
    public static void RandomNumberGenerator() {
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
    }

    public static boolean UserInputValidCheck(String s) {
        if(s.length() != 3) return false;
        if(s.charAt(0) == s.charAt(1) || s.charAt(1) == s.charAt(2) || s.charAt(2) == s.charAt(0)) return false;
        for(int i = 0; i < 3; i++) {
            int Digit = s.charAt(i) - '0';
            if(Digit == 0) return false;
            if(Digit < 0 || Digit > 9) return false;
        }
        return true;
    }

    public static void main(String[] args) {

        RandomNumberGenerator();
        System.out.println("숫자 야구 게임을 시작합니다.");
        while(true) {
            System.out.print("숫자를 입력하세요 : ");
            String UserInput = Console.readLine();

            if (UserInputValidCheck(UserInput) == false) {
                throw new IllegalArgumentException();
            }
            int Strike = 0;
            int BallCount = 0;
            int[] UserDigits = new int[3];
            for(int i = 0; i < 3; i++) {
                UserDigits[i] = UserInput.charAt(i) - '0';
            }
            for(int i = 0; i < 3; i++) {
                for(int j = 0; j < 3; j++) {
                    if (i == j && computer.get(i) == UserDigits[j]) {
                        Strike++;
                    }
                    if(i != j && computer.get(i) == UserDigits[j]) {
                        BallCount++;
                    }
                }
            }
            if(Strike == 3) {
                System.out.println("3스트라이크\n" + "3개의 숫자를 모두 맞히셨습니다!" + " " + "게임 종료"
                        + "\n" + "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                String isGameEnd = Console.readLine();
                if(isGameEnd.charAt(0) == '1') {
                    computer.clear();
                    RandomNumberGenerator();
                    continue;
                }
                else if(isGameEnd.charAt(0) == '2')
                    return;
                else
                    throw new IllegalArgumentException();
            }

            if(Strike > 0 && Strike < 3 && BallCount == 0)
                System.out.println(Strike + "스트라이크");
            if(BallCount > 0 && BallCount <= 3 && Strike == 0)
                System.out.println(BallCount + "볼");
            if(Strike > 0 && BallCount > 0 && Strike < 3 && BallCount < 3)
                System.out.println(BallCount + "볼 " + Strike + "스트라이크");
            if(Strike == 0 && BallCount == 0)
                System.out.println("낫싱");
        }

    }
}
