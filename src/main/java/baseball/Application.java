package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Application {
    final static int LENGTH_OF_NUMBER = 3;
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        while (true) {
            System.out.println("숫자 야구 게임을 시작합니다.");

            List<Integer> computer = getRandomNumber();

            while (true) {
                // 사용자의 입력을 받는 부분

                Integer[] userNumber = setUserNumber();

                int numberOfStrike = calculatingStrikeValue(computer,userNumber);

                int numberOfBall = calculatingBallValue(computer,userNumber);

                System.out.println(outputGameResult(numberOfStrike,numberOfBall));

                if (numberOfStrike == 3) {
                    break;
                }
            }

            if (askRestartGame() == 2) {
                break;
            }
        }
    }
    static List<Integer> getRandomNumber(){
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < LENGTH_OF_NUMBER) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
        return numbers;
    }

    static Integer[] setUserNumber(){
        System.out.print("숫자를 입력해주세요 : ");
        String[] user = Console.readLine().split("");
        if (user.length != 3 || checkSameNumber(user))
            throw new IllegalArgumentException("옳은 입력값을 입력해주세요.");

        //TODO 무슨 말인지 모르겠다 공부하자 새로운 언어에서의 문법
        return Stream.of(user).mapToInt(Integer::parseInt).boxed().toArray(Integer[]::new);
    }

    static int calculatingStrikeValue(List<Integer> computer, Integer[] user){
        int numberOfStrike = 0;

        for (int i = 0; i < LENGTH_OF_NUMBER; i++) {
            if (computer.get(i).equals(user[i]))
                numberOfStrike++;
        }
        return numberOfStrike;
    }

    static int calculatingBallValue(List<Integer> computer, Integer[] user){
        int numberOfBall = 0;

        for (int i = 0; i < LENGTH_OF_NUMBER; i++) {
            if (computer.contains(user[i]))
                numberOfBall++;
        }
        return numberOfBall - calculatingStrikeValue(computer,user);
    }

    static String outputGameResult(int numberOfStrike, int numberOfBall){
        if (numberOfStrike == 0 && numberOfBall != 0) {
            return numberOfBall + "볼";
        } else if (numberOfStrike == 0 && numberOfBall == 0) {
            return "낫싱";
        } else if (numberOfBall == 0 && numberOfStrike != 0) {
            return numberOfStrike + "스트라이크";
        } else {
            return numberOfBall + "볼 " + numberOfStrike + "스트라이크";
        }
    }

    static int askRestartGame(){
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int input = Integer.parseInt(Console.readLine());

        if(input == 1 || input == 2){
            throw new IllegalArgumentException();
        }

        return input;
    }

    static boolean checkSameNumber(String[] userNumber){
        for(int i = 0; i<userNumber.length-1; i++){
            for(int j = i+1; j<userNumber.length; j++){
                if(userNumber[i].equals(userNumber[j]))
                    return true;
            }
        }
        return false;
    }
}
