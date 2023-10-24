package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");
        Computer computer = new Computer();
        User user = new User();
        BaseballGame baseballGame = new BaseballGame(user,computer);

        while (baseballGame.gameStart());
    }
    static class User {
        private  List<Integer> numbers;
        private  List<Integer> numberInRange;

        public User() {
            this.numbers = new ArrayList<>();
            this.numberInRange = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9));
        }

        public List<Integer> getNumbers() {
            return numbers;
        }

        public void reset(){
            this.numbers.clear();
        }

        public void inputNumber(){
            reset();
            System.out.print("숫자를 입력해주세요 : ");
            String input = Console.readLine();

            try {
                if(!(3 == input.length())){
                    throw new IllegalArgumentException("잘못 입력하셨습니다. 3자리 수를 입력하세요.");
                }

                for (int i = 0 ; i < input.length() ; i++){

                    int inputNumber = Integer.parseInt(String.valueOf(input.charAt(i)));

                    if(numberInRange.contains(inputNumber)){
                        numbers.add(inputNumber);
                    }else {
                        throw new IllegalArgumentException("잘못 입력하셨습니다. 1~9사이의 숫자를 입력하세요.");
                    }
                }

                if(numbers.size() != numbers.stream().distinct().count()){
                    throw new IllegalArgumentException("잘못 입력하셨습니다. 숫자를 중복없이 입력하세요.");
                }

            } catch (NumberFormatException e){
               throw  new IllegalArgumentException("잘못 입력하셨습니다. 1~9사이의 숫자를 입력하세요.");
            } catch (IllegalArgumentException e){
               throw  new IllegalArgumentException(e.getMessage());
            }
        }
    }

    static class Computer{
        private  List<Integer> numbers;

        public Computer() {
            this.numbers = new ArrayList<>();
            while (numbers.size() < 3) {
                int randomNumber = Randoms.pickNumberInRange(1, 9);
                if (!numbers.contains(randomNumber)) {
                    numbers.add(randomNumber);
                }
            }
        }

        public List<Integer> getNumbers() {
            return numbers;
        }

        public void reset(){
            this.numbers.clear();
            while (numbers.size() < 3) {
                int randomNumber = Randoms.pickNumberInRange(1, 9);
                if (!numbers.contains(randomNumber)) {
                    numbers.add(randomNumber);
                }
            }
        }


    }

    static class BaseballGame{
        private User user;
        private Computer computer;

        public BaseballGame(User user, Computer computer) {
            this.user = user;
            this.computer = computer;
        }

        public boolean gameStart(){
            int strike = 0;
            int ball = 0;
            String message = "";

            user.inputNumber();

            for (int i = 0 ; i <  user.getNumbers().size(); i++){
                if( i == computer.getNumbers().indexOf(user.getNumbers().get(i))){
                    strike++;
                    continue;
                }

                if(computer.getNumbers().contains(user.getNumbers().get(i))){
                    ball++;
                }
            }

            if(strike == 0 && ball == 0){
                System.out.println("낫싱");
                return true;
            }

            if(strike==3){
                System.out.println(strike+"스트라이크");
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                String input = Console.readLine();

                if(input.equals("1")){
                    computer.reset();
                    return true;
                }else if(input.equals("2")){
                    return false;
                }else {
                    throw new IllegalArgumentException("잘못 입력하셨습니다.");
                }
            }else {
                if(ball!=0){
                    message += ball+"볼 ";
                }
                if(strike!=0){
                    message += strike+"스트라이크";
                }
                System.out.println(message);
                return true;
            }
        }
    }
}
