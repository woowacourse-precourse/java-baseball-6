package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;


public class Application {
    static int count = 0;
    static final int NUMBER_DIGIT = 3;
    static List<Integer> computerNumber = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        //컴퓨터 숫자를 생성한다
        createComputerNumber();

        //디버깅용
        for (int i = 0; i < computerNumber.size(); i++) {
            System.out.println(computerNumber.get(i));
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            //입력을 받는다
            int inputNumber = Integer.parseInt(br.readLine());

            //입력 값에 대한 조건을 검증한다
            //checkNumberDigits(inputNumber);
            //checkNumberRange(inputNumber);
            //checkEachDigitIsSameNumber(inputNumber);

            //컴퓨터 숫자를 char 배열로 표현하도록 바꾼다
            int[] intArrayComputerNumber = listTransformToIntArray(computerNumber);

            //입력 숫자를 char 배열로 표현하도록 바꾼다
            int[] charArrayInputNumber = getDigitsArray(inputNumber);

            /***
             * 1~9까지의 배열을 하나 만들고 컴퓨터 숫자에 있는 각 자리의 수를 1로 바꾸고,
             * 입력 값에 있는 각 자리의 수를 배열에서 1인 수만 0으로 바꾼다
             * 1의 갯수로 답을 알아낸다
             */

            //1~9까지의 오름차순 배열 생성 후 초기화 //나중에 9를 다른 변수로 선언 후 사용
            int[] discriminator = new int[10];
            for (int i = 0; i <= 9; i++) {
                discriminator[i] = 0;
            }

            //컴퓨터 숫자에 있는 각 자리의 수에 매칭되는 인덱스 값을 1로 치환
            for (int i = 0; i < NUMBER_DIGIT; i++) {
                for (int j = 1; j <= 9; j++) {
                    if (intArrayComputerNumber[i] == j) {
                        discriminator[j] = 1;
                    }
                }
            }

            //입력 값에 있는 각 자리의 수를 배열에서 1인 수만 0으로 치환
            for (int i = 0; i < NUMBER_DIGIT; i++) {
                for (int j = 1; j <= 9; j++) {
                    if (charArrayInputNumber[i] == j && discriminator[j] == 1) {
                        discriminator[j] = 0;
                    }
                }
            }

            //1인 원소가 0개면 정답
            count = 0;
            for (int i = 1; i <= 9; i++) {
                if (discriminator[i] == 1) {
                    count++;
                }
            }

            if (count == 0) {
                break;
            }
        }

        System.out.println("!");

    }


    /***
     * 입력 값이 세 자리 수인지 검증한다
     *
     * @param number
     */
    private static void checkNumberDigits(int number) {
        int digit = getNumberDigit(number);

        if (digit != 3) {
            throw new IllegalArgumentException("세 자리수만 입력 가능합니다.");
        }
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
     * @param inputNumber
     */
    private static void checkInputNumberRange(int inputNumber) {
        int[] intArrayInputNumber = getDigitsArray(inputNumber);

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
     * 파라메터가 몇 자리의 수인지 계산한다
     *
     * @param number
     * @return
     */
    private static int getNumberDigit(int number) {
        int digit = (int) (Math.log10(number) + 1);

        return digit;
    }


    /***
     * 배열 내에 중복되는 수가 있는지 확인한다
     *
     * @param arr
     * @return 배열에 중복값이 있는지에 대한 여부를 boolean값으로 반환
     */
    public static boolean areAllDistinct(int[] arr) {
        return IntStream.range(0, arr.length)
                .noneMatch(i -> IntStream.range(i + 1, arr.length)
                        .anyMatch(j -> arr[i] == arr[j]));
    }
}

