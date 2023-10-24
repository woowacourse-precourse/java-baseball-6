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

        List<Integer> computer = computer();
        boolean gameEnd = true;

        while (gameEnd){
            List<Integer> user = user();
            gameEnd = gameStart(user,computer);
        }
    }


    public static boolean gameStart(List<Integer> user ,List<Integer> computer){
        int strike = 0;
        int ball = 0;

        for (int i = 0 ; i < user.size(); i++){
            if(user.get(i)==computer.get(i)){
                strike++;
                continue;
            }
            if(computer.contains(user.get(i))){
                ball++;
            }
        }
        String result = "";

        if(strike == 0 && ball == 0){
            System.out.println("낫싱");
        }

        if(ball>0){
            result += ball+"볼 ";
        }

        if(strike>0){
            result += strike+"스트라이크";
        }

        if(strike==3){
            System.out.println(result);
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String input = Console.readLine();

            if(input.equals("1")){
                computer.clear();
                while (computer.size() < 3) {
                    int randomNumber = Randoms.pickNumberInRange(1, 9);
                    if (!computer.contains(randomNumber)) {
                        computer.add(randomNumber);
                    }
                }
                return true;
            }else if(input.equals("2")){
                return false;
            }else {
               throw new IllegalArgumentException("잘못 입력하셨습니다.");
            }

        }else {
            System.out.println(result);
            return true;
        }
    }

    public static List<Integer> user(){
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        List<Integer> numberInRange = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9));

        if(!(3 == input.length())){
            throw new IllegalArgumentException("잘못 입력하셨습니다. 3자리 수를 입력해 주세요.");
        }

        List<Integer> user = new ArrayList<>();

        for (int i = 0 ; i < input.length() ; i++){
            try {
                int inputNumber = Integer.parseInt(String.valueOf(input.charAt(i)));

                if(numberInRange.contains(inputNumber)){
                    user.add(inputNumber);
                }else {
                    throw new IllegalArgumentException();
                }
            } catch (Exception e){
                throw new IllegalArgumentException("잘못 입력하셨습니다. 1~9사이 숫자를 입력하세요.");
            }
        }

        for(int i = 0 ; i < user.size(); i++){
            Integer num = user.get(i);
            if(numberInRange.contains(num)){
                numberInRange.remove(num);
            }else {
                throw new IllegalArgumentException("잘못 입력하셨습니다. 숫자를 중복없이 입력하세요.");
            }
        }
        return user;
    }

    public static List<Integer> computer(){
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }
}
