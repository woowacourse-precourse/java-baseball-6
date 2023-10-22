package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class Application {
    public static void main(String[] args) throws IllegalArgumentException {
        BaseballGameManager newGame = new BaseballGameManager();
        newGame.start();
    }
}

// Controller
class BaseballGameManager{

    BaseballGame model;
    OutputView view;

    public BaseballGameManager(){
        this.model = new BaseballGame();
        this.view = new OutputView();
    }

    public void start() throws IllegalArgumentException {
        do{
            prepareForNewGame();
            view.startGameAnnouncement();           // 게임 시작시 문자열을 출력합니다.
            loadNewGame();                          // 새로운 게임을 시작합니다.
            getUserFinishInput();                   // 유저에게 게임의 재시작 여부를 묻습니다.
        }while(!model.checkGameFinish());            // User가 2를 입력하는 경우까지 시행한다.
    }

    public void loadNewGame() throws IllegalArgumentException {
        while(model.getStrikeCount() != 3) {
            view.promptUserForRoundGuess();         // 유저에게 숫자 입력을 안내합니다.
            getUserNumberInput();                   // 유저에게 숫자를 입력받아 Model의 userNumber Array에 넣습니다.
            model.calculateScore();                 // 해당 라운드의 점수를 계산합니다.
            printRoundScore();
        }
    }

    public void prepareForNewGame(){
        model.setFinishNumbers();
        model.resetScores();
        model.generateComputerNumbers();
    }

    public void getUserNumberInput() throws IllegalArgumentException {
        model.resetUserRoundNumbers();
        model.readLineRoundInput();
        model.checkUserRoundNumberLength();
        model.roundNumberConvertStringToInt();
        model.roundNumberConvertIntToArraylist();
    }

    public void getUserFinishInput() throws IllegalArgumentException{
        view.prinfFinishAnnouncement();
        model.readLineFinishInput();
        model.checkUserFinishNumberLength();
        model.finishNumberConvertStringToInt();
    }

    public void printRoundScore(){
        int roundStrike = model.getStrikeCount();
        int roundBall = model.getBallCount();
        if(roundStrike == 0 && roundBall == 0)
            view.printNothing();
        if(roundStrike == 0 && roundBall != 0)
            view.printBall(roundBall);
        if(roundStrike != 0 && roundBall == 0)
            view.printStrike(roundStrike);
        if(roundStrike != 0 && roundBall != 0)
            view.printBoth(roundStrike, roundBall);
    }
}

// Model
class BaseballGame {

    // Variables

    List<Integer> computerNumbers;
    List<Integer> userNumbers;
    List<Integer> finishNumbers;
    int strikeCount;
    int ballCount;
    int gameFinish;
    int userInputInteger;
    String userFinishInput;
    String userRoundInput;

    public BaseballGame() {
        this.computerNumbers = new ArrayList<>();
        this.userNumbers = new ArrayList<>();
        this.finishNumbers = new ArrayList<>();
        this.strikeCount = 0;
        this.ballCount = 0;
        this.gameFinish = 1;
        this.userInputInteger = 0;
        this.userFinishInput = null;
        this.userRoundInput = null;
    }

    // Methods

    public boolean checkGameFinish(){
        return gameFinish == 2;
    }

    public void setFinishNumbers(){
        if(finishNumbers.isEmpty()) {
            finishNumbers.add(1);
            finishNumbers.add(2);
        }
    }

    public void readLineFinishInput(){
        userFinishInput = Console.readLine();
    }

    public void checkUserFinishNumberLength() throws IllegalArgumentException{
        if(userFinishInput.length() != 1){
            throw new IllegalArgumentException();
        }
    }

    public void finishNumberConvertStringToInt() throws IllegalArgumentException{
        try{
            int userFinishInputInt = Integer.parseInt(userFinishInput);
            if(finishNumbers.contains(userFinishInputInt))
                gameFinish = userFinishInputInt;
            if(!finishNumbers.contains(userFinishInputInt))
                throw new IllegalArgumentException();
        }
        catch ( NumberFormatException | NullPointerException e) {
            throw new IllegalArgumentException();
        }
    }

    public void readLineRoundInput(){
        userRoundInput = Console.readLine();
    }

    public void checkUserRoundNumberLength() throws IllegalArgumentException{
        if(userRoundInput.length() != 3){
            throw new IllegalArgumentException();
        }
    }

    public void roundNumberConvertStringToInt() throws IllegalArgumentException{
        try {
            userInputInteger = Integer.parseInt(userRoundInput);
        }
        catch ( NumberFormatException | NullPointerException e) {
            throw new IllegalArgumentException();
        }
    }

    public void roundNumberConvertIntToArraylist() throws IllegalArgumentException{
        while (userInputInteger > 0) {
            int insertNumber = userInputInteger % 10;
            if(checkUserNumberForDuplicates(insertNumber)||checkUserNumberForZero(insertNumber))
                throw new IllegalArgumentException();
            userNumbers.add(insertNumber);
            userInputInteger /= 10;
        }
        Collections.swap(userNumbers, 0, 2);
    }

    public void resetUserRoundNumbers(){
        userNumbers.clear();
    }

    public void resetComputerNumbers(){
        computerNumbers.clear();
    }

    public boolean checkUserNumberForDuplicates(int insertNumber){
        return userNumbers.contains(insertNumber);
    }

    public boolean checkUserNumberForZero(int insertNumber){
        return(insertNumber == 0);
    }

    public void generateComputerNumbers() {
        if(!computerNumbers.isEmpty()){
            resetComputerNumbers();
        }
        while (computerNumbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumbers.contains(randomNumber)) {
                computerNumbers.add(randomNumber);
            }
        }
    }

    public void calculateScore(){
        resetScores();
        for (int index = 0; index < 3; index++) {
            int indexUserNumber = userNumbers.get(index);
            int indexComputerNumber = computerNumbers.get(index);
            if(indexUserNumber == indexComputerNumber) {
                incrementStrikeCount();
            }
            if(computerNumbers.contains(indexUserNumber) && indexComputerNumber != indexUserNumber){
                incrementBallCount();
            }
        }
    }

    public void incrementStrikeCount() {
        strikeCount += 1;
    }

    public void incrementBallCount() {
        ballCount += 1;
    }

    public void resetScores() {
        strikeCount = 0;
        ballCount = 0;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }

}

// View
class OutputView{
    public void startGameAnnouncement(){
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void prinfFinishAnnouncement(){
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    public void promptUserForRoundGuess() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    public void printStrike(int strikeCount) {
        System.out.println(strikeCount + "스트라이크");
    }

    public void printBall(int ballCount) {
        System.out.println(ballCount +"볼");
    }

    public void printNothing() {
        System.out.println("낫싱");
    }

    public void printBoth(int strikeCount, int ballCount) {
        System.out.println(ballCount+"볼 "+strikeCount+"스트라이크");
    }

}
