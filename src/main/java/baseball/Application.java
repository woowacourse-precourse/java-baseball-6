package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

public class Application {

    static class Computer{
        List<Integer> computerDigit = new ArrayList<>();

        public void setRandomNumber() {
            List<Integer> randomNumber = new ArrayList<>();
            while(randomNumber.size() <3) {
                int randomDigit = Randoms.pickNumberInRange(1, 9);
                if(!randomNumber.contains(randomDigit)) {
                    randomNumber.add(randomDigit);
                }
            }
            this.computerDigit = randomNumber;
        }
    }

    static class User{
        private static final String INPUT_NUMBER = "숫자를 입력해주세요 : ";

        List<Integer> userDigit = new ArrayList<>();
        int userNumber=0;

        public void stringValidation(String input) {
            if(!(Pattern.compile("[1-9]{3,3}").matcher(input).matches())) {
                throw new IllegalArgumentException("IllegalArgument for userNumber pattern");
            }
            if(input.length() != 3) {
                throw new IllegalArgumentException("IllegalArgument for userNumber length");
            }
        }

        public void setUserNumber(){
            System.out.print(INPUT_NUMBER);
            String input = Console.readLine();
            stringValidation(input);
            this.userNumber = Integer.parseInt(input);
            changeToList();
        }

        public void changeToList(){
            while(this.userNumber > 0) {
                userDigit.add(this.userNumber %10);
                this.userNumber /= 10;
            }
            Collections.reverse(this.userDigit);
        }

    }

    static class Game{
        private static final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
        private static final String STRIKE_FINISH = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
        private static final String RESTART_CHOICE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
        private static final String QUIT_VALUE = "2";
        private static final String RESTART_VALUE = "1";

        Computer computer = new Computer();
        User user = new User();
        boolean quit = false;
        int both=0;
        int strike=0;
        int ball=0;
        String quitResponse="";

        public void play(){
            System.out.println(START_MESSAGE);

            computer.setRandomNumber();

            while(!quit) {
                initCount();
                user.setUserNumber(); //유저입력받기

                System.out.println(ans(computer.computerDigit,user.userDigit));

                if(this.strike == 3) {
                    System.out.println(STRIKE_FINISH);
                    System.out.println(RESTART_CHOICE);
                    setQuitResponse();
                    if(this.quitResponse.equals(QUIT_VALUE)){
                        quit = true;
                    }else if(this.quitResponse.equals(RESTART_VALUE)){
                        computer.setRandomNumber();
                    }
                }
            }
        }

        public void setQuitResponse(){
            String inputQuit = Console.readLine();
            validateQuitInput(inputQuit);
            this.quitResponse = inputQuit;
        }

        private void validateQuitInput(String quitResponse) {
            List<String> inputList = new ArrayList<>(Arrays.asList(new String[]{RESTART_VALUE, QUIT_VALUE}));
            boolean inputValidation = inputList.contains(quitResponse);
            if(!inputValidation) {
                throw new IllegalArgumentException("IllegalArgument for QuitInput");
            }
        }

        public int countBoth(List<Integer> computer, List<Integer> user){
            both = 0;
            for(int i = 0; i < user.size(); i++){
                if(computer.contains(user.get(i))){
                    both += 1;
                }
            }
            return both;
        }

        public int countStrike(List<Integer> computer, List<Integer> user){
            strike = 0;
            for(int i = 0; i < user.size(); i++){
                if(computer.get(i) == user.get(i)){
                    strike += 1;
                }
            }
            return strike;
        }

        public String ans(List<Integer> computer, List<Integer> user){
            this.both = countBoth(computer, user);
            this.strike = countStrike(computer, user);
            this.ball = this.both - this.strike;

            if(both == 0){
                return "낫싱";
            }else if(strike == 0){
                return ball + "볼";
            }else if(ball == 0){
                return strike + "스트라이크";
            }
            return ball + "볼 " + strike + "스트라이크";
        }

        public void initCount(){
            this.both=0;
            this.strike=0;
            this.ball=0;
            this.quitResponse="";
            quit = false;
            user.userDigit = new ArrayList<>();
        }
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.play();
    }
}