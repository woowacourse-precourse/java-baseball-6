package baseball.view;

import baseball.model.BaseballGameModel;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

public class BaseballGameView {

    private List<Integer> userGuessNums;
    private int useChoicePlayAgain;

    public BaseballGameView(){
        generateUserGuessNums();
    }

    public void displayWelcomeMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }
    public void displayUserInputMessage() {
        System.out.print("숫자를 입력해주세요 : ");
    }


    public void displayBothResult(int[] result) {
        System.out.println(result[1] + "볼 " + result[0] + "스트라이크");
    }

    public void displayOnlyStrikeResult(int[] result) {
        System.out.println(result[0]+"스트라이크");
    }
    public void displayOnlyBallResult(int[] result) {
        System.out.println(result[1]+"볼");
    }
    public void displayNothingResult(){
        System.out.println("낫싱");
    }

    public void displayGameEndMessage() {
        System.out.println("3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public void displayRestartOrQuitMessage() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    public void generateUserGuessNums(){
        String inputNums = Console.readLine();

        checkValidLength(inputNums);
        checkValidDuplicated(inputNums);

        userGuessNums = new ArrayList<>();
        for (int i = 0; i < 3; i++){
            userGuessNums.add((int) inputNums.charAt(i));
        }

    }
    public void choicePlayAgain(){
        String s = Console.readLine();
        useChoicePlayAgain = Integer.parseInt(s);
    }

    public List<Integer> getUserGuessNums(){
        return userGuessNums;
    }

    /**
     * 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨다.
     * set 자료 구조를 이용해서 결과적으로 set에 데이터가 3개가 아니라면 중복값 입력이기 때문에 예외 발생
     *
     * @param inputNums 문자열로 입력 받은 사용자 입력값
     * */
    private void checkValidDuplicated(String inputNums) {
        Set<Integer> checkSet = new HashSet<>();
        for (int i = 0; i < 3; i++){
            checkSet.add((int) inputNums.charAt(i));
        }
        if(checkSet.size() > 3){
            throw new IllegalArgumentException();
        }


    }

    /**
     * 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨다.
     * 길이가 3이 아니라면 3자리가 아니기 때문에 예외 발생
     *
     * @param inputNums 문자열로 입력 받은 사용자 입력값
     * */
    private static void checkValidLength(String inputNums){
        if (!(inputNums.length() == 3)){
            throw new IllegalArgumentException();
        }
    }

    public int getPlayAgainChoice() {

        return useChoicePlayAgain;
    }
}
