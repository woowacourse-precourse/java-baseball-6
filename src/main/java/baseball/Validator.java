package baseball;

import static baseball.Type.BALL;
import static baseball.Type.NONE;
import static baseball.Type.STRIKE;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Validator {
  int randomNumber;
  int inputNumber;
  ArrayList<String> randomList = new ArrayList<>();
  ArrayList<Baseball> inputList = new ArrayList<>();

  public Validator(int randomNumber, int inputNumber) {
    this.randomNumber = randomNumber;
    this.inputNumber = inputNumber;
  }

  public void init() {
    String[] splitRandom = String.valueOf(randomNumber).split("");
    String[] splitInput = String.valueOf(inputNumber).split("");
    addToList(splitRandom, splitInput);
  }

  public void addToList(String[] randomArr, String[] inputArr) {
    for(int i=0; i<3; i++) {
      this.randomList.add(randomArr[i]);
      this.inputList.add(new Baseball(NONE, Integer.parseInt(inputArr[i]), i));
    }
  }

  //TODO: 해당 로직 리팩토링 필요
  public void changeInputBaseballType() {
    for(Baseball baseball : inputList) {
      String baseballNumber = String.valueOf(baseball.number);
      if(randomList.contains(baseballNumber)) {
        if(randomList.indexOf(baseballNumber) == baseball.index) {
          baseball.changeType(STRIKE);
        } else {
          baseball.changeType(BALL);
        }
      }
    }
  }

  public Map<String, Integer> calculateResult() {
    Map<String, Integer> resultTable = new HashMap<>();
    int ball = 0;
    int strike = 0;
    resultTable.put("스트라이크", 0);
    resultTable.put("볼", 0);

    for(Baseball baseball : inputList) {
      if(baseball.type == STRIKE) {
        resultTable.put("스트라이크", resultTable.get("스트라이크") + 1);
//        strike++;
      } else if(baseball.type == BALL) {
        resultTable.put("볼", resultTable.get("볼") + 1);
//        ball++;
      }
    }
    return resultTable;
  }

  public boolean answerOfProgress(String answer) {
    if(answer.equals("1")) {
      return true;
    }
    return false;
  }

}
