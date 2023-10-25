package baseball.service;

import baseball.model.BaseBallNumber;
import baseball.model.BaseBallResult;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;

public class BaseBallGameService {

    private final Integer numberSize;

    public BaseBallGameService(Integer numberSize) {
        this.numberSize = numberSize;
    }

    /**
     * 야구 게임 시작
     */
    public void gameStart() {
        printStartNotice();
        while (true) {
            playGame();

            //재시작 여부 확인
            printRestartNotice();
            if (!isRestartGame()) {
                break;
            }
        }
    }

    /**
     * 야구 게임 진행
     */
    private void playGame() {
        //숫자 생성
        BaseBallNumber computerNum = initComputerNum();

        //게임 진행
        while (true) {
            printUserInputNotice();
            BaseBallNumber userNum = initUserNum();
            BaseBallResult gameResult = userNum.compareNumber(computerNum);
            printGameResult(gameResult);
            if (isGameFinish(gameResult)) {
                printGameResult();
                break;
            }
        }
    }

    /**
     * 컴퓨터 숫자 생성
     *
     * @return BaseBallNumber 컴퓨터 생성 숫자
     */
    private BaseBallNumber initComputerNum() {
        ArrayList<Integer> computerNums = new ArrayList<>();
        int number[] = new int[10];
        for (int i = 0; i < numberSize; i++) {
            int num = Randoms.pickNumberInRange(1, 9);
            if (number[num] == 1) {
                num = Randoms.pickNumberInRange(1, 9);
            }
            number[num] = 1;
            computerNums.add(num);

        }

        return new BaseBallNumber(computerNums);
    }

    /**
     * 사용자 숫자 생성(입력)
     *
     * @return BaseBallNumber 사용자 숫자
     */
    private BaseBallNumber initUserNum() {
        String userInput = Console.readLine();
        int userInputNum = 0;
        try {
            userInputNum = Integer.parseInt(userInput);
            int min = makeSqrt(10, numberSize - 1);
            int max = makeSqrt(10, numberSize);

            if (userInputNum >= max || userInputNum < min) {
                throw new IllegalArgumentException();
            }
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }

        ArrayList<Integer> userInputNums = divideIntByTen(userInputNum);
        if (!isAllDiffNumber(userInputNums)) {
            throw new IllegalArgumentException();
        }
        return new BaseBallNumber(userInputNums);
    }

    boolean isAllDiffNumber(ArrayList<Integer> nums) {
        int number[] = new int[10];
        for (int i : nums) {
            if (number[i] != 0) {
                return false;
            }
            number[i] = 1;
        }
        return true;
    }

    /**
     * a의 b제곱 만들기
     */
    private int makeSqrt(int a, int b) {
        int result = 1;
        for (int i = 0; i < b; i++) {
            result *= a;
        }
        return result;
    }

    private ArrayList<Integer> divideIntByTen(int num) {
        ArrayList<Integer> nums = new ArrayList<>();
        while (num > 0) {
            nums.add(num % 10);
            num /= 10;
        }
        Collections.reverse(nums); //앞자리부터 저장하기 위함
        return nums;
    }

    /**
     * 게임 종료 여부 확인
     *
     * @param result BaseBallResult
     * @return true:  정답, 게임 끝남, false: 정답 못맞춤
     */
    private boolean isGameFinish(BaseBallResult result) {
        if (result.strike().equals(3)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 게임 재시작 여부 확인
     *
     * @return true: 재시작, false: 종료
     */
    private boolean isRestartGame() {
        String userInput = Console.readLine();
        try {
            int userInputNum = Integer.parseInt(userInput);

            if (userInputNum == 1) {
                return true;
            } else if (userInputNum == 2) {
                return false;
            } else {
                throw new IllegalArgumentException();
            }

        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }

    private void printUserInputNotice() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    private void printGameResult(BaseBallResult result) {
        if (result.ball().equals(0) && result.strike().equals(0)) {
            System.out.println("낫싱");
            return;
        }
        if (result.ball() > 0) {
            System.out.print(result.ball().intValue() + "볼 ");
            if (result.strike() == 0) {
                System.out.println();
            }
        }
        if (result.strike() > 0) {
            System.out.println(result.strike().intValue() + "스트라이크");
        }
    }

    private void printGameResult() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    private void printRestartNotice() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    private void printStartNotice() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }
}
