package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

class Game {
    private static final int NUMBER_COUNT = 3;

    private List<Integer> computerNumbers;
    private List<Integer> userNumbers;
    private int strike;
    private int ball;
    private int out;

    Game() {
        computerNumbers = createRandomNumbers();
        userNumbers = new ArrayList<>();
        strike = 0;
        ball = 0;
        out = 0;
    }

    private List<Integer> createRandomNumbers() {
        List<Integer> randomNumbers = new ArrayList<>();
        while (randomNumbers.size() < NUMBER_COUNT) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!randomNumbers.contains(randomNumber)) {
                randomNumbers.add(randomNumber);
            }
        }
        return randomNumbers;
    }

    boolean validateUserInput(String input){
        userNumbers.clear();
        if(input.length() != NUMBER_COUNT){
            return false;
        }
        for(int i=0; i<input.length(); i++){
            char testChar = input.charAt(i);
            if(!Character.isDigit(testChar)){
                return false;
            }
            int tempInt = Character.getNumericValue(testChar);
            if(tempInt == 0 || userNumbers.contains(tempInt)){
                return false;
            }
            userNumbers.add(tempInt);
        }
        return true;
    }

    void calculateResult(){
        this.ball = 0;
        this.strike = 0;
        this.out = 0;

        for(int i=0; i<userNumbers.size(); i++){
            int userCurNum = userNumbers.get(i);
            int computerCurNum = computerNumbers.get(i);
            if(userCurNum == computerCurNum){
                strike += 1;
            } else if(computerNumbers.contains(userCurNum)){
                ball += 1;
            } else {
                out += 1;
            }
        }
    }

    boolean isUserWin() {
        return strike == NUMBER_COUNT;
    }

    String getResult() {
        StringBuilder result = new StringBuilder();
        if(out == NUMBER_COUNT){
            result.append("낫싱");
        }
        if(ball > 0){
            result.append(ball).append("볼");
        }
        if(strike > 0){
            if(!result.isEmpty()){
                result.append(" ");
            }
            result.append(strike).append("스트라이크");
        }
        return result.toString();
    }
}

public class Application {

    private static boolean playing;

    public static void main(String[] args){
        startGame();
    }

    private static void startGame() {
        System.out.println("숫자 야구게임을 시작합니다.");
        playing = true;
        while (playing){
            playGame();
        }
    }

    private static void playGame() {
        Game game = new Game();
        while (true) {
            readUserInput(game);
            game.calculateResult();
            printResult(game);
            if (game.isUserWin()) {
                printWinMessage();
                break;
            }
        }
    }

    private static void readUserInput(Game game) {
        System.out.print("숫자를 입력해주세요 : ");
        String userInput = Console.readLine();
        if(!game.validateUserInput(userInput)){
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
    }

    private static void printResult(Game game) {
        System.out.println(game.getResult());
    }

    private static void printWinMessage() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String userInput = Console.readLine();

        if(!"1".equals(userInput) && !"2".equals(userInput)){
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }

        playing = "1".equals(userInput);
    }
}
