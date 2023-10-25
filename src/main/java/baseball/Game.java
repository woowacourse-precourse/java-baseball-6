package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Game {
    public Game(){

    }

    public void play(){
        printStartMessage();
        do{
            playGame();
        } while (shouldRestartGame());
    }

    private void playGame(){
        AnswerBalls answerBalls;
        AnswerBalls responseBalls;
        AnswerCheck answerCheck = null;

        answerBalls = AnswerBalls.makeAnswerBalls();
        do{
            responseBalls = AnswerBalls.makeResponseBalls(getUserInput());
            answerCheck = AnswerCheck.checkBalls(answerBalls, responseBalls);
            printResult(answerCheck);
        }while (!answerCheck.isAllStrike());
        printAnswerCorrect();
    }

    private void printInputRequestMessage(){
        System.out.print("숫자를 입력해주세요 : ");
    }

    private String getUserInput(){
        printInputRequestMessage();
        String userInput = readLine();
        if(userInput.length()!= 3){
            throw new IllegalArgumentException("3개의 숫자를 입력해야 합니다.");
        }
        return userInput;
    }
    private void printStartMessage(){
        System.out.println("숫자 야구 게임을 시작합니다.");
    }
    private void printResult(AnswerCheck answerCheck){
        String checkingMessage = answerCheck.getCheckingMessage();
        System.out.println(checkingMessage);
    }
    private void printAnswerCorrect(){
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
    private boolean shouldRestartGame(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int inputRestart = Integer.parseInt(readLine());
        if(inputRestart != 1 && inputRestart != 2){
            throw new IllegalArgumentException("1 또는 2만 입력할 수 있습니다.");
        }
        return inputRestart == 1;
    }
}
