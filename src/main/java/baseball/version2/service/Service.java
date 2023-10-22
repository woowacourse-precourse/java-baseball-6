package baseball.version2.service;


import static baseball.version2.Constants.Value.*;

import baseball.version2.dto.ScoreDto;
import baseball.version2.repository.ComputerRepository;
import baseball.version2.repository.ScoreRepository;
import baseball.version2.view.InputView;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;

public class Service {

    private final ComputerRepository computerRepository;
    private final InputView inputView;
    private ScoreRepository scoreRepository;

    public Service() {
        this.computerRepository = new ComputerRepository();
        this.scoreRepository = new ScoreRepository();
        this.inputView = new InputView();
    }

    // 컴퓨터 서비스
    public ArrayList<Integer> getComputerAnswer() {
        ArrayList<Integer> computerAnswer = new ArrayList<>();
        while (computerAnswer.size() < ANSWER_ARRAY_SIZE) {
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
        int[] answerArray = new int[ANSWER_ARRAY_SIZE];
        int answerOrder = 0;
        for (int answer : computerAnswer) {
            answerArray[answerOrder++] = answer;
        }

        return answerArray;
    }

    // 플레이어 서비스


    public void compareTwoAnswer(int[] playerAnswer) {

        for (int i = 0; i < playerAnswer.length; i++) {
            checkPlayerValueAndComputerAnswer(playerAnswer, i);
        }
    }

    private void checkPlayerValueAndComputerAnswer(int[] playerAnswer, int i) {
        int[] computerAnswer = computerRepository.getAnswerArray();
        for (int j = 0; j < computerAnswer.length; j++) {
            if (playerAnswer[i] == computerAnswer[j] && i == j) {
                scoreRepository.increaseStrike();
            }
            if (playerAnswer[i] == computerAnswer[j] && i != j) {
                scoreRepository.increaseBall();
            }
        }
    }


    public void initScoreRepository() {
        scoreRepository.initScore();
    }

    public ScoreDto getResult() {
        ScoreDto scoreDto = new ScoreDto(scoreRepository.getBall(), scoreRepository.getStrike());
        return scoreDto;
    }
}
