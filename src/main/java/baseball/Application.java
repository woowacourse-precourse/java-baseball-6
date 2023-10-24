package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args){
        System.out.println("숫자 야구 게임을 시작합니다.");

        List<Integer> computerNumberList = computerRanNumList();

        boolean inGame = true;

        while(inGame) {
            System.out.println("숫자를 입력해주세요 : ");
            String userInput = Console.readLine();
            List<Integer> userNumberList = userInputNumList(userInput);

            int strike = strikeCnt(computerNumberList, userNumberList);
            int inList = inListCnt(computerNumberList, userNumberList);

            int ball = inList - strike;

            printScore(ball, strike);

            if (strike == 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                String againNumber = Console.readLine();
                inGame = checkAgainGame(againNumber);
                if (inGame) {
                    computerNumberList = computerRanNumList();
                }
            }
        }
    }

    // computer
    private static List<Integer> computerRanNumList() {
        List<Integer> computerNumberList = new ArrayList<>();
        while (computerNumberList.size() < 3) {
            int randNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumberList.contains(randNumber)) {
                computerNumberList.add(randNumber);
            }
        }
        return computerNumberList;
    }
    //user
    private static List<Integer> userInputNumList(String userInput){
        List<Integer> userInputNumberList = new ArrayList<>();
        checkLength(userInput);
        for(String splitUserNumber : userInput.split("")){
            if(!splitUserNumber.isEmpty()){
                userInputNumberList.add(Integer.parseInt(splitUserNumber));
            }
        }
        for(int i = 0; i < userInputNumberList.size(); i++){
            checkZero(userInputNumberList.get(i));
        }
        return userInputNumberList;
    }

    private static void checkLength(String inputNumber) {
        if (inputNumber.length() != 3){
            throw new IllegalArgumentException("3개의 숫자를 입력하세요.");
        }
    }

    private static void checkZero(int number){
        if (number <= 0){
            throw new IllegalArgumentException("1부터 9사이의 숫자만 입력하세요.");
        }
    }

    //game
    private static boolean checkAgainGame(String againNum){
        if(againNum.equals("1")){
            return true;
        }
        if(againNum.equals("2")){
            return false;
        }
        throw new IllegalArgumentException("잘못된 값을 입력했습니다.");
    }

    private static int strikeCnt(List<Integer> computer, List<Integer> player){
        int strikeCount = 0;
        for (int i = 0; i < computer.size(); i++){
            if(computer.get(i) == player.get(i)){
                strikeCount ++;
            }
        }
        return strikeCount;
    }

    private static int inListCnt(List<Integer> computer, List<Integer> player){
        int inListCount = 0;
        for (int i = 0; i < computer.size(); i++){
            if(computer.contains(player.get(i))){
                inListCount ++;
            }
        }
        return inListCount;
    }

    private static void printScore(int ball, int strike){
        if(ball == 0 && strike == 0){
            System.out.println("낫싱");
            return;
        }

        if(ball == 0 && 1 <= strike && strike <= 3){
            System.out.println(strike + "스트라이크");
            return;
        }

        if(strike == 0 && 1 <= ball && ball <= 3){
            System.out.println(ball + "볼");
            return;
        }
        System.out.println(ball + "볼 " + strike + "스트라이크");
    }

}


