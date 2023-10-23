package baseball;

public class BaseballGameController {

    public BaseBallGameModel guess(Player computer, String input){
        NumberBoard computerAnswer = computer.getNumberBoard();
        NumberBoard playerAnswer = new NumberBoard(input);

        return countBallByAnswer(computerAnswer, playerAnswer);
    }

    private static BaseBallGameModel countBallByAnswer(NumberBoard computerAnswer, NumberBoard myAnswer) {
        int strike = 0;
        int ball = 0;
        int size = myAnswer.size();

        for(int i = 0; i<size; i++){
            for(int j = 0; j<size; j++){
                if(myAnswer.get(i) == computerAnswer.get(j) && i==j) {
                    strike++;
                    break;
                }
                if(myAnswer.get(i) == computerAnswer.get(j) && i!=j) {
                    ball++;
                    break;
                }
            }
        }

        int[] result = new int[2];
        result[0] = strike;
        result[1] = ball;
        return new BaseBallGameModel(result, size);
    }
}
