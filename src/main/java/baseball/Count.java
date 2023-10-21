package baseball;

import java.util.Scanner;

public class Count {
    private String number;

    public Count(){
        System.out.println("숫자를 입력해주세요 : ");
        Scanner sc = new Scanner(System.in);
        String number = sc.next();

    }

    private void isThreeDigits(String number){
        if (number.length() != 3) {
            throw new IllegalArgumentException("3자리의 정수를 입력해야 합니다.");
        }

        try {
            Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("3자리의 정수를 입력해야 합니다");
        }
    }
}
