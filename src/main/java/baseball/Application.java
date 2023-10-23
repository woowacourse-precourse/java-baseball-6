package baseball;

import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        System.out.println("숫자 야구 게임을 시작합니다.");

        StringBuilder computerNumber = new StringBuilder();
        for(int i = 0; i < 3 ; i++) {
            computerNumber.append(Randoms.pickNumberInRange(1, 9));
        }

        System.out.println(computerNumber);

        // TODO: Input User Expect Number

        // TODO: Compare User Number and Computer Baseball Number

        // TODO: Print Result

        // TODO: Re-game ?

        // TODO: END
    }

}
