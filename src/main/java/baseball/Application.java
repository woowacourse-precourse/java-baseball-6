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
        while(!model.checkGameFinish()){            // User가 2를 입력하는 경우까지 시행한다.
            prepareForNewGame();                    // 새로운 게임의 시작을 위해 일부 변수를 초기화합니다.
            loadNewGame();                          // 새로운 게임을 시작합니다.
            getUserFinishOrRestart();               // 유저에게 게임의 재시작/종료 여부를 묻습니다.
        }
    }

    public void prepareForNewGame(){
        view.startGameAnnouncement();               // 게임 시작시 문자열을 출력합니다.
        model.resetComputerNumbers();               // 게임에서 사용할 컴퓨터의 숫자를 초기화합니다.
        model.generateComputerNumbers();            // 게임에서 사용할 컴퓨터의 숫자를 새로 생성합니다.
        model.resetScores();                        // 라운드의 점수 계산전 이전 라운드의 점수를 초기화합니다.
    }

    public void loadNewGame() throws IllegalArgumentException {
        do{
            model.resetScores();                    // 라운드의 점수 계산전 이전 라운드의 점수를 초기화합니다.
            view.promptUserForRoundGuess();         // 유저에게 숫자 입력을 안내합니다.
            getUserNumberInput();                   // 유저에게 숫자를 입력받아 Model의 userNumber Array에 넣습니다.
            model.calculateScore();                 // 해당 라운드의 점수를 계산합니다.
            printRoundScore();                      // 해당 라운드의 점수를 출력합니다.
        }while(model.getStrikeCount() != 3);        // 스트라이크가 3개가 될 때까지 진행합니다.
    }

    public void getUserNumberInput() throws IllegalArgumentException {
        model.resetUserRoundNumbers();
        model.readLineRoundInput();
        model.checkUserRoundNumberLength();
        model.roundNumberConvertStringToInt();
        model.roundNumberConvertIntToArraylist();
    }

    public void getUserFinishOrRestart() throws IllegalArgumentException{
        view.printFinishAnnouncement();
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

    // Constant
    public static final int ROUND_SIZE = 3;
    public static final int FINISH_SIZE = 1;
    public static final int GAME_FINISH = 2;
    public static final int GAME_RESTART = 1;

    // Variables
    private List<Integer> computerNumbers;
    private List<Integer> userNumbers;
    private int strikeCount;
    private int ballCount;
    private int gameFinish;
    private int userInputInteger;
    private String userFinishInput;
    private String userRoundInput;

    public BaseballGame() {
        this.computerNumbers = new ArrayList<>();
        this.userNumbers = new ArrayList<>();
        this.strikeCount = 0;
        this.ballCount = 0;
        this.gameFinish = 3;
        this.userInputInteger = 0;
        this.userFinishInput = null;
        this.userRoundInput = null;
    }

    // Methods
    public boolean checkGameFinish(){
        return this.gameFinish == 2;
    }

    public void readLineFinishInput(){
        this.userFinishInput = Console.readLine();
    }

    public void checkUserFinishNumberLength() throws IllegalArgumentException{
        if(userFinishInput.length() != FINISH_SIZE){
            throw new IllegalArgumentException();
        }
    }

    public void finishNumberConvertStringToInt() throws IllegalArgumentException{
        try{
            int userFinishInputInt = Integer.parseInt(userFinishInput);
            if( userFinishInputInt != GAME_RESTART && userFinishInputInt != GAME_FINISH )
                throw new IllegalArgumentException();
            this.gameFinish = userFinishInputInt;
        }
        catch ( NumberFormatException | NullPointerException e) {
            throw new IllegalArgumentException();
        }
    }

    public void readLineRoundInput(){
        this.userRoundInput = Console.readLine();
    }

    public void checkUserRoundNumberLength() throws IllegalArgumentException{
        if(userRoundInput.length() != ROUND_SIZE){
            throw new IllegalArgumentException();
        }
    }

    public void roundNumberConvertStringToInt() throws IllegalArgumentException{
        try {
            this.userInputInteger = Integer.parseInt(userRoundInput);
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

    public boolean checkUserNumberForDuplicates(int insertNumber){
        return userNumbers.contains(insertNumber);
    }

    public boolean checkUserNumberForZero(int insertNumber){
        return(insertNumber == 0);
    }

    public void generateComputerNumbers() {
        while (computerNumbers.size() < ROUND_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumbers.contains(randomNumber)) {
                computerNumbers.add(randomNumber);
            }
        }
        System.out.println(computerNumbers);
    }

    public void resetComputerNumbers(){
        if(!computerNumbers.isEmpty()){
            computerNumbers.clear();
        }
    }

    public void calculateScore(){
        for (int index = 0; index < ROUND_SIZE; index++) {
            int indexUserNumber = userNumbers.get(index);
            int indexComputerNumber = computerNumbers.get(index);
            if( indexComputerNumber == indexUserNumber){
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
        this.strikeCount = 0;
        this.ballCount = 0;
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

    public void printFinishAnnouncement(){
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
