package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;

public class Game {
    ArrayList<Integer> computerNums;
    int strike = 0;
    int ball = 0;

    /**
     * 게임 시작 함수
     */
    public void startGame() {
        boolean isStartRound = true;
        while(isStartRound) {
            // 컴퓨터가 가진 수 알아내기
            computerNums = getComputerNums();

            System.out.println("숫자 야구 게임을 시작합니다.");

            isStartRound = startRoundGame();
        }
    }

    /**
     * 게임 라운드 시작 함수
     * 게임의 전체 흐름과 입출력 실행
     * @return 게임 진행 여부
     */
    public boolean startRoundGame() {
        // 숫자 입력 반복
        while (true) {
            // 스트라이크, 볼 개수 초기화
            strike = 0;
            ball = 0;

            // 사용자 숫자 입력
            System.out.print("숫자를 입력해주세요 : ");
            int input = Integer.parseInt(Console.readLine());
            // 예외 확인
            checkException(1, input);

            // 볼이나 스트라이크 판단
            boolean isIncluding = checkIncluding(input);

            // 낫싱 상태 (볼 X, 스트라이크 X)
            if (!isIncluding) {
                System.out.print("낫싱");
            }
            else {
                // 게임 성공 -> 게임 라운드 종료
                if (strike == 3) {
                    System.out.println("3스트라이크");
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");

                    // 게임 진행 입력 및 예외 확인
                    System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                    int nextGame = Integer.parseInt(Console.readLine());
                    // 예외 확인
                    checkException(2, nextGame);

                    // 숫자 입력 : 1인 경우, 게임 재실행 | 2인 경우, 게임 완전히 종료.
                    return nextGame == 1;
                }

                // 출력
                if (ball > 0) {
                    // 볼 개수 출력
                    System.out.print(ball + "볼 ");
                }
                if (strike > 0) {
                    // 스트라이크 개수 출력
                    System.out.print(strike + "스트라이크");
                }
            }
            System.out.println();
        }
    }

    /**
     * 컴퓨터가 가진 수 3개 랜덤하게 정하는 함수
     * @return 3개의 랜덤 수를 포함한 ArrayList
     */
    public ArrayList<Integer> getComputerNums() {
        // 컴퓨터가 가진 수 3개 랜덤하게 정하기 (1~9)
        ArrayList<Integer> computerNums = new ArrayList<>();
        while (computerNums.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNums.contains(randomNumber)) {
                computerNums.add(randomNumber);
            }
        }

        return computerNums;
    }

    /**
     * 입력된 수에서 computerNum에 포함된 수가 있는지 확인하는 함수
     * @param input 입력된 수
     * @return 스트라이크, 볼 포함 여부
     */
    public boolean checkIncluding(int input) {
        // 볼이나 스트라이크가 있는지 판단하는 변수
        boolean isIncluding = false;

        // computer 수에 포함되있는지 확인 (100자리 수, 10자리 수, 1자리 수 순)
        for (int i = 2; i >= 0; i--) {
            int checkNum = input % 10;
            int computerCheck = computerNums.indexOf(checkNum);
            if (computerCheck != -1) {
                // 동일 수가 같은 위치에 있는지 확인
                if (computerCheck == i) {
                    // 같은 위치일 경우, 스트라이크
                    strike++;
                    isIncluding = true;
                }
                else {
                    // 아닐 경우, 볼
                    ball++;
                    isIncluding = true;
                }
            }
            input /= 10;
        }

        return isIncluding;
    }

    /**
     * 입력 예외 처리 함수
     * @param caseNum 어떤 입력인지 case 번호
     * @param input 입력 값
     */
    public void checkException(int caseNum, int input) {
        switch (caseNum) {
            case 1:
                // 100보다 작거나 999보다 클 경우 게임 종료
                if (input > 999 || input < 100)
                    throw new IllegalArgumentException();
                break;
            case 2:
                // 1이나 2가 아닐 경우 게임 완전히 종료.
                if (input != 1 && input != 2)
                    throw new IllegalArgumentException();
        }
    }
}
