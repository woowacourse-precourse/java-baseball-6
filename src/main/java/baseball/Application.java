package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.Objects;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        while(true){
            RandomNumber randomNumber = new RandomNumber();
            System.out.println(randomNumber.number);
            CompareNumber compareNumber = new CompareNumber();
            compareNumber.go(randomNumber.number);
            String input = Console.readLine();
            if (Objects.equals(input, "2")){
                System.out.println("게임 종료");
                break;
            }
        }
    }
}
