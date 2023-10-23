package baseball;

import camp.nextstep.edu.missionutils.Randoms;

public class PlayerPartner {
    private int answer = 0;
    private boolean[] answerSheet = new boolean[10];

    public PlayerPartner(){}

    private void writeAnswer() {
        StringBuffer stringAnswer = new StringBuffer();

        while(stringAnswer.length() < 3){
            int number = Randoms.pickNumberInRange(1, 9);

            if(!this.answerSheet[number]){
                this.answerSheet[number] = true;
                stringAnswer.append(number);
            }
        }

        this.answer = Integer.parseInt(stringAnswer.toString());
    }

    public void startGame(){
        writeAnswer();

        int strikeCount = 0;

        while(isContinue(strikeCount)){
            int playerNumbers = Player.nextNumberOf().getNumber();
            strikeCount = getStrikeCount(playerNumbers);
            int ballCount = getBallCount(playerNumbers, strikeCount);

            printBallStatus(strikeCount, ballCount);
        }
    }

    private int getStrikeCount(int playerNumbers) {
        int strikeCount = 0;
        int standardNumbers = this.answer;
        while(playerNumbers % 10 > 0){
            int playerNumber = playerNumbers % 10;
            int partnerNumber = standardNumbers % 10;

            if(playerNumber == partnerNumber){
                strikeCount++;
            }

            playerNumbers /= 10;
            standardNumbers /= 10;
        }

        return strikeCount;
    }

    private int getBallCount(int playerNumbers, int strikeCount) {
        int matchCount = 0;

        while(playerNumbers % 10 > 0){
            int playerNumber = playerNumbers % 10;

            if(this.answerSheet[playerNumber]){
                matchCount++;
            }

            playerNumbers /= 10;
        }

        return matchCount - strikeCount;
    }

    private boolean isContinue(int strikeCount) {
        return strikeCount < 3;
    }

    private void printBallStatus(int strikeCount, int ballCount) {
        StringBuffer message = new StringBuffer();

        if (ballCount > 0) {
            message.append(ballCount + "볼 ");
        }

        if (strikeCount > 0) {
            message.append(strikeCount + "스트라이크");
        }

        if (ballCount == 0 && strikeCount == 0) {
            message.append("낫싱");
        }

        System.out.println(message.toString());
    }
}