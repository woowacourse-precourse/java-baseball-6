# 클린 코드
## 비대함을 해결하자
https://refactoring.guru/smells/long-method

- 긴 메소드를 피해라
	- 메소드가 길면 기능이 여러개일 가능성이 많다. 기능이 여러개면 코드를 읽는 다른 사람이 메서드를 이해하기 어려워진다.
- 파라미터를 3개 이상 쓰지마라. 
	- 파라미터 또한 많으면 메서드가 수행하는 기능이 여러개일 가능성이 높다.
- 커다란 클래스를 만들지 마라
	- 클래스를 작은 클래스로 책임을 나눠라. 클래스가 작고 할일이 분명하면 다른 개발자가 볼 때도 그 클래스가 무얼하는지 많은 것을 기억할 필요가 없다. 

기능이 오직 하나인 메서드, 책임이 하나인 클래스가 좋은 이유는 
- 단위 테스트 코드를 짜기 쉽다. (테스트코드 - 메소드 분리 참고)
- 다른 개발자가 볼 때도 그것이 무얼하는지 많은 것을 기억할 필요가 없다. 

## 한 메서드에서 하나의 들여쓰기만 사용하자
이전 코드를 먼저 보면 
```
private void calculateCount(int[] userInput, int[] computerNumbers){
	for(int userIndex = 0; userIndex < 3; userIndex++){
		if(isStrike(userInput, computerNumbers, userIndex)) {
			strikeCount++;
		}
		else if(isBall(userInput, computerNumbers, userIndex)){
			ballCount++;
		}
	}
}
```
들여쓰기가 두번 되어 있는 것을 볼 수 있다. 아직은 코드가 복잡해지지 않아서 그렇지 스케일이 큰 프로젝트에서 들여쓰기가 두번된 코드를 보면 머리가 복잡해지고 가독성이 떨어진다.

메서드를 분리해서 이를 해결한 코드이다. 
```
private void calculateCount(int[] userInput, int[] computerNumbers){
	for(int userIndex = 0; userIndex < 3; userIndex++){
		countStrike(userInput, computerNumbers, userIndex);
		countBallOneByOne(userInput, computerNumbers, userIndex);
	}
}
private void countStrike(int[] userInput, int[] computerNumbers, int index){
	if(userInput[index] == computerNumbers[index]) strikeCount++;
}
```
calculateCount 코드를 보면 확실하게 이해하기 쉽다. "유저가 입력한 숫자 하나하나 스트라이크를 세고, 볼을 센다." 이처럼 메서드를 분리하니까 코드 가독성이 올라갔다. 
그리고 메서드를 분리하면 기능이 한개가 되므로 여러개였을 때다 범용성이 높아 코드 재사용성이 높아진다. 