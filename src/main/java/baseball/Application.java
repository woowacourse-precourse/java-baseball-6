package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        Game game = new Game();
        game.computer();
        game.user();
    }
}

class Game{
    List<Integer> computer_answer = new ArrayList<>();
    List<Integer> answer = new ArrayList<>();

    void computer(){
        while (computer_answer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer_answer.contains(randomNumber)) {
                computer_answer.add(randomNumber);
            }
        }
        System.out.println("computer: " + computer_answer);
    }

    void user() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();

        try {
            if (input.length() != 3) {
                throw new IllegalArgumentException("3자리 숫자가 아닙니다.");
            }
            for (int i = 0; i < input.length(); i++) {
                int num = input.charAt(i) - '0';
                if (num < 1 || num > 9) {
                    throw new IllegalArgumentException("1부터 9까지의 숫자를 입력해주세요.");
                }
                if (answer.contains(num)) {
                    throw new IllegalArgumentException("중복된 숫자가 입력되었습니다.");
                }
                answer.add(num);
            }
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("게임 종료");
        }
    }
}