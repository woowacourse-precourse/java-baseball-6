package baseball;

import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    private static String randomNumber;

    public static void main(String[] args) throws IllegalArgumentException {
        //TODO: 숫자 야구 게임 구현

    }

    public static String makeRandomNumber() {
        String randomNumber= "";
        while (randomNumber.length() < 3) {
            String n = String.valueOf(Randoms.pickNumberInRange(1,10));
            if (!randomNumber.contains(n))
                randomNumber += n;
        }
        return randomNumber;
    }



}