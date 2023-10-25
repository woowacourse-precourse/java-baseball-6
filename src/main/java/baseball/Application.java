package baseball;
import java.util.*;
import camp.nextstep.edu.missionutils.*;
public class Application {
    public static List<Integer> randomMaking() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        return computer;
    }

    public static List<Integer> getUserNumber() {
        String tmp = camp.nextstep.edu.missionutils.Console.readLine();
        if (tmp.length() != 3)
            throw new IllegalArgumentException("Invalid argument: " + tmp);
        List<Integer> user = new ArrayList<>();
        for (int i = 0; i < 3; i++)
            user.add(tmp.charAt(i) - '0');

        return user;
    }

    public static int[] checkCount(List user, List computer) {
        int count[] = new int[2];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (user.get(i) == computer.get(j)) {
                    if (i == j) count[1]++;
                    else count[0]++;
                }
            }
        }

        return count;
    }

    public static void printResult(int ball, int strike) {
        if (strike == 0 && ball == 0)
            System.out.println("낫싱");
        else if (strike == 0 && ball != 0)
            System.out.println(ball + "볼");
        else if (strike != 0 && ball == 0)
            System.out.println(strike + "스트라이크");
        else
            System.out.println(ball + "볼 " + strike + "스트라이크");
    }

    public static void main(String[] args) {
        int restart = 1;

        ENDGAME:
        while (true) {
            List<Integer> computer = randomMaking();

            System.out.println("숫자 야구 게임을 시작합니다.");

            NEWGAME:
            while (true) {
                System.out.println(computer);
                System.out.print("숫자를 입력해주세요 : ");
                List<Integer> user = getUserNumber();

                int[] count = checkCount(user, computer);
                int strike = count[1], ball = count[0];

                printResult(ball, strike);

                if (strike == 3) {
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n" +
                            "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                    String tmp = camp.nextstep.edu.missionutils.Console.readLine();
                    restart = tmp.charAt(0) - '0';
                    if (restart < 1 || restart > 2)
                        throw new IllegalArgumentException("Invalid argument: " + restart);

                    if (restart == 2)
                        break ENDGAME;
                    if(restart == 1)
                        break NEWGAME;
                }
            }


        }
    }
}
