package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
// 기능목록
//
//  게임 준비
//      "숫자 야구 게임을 시작합니다." 문구 출력
//      서로 다른 3가지 숫자 주어진 랜덤 함수로 뽑아오기
//
//  게임 시작(사용자가 맞힐 때 까지 반복)
//      사용자로 부터 서로 다른 3자리 숫자를 입력 받는다.
//      만약 3자리가 아니거나 숫자만 있지 않거나 서로 다르지 않다면 IllegalArgumentException 에러 발생
//      이때 "숫자를 입력해주세요 : " 문구를 줄바꿈 없이 출
//      입력된 값의 스트라이크, 볼의 갯수를 계산
//      같은 자리수를 비교해 스트라이크 카운트, indexOf를 이용하여 볼 카운트
//      볼 - 스트라이크 = 실제 볼 수
//      스트라이크만 존재한다면 x스트라이크 출력
//      볼 만 존재한다면 x볼 출력
//      볼, 스트라이크가 같이 존재한다면 x볼 x스트라이크 출력
//      볼, 스트라이크가 존재하지 않는다면 낫싱 출력
//
//  사용자 정답
//      정답 시 "3개의 숫자를 모두 맞히셨습니다! 게임 종료" 문구 출력 후
//      "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요." 출력해 게임 지속여부 확인
//      만약 숫자가 아니거나 숫자 1 혹은 2가 아니거나 1글자를 넘어서면 IllegalArgumentException 에러 발생

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
        else if(
            !(userGameSelectNum.equals("1")
            || userGameSelectNum.equals("2"))
        ) throw new IllegalArgumentException();

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