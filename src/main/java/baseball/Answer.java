package baseball;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Answer {
	List<Integer> answer;
	public Answer(){
		answer = new ArrayList<>();
		makeAnswer();
	}

	private void makeAnswer() {
		while (answer.size() < 3) {
			int randomNumber = Randoms.pickNumberInRange(1, 9);
			if (!answer.contains(randomNumber)) {
				answer.add(randomNumber);
			}
		}
	}

	private List<String> getResult(int[] userNumber){
		return answerTransforming(checkAnswer(userNumber));
	}

	private List<String> answerTransforming(List<Integer> integerResult) {
		List<String> result = new ArrayList<>();
		if (integerResult.get(0) == 0 && integerResult.get(1) == 0){
			result.add("낫싱");
			return result;
		}
		result.add(integerResult.get(0) + "스트라이크");
		result.add(integerResult.get(1) + "볼");
		return result;
	}

	private List<Integer> checkAnswer(int[] userNumber) {
		int strike = 0;
		int ball = 0;
		for (int i = 0; i < answer.size(); i++){
			for (int j = 0; j < answer.size(); j++){
				if (j == i && answer.get(i).equals(userNumber[j])) {
					strike++;
				}
				else if (answer.get(i).equals(userNumber[j])) ball++;
			}
		}
		List<Integer> result = new ArrayList<>();
		result.add(strike);
		result.add(ball);
		return result;
	}


}
