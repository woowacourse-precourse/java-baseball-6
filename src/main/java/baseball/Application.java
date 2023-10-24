package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {

    static class Computer{
        public List<Integer> getRandomNumber() {
            List<Integer> randomNumber = new ArrayList<>();
            while(randomNumber.size() <3) {
                int randomDigit = Randoms.pickNumberInRange(1, 9);
                if(!randomNumber.contains(randomDigit)) {
                    randomNumber.add(randomDigit);
                }
            }
            return randomNumber;
        }
    }

    static class User{
        public void inputValidationCheck(int input){
            if (!(input >= 111 && input <= 999 && input % 10 != 0 && (input / 10) % 10 != 0 && (input / 100) % 10 != 0)) {
                throw new IllegalArgumentException("Please");
            }
        }

        public void setUserNumber(){
            System.out.print("숫자를 입력해주세요 : ");
            String input = Console.readLine();
            int inputNum = Integer.parseInt(input);
            try{
                inputValidationCheck(inputNum);
            }catch (IllegalArgumentException e){
                e.printStackTrace();
            }
            System.out.println(inputNum);
        }

    }

    static class Game{
        public void play(){
            System.out.println("숫자 야구 게임을 시작합니다.");
        }

    }

    public static void main(String[] args) {
        Game game = new Game();
        Computer computer = new Computer();
        User user = new User();
        game.play();
        System.out.println(computer.getRandomNumber());
        user.setUserNumber();
    }

}