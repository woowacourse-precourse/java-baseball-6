package baseball;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String number;
        User user;

        System.out.println("숫자 야구 게임을 시작합니다.");
        Scanner sc = new Scanner(System.in);

        System.out.println("숫자를 입력해주세요 : ");
        number = sc.nextLine();
        user = new User(number);
        }
    }
