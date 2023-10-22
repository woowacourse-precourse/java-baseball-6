package baseball;

import java.util.Random;
import java.util.Scanner;

public class Application {
    // 숫자 랜덤 생성하는 클래스
    public static int[] generateRandomNumber() {
        Random random = new Random();
        int[] randomNumber = new int[3];

        for( int i = 0; i < 3; i++ ) {
            int number;
            do {
                number = random.nextInt(9)+1;
            }while (containsNumber(randomNumber,number)); // 중복 방지

            randomNumber[i] = number;
        }

        return randomNumber;
    }

    //중복 비교
    public static boolean containsNumber(int[] array, int number) {
        for (int num : array) {
            if (num == number) {
                return true;
            }
        }
        return false;
    }

    // 정수를 배열로 변환
    public static int[] numberToArray(int number) {
        int[] array = new int[3];

        for (int i = 2; i >= 0; i--) {
            array[i] = number % 10;
            number /= 10;
        }

        return array;
    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("숫자 야구 게임을 시작합니다.");
        generateRandomNumber(); //랜덤숫자 생성
//        System.out.println(Arrays.toString(generateRandomNumber()));
        System.out.print("숫자를 입력해주세요 : ");
        int[] ints = numberToArray(sc.nextInt());
//        System.out.println(Arrays.toString(ints));

        //TODO: 반복문으로 사용자가 입력한 값과 랜덤 값 배열 비교.

    }
}
