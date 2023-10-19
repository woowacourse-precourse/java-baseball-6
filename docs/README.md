## [ 구현할 기능 목록 ]

### F1: 게임 시작 문구를 출력하는 기능

- `숫자 야구 게임을 시작합니다.`


### F2: 컴퓨터의 랜덤 값을 생성하는 기능

- 컴퓨터는 1에서 9까지 서로 다른 임의의 수 3개를 선택
- `camp.nextstep.edu.missionutils`에서 제공하는 `Randoms` 및 `Console` API를 사용하여 구현
- Random 값 추출은 `camp.nextstep.edu.missionutils.Randoms`의 `pickNumberInRange()`를 활용
- 사용 예시
```java
List<Integer> computer = new ArrayList<>();
while (computer.size() < 3) {
    int randomNumber=  Randoms.pickNumberInRange(1, 9);
    if (!computer.contains(randomNumber)) {
        computer.add(randomNumber);
    }
}
```


### F3: 서로 다른 3자리의 수를 입력받는 기능

- `숫자를 입력해주세요 : `
- 사용자가 입력하는 값은 `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용한다.


### F4: 잘못된 값을 입력할 경우 종료되는 기능

- `IllegalArgumentException`을 발생시킨 후 종료


### F5: 입력한 수에 대한 결과를 볼, 스트라이크 개수로 표시하는 기능

- 입력한 수와 컴퓨터의 수를 비교하여 볼(같은 수가 다른 자리에 있는 경우) 개수를 계산하는 작업 필요
- 입력한 수와 컴퓨터의 수를 비교하여 스트라이크(같은 수가 같은 자리에 있는 경우) 개수를 계산하는 작업 필요
- 0볼 0스트라이크 -> `낫싱`
- n볼 m스트라이크 -> `n볼 n스트라이크`
- 0볼 3스트라이크 -> `3스트라이크\n 3개의 숫자를 모두 맞히셨습니다! 게임 종료`


### F6: 게임이 끝난 경우 재시작/종료를 구분하는 1과 2 중 하나의 수를 입력 받는 기능

- `게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.`
- 재시작하기 위해 반복 위치 설정 및 코드 삽입 필요
- 종료하는 함수 호출 필요 (단, `System.exit()`를 호출하지 않는다.)


