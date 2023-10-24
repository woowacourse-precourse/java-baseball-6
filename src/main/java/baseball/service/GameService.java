package baseball.service;

public class GameService {
    public int strikeResult(String computer, String player){
        int result = 0;
        char[] computerBall = computer.toCharArray();
        char[] playerBall = player.toCharArray();

        for (int i=0; i<computerBall.length; i++) {
            if (computerBall[i] == playerBall[i]) {
                result += 1;
            }
        }
        return result;
    }

    public int ballResult(String computer, String player) {
        int result = 0;
        int strike = strikeResult(computer, player);
        String[] playerBall = player.split("");

        for (String s : playerBall) {
            if (computer.contains(s)) {
                result += 1;
            }
        }
        return result - strike;
    }
}
