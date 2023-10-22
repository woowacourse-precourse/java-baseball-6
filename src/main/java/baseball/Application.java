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
        
    }
}
