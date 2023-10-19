## 기능 목록

### 플레이어의 입력을 받는 기능 `inputPlayerNumber()`

- `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 사용하여 사용자의 입력을 받는다.
- 입력받은 값을 `validatePlayerInput()`의 인수로 넣어줘서 예외가 발생하는지 확인
- 예외가 발생하지 않는다면 입력받은 값으로 Player의 값으로 설정

### `inputPlayerNumber()` 에서 받은 값을 검증하는 기능인 `validatePlayerInput()`

- 요구사항 : 서로 다른 세자리수, 숫자만 가능
- 요구사항에 만족하지 않으면 `IllegalArgumentException`을 발생시킨다

### 컴퓨터의 랜덤한 숫자를 생성해주는 `generateComputerRandomNumber()`

- `camp.nextstep.edu.missionutils.Randoms`의 `pickNumberInRange()`를 사용

```java
List<Integer> computer=new ArrayList<>();
while(computer.size()< 3){
    int randomNumber=Randoms.pickNumberInRange(1,9);
    if(!computer.contains(randomNumber)){
        computer.add(randomNumber);
    }
}
```

- 위 코드에서 저장된 computer의 값을 Computer의 값으로 설정

### 플레이어의 숫자와 컴퓨터의 숫자를 받아서 힌트를 반환하는 기능 `calculateStrikeAndBall()`

- `int strike = 0`, `int ball = 0`을 메서드 안에 선언 후
- 컴퓨터의 숫자와 플레이어의 숫자가 자리수와 값이 같은 경우 -> `strike++`
- 컴퓨터의 숫자와 플레이어의 숫자가 자리수는 다르지만 값은 같은 경우 -> `ball++`
- 컴퓨터의 숫자와 플레이어의 숫자가 전혀 다른경우 -> `strike = 0, ball = 0`일 경우에 `낫싱`

### 위 흐름을 반복하는 기능 `playBall()`

- `whlie`문을 사용해서 컴퓨터의 숫자와 플레이어의 숫자가 같을 때까지 플레이어의 입력 반복

### 플레이어의 번호와 컴퓨터의 번호가 일치하는지 판별하는 함수 `isThreeStrike()`

- 컴퓨터의 숫자와 플레이어의 숫자가 같은지 판별

### 계속 진행할 것인지, 프로그램을 끝낼 것인지 물어보는 기능 `continueOrFinish()`

- `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 사용하여 입력을 받는다.
- 1이면 `playBall()`호출하고, 2면 `return`을 통해 함수를 종료한다.
