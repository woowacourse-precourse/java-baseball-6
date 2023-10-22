package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int finish = 1;
        boolean restart = true;
        List<Integer> computer = new ArrayList<>();

        System.out.println("숫자 야구 게임을 시작합니다.");

        while (finish == 1) {

            while (computer.size() < 3 && restart) {
                int randomNumber = Randoms.pickNumberInRange(1, 9);
                if (!computer.contains(randomNumber)) {
                    computer.add(randomNumber);
                }
            }

            restart = false;

            Balls comBalls = new Balls(computer);

            System.out.print("숫자를 입력해주세요 : ");
            String user = Console.readLine();

            char[] chars = user.toCharArray();

            List<Integer> userList = new ArrayList<>();

            for (char c : chars) {
                if (Character.isDigit(c)) {
                    userList.add(Character.getNumericValue(c));
                }
            }

            Balls userBalls = new Balls(userList);

            PlayResult playResult = comBalls.play(userBalls);
            if (playResult.getBall() + playResult.getStrike() == 0) {
                System.out.println("낫싱");
            }

            System.out.println(playResult.getBall());
            System.out.println(playResult.getStrike());

            if (playResult.getBall() > 0 && playResult.getStrike() > 0) {
                System.out.println(playResult.getBall() + "볼 " + playResult.getStrike() + "스트라이크");
            } else if (playResult.getBall() == 0 && playResult.getStrike() > 0) {
                System.out.println(playResult.getStrike() + "스트라이크");
            } else if (playResult.getStrike() == 0 && playResult.getBall() > 0) {
                System.out.println(playResult.getBall() + "볼");
            }

            if (playResult.getStrike() == 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다!");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

                String finishCheck = Console.readLine();

                System.out.println("끝" + finishCheck);

                if (finishCheck.equals("1")) {
                    restart = true;
                    computer.clear();
                } else {
                    finish = 2;
                    System.out.println("게임 종료");
                }
            }

            if (finish == 2) {
                break;
            }
        }
    }
}
