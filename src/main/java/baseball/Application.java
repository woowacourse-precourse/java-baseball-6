package baseball;
import  camp.nextstep.edu.missionutils.*;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        int[] ComputerNumber = generateComputerNumber();

        int[] UserNumArr = convertStringToIntArray(inputUserNumber());

        for (int number : UserNumArr) {
            System.out.print(number);
        }
        System.out.println();

    }


    private static int[] generateComputerNumber() {
        int[] computerNumber = new int[3];

        for (int i = 0; i < 3; i++) {
            computerNumber[i] = Randoms.pickNumberInRange(1, 9);
        }

        return computerNumber;
    }


    private static String inputUserNumber() {
        System.out.print("숫자를 입력해주세요 : ");

        String UserNum = Console.readLine();

        return UserNum;
    }

    private static int[] convertStringToIntArray(String input) {
        int[] result = new int[input.length()];
        for (int i = 0; i < input.length(); i++) {
            char digit = input.charAt(i);
            result[i] = Character.getNumericValue(digit);
        }
        return result;
    }
}
