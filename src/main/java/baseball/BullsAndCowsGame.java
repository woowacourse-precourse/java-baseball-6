package baseball;

import camp.nextstep.edu.missionutils.Console;

public class BullsAndCowsGame extends AbstractTurnBasedGame {
    private LanguagePack languagePack;
    private Player host;
    private Player guest;
    private Result result;

    public BullsAndCowsGame() {
        languagePack = new KoreanLanguagePack();
        host = new Player(new RandomSecretNumberResolver());
        guest = new Player(new ConsoleSecretNumberResolver());
    }

    @Override
    protected void onGameStarted() {
        System.out.print(languagePack.renderGameStartMsg());
    }

    @Override
    protected void onRoundStarted() {
        host.updateSecretNumber();
    }

    @Override
    protected void onRoundEnded() {
        System.out.print(languagePack.renderVictoryMsg());
        System.out.print(languagePack.renderGameEndMsg());
    }

    @Override
    protected boolean hasNextRound() throws IllegalArgumentException {
        System.out.print(languagePack.renderAskNewGameMsg());
        String userChoice = Console.readLine();
        switch (userChoice) {
            case UserCommand.RESTART:
                return true;
            case UserCommand.QUIT:
                return false;
            default:
                throw new IllegalArgumentException();
        }
    }

    @Override
    protected void onTurnStarted() {
        System.out.print(languagePack.renderAskNumbersMsg());
        guest.updateSecretNumber();
    }

    @Override
    protected void onTurnEnded() {
        updateResult();
        System.out.print(languagePack.renderHintMsg(result));
    }

    @Override
    protected boolean hasNextTurn() {
        return result.bulls != SecretNumber.SIZE;
    }

    private void updateResult() {
        result = getResult();
    }

    private Result getResult() {
        int bulls = 0;
        int cows = 0;
        for (int i = 0; i < SecretNumber.SIZE; i++) {
            for (int j = 0; j < SecretNumber.SIZE; j++) {
                if (host.getSecretNumber().get(i) == guest.getSecretNumber().get(j)) {
                    if (i == j) {
                        bulls++;
                    } else {
                        cows++;
                    }
                }
            }
        }
        return new Result(bulls, cows);
    }
}
