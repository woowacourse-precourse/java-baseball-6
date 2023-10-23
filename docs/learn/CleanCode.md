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


## 원시타입을 포장하자
(https://tecoble.techcourse.co.kr/post/2020-05-29-wrap-primitive-type/)
가장 와닿지 않는 말인데 내가 프로젝트하면서 한번도 원시타입을 포장할 생각이 없었기 때문이다. 이 내용을 이해할 수 없어도 일단 따라보고 그 결과를 지켜보기로 했다.

원시타입을 포장하는 이유는
### 상태를 관리할 수 있다.
원시타입을 사용할 경우 상태를 관리하기 어렵지만 원시타입을 포장할 경우 상태를 관리할 수 있다.
다음은 교통카드 클래스이고 원시타입을 사용한다.
```
public class TransportationCard {
	int amount; 
	TransportationCard(int amount){
		this.amount = amount;
	}
	
}
```
만약 교통카드 한도가 10만원이라면 원시타입으로는 10만원을 넘기는 값이 들어오면 예외 처리를 할 수 없다.
이럴 때 원시타입을 포장하는 것은 도움이 된다.

```
public class Amount {
	private int amount;
	Amount(int coin){
		if(coin > 100000){
			throw new IlligalArgumentException;
		}
		this.amount = coin;
	}
}
public class TransportationCard {
	Amount amount; 
	TransportationCard(int coin){
		this.amount = new Amount(coin);
	}
	
}
```
Amount라는 클래스를 생성해서 한도를 넘기면 예외처리를 하도록 변경했다.
이전에는 amount 변수를 우리의 비즈니스에 맞게할 수 없었지만 가능해졌다.

```
public class TransportationCard {
	int amount; 
	TransportationCard(int amount){
		if(amount > 100000){
			throw new IlligalArgumentException;
		}
		this.amount = amount;
	}
	
}
```
이렇게도 amount 예외처리를 할 수 있다만 중요한 것은 이 TransportationCard 클래스는 예외처리 하도록 만들어진 클래스는 아니라는 것이다.
### 유지보수에 도움이 된다.
원시타입을 사용하면 자연스레 포장을 했을 때 안에 있었던 기능들이 클래스들로 뿔뿔히 흩어지게 된다.
이를태면 TransportationCard에서 태그할 때돈을 계산하고 Account로 환전 될 수 있다.
```
public class TransportationCard {
	int amount; 
	void tag(int price){
		this.amount -= price;
	}
	void transfer(int amount, Account account){
		this.amount -= amount;
		account.plus(amount);
	}
}
public class Account {
	int amount;
	void plus(int amount){
		this.amount += amount;
	}
}
```
하지만 여기서 환율이라는 기능이 추가되면 어떻게 될까.
두 클래스 전부 환율 기능을 추가하기 위해 수정되어야한다. 두 클래스라서 그렇지 3개 이상 수정하게 되면 꽤나 골치 아플 것이다. 이따 Amount라는 클래스로 원시타입을 포장하면 한 클래스에 이체 기능을 추가하는 것만으로도 끝난다.

이것보다 어떻게 분리하지? 라는 생각이 있었는데 원시 타입을 포장하니까 분리할 수 있는 영역들이 꽤나 많다는 것을 느꼈다.

### 원시값 포장과 VO
https://engineerinsight.tistory.com/37
자주 이 둘이 함께 소개되는 것을 볼 수 있다.
VO는 유효성 검사, 동등성 비교, 불변성을 가지는 객체이다. 값을 가리키는 객체라는 점에서 원시타입을 포장했다고도 볼 수 있다.
하지만 원시값을 포장했다고 무조건 VO가 되는 것은 아니다. 유효성 검사, 동등성 비교, 불변성을 포함해야하기 때문이다.

원시값 포장은 VO를 포함하는 개념이라고 볼 수 있다.
