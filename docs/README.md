# 🌷 [1주차] 구현할 기능 목록

### 1. 사용자 입력 기능
- 사용자의 입력을 받는다.
    - `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용한다

### 2. 사용자 숫자 입력에 대한 검증 기능
- 사용자가 입력한 값이 3자리인지 검증한다
- 사용자가 입력한 값이 모두 숫자인지 검증한다
- 사용자가 입력한 값이 1에서 9까지의 숫자인지 검증한다
- 사용자가 입력한 값이 서로 다른 숫자인지 검증한다
- 검증을 통과하지 못하면 `IllegalArgumentException`을 발생시킨다

### 3. 게임 재시작 및 종료 입력에 대한 검증 기능
- 사용자가 입력한 값이 1 또는 2인지 검증한다
- 검증을 통과하지 못하면 `IllegalArgumentException`을 발생시킨다

### 4. 출력 기능
- 게임 시작 문구를 출력한다
- 입력 문구를 출력한다 (숫자 입력, 재시작/종료 여부)
- 낫싱, 볼, 스트라이크 등의 결과를 출력한다

### 5. 게임의 시작, 재시작 및 종료 기능
- 처음 애플리케이션을 시작하면 게임이 시작한다
- 게임의 결과가 3스트라이크면 게임이 종료된다
- 게임이 종료되면 사용자에게 재시작/종료 여부를 묻는다 (1이면 재시작, 2면 종료)
- 사용자가 잘못된 값을 입력해서 `IllegalArgumentException`이 발생하면 종료한다

### 6. 컴퓨터 숫자 생성 기능
- 1에서 9까지의 숫자를 3개 생성한다
- `camp.nextstep.edu.missionutils.Randoms`의 `pickNumberInRange()`를 활용한다
- 서로 다른 수 3개를 생성하기 위해 `Set`을 활용한다

### 7. 게임 동작
- 사용자 입력을 받기 전, 6. 컴퓨터 숫자 생성 기능으로 컴퓨터의 숫자를 생성 및 검증한다
- 사용자의 검증된 입력값을 저장한다
- 사용자와 컴퓨터의 숫자를 비교하여 볼/스트라이크/낫싱 결과를 저장 및 출력한다
- 사용자와 컴퓨터의 숫자가 일치할 때까지 사용자 입력 받기부터의 과정을 반복한다


### 8. 스트라이크 개수 확인

- `countStrike` 메서드 안에 `isDigitStrike`을 구현한다
- `isDigitStrike`는 두 숫자를 비교하여 스트라이크 여부를 확인한다
- `countStrike`는 `isDigitStrike`의 결과로 스트라이크 수를 계산한다

### 9. 볼 수 확인

- `countBall` 메서드 안에 `isDigitBall`을 구현한다
- `isDigitBall`은 사용자 인풋의 숫자 하나와 컴퓨터 숫자 3개를 비교하여 볼 여부를 확인한다
- `countBall`은 `isDigitBall`의 결과로 볼 수를 계산한다

- - - 
# 🌻 [1주차] 클래스 모델링

## 1. InputView
- 입력과 관련한 문구를 출력한다

## 2. OutputView
- 출력과 관련한 문구를 출력한다

## 3. Ball

- 변수
    - `private static final char MIN_NUMBER`
    - `private static final char MAX_NUMBER`
    - `private final Integer number`: `final`로 설정해 불변성을 보장한다
- 메서드
    - `void validateIsNaturalNumber`
    - `boolean equals`

```java
public class Ball {
	private static final int ZERO = 0;
    private final Integer number;
    
    public Ball(String input) {
    	this.number = validateIsNaturalNumber(input);
    }
    
    int validateIsNaturalNumber(char val) {}
    boolean equals(Ball a, Ball b) {}
}
```

## 4. UserBalls

- 변수
    - `private static final int LENGTH`
    - `private final List<Ball> userBalls`
- 메서드
    - `void validateIsThreeDigits`: string 인풋이 세글자인지 확인
    - `void validateDiffVals`

```java
public class UserBalls {
	private static final int LENGTH = 3;
    private final List<Ball> userBalls;
    
    public UserBalls(String input) {
    	validateHasThree;
        validateDiffVals;
        // stream 사용
    }
    
    void validateIsThreeDigits(String input) {}
    void validateDiffVals(String input) {}

}
```

## 5. Score

- 변수
    - `private final int strike`
    - `private final int ball`
- 메서드
    - `boolean isThreeStrikes`
    - `int getStrike()`
    - `int getBall()`
## 6. GameRules

- `countStrike`: `isDigitStrike`의 결과로 스트라이크 수를 계산한다
- `isDigitStrike`: 두 숫자를 비교하여 스트라이크 여부를 확인한다
- `countBall`: `isDigitBall`의 결과로 볼 수를 계산한다
- `getResult`: 볼과 스트라이크의 수를 `Score`로 리턴한다


## 7. ComputerBalls

- 변수
    - `private static final int LENGTH`
    - `private final List<Ball> computerBalls`
- 메서드
    - `List<Ball> generateComputerBalls`
    - 서로 다른 숫자만 포함하는지에 대한 검증 로직은 `Set`을 사용함으로써 대체한다

## 8. BaseballGame

- 게임의 모든 요소를 사용해 흐름을 구현한다