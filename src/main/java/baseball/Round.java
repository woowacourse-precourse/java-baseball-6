package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Round {

    private List<Integer> comNum;
    private List<Integer> userNum;
    private int strike;
    private int ball;

    public Round() {
        resetComNum();
    }

    // 숫자 야구 게임을 새로 시작할 때, 컴퓨터가 무작위로 1부터 9 사이에서 중복되지 않는 3개의 숫자를 선택하는 메서드
    public void resetComNum() {
        comNum = new ArrayList<>();
        while (comNum.size() < 3) {
            int randomNum = Randoms.pickNumberInRange(1, 9);
            if (!comNum.contains(randomNum)) {
                comNum.add(randomNum);
            }
        }
    }

    public boolean gameplay() {
        while (strike != 3) {
            System.out.println("세 자리 숫자를 입력해주세요 : ");
            String userInput = Console.readLine();

            this.userNum = makeList(userInput);
            verifyUserNum();
            compareNumbers();
            System.out.println(compareNumbersResult());
        }
        return endCheck();
    }

    // 사용자 입력 문자열을 받아서 숫자 리스트로 변환하는 메서드
    public List<Integer> makeList(String userInput) {
        String[] arrayInput = userInput.split("");
        List<Integer> userNumbers = new ArrayList<>();

        for (int i = 0; i < userInput.length(); i++) {
            userNumbers.add(Integer.parseInt(arrayInput[i]));
        }
        return userNumbers;
    }


    // 사용자의 입력숫자가 유효한지 확인하는 메소드
    public void verifyUserNum() {
        if (userNum.size() != 3) {
            throw new IllegalArgumentException("잘못 입력하셨습니다. 세자리 숫자를 입력해주세요.");
        }
        if (userNum.contains(0)) {
            throw new IllegalArgumentException("잘못 입력하셨습니다. 0을 제외한 숫자를 입력해주세요.");
        }
        Set<Integer> userNumSet = new HashSet<>(userNum);
        if (userNumSet.size() != 3) {
            throw new IllegalArgumentException("잘못 입력하셨습니다. 세자리 숫자에는 중복된 숫자를 사용할 수 없습니다.");
        }
    }

    // comNum,userNum을 비교하여, 스트라이크와 볼을 계산하는 메서드
    public void compareNumbers() {
        this.strike = 0;
        this.ball = 0;
        for (int i = 0; i < userNum.size(); i++) { // comNum=[1,3,5], userNum=[1,2,7] -> 1스트라이크
            if (comNum.get(i) == userNum.get(i)) {
                strike++;
                continue;
            }
            if (comNum.contains(userNum.get(i))) {
                ball++;
            }
        }
    }

    // 비교된 스트라이크와 볼의 수에 따라 결과를 반환
    public String compareNumbersResult() {
        if ((ball != 0) && (strike != 0)) {
            return (ball + "볼" + " " + strike + "스트라이크");
        }
        if (ball == 0 && strike != 0) {
            return (strike + "스트라이크");
        }
        if (ball != 0 && strike == 0) {
            return (ball + "볼");
        }
        return ("낫싱");
    }

    public boolean endCheck() { // 메서드명 endCheck
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        String reinput = Console.readLine();
        if (reinput.equals("1")) {
            return true; // 계속할게요
        }
        if (reinput.equals("2")) {
            return false; // 그만할게요
        }
        throw new IllegalArgumentException("잘못된 숫자입니다. 1 또는 2를 입력하세요.");
    }
}