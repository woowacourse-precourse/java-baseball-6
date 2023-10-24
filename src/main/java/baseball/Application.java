package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        boolean replay = true;

        while (replay) {
            /** 1. 컴퓨터가 임의의 수 3개 선택 */
            List<Integer> computer = new ArrayList<>();
            while (computer.size() < 3) {
                int randomNumber = Randoms.pickNumberInRange(1, 9);
                if (!computer.contains(randomNumber)) {
                    computer.add(randomNumber);
                }
            }

            System.out.println("숫자 야구 게임을 시작합니다.");

            boolean answer = true;

            while (answer) {
                /** 2. 게임 플레이어에게 3개의 숫자 입력받기 */
                List<Integer> user = new ArrayList<>();

                System.out.print("숫자를 입력해주세요 : ");
                String userPickNumberString = readLine();

                for (int i = 0; i < userPickNumberString.length(); i++) {
                    int userPickNum = (int) userPickNumberString.charAt(i) - 48;
                    if (!user.contains(userPickNum) && userPickNum!=0) {
                        user.add((int) userPickNumberString.charAt(i) - 48);
                    }
                }
                /** Exception, 사용자에게 입력받을 때 생기는 에외 */
                if (user.size()!=3) {
                    throw new IllegalArgumentException("1~9까지의 서로 다른 3개의 수만 입력하세요.");
                }
                /** 입력된 숫자에 대한 결과 출력 */
                int strikeCount = 0;
                int ballCount = 0;
                
                for (int i = 0; i < computer.size(); i++) {
                    if (computer.get(i)==user.get(i)) {
                        strikeCount++;
                    }
                    for (int j = 0; j < user.size(); j++) {
                        if (computer.get(i)==user.get(j) && i!=j) {
                            ballCount++;
                        }
                    }
                }
                StringBuffer hint = new StringBuffer();
                if (ballCount > 0) {
                    hint.append(ballCount).append("볼");
                }
                if (ballCount > 0 && strikeCount > 0) {
                    hint.append(" ");
                }
                if (strikeCount > 0) {
                    hint.append(strikeCount).append("스트라이크");
                }
                if (ballCount==0 && strikeCount==0) {
                    hint.append("낫싱");
                }

                System.out.println(hint);

                if (hint.toString().equals("3스트라이크")) {
                    answer = false;

                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                    String replayInt = readLine();
                    if (!(replayInt.equals("1") || replayInt.equals("2"))) {
                        throw new IllegalArgumentException("1 또는 2만 입력해야합니다.");
                    }
                    if (replayInt.equals("2")) {
                        replay = false;
                        System.out.println("게임 종료");
                    }
                }
            }
        }
    }
}
