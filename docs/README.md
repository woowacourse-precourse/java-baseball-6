# 미션1. 숫자 야구

## 구현할 기능 목록

### 정답 생성

- 게임의 정답으로 각 자리에 중복되는 숫자가 없는 임의의 3자리 수를 생성한다.

### 대답을 입력 받아 힌트 통보

- 플레이어에게서 값을 입력 받는다.
- 입력 받은 값을 토대로 힌트를 통보한다.
- 3스트라이크인 경우 게임을 종료한다.

### 게임이 끝난 경우 재시작/종료 선택

- 정답을 맞춰 게임이 끝난 경우 재시작/종료를 구분하는 숫자를 입력받는다.
- 입력 받은 숫자를 토대로 게임을 재시작/종료한다.

## 구현할 클래스 및 메서드

### Application.java

#### main

- 프로그램 시작시 게임 시작
- Game.runGame() 실행

### Game.java

#### runGame()

- Computer.createRandomNumber()실행
- Player.input() 실행

### Computer.java

#### createRandomNumber()

- Randoms.pickUniqueNumbersInRange 메서드를 이용해 각 자리에 중복되는 숫자가 없는 임의의 3자리 수를 생성
- 정답이 되는 ArrayList<Integer> answerNumber에 수를 하나씩 add

#### checkScore()

- 플레이어가 입력한 대답을 바탕으로 점수 계산

#### returnResult()

- checkScore()에서 계산된 점수를 바탕으로 결과(힌트) 통보

### Player.java

#### input()

- 플레이어에게서 대답을 입력 받음

#### restartOrEnd()

- 플레이어에게서 재시작 혹은 종료에 대한 답을 입력받음
- 대답이 정상적인 값(1 또는 2)인지 확인
- 정상적인 값이 아닐 경우 IllegalArgumentException을 발생시킨 후 애플리케이션 종료

### Number.java

#### checkValidity()

- 입력된 값이 숫자가 맞는지 판별
- 입력된 값이 세 자리 숫자인지 판별
- 아닐 경우 error() 호출

#### checkRedundancy()

- 입력된 값의 각 자리에 중복되는 숫자가 없는지 판별
- 중복되는 숫자가 있을 경우 error() 호출

#### toArrayList()

- 입력받은 값을 ArrayList<Integer>의 type으로 변환

#### error()

- IllegalArgumentException을 발생시킨 후 애플리케이션 종료