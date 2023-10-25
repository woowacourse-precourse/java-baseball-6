package baseball.view;

import baseball.domain.results.Results;

public interface Output {

    void displayGameStartMessage();

    void displayRequestNumberMessage();

    void displayCongratulationMessage();

    void displayAskRestartMessage();

    void displayResults(Results results);

}
