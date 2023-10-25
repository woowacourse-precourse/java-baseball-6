package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Application {

    static class Computer{
        List<Integer> computerNumber = new ArrayList<>();

        public List<Integer> getRandomNumber() {
            List<Integer> randomNumber = new ArrayList<>();
            while(randomNumber.size() <3) {
                int randomDigit = Randoms.pickNumberInRange(1, 9);
                if(!randomNumber.contains(randomDigit)) {
                    randomNumber.add(randomDigit);
                }
            }
            this.computerNumber = randomNumber;
            return randomNumber;
        }
    }

    static class User{
        List<Integer> UserNumber = new ArrayList<>();
        int inputNum;

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
                //e.printStackTrace();
                throw new IllegalArgumentException("EXCEPTION_MESSAGE");
            }
            this.inputNum = inputNum;
            //System.out.println(inputNum);
            changeToList();
        }

        public void changeToList(){
            while(this.inputNum > 0) {
                UserNumber.add(this.inputNum %10);
                this.inputNum /= 10;
            }
            Collections.reverse(this.UserNumber);
        }

    }

    static class Game{
        public void play(){
            System.out.println("숫자 야구 게임을 시작합니다.");
            Computer computer = new Computer();
            User user = new User();
            System.out.println(computer.getRandomNumber()); //컴퓨터 랜덤넘버
            user.setUserNumber(); // 유저입력넘버

            //System.out.println(user.UserNumber);
            // 유저 입력을 List<Integer>로 바꿔야함
            // 볼의 개수 = 공통수 - 스트라이크
//            int both = countBoth(computer.computerNumber,user.UserNumber);
//            int strike = countStrike(computer.computerNumber,user.UserNumber);
            System.out.println(ans(computer.computerNumber,user.UserNumber));

        }

        public int countBoth(List<Integer> computer, List<Integer> user){
            int both = 0;
            for(int i = 0; i < user.size(); i++){
                if(computer.contains(user.get(i))){
                    both += 1;
                }
            }
            return both;
        }

        public int countStrike(List<Integer> computer, List<Integer> user){
            int strike = 0;
            for(int i = 0; i < user.size(); i++){
                if(computer.get(i) == user.get(i)){
                    strike += 1;
                }
            }
            return strike;
        }

        public String ans(List<Integer> computer, List<Integer> user){
            int both = countBoth(computer, user);
            int strike = countStrike(computer, user);
            int ball = both - strike;

            if(both == 0){
                return "낫싱";
            }else if(strike == 0){
                return ball + "볼";
            }else if(ball == 0){
                return strike + "스트라이크";
            }
            return ball + "볼 " + strike + "스트라이크";
        }
    }

    public static void main(String[] args) {
        Game game = new Game();
        try{
            game.play();
        }catch (IllegalArgumentException e){
            e.printStackTrace();
        }

    }

}