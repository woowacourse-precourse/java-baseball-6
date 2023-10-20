package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Application {
    public static void main(String[] args) {
        Game game = new Game();
        game.start();
    }
}

class Game{
    List<Integer> computer_answer = new ArrayList<>();
    List<Integer> answer = new ArrayList<>();

    void start(){
        System.out.println("숫자 야구 게임을 시작합니다.");
        boolean check = false;

        while (!check) {
            computer_answer.clear();
            computer();

            while (true) {
                answer.clear();
                user();

                Hint hint = new Hint();
                hint.score(answer, computer_answer);

                if (hint.result()) {
                    System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                    int choice = Integer.parseInt(Console.readLine());
                    if (choice == 1) {
                        break;
                    } else if (choice == 2) {
                        check = true;
                        break;
                    }
                    else{
                        throw new IllegalArgumentException("게임 종료");
                    }
                }
            }
        }
    }

    void computer(){
        while (computer_answer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer_answer.contains(randomNumber)) {
                computer_answer.add(randomNumber);
            }
        }
    }

    void user() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();

        try {
            validateInput(input);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("숫자가 아닙니다.");
        }
    }

    private void validateInput(String input) {
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
    }
}

class Hint{
    int ball, strike;

    void score(List<Integer>user, List<Integer>computer){
        ball = 0;
        strike = 0;

        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(Objects.equals(user.get(i), computer.get(j))){
                    if(i == j){
                        strike++;
                    } else{
                        ball++;
                    }
                }
            }
        }
    }

    boolean result(){
        if(this.ball == 0 && this.strike == 0){
            System.out.println("낫싱");
        }
        else if(ball > 0 && strike == 0){
            System.out.println(ball+"볼");
        }
        else if(ball == 0 && strike > 0){
            System.out.println(strike+"스트라이크");
            if(strike == 3){
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                return true;
            }
        }
        else if(ball > 0 && strike > 0){
            System.out.println(ball+"볼 "+strike+"스트라이크");
        }
        return false;
    }
}