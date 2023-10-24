package baseball.baseballGame;

import camp.nextstep.edu.missionutils.Randoms;
import org.mockito.internal.stubbing.answers.ThrowsException;

public class BaseBallGame {
    private int cnt; // 맞춰야 할 숫자의 개수
    private int computerNum; // 컴퓨터가 선택한 숫자
    PrintConsole print = new PrintConsole(); // 콘솔 출력 위한 참조변수
    CompareNum compareNum = new CompareNum(); // 숫자 비교 위한 참조변수

    public BaseBallGame() {
    }

    public BaseBallGame(int cnt) {
        this.cnt = cnt;
    }

    public int getCnt() {
        return cnt;
    }

    public int getComputerNum() {
        return computerNum;
    }

    // 랜덤한 숫자 생성
    public void init() {
        int tmp = 0; // 현재 선택한 숫자 개수
        boolean[] ch = new boolean[10]; // 중복된 숫자 체크 위한 배열

        // cnt 만큼 숫자 선택해서 세 자자리수 숫자로 저장
        while (tmp < cnt) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!ch[randomNumber]) {
                ch[randomNumber] = true;
                computerNum *= 10;
                computerNum += randomNumber;
                tmp++;
            }
        }
    }

    // 숫자 야구 게임 시작
    public void start() {
        init();

        print.printStart();
        while (true) {
            int num = print.printInput();
            print.printOutput(compareNum.compare(this.computerNum, num));

            if (this.computerNum == num) {
            }


        }
    }



    // 컴퓨터 숫자와 사용자 입력 숫자 비교
    private void check(int num) {

    }
}
