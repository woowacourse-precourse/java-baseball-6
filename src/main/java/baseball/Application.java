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
        List<Integer> userDigit = new ArrayList<>();
        int userNumber=0;

//        public void inputValidationCheck(int input){
//            if (!(input >= 111 && input <= 999 && input % 10 != 0 && (input / 10) % 10 != 0 && (input / 100) % 10 != 0)) {
//                throw new IllegalArgumentException("Please");
//            }
//        }

        public void stringValidation(String input) {
            if(!(Pattern.compile("[1-9]{3,3}").matcher(input).matches())) {
                throw new IllegalArgumentException("EXCEPTION_MESSAGE");
            }
            if(input.length() != 3) {
                throw new IllegalArgumentException("EXCEPTION_MESSAGE");
            }
        }

        public void setUserNumber(){
            System.out.print("숫자를 입력해주세요 : ");
            String input = Console.readLine();
            try{
                stringValidation(input);
            }catch (IllegalArgumentException e){
                throw new IllegalArgumentException("EXCEPTION_MESSAGE");
            }


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
        Computer computer = new Computer();
        User user = new User();

        boolean quit = false;

        int both=0;
        int strike=0;
        int ball=0;
        String quitResponse="";

        public void play(){
            System.out.println("숫자 야구 게임을 시작합니다.");

            computer.setRandomNumber();
            //System.out.println(computer.computerDigit); //컴퓨터 랜덤넘버
            // 유저입력넘버

            //initializeRandomNumber(); //PC의 랜덤넘버 생성

            while(!quit) {
                user.userDigit = new ArrayList<>();
                user.setUserNumber();//유저입력받기

                initCount();

                System.out.println(ans(computer.computerDigit,user.userDigit));

                if(this.strike == 3) {
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                    setQuitResponse();
                    if(this.quitResponse.equals("2")){
                        quit = true;
                    }else if(this.quitResponse.equals("1")){
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
            List<String> inputList = new ArrayList<>(Arrays.asList(new String[]{"1", "2"}));
            boolean inputValidation = inputList.contains(quitResponse);
            if(!inputValidation) {
                throw new IllegalArgumentException("ExceptionMessage");
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
        }
    }

    public static void main(String[] args) {
        Game game = new Game();
        try{
            game.play();
        }catch (IllegalArgumentException e){
            throw new IllegalArgumentException("EXCEPTION_MESSAGE");
        }
    }
}