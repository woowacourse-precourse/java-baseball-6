package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class AnswerFactory {
    public static final int ANSWER_SIZE =3;
    private static final int NUMBER_MAX_SIZE =10;
    private static final int START_RANG = 1;
    private static final int END_RANG = 9;

    public Answer createAnswerArray(){
        boolean[] numberVisit = new boolean[NUMBER_MAX_SIZE];
        int[] answer = new int[ANSWER_SIZE];

        for(int i =0; i<ANSWER_SIZE;i++){
            int number = Randoms.pickNumberInRange(START_RANG, END_RANG);
            if(numberVisit[number]){
                i--;
                continue;
            }

            numberVisit[number] = true;
            answer[i] = number;
        }

        return new Answer(answer, numberVisit);
    }
}