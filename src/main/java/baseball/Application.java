package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        GameMaster gm = new GameMaster();

        System.out.println("숫자 야구 게임을 시작합니다.");

        /** 1. 컴퓨터가 임의의 수 3개 선택 */
        Computer com = new Computer();
        List computerRandomNumber = com.computerNumberSelection();

        do {
            if (gm.isReplay()) {
                com = new Computer();
                computerRandomNumber = com.computerNumberSelection();
                gm.setReplay(false);
            }
            /** 2. 게임 플레이어에게 3개의 숫자 입력받기 */
            User user = new User();

            System.out.print("숫자를 입력해주세요 : ");
            String userPickNumberString = readLine();

            List userPickNumber = user.userPickNumberStringToList(userPickNumberString);

            /** 3. 입력된 숫자에 대한 결과 출력 */
            gm.setBallCount(0);
            gm.setStrikeCount(0);
            gm.countStrikeAndBall(computerRandomNumber, userPickNumber);

            StringBuffer hint = gm.generateHint(gm.getBallCount(), gm.getStrikeCount());

            System.out.println(hint);

            if (hint.toString().equals("3스트라이크")) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                String replayInt = readLine();
                gm.replayIntExceptionCheck(replayInt);
                gm.replayIntResultCheck(replayInt);
            }
        } while (gm.isAnswer());
    }
}
