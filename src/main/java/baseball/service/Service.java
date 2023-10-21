package baseball.service;

import static baseball.Constants.DIGIT_NUMBER;
import static baseball.Constants.RANGE_END_NUMBER;
import static baseball.Constants.RANGE_START_NUMBER;

import baseball.repository.ComputerRepository;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class Service {

    private final ComputerRepository computerRepository;

    public Service() {
        this.computerRepository = new ComputerRepository();
    }

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
        int[] answerArray = new int[2];
        int answerOrder = 0;
        for(int answer : computerAnswer){
            answerArray[answerOrder++] = answer;
        }

        return answerArray;
    }
}
