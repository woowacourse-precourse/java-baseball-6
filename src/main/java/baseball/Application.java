package baseball;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Application {
	public static void main(String[] args) {

		System.out.println("숫자 야구 게임을 시작합니다.");
		String re = "1";
		// 시작/재시작 1 - Controller
		while(re.equals("1")){
			// 랜덤 숫자 생성
			List<Integer> computer = new ArrayList<>();
			while(computer.size() < 3){
				int randomNumber = Randoms.pickNumberInRange(1, 9);
				if(!computer.contains(randomNumber)){
					computer.add(randomNumber);
				}
			}


			List<Integer> user;

			while(true) {

				// 사용자 입력 받기 2 - UserInput
				user = new ArrayList<>();
				int strike = 0, ball = 0;

				System.out.print("숫자를 입력해주세요 : ");
				String[] userInput = Console.readLine().split("");

				if(userInput.length != 3){
					throw new IllegalArgumentException("잘못된 입력입니다.");
				}

				for(String a : userInput){
					if(!user.contains(Integer.parseInt(a))){
						user.add(Integer.parseInt(a));
					}
				}

				if(user.size() != 3){
					throw new IllegalArgumentException("잘못된 입력입니다.");
				}

				// 스트라이크, 볼 검사 3 - Calculation
				for(int i = 0; i < 3; i++){
					if(Objects.equals(computer.get(i), user.get(i))) {
						strike++;
					}
					if(computer.contains(user.get(i))) {
						ball++;
					}
				}
				if(strike == 0 && ball == 0){
					System.out.println("낫싱");
					continue; //입력으로 다시 돌아감.
				}
				if(ball != 0){
					System.out.print(strike+"볼 ");
				}
				if(strike != 0 ){
					System.out.print(strike+"스트라이크");
				}
				if(strike == 3){
					System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
					System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
					re = Console.readLine();
					break;  // 입력 while문 빠져나옴.
				}
			}

		}
	}
}