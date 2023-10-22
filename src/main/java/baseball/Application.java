package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class Application {
    static int inputNumber;
    static int retry = 1;
    static final int NUMBER_DIGIT = 3;
    static List<Integer> computerNumber;
    static BufferedReader br;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        while (retry == 1) {
            //게임 실행
            basebell();

            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

            retry = Integer.parseInt(br.readLine());

            if (retry == 2) {
                break;
            }
        }
    }

    private static void basebell() throws IOException {
        System.out.println("숫자 야구 게임을 시작합니다.");

        //컴퓨터 숫자를 생성한다
        createComputerNumber();

        //디버깅용
//        for (int i = 0; i < computerNumber.size(); i++) {
//            System.out.println(computerNumber.get(i));
//        }

        while (true) {
            //입력을 받는다
            System.out.print("숫자를 입력해주세요 : ");
            inputNumber = Integer.parseInt(br.readLine());

            //입력 값에 대한 조건을 검증한다
            if (checkNumberDigits(inputNumber)) {
                throw new IllegalArgumentException();
            }
            //checkEachDigitIsSameNumber(inputNumber);
            //checkNumberRange(inputNumber);

            //컴퓨터 숫자를 int 배열로 표현하도록 바꾼다
            int[] intArrayComputerNumber = listTransformToIntArray(computerNumber);

            //입력 숫자를 int 배열로 표현하도록 바꾼다
            int[] intArrayInputNumber = getDigitsArray(inputNumber);

            //두 배열 비교
            int strike = 0;
            int ball = 0;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (intArrayInputNumber[i] == intArrayComputerNumber[j]) {
                        if (i == j) {
                            strike++;
                            continue;
                        }
                        ball++;
                    }
                }
            }

            if (strike == 3) {
                break;
            }
            if (ball == 0 && strike == 0) {
                System.out.println("낫싱");
                continue;
            }
            if (ball == 0) {
                System.out.println(strike + "스트라이크");
                continue;
            }
            if (strike == 0) {
                System.out.println(ball + "볼");
                continue;
            }
            System.out.println(ball + "볼 " + strike + "스트라이크");
        }
    }


    /***
     * 입력 값이 세 자리 수인지 검증한다
     *
     * @param number
     */
    public static boolean checkNumberDigits(int number) {
        int numberOfDigits = String.valueOf(number).length();
        if (numberOfDigits != 3) {
            return true;
        }
        return false;
    }


    /***
     * 각 자리의 숫자가 서로 다른 숫자인지 검증한다 - 작동 안함
     *
     * @param number
     */
    private static void checkEachDigitIsSameNumber(int number) {
        int[] intArrayNumber = getDigitsArray(number);

        if (areAllDistinct(intArrayNumber)) {
            throw new IllegalArgumentException("각 자리에 중복인 숫자가 있습니다.");
        }
    }


    /***
     * 입력 값의,각 자리의 범위를 검증한다
     *
     * @param Number
     */
    private static void checkNumberRange(int Number) {
        int[] intArrayInputNumber = getDigitsArray(Number);

        for (int n : intArrayInputNumber) {
            checkNumberValidity(n, 1, 9);
        }
    }


    /***
     * 파라메터가 low~high 사이의 숫자인지 검증한다
     *
     * @param number
     */
    private static void checkNumberValidity(int number, int low, int high) {
        if (number > high || number < low) {
            throw new IllegalArgumentException(low + "에서" + high + " 사이의 숫자만 입력 가능합니다.");
        }
    }


    /***
     * 컴퓨터 숫자를 생성하는 함수
     */
    private static void createComputerNumber() {
        computerNumber = new ArrayList<>();
        while (computerNumber.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            addNotExistNumberToList(computerNumber, randomNumber);
        }
    }


    private static void addNotExistNumberToList(List<Integer> numberList, int number) {
        if (!isAlreadyInList(numberList, number)) {
            addNumberToList(numberList, number);
        }
    }

    private static void addNumberToList(List<Integer> numberList, int number) {
        numberList.add(number);
    }


    private static boolean isAlreadyInList(List<Integer> numberList, int number) {
        if (numberList.contains(number)) {
            return true;
        }
        return false;
    }

    /***
     * 컴퓨터 숫자를 List에서 Char 배열로 타입변환 하는 함수.
     *
     */
    private static int[] listTransformToIntArray(List<Integer> number) {
        int[] intArrayNumber = new int[NUMBER_DIGIT];

        for (int i = 0; i < NUMBER_DIGIT; i++) {
            {
                intArrayNumber[i] = number.get(i);
            }
        }
        return intArrayNumber;
    }

    /***
     * 파라메터의 각 자리에 있는 수를 배열에 담아 반환한다.
     *
     * @param number
     * @return 각 자리의 수를 담은 배열을 반환한다.
     */
    private static int[] getDigitsArray(int number) {
        int[] intArrayNumber = new int[NUMBER_DIGIT];

        for (int i = NUMBER_DIGIT - 1; i >= 0; i--) {
            intArrayNumber[i] = number % 10;
            number /= 10;
        }

        return intArrayNumber;
    }


    /***
     * 배열 내에 중복되는 수가 있는지 확인한다
     *
     * @param arr
     * @return
     */
    public static boolean areAllDistinct(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    return false;
                }
            }
        }
        return true;
    }
}

