package baseball;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;


public class Application {
    public static void main(String[] args) throws IllegalArgumentException {

        String inputNumber;
        int[] inputNumber2Array = new int[3];
        int[] randomNumber = new int[3];
        int strikes = 0;
        int balls = 0;

        for (int i = 0; i < 3; i++) {
            randomNumber[i] = Randoms.pickNumberInRange(1, 9);
        }

        System.out.println("숫자 야구 게임을 시작합니다. ");
        System.out.print("숫자를 입력해주세요 : ");
        inputNumber = Console.readLine();

        if (inputNumber.length() != 3) {
            throw new IllegalArgumentException();
        }

        for( int i = 0; i < 3; i++ ) {

            inputNumber2Array[i] = inputNumber.charAt(i) - '0';
        }

        for (int i = 0; i < 3; i++) {
            System.out.print(inputNumber2Array[i]+" ");
            System.out.println(randomNumber[i]);
            if (inputNumber2Array[i] == randomNumber[i]) {
                strikes++;
            } else if (contains(randomNumber, inputNumber2Array[i])) {
                balls++;
            }
        }

        if (strikes > 0 && balls == 0) {
            System.out.println(strikes + "스트라이크");
        } else if (balls > 0 && strikes == 0) {
            System.out.println(balls + "볼");
        } else if (strikes > 0 && balls > 0){
            System.out.print(balls + "볼 ");
            System.out.println(strikes + "스트라이크");
        } else {
            System.out.print("낫싱");
        }
    }

    private static boolean contains(int[] array, int num) {
        for (int i : array) {
            if (i == num) {
                return true;
            }
        }
        return false;
    }

}
