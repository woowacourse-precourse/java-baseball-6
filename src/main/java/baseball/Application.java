package baseball;

import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    private static String randomNumber;
    private static String inputNumber;

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

    public static int calculateStrikeCount() {
        int cnt = 0;
        for (int i = 0; i < 3; i++) {
            if(randomNumber.charAt(i) == inputNumber.charAt(i))
                cnt++;
        }
        return cnt;
    }

}