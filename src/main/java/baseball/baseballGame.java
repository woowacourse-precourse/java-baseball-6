package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class baseballGame {
    // 생성된 컴퓨터 숫자를 저장하는 ArrayList
    ArrayList<Integer> computerNumber = new ArrayList<>();
    // 입력받은 사용자 숫자를 저장하는 ArrayList
    ArrayList<Integer> userNumber = new ArrayList<>();
    // 볼, 스트라이크 개수
    int b, s;

    // 컴퓨터 숫자 생성
    public void computerNumberArrList() {
        computerNumber.clear();
        while (computerNumber.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumber.contains(randomNumber)) {
                computerNumber.add(randomNumber);
            }
        }
    }

    // 사용자 숫자 입력
    public void userNumberArrList(String strUserInput) throws IllegalArgumentException {
        userNumber.clear();
        // String strUserNumber = Console.readLine();
        String[] strUserNumberArr = strUserInput.split("");

        userNumberException(strUserInput);

        // 입력 받은 문자열 사용자 번호를 정수형으로 형변환
        ArrayList<String> strUserNumberArrList = new ArrayList<String>(Arrays.asList(strUserNumberArr));
        for (int j = 0; j < 3; j++) {
            userNumber.add(Integer.parseInt(strUserNumberArrList.get(j)));
        }
    }

    // 사용자 숫자 입력 시 예외처리
    public void userNumberException(String strUserInput) throws IllegalArgumentException {
        String[] strUserNumberArr = strUserInput.split("");
        // 3자리의 수가 아닐 때
        if (strUserNumberArr.length != 3) {
            throw new IllegalArgumentException();
        }
        // 입력받은 값이 정수가 아닐 때
        for (int i = 0; i < strUserNumberArr.length; i++) {
            try {
                Integer.parseInt(strUserNumberArr[i]);
            } catch (IllegalArgumentException ex) {
                throw new IllegalArgumentException();
            }
        }
        // 입력받은 수에 0이 포함될 때
        for (int j = 0; j < strUserNumberArr.length; j++) {
            if (Integer.parseInt(strUserNumberArr[j]) == 0) {
                throw new IllegalArgumentException();
            }
        }
        // 서로 다른 수가 아닐 때
        ArrayList<String> strUserNumberArrList = new ArrayList<String>(Arrays.asList(strUserNumberArr));
        Set<String> strUserNumberArrSet = new HashSet<>(strUserNumberArrList);

        if (strUserNumberArrSet.size() != strUserNumberArrList.size()) {
            throw new IllegalArgumentException();
        }
    }

    // 스트라이크와 볼의 개수 확인
    public void getStrikeAndBall() {
        b = 0;
        s = 0;
        for (int i = 0; i < 3; i++) {
            if (userNumber.get(i).equals(computerNumber.get(i))) {
                s += 1;
            } else if (computerNumber.contains(userNumber.get(i))) {
                b += 1;
            }
        }
    }

    // 입력한 수에 대한 결과를 볼, 스트라이크로 출력
    public void printStrikeAndBall() {
        if (s == 3) {
            System.out.printf("3스트라이크%n3개의 숫자를 모두 맞히셨습니다! 게임 종료%n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.%n");
        } else if (b == 0 & s == 0) {
            System.out.printf("낫싱%n");
        } else if (b != 0 & s != 0) {
            System.out.printf("%d볼 %d스트라이크%n", b, s);
        } else if (b != 0 & s == 0) {
            System.out.printf("%d볼%n", b);
        } else if (b == 0 & s != 0) {
            System.out.printf("%d스트라이크%n", s);
        }
    }

    // 3스트라이크가 되었을 때 입력 시 예외처리
    public String restartOrQuit(String continueOrStop) throws IllegalArgumentException {
        String[] continueOrStopArr = continueOrStop.split("");

        // 입력값이 한자리가 아닐 때
        if (continueOrStopArr.length != 1) {
            throw new IllegalArgumentException();
        }

        // 입력한 값이 정수가 아닐 때
        try {
            Integer.parseInt(continueOrStopArr[0]);
        } catch (IllegalArgumentException ex) {
            throw new IllegalArgumentException();
        }

        // 입력한 한자리 정수가 1 또는 2가 아닐 때
        if (Integer.parseInt(continueOrStopArr[0]) != 1 && Integer.parseInt(continueOrStopArr[0]) != 2) {
            throw new IllegalArgumentException();
        }
        return continueOrStop;
    }
}