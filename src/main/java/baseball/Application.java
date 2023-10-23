package baseball;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자를 입력해주세요 : ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        //예외 처리 3자리가 아닌경우
        if (input.length() != 3) {
            System.out.println("3자리 숫자를 입력해주세요.");
        }

        int[] numbers = new int[3];

        // 문자열의 각 문자를 int로 변환하여 배열에 저장
        for (int i = 0; i < 3; i++) {
            // 문자를 숫자로 변환하고 배열에 저장
            numbers[i] = Integer.parseInt(input.substring(i, i + 1));
        }
        System.out.println("Numbers : " + numbers[0] + numbers[1] + numbers[2]);




    }
}
