package baseball.service;

import static baseball.version1.Constants.BALL_NUMBER;
import static baseball.version1.Constants.DIGIT_NUMBER;
import static baseball.version1.Constants.RANGE_END_NUMBER;
import static baseball.version1.Constants.RANGE_START_NUMBER;
import static baseball.constants.Printer.ERROR_PHRASES;
import static baseball.version1.Constants.STRIKE_NUMBER;
import static java.lang.Integer.parseInt;

import baseball.constants.Printer;
import baseball.repository.ComputerRepository;
import baseball.repository.ScoreRepository;
import baseball.validator.DataValidator;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;

public class Service {

    private final ComputerRepository computerRepository;
    private final Printer printer;
    private final DataValidator dataValidator;
    private ScoreRepository scoreRepository;
    public Service() {
        this.computerRepository = new ComputerRepository();
        this.printer = new Printer();
        this.dataValidator = new DataValidator();
    }

    // 컴퓨터 서비스
    public ArrayList<Integer> getComputerAnswer() {
        ArrayList<Integer> computerAnswer = new ArrayList<>();
        while (computerAnswer.size() < DIGIT_NUMBER) {
            int randomNumber = Randoms.pickNumberInRange(RANGE_START_NUMBER, RANGE_END_NUMBER);
            if (!computerAnswer.contains(randomNumber)) {
                computerAnswer.add(randomNumber);
            }
        }
        return computerAnswer;
    }

    public void saveComputerAnswer(ArrayList<Integer> computerAnswer) {
        int[] computerAnswerArray = convertListToArray(computerAnswer);
        computerRepository.setAnswerArray(computerAnswerArray);
    }

    private int[] convertListToArray(ArrayList<Integer> computerAnswer) {
        int[] answerArray = new int[3];
        int answerOrder = 0;
        for (int answer : computerAnswer) {
            answerArray[answerOrder++] = answer;
        }

        return answerArray;
    }

    // 플레이어 서비스

    public int[] getPlayerAnswer() {
        printer.printInsertAnswer();
        String[] inputStringArray = Console.readLine().split("");
        int[] playerAnswerArray = convertStringToInt(inputStringArray);
        dataValidator.validatePlayerAnswer(playerAnswerArray);
        return playerAnswerArray;
    }

    private int[] convertStringToInt(String[] inputStringArray) {
        int[] answerArray = new int[3];
        int answerOrder = 0;
        try {
            for (String input : inputStringArray) {
                answerArray[answerOrder] = parseInt(input);
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_PHRASES);
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new IllegalArgumentException(ERROR_PHRASES);
        }
        return answerArray;
    }


    public void compareTwoAnswer(int[] playerAnswer) {
        scoreRepository = new ScoreRepository();
        for (int i = 0; i < playerAnswer.length; i++) {
            checkPlayerValueAndComputerAnswer(playerAnswer, i);
        }
    }

    private void checkPlayerValueAndComputerAnswer(int[] playerAnswer, int i) {
        int[] computerAnswer = computerRepository.getAnswerArray();
        for (int j=0;j<computerAnswer.length;j++) {
            if ( playerAnswer[i]==computerAnswer[j] && i == j){
                scoreRepository.increaseStrike();
            }
            if (playerAnswer[i]==computerAnswer[j] && i != j) {
                scoreRepository.increaseBall();
            }
        }
    }

    public void printResult() {
        int ball = scoreRepository.getBall();
        int strike = scoreRepository.getStrike();

        if (ball == 0 && strike == 0) {
            printer.printNothing();
        }
        if(ball==0&&strike>0){
            printer.printStrike(strike);
        }
        if(ball>0&&strike==0){
            printer.printBall(ball);
        }
        if(ball>0&&strike>0){
            printer.printBallAndStrike(ball,strike);
        }
    }

    public int getPlayerDecision() {
        printer.printSelectContinue();
        int decision = Integer.parseInt(Console.readLine());
        dataValidator.validateDecision(decision);
        return decision;
    }
}
