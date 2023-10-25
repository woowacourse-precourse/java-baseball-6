package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Game {
    public static int start(){

        /* answer 생성 */
        List<Integer> answerList = new ArrayList<>();
        while (answerList.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!answerList.contains(randomNumber)) {
                answerList.add(randomNumber);
            }
        }

        /* 사용자로부터 입력되는 숫자 저장 및 유효성검사 */
        System.out.printf("숫자 야구 게임을 시작합니다.\n");
        while(true) {
            int strikeCnt = 0;
            int ballCnt = 0;
            int incorrectCnt = 0;

            System.out.printf("숫자를 입력해주세요 : ");
            String submitStr = Console.readLine();
            char[] submitCharNumbers = submitStr.toCharArray();
            int[] submitIntNumbers = new int[submitCharNumbers.length];
            for (int i = 0; i < submitCharNumbers.length; i++) {
                if (i >= 3) throw new IllegalArgumentException("3개의 숫자를 입력하셔야합니다.");

                if (48 <= submitCharNumbers[i] && 57 >= submitCharNumbers[i]) {
                    submitIntNumbers[i] = submitCharNumbers[i] - '0';
                } else
                    throw new IllegalArgumentException("3개의 숫자를 입력하셔야합니다.");
            }

            /* 정답 체크 */
            for (int i = 0; i < submitIntNumbers.length; i++) {
                if (answerList.contains(submitIntNumbers[i])) {
                    if (answerList.indexOf(submitIntNumbers[i]) == i) strikeCnt++;
                    else ballCnt++;
                } else
                    incorrectCnt++;
            }

            if (incorrectCnt == 3)
                System.out.printf("낫싱\n");
            else {
                if (ballCnt != 0)
                    System.out.printf("%d볼 ", ballCnt);
                if (strikeCnt != 0)
                    System.out.printf("%d스트라이크\n", strikeCnt);
                if (strikeCnt == 3) {
                    System.out.printf("%d개의 숫자를 모두 맞히셨습니다! 게임 종료\n", strikeCnt);
                    break;
                }
            }
        }

        /* 게임 재시작 여부 체크 */
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        String gameStartYN = Console.readLine();
        if(gameStartYN.equals("1"))
            return 1;
        else if(gameStartYN.equals("2"))
            return 2;
        else
            throw new IllegalArgumentException("1 또는 2를 입력하셔야합니다.");
    }

}
