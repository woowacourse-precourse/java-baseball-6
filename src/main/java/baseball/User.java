package baseball;

import java.util.ArrayList;
import java.util.Scanner;

public class User {
    ArrayList<Integer> number = new ArrayList<>();

    public void inputUserNumber() {
        number.clear();
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("숫자를 입력해주세요 : ");
            String userInput = sc.next();
            for (int i = 0; i < userInput.length(); i++) {
                number.add(Integer.parseInt(userInput.substring(i, i + 1)));
            }
            //3자리가 아니면 예외처리
            if (number.size() != 3) {
                throw new IllegalArgumentException();
            }
            //겹치는 숫자가 있으면 예외처리
            if (number.stream().distinct().count() < 3) {
                throw new IllegalArgumentException();
            }
            //1~9가 아니면 예외처리
            if (number.stream().anyMatch(x -> x < 1 || x > 9)) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            //프로그램 종료
            System.exit(0);
        }
    }

    public ArrayList<Integer> getNumber(){
        return number;
    }
}
