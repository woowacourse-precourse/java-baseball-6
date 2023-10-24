package baseball;

	import java.util.ArrayList;
	import java.util.List;
	import camp.nextstep.edu.missionutils.*;

public class AnswerGenerator { 
	List<Integer> Answerlist = new ArrayList<>();
	
	public void RandomNumGeneration(){ // 랜덤 Number list 생성
		List<Integer> Answerlist = new ArrayList<>();
		while (Answerlist.size() < 3) {
			int randomNumber = Randoms.pickNumberInRange(1, 9);
			
			if (!Answerlist.contains(randomNumber)) {
				Answerlist.add(randomNumber);
			}
		}
		this.Answerlist = Answerlist;
	}
}

