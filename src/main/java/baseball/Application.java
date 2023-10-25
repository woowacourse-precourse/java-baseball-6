package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {

    // 임의의 수 3가지 부여 기능
    static List<Integer> getRandomNumbers() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        return computer;
    }

    // 사용자 숫자 입력 기능
    static List<Integer> getInputNumbers() {
        List<Integer> clientNumbers = new ArrayList<>();

        String number = Console.readLine();
        for(int idx=0; idx<number.length(); idx++)
            clientNumbers.add(Character.getNumericValue(number.charAt(idx)));

        return clientNumbers;
    }

    // 낫싱 판단
    static void checkNoting(List<Integer> randomNumbers, List<Integer> guessNumbers, List<Integer> numberCheckCount) {

        for (int idx = 0; idx < 3; idx++) {
            int checkNumber = guessNumbers.get(idx);
            if (randomNumbers.contains(checkNumber)) {
                numberCheckCount.add(0);
                return;
            }
        }

        numberCheckCount.add(1);
    }

    // 4.볼 판단
    static void checkBall(List<Integer> randomNumbers, List<Integer> guessNumbers, List<Integer> numberCheckCount) {

        int ballCount = 0;

        for (int idx = 0; idx < 3; idx++) {
            int checkNumber = guessNumbers.get(idx);

            if (randomNumbers.contains(checkNumber) && checkNumber != randomNumbers.get(idx)) {
                ballCount += 1;
            }
        }

        numberCheckCount.add(ballCount);
    }

    // 5.스트라이크 판단
    static void checkStrike(List<Integer> randomNumbers, List<Integer> guessNumbers, List<Integer> numberCheckCount) {

        int strikeCount = 0;

        for (int idx = 0; idx < 3; idx++) {
            int checkNumber = guessNumbers.get(idx);
            if (randomNumbers.contains(checkNumber) && checkNumber == randomNumbers.get(idx)) {
                strikeCount += 1;
            }
        }

        numberCheckCount.add(strikeCount);
    }

    // 6.숫자 판단 결과
    static int getNoticeResult(List<Integer> numberCheckCount) {

        // 각 결과 수
        int nCount = numberCheckCount.get(0);
        int bCount = numberCheckCount.get(1);
        int sCount = numberCheckCount.get(2);

        String noticeResult = "";

        // 낫싱인 경우
        if (nCount == 1) {
            System.out.println("낫싱");
            return -1;
        }

        // 볼이 있는 경우
        if (bCount > 0) {
            noticeResult = bCount + "볼" + " ";
        }

        // 스트라이크가 있는 경우
        if (sCount > 0) {
            noticeResult = noticeResult + sCount + "스트라이크";
            System.out.println(noticeResult);

            // 모두 맞힌 경우
            if (sCount == 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                return 1;
            }
        }

        System.out.println(noticeResult);
        return -1;
    }

    public static void main(String[] args) {

        // 임의의 수 3가지, 사용자 입력 수, 판단 리스트
        List<Integer> randomNumbers;
        List<Integer> guessNumbers;
        List<Integer> numberCheckCount;

        // 게임 시작 문구 출력
        System.out.println("숫자 야구 게임을 시작합니다.");

        // 임의의 수 3가지 부여
        randomNumbers = getRandomNumbers();

        // 숫자 입력 문구 출력
        System.out.print("숫자를 입력해주세요 : ");

        // 사용자 숫자 입력
        try {
            guessNumbers = getInputNumbers();
        }
        catch (IllegalArgumentException e) {
            return;
        }

        // 숫자 판단 기능
        numberCheckCount = new ArrayList<>();

        // - 낫싱 판단
        checkNoting(randomNumbers, guessNumbers, numberCheckCount);
        // - 볼 판단
        checkBall(randomNumbers, guessNumbers, numberCheckCount);
        // - 스트라이크
        checkStrike(randomNumbers, guessNumbers, numberCheckCount);
        // - 숫자 판단 결과 함수 호출
        getNoticeResult(numberCheckCount);
    }
}
