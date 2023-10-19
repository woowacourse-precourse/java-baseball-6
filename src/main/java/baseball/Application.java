package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");

        do{
            startGame();
        }while(checkReGame());

        System.out.println("게임 종료");
    }

    private static void startGame() {
        List<Integer> computerNumber = makeComputerNumber();
        List<Integer> userNumber;
        String userNumberByString;

        do {
            System.out.print("숫자를 입력해주세요 : ");
            userNumberByString = enterUserNumber();

            userNumber = changeUserNumberToInt(userNumberByString);

        }while(!judge(computerNumber, userNumber));
    }

    private static boolean checkReGame(){

        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String reGame = readLine();
        checkReGameNumber(reGame);

        if(reGame.equals("1"))
            return true;
        if(reGame.equals("2"))
            return false;

        return false;
    }

    private static void checkReGameNumber(String reGame) {
        boolean isNumber = Pattern.matches("^[1-2]$", reGame);
        if(!isNumber)
            throw new IllegalArgumentException("잘못된 입력입니다. 재시작(1) 또는 종료(2)를 입력해주세요.");
    }

    private static boolean judge(List<Integer> computerNumber, List<Integer> userNumber) {
        JudgeStrike judgeStrike = new JudgeStrike(computerNumber, userNumber);

        return judgeStrike.judge();
    }

    private static String enterUserNumber(){
        String userNumberByString = readLine();
        checkUserNumber(userNumberByString);

        return userNumberByString;
    }


    private static List<Integer> changeUserNumberToInt(String userNumberByString) {
        List<Integer> userNumber = new ArrayList<>();
        for (String num : userNumberByString.split("")) {
            userNumber.add(Integer.parseInt(num));
        }
        return userNumber;
    }

    private static void checkUserNumber(String userNumberByString){
        boolean isNumber = Pattern.matches("^(?!.*(\\d).*\\1)[1-9]{3}$", userNumberByString);
        if(!isNumber)
            throw new IllegalArgumentException("잘못된 입력입니다. 1부터 9까지 서로 다른 수로 이루어진 3자리의 수를 입력해주세요.");
    }

    private static List<Integer> makeComputerNumber(){
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
