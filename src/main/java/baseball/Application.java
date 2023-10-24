package baseball;

import camp.nextstep.edu.missionutils.Randoms;

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

    static class Game{
        public void play(){
            System.out.println("숫자 야구 게임을 시작합니다.");
        }

    }

    public static void main(String[] args) {
        Game game = new Game();
        Computer computer = new Computer();
        game.play();
        System.out.println(computer.getRandomNumber());
    }

}