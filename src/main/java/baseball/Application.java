package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        Output show = new Output();
        show.opening();

        boolean endGame = false;
        int state = 1;
        ComputerNumberManage randomNumber = new ComputerNumberManage();

        while(!endGame){
            if(state == 0){
                randomNumber = new ComputerNumberManage();
            }


                show.guide();
                String input = Console.readLine();
                UserNumberManage user = new UserNumberManage(input);
                user.checkNumber();

                int [] checkScore = new int[3];
                List<Integer> userTemp = user.getUserNumbers();
                List<Integer> randomNumTemp = randomNumber.getComputerNumbers();

                for(int computerNum = 0; computerNum < 3; computerNum++){
                    for(int userNum = 0; userNum < 3; userNum++){
                        if(checkScore[userNum] == 2 ) continue;
                        if(randomNumTemp.get(computerNum).equals(userTemp.get(userNum)) && computerNum == userNum) {
                            checkScore[computerNum] = 2;
                            break;
                        }
                        else if(randomNumTemp.get(computerNum).equals(userTemp.get(userNum))){
                            checkScore[computerNum] = 1;
                            break;
                        }
                    }
                }

                // delete
                System.out.println(randomNumTemp.toString());
                System.out.println(userTemp.toString());


                int ball = 0;
                int strike = 0;

                for(int i = 0; i < 3; i++){
                    if(checkScore[i] == 1){
                        ball++;
                    }
                    else if(checkScore[i] == 2){
                        strike++;
                    }
                }
                show.result(ball, strike);

                if(strike == 3){
                    show.decide();
                    String decision = Console.readLine();
                    if(decision.equals("1")){
                        state = 0;
                    }
                    else if(decision.equals("2")){
                        endGame = true;
                    }

                }
                else{
                    state = 1;
                }



        }
    }
}

class Output{
    public Output(){
    }
    public void opening(){
        System.out.println("숫자 야구 게임을 시작합니다.");
    }
    public void guide() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    public void result(int ball, int strike) {
        if(ball > 0 && strike > 0) {
            System.out.println(ball + "볼 " + strike + "스트라이크");
        }
        else if(ball > 0){
            System.out.println(ball + "볼");
        }
        else if(strike > 0){
            System.out.println(strike + "스트라이크");
        }
        else{
            System.out.println("낫싱");
        }
    }

    public void decide(){
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
}

class UserNumberManage {
    private static final int MAX_LENGTH = 3;
    private List<Integer> numbers;
    private String data;
    public UserNumberManage(String input){
        data = input;
    }

    public void checkNumber(){
        numbers = new ArrayList<>();

        if (data.length() != MAX_LENGTH) {
            throw new IllegalArgumentException();
        }

        for(int i = 0; i < MAX_LENGTH; i++){
            if(!Character.isDigit(data.charAt(i))){
                throw new IllegalArgumentException();
            }
            int num = Character.getNumericValue(data.charAt(i));

            if (num < 1 || num > 9){
                throw new IllegalArgumentException();
            }

            if (numbers.contains(num)){
                throw new IllegalArgumentException();
            }
            else{
                numbers.add((num));
            }

        }
    }
    public List<Integer> getUserNumbers() {
        return numbers;
    }
}

class ComputerNumberManage {
    private List<Integer> computer = new ArrayList<>();
    public ComputerNumberManage() {
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
    }

    public List<Integer> getComputerNumbers(){
        return computer;
    }
}