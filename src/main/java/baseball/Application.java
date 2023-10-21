package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        System.out.print("숫자를 입력해주세요 : ");

        int strike = 0;
        int ball = 0;
        int nothing = 0;

        String userNumber = "";
        try {
            userNumber = Console.readLine();                                         // 사용자의 입력 숫자
            if (userNumber.length() > 3) {
                throw new IllegalArgumentException("3자리의 숫자를 입력해주세요");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
        //String userNumber = Console.readLine();                                         // 사용자의 입력 숫자
        String comRandomNumber1 = String.valueOf(Randoms.pickNumberInRange(1,9));                         // 컴퓨터의 랜덤 숫자
        String comRandomNumber2 = String.valueOf(Randoms.pickNumberInRange(1,9));
        String comRandomNumber3 = String.valueOf(Randoms.pickNumberInRange(1,9));

        String[] userNumberArr = userNumber.split("");                            // 사용자 숫자 한자리씩 배열에 담기
        String[] comRandomNumberArr = {comRandomNumber1, comRandomNumber2, comRandomNumber3};  // 컴퓨터 숫자 한자리씩 배열에 담기

        for (int i = 0; i < comRandomNumberArr.length; i++) {
            if (userNumberArr[i].equals(comRandomNumberArr[i])) strike++;
        }
        for (int i = 0; i < comRandomNumberArr.length; i++) {
            for (int j = 0; j < userNumberArr.length; j++) {
                if (userNumberArr[i].equals(comRandomNumberArr[j])) {
                    if (i == j) continue;
                    ball++;
                }
            }
        }
        if (strike != 0 && ball == 0) {
            System.out.println(strike + "스트라이크");
        } else if (strike == 0 && ball != 0) {
            System.out.println(ball + "볼");
        } else if (strike != 0 && ball != 0) {
            System.out.println(ball+"볼 "+strike + "스트라이크");
        } else {
            System.out.println("낫싱");
        }
        System.out.println(Arrays.toString(comRandomNumberArr));

    }
}
