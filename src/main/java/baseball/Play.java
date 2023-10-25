package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Play {
    public Boolean play() {
        int strike = 0;                             // 스트라이크 개수
        int ball = 0;                               // 볼 개수
        String[] comRandomNumberArr = comNumber();  // 컴퓨터가 랜덤으로 생성한 번호
        boolean gameAgain = true;                   // 게임 지속 여부

        while (gameAgain) {                         // 게임 1턴씩 반복 수행
            System.out.print("숫자를 입력해주세요 : ");
            String[] userNumberArr = userNumer().split("");            // 사용자 입력값 배열에 초기화
            strike = strikeCount(comRandomNumberArr, userNumberArr);        // 스트라이크 개수 카운트
            ball = ballCount(comRandomNumberArr, userNumberArr);            // 볼 개수 카운트

            if (strike == 3) {
                System.out.println("3스트라이크");
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                String playAgain = Console.readLine();
                if (playAgain.equals("1")) {
                    comRandomNumberArr = comNumber();           // 게임 재시작시 컴퓨터 번호 새로 생성
                    gameAgain = true;
                } else if (playAgain.equals("2")) {
                    gameAgain = false;
                } else {
                    throw new IllegalArgumentException();
                }
            } else if (strike == 0 && ball != 0) {
                System.out.println(ball + "볼");
            } else if (strike != 0 && ball != 0) {
                System.out.println(ball + "볼 " + strike + "스트라이크");
            } else if (strike != 0 && ball == 0) {
                System.out.println(strike + "스트라이크");
            } else if (strike == 0 && ball == 0) {
                System.out.println("낫싱");
            }
            strike = 0;
            ball = 0;
        }
        return false;
    }

    public String[] comNumber() {           // 컴퓨터 랜덤 번호 생성 메소드
        String[] comRandomNumberArr = new String[3];
        for (int i = 0; i < 3; i++) {
            comRandomNumberArr[i] = String.valueOf(Randoms.pickNumberInRange(1,9));
            if (i == 1) {
                while (true) {              // 첫번째 인덱스의 숫자와 중복되지 않을 때까지 반복
                    if (comRandomNumberArr[0].equals(comRandomNumberArr[i])) {
                        comRandomNumberArr[i] = String.valueOf(Randoms.pickNumberInRange(1,9));
                    } else {
                        break;
                    }
                }
            } else if (i == 2) {
                while (true) {              // 첫번째 인덱스의 숫자, 두번째 인덱스의 숫자와 중복되지 않을 때까지 반복
                    if (comRandomNumberArr[0].equals(comRandomNumberArr[i]) || comRandomNumberArr[1].equals(comRandomNumberArr[i])) {
                        comRandomNumberArr[i] = String.valueOf(Randoms.pickNumberInRange(1,9));
                    } else {
                        break;
                    }
                }
            }
        }
        return comRandomNumberArr;          // 생성된 번호 리턴
    }

    public String userNumer() {
        String userNumber = Console.readLine();        // 사용자 입력값

        if (userNumber.length() != 3) {         // 3자리만 입력 가능
            throw new IllegalArgumentException("3자리의 숫자를 입력해주세요");
        } else if (userNumberCheck(userNumber)) { // 중복 숫자 검증 로직
            throw new IllegalArgumentException("중복되지 않은 숫자를 입력해주세요");
        } else if ( userNumber.contains("0")) { // 0 입력 불가
            throw new IllegalArgumentException("1~9까지의 수 3자리를 입력하세요.");
        }
        return userNumber;
    }

    public boolean userNumberCheck(String userNumber) {         // 사용자의 입력값에 중복된 숫자 있으면 true
        String[] number = userNumber.split("");

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == j) continue;
                if (number[i].equals(number[j])) {
                    return true;
                }
            }
        }
        return false;
    }

    public int strikeCount(String[] comRandomNumberArr, String[] userNumberArr) {   // 스트라이크 개수 카운트
        int strike = 0;

        for (int i = 0; i < comRandomNumberArr.length; i++) {
            if (userNumberArr[i].equals(comRandomNumberArr[i])) strike++;
        }
        return strike;
    }

    public int ballCount(String[] comRandomNumberArr, String[] userNumberArr) {     // 볼 개수 카운트
        int ball = 0;

        for (int i = 0; i < comRandomNumberArr.length; i++) {
            for (int j = 0; j < userNumberArr.length; j++) {
                if (userNumberArr[i].equals(comRandomNumberArr[j])) {
                    if (i == j) continue;
                    ball++;
                }
            }
        }
        return ball;
    }
}
