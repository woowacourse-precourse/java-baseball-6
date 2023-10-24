package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Creator {

    // 컴퓨터 숫자 생성 메서드
    public static int[] getComputer() {
        int[] result = new int[3];
        for (int i = 0; i < 3; i++) {
            result[i] = Randoms.pickNumberInRange(1, 9);
        }
        return result;
    }

    // 사용자 숫자 입력 메서드
    public static int[] getUser() {
        int[] user = new int[3];
        System.out.print("숫자를 입력해주세요 : ");
        try {
            String num = Console.readLine();
            for (int i = 0; i < user.length; i++) {
                user[i] = Character.getNumericValue(num.charAt(i));
            }
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
        return user;
    }
}