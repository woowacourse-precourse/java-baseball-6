package baseball.service;

import static baseball.Constants.BALL_NUMBER;
import static baseball.Constants.DIGIT_NUMBER;
import static baseball.Constants.RANGE_END_NUMBER;
import static baseball.Constants.RANGE_START_NUMBER;
import static baseball.Constants.STRIKE_NUMBER;
import static baseball.constants.Printer.ERROR_PHRASES;

import baseball.constants.Printer;
import baseball.repository.ComputerRepository;
import baseball.validator.DataValidator;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;

public class Service {

    private final ComputerRepository computerRepository;
    private final Printer printer;
    private final DataValidator dataValidator;
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
        for(int answer : computerAnswer){
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
            int[] answerArray = new  int[3];
            int answerOrder = 0;
            try {
                for (String input : inputStringArray) {
                    answerArray[answerOrder]=Integer.parseInt(input);
                }
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(ERROR_PHRASES);
            } catch (ArrayIndexOutOfBoundsException e){
                throw new IllegalArgumentException(ERROR_PHRASES);
            }
        return answerArray;
    }


}
