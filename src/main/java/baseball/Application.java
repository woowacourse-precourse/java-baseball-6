package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    static final String NUM_REG = "[0-9]+";

    public static void main(String[] args) {
        // 게임 시작 문구 출력
        System.out.println("숫자 야구 게임을 시작합니다.");

        while (true) {
            // 컴퓨터는 임의의 수 3개 선택
            String computerNum = getThreeRandomNum();

            // 숫자야구 게임 시작
            startNumberBaseBallGame(computerNum);

            // 정답을 맞추면 아래 문구 출력 및 게임 지속 여부 받기
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            String inputNum = printMsgAndReadNum("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.", 1, false, true);
            if(inputNum.equals("2")) break;
        }

    }


    private static void startNumberBaseBallGame(String computerNum) {
        while (true) {
            String userSelectNum = printMsgAndReadNum("숫자를 입력해주세요 : ", 3, true, false);

            // 스트라이크와 볼의 개수를 파악하기 위한 정수형 변수 선언
            int strikeCnt = 0;
            int ballCnt = 0;

            // 스트라이크 개수 찾기
            for(int i = 0; i < 3; i++) if(computerNum.charAt(i) == userSelectNum.charAt(i)) strikeCnt++;

            // 3스트라이크 인 경우 종료
            if(strikeCnt == 3) {
                System.out.println(strikeCnt + "스트라이크");
                break;
            }

            // 볼 개수 찾기
            for(int i = 0; i < 3; i++) if(computerNum.indexOf(String.valueOf(userSelectNum.charAt(i))) > -1) ballCnt++;

            // 볼 개수에서 스트라이크 개수 빼기
            ballCnt -= strikeCnt;

            // 둘 다 0인 경우 아무것도 맞추지 못했으므로 낫싱 출력 후 넘기기
            if(ballCnt == 0 && strikeCnt == 0) {
                System.out.println("낫싱");
                continue;
            }

            // 둘 중 하나라도 개수가 0이라면 한가지 문구만 출력 후 넘기기
            if(ballCnt == 0 || strikeCnt == 0) {
                System.out.println(strikeCnt == 0 ? ballCnt + "볼" : strikeCnt + "스트라이크");
                continue;
            }

            // 둘 다 존재하는 경우 x볼 x스트라이크 출력
            System.out.println(ballCnt + "볼 " + strikeCnt + "스트라이크");
        }
    }

    private static String getThreeRandomNum() {
        String computer = "";

        while(computer.length() < 3) {
            String randomNumber = String.valueOf(Randoms.pickNumberInRange(1, 9));
            if (!computer.contains(randomNumber)) computer += randomNumber;
        }

        return computer;
    }

    private static String printMsgAndReadNum(String msg, int len, boolean isSameCheck, boolean isEnter) {
        System.out.print(msg + (isEnter ? "\n" : ""));
        String userGameSelectNum = Console.readLine();

        // 입력받은 숫자가 글자 수가 다르거나 숫자 이외의 문자가 섞여있다면 에러
        if(!(userGameSelectNum.matches(NUM_REG) && userGameSelectNum.length() == len)) throw new IllegalArgumentException();

        // 같은 숫자가 입력되어 있는지 확인 후 같다면 에러를 던질 수 있도록 구현
        if(isSameCheck) sameNumCheck(userGameSelectNum);

        return userGameSelectNum;
    }

    public static void sameNumCheck(String userGameSelectNum) {
        for (int i = 0; i < userGameSelectNum.length(); i++) {
            String nowNum = String.valueOf(userGameSelectNum.charAt(i));
            int cutNumLen = userGameSelectNum.replace(nowNum, "").length();
            if(cutNumLen != 2) throw new IllegalArgumentException();
        }
    }

}
