package baseball;
import camp.nextstep.edu.missionutils.Randoms;

public static boolean isUniqueThreeDigitNumber(int number) {
    if (number < 100 || number > 999) {
    return false;
    }
    int digit1 = number % 10;
    int digit2 = (number / 10) % 10;
    int digit3 = (number / 100) % 10;
    return digit1 != digit2 && digit2 != digit3 && digit1 != digit3;
}
public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");

        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        List<Interger> user = new ArrayList<>();

        System.out.print("숫자를 입력해주세요 : ");

        int number = scanner.nextInt();

        if (isUniqueThreeDigitNumber(number)) {
            String numStr = String.valueOf(number);

            char[] digits = numStr.toCharArray();

            for (int i = 0; i < digits.length; i++) {
                user[i] = Character.getNumericValue(digits[i]);
            }
        }
        else {
            System.out.println("잘못된 입력으로 숫자 야구 게임을 종료합니다.");
            return;
        }

        int strike = 0;
        int ball = 0;
        boolean nothing = true;

        for (int i = 0 ; i < 3 ; i++) {
            if (computer[i] == user[i]) {
                strike++;
                nothing = false;
            }
            else {
                if (Arrays.asList(computer).contains(user[i])) {
                    ball++;
                    nothing = false;
                }
            }
    }
}
