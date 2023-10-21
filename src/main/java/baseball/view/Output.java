package baseball.view;

import baseball.results.Results;

public interface Output {

    void displayGameStartMessage();

    void displayRequestNumberMessage();

    void displayCongratulationMessage();

    void displayAskRestartMessage();

    void displayResults(Results results);

}
