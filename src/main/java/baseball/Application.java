package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        System.out.println("숫자 야구 게임을 시작합니다.");
        boolean moreGame = true;
        while (moreGame) {

            List<Integer> computerN = new ArrayList<>();
            setComputerNumber(computerN);

            boolean correct = false;
            while (!correct) {
                correct=userRound(computerN);
            }

            System.out.printf("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.%n");
            String newOrEndGame = Console.readLine();

            if (problemWithMoreGame(newOrEndGame)){
                throw new IllegalArgumentException("형식에 맞지 않는 숫자를 입력했습니다.");
            }

            if (newOrEndGame.equals("2")) {
                moreGame=false;
            }
        }

        return;
    }

    public static boolean userRound(List<Integer> answer){
        System.out.printf("숫자를 입력해주세요 : ");

        String userInput = Console.readLine();
        if (problemWithUserInput(userInput)) {
            throw new IllegalArgumentException("형식에 맞지 않는 숫자를 입력했습니다.");
        }

        List<Integer> userInputList=strNumToIntegerList(userInput);
        return isCorrectAnswer(answer, userInputList);
    }

    public static void setComputerNumber(List<Integer> computerN){
        while (computerN.size()<3){
            int randomN = Randoms.pickNumberInRange(1, 9);
            if (!computerN.contains(randomN)){
                computerN.add(randomN);
            }
        }
    }

    public static List<Integer> strNumToIntegerList(String s){
        List<Integer> list = new ArrayList<>();
        for (int i=0; i<s.length(); i++){
            list.add(s.charAt(i)-'0');
        }
        return list;
    }

    public static boolean problemWithUserInput(String target) {

        if (target.length() != 3) {
            return true;
        }

        if (target.charAt(0) == target.charAt(1) ||
                target.charAt(0) == target.charAt(2) ||
                target.charAt(1) == target.charAt(2)) {
            return true;
        }

        return false;

    }

    public static boolean problemWithMoreGame(String target){
        if (target.equals("1") || target.equals("2")){
            return false;
        }

        return true;
    }

    public static boolean isCorrectAnswer(List<Integer> answer, List<Integer> input){
        int strike = 0, ball = 0;

        for (int i=0; i<3; i++){
            if (answer.get(i).equals(input.get(i))) {
                strike++;
            }
        }

        for (int i=0; i<3; i++) {
            if (answer.contains(input.get(i)) && answer.get(i) != input.get(i)) {
                ball++;
            }
        }

        showTrialResult(strike, ball);

        if (strike==3) {
            return true;
        }
        else {
            return false;
        }
    }

    public static void showTrialResult(int s, int b){
        if (b==0 && s==0) {
            System.out.println("낫싱");
            return;
        }

        if (b>0) {
            System.out.printf("%d볼 ", b);
            if (s==0) {
                System.out.printf("%n");
            }
        }
        if (s>0) {
            System.out.printf("%d스트라이크%n", s);
            if (s==3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            }
        }
    }

}

