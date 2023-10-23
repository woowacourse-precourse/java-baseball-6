package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Computer cp = Computer.getInstance();
        User user = User.getInstance();
        Play play = Play.getInstance();
        int[] comNums = cp.setRandomNums();

        while(true) {
            System.out.println(Arrays.toString(comNums));
            System.out.println("숫자 야구 게임을 시작합니다.");
            System.out.print("숫자를 입력해주세요 : ");
            String str = Console.readLine();
            int[] userNums = user.setUserNum(str);
            int status = play.run(comNums, userNums);
            boolean gameStatus = play.checkGameStatus(status);

            if (gameStatus) {
                System.out.println("게임 종료");
                break;
            } else {
                if (status == 1) {
                    cp.resetNums();
                }
            }
        }
    }
}
