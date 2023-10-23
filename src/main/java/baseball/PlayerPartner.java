package baseball;

public class PlayerPartner {
    private int partnerNumner = 0;
    private boolean[] isExsitNumbers = new boolean[10];

    public PlayerPartner(){}

    private void setPartnerNumner() {
        // 구현 필요
    }

    public void startGame(){
        setPartnerNumner();

        int strikeCount = 0;

        while(isAllStrike(strikeCount)){
            int playerNumber = Player.nextNumberOf().getNumber();
            strikeCount = getStrikeCount(playerNumber);
            int ballCount = getBallCount(playerNumber, strikeCount);

            printBall(strikeCount, ballCount);
        }
    }

    private int getStrikeCount(int playerNumber) {
        int strikeCount = 0;

        while(playerNumber / 10 > 0){
            int playerRemain = playerNumber % 10;
            int partnerRemain = partnerNumner % 10;

            if(playerRemain == partnerRemain){
                strikeCount++;
            }

            playerNumber /= 10;
        }

        return strikeCount;
    }

    private int getBallCount(int playerNumber, int strikeCount) {
        int matchCount = 0;

        while(playerNumber / 10 > 0){
            int playerRemain = playerNumber % 10;

            if(isExsitNumbers[playerRemain]){
                matchCount++;
            }

            playerNumber /= 10;
        }

        return matchCount-strikeCount;
    }

    private boolean isAllStrike(int strikeCount) {
        return strikeCount == 3;
    }

    private void printBall(int strikeCount, int ballCount) {
        StringBuffer message = new StringBuffer();

        if(ballCount > 0){
            message.append(ballCount +"볼 ");
        }

        if(strikeCount > 0){
            message.append(strikeCount +"스트라이크");
        }

        System.out.println(message.toString());
    }
}