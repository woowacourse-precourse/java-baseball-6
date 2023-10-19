package baseball;


import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        Person person = new Person();

        System.out.println("숫자 야구 게임을 시작합니다.");
        while (true) {
            System.out.print("숫자를 입력해주세요 : " );
            String input = Console.readLine();
            person.insert(input);
        }
    }
}
