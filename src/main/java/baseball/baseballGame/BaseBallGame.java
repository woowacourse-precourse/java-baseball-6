package baseball.baseballGame;

import camp.nextstep.edu.missionutils.Randoms;

public class BaseBallGame {
    private int cnt; // 맞춰야 할 숫자의 개수
    private int computerNum; // 컴퓨터가 선택한 숫자
    private boolean flag = true; // 게임 종료 확인 위한 변수
    PrintConsole print = new PrintConsole(); // 콘솔 출력 위한 참조변수
    CompareNum compareNum = new CompareNum(); // 숫자 비교 위한 참조변수
    CheckValidNum checkNum = new CheckValidNum(); // 사용자 입력 숫자 유효성 확인 위한 참조변수

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
        computerNum = 0;
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
        while (flag) {
            int num = print.printInput();

            checkNum.check(num); // 사용자가 올바른 숫자 입력했는지 확인
            print.printOutput(compareNum.compare(this.computerNum, num)); // 숫자 비교해서 결과 출력

            if (this.computerNum == num) { // 숫자 맞추면 게임 종료
                int result = end();
                if (result == 1) { // 재시작
                    start();
                } else if (result == 2) { // 종료
                    return;
                }
            }
        }
    }

    // 숫자 야구 게임 종료
    public int end() {
        print.printEnd();

        int num = print.input();
        // 게임 종료 시 1 또는 2만 입력 받기
        if (num == 1) { // 게임 재시작
            return 1;
        } else if (num == 2) { // 게임 종료
            flag = false;
            return 2;
        } else { // 예외 발생
            throw new IllegalArgumentException();
        }
    }


}
