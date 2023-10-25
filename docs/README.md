# ✏️ 기능 구현 목록

## 🌏 목차

- ### [GameManager.java](#-gamemanagerjava)
- ### [Computer.java](#-computerjava)
- ### [Global.Strike.java](#-globalstrikejava)
- ### [Global.Ball.java](#-globalballjava)
- ### [NumberArray.java](#-numberarrayjava)

---

## 👍 GameManager.java

### 1. start()

- Application.java에서 가장 먼저 호출되어 게임을 시작시킵니다.
- game()을 호출해 숫자야구게임 시작을 주도하고 게임 종료 후 readMenu()를 호출해 게임의 재시작 혹은 종료를 할 수 있습니다.

### 2. readMenu()

- 게임의 재시작 여부를 묻기 위해 유저에게 1 or 2의 입력값을 받습니다.
- 받은 입력값이 1 or 2 가 아니라면 에러를 발생시킵니다.

### 3. game()

- 게임 시작전 셋팅을 위해 initialize() 호출합니다.
- 게임을 진행합니다.
- 유저에게 숫자를 입력 받고 컴퓨터의 수와 비교해 (computer.check() 호출) 볼 혹은 스트라이크의 숫자가 몇개 인지 판단 한 후 print()를 호출합니다.
- print()의 반환값에 따라 3개의 숫자를 맞췄는지 판단하고 다 맞출 경우 start()로 돌아가 게임 재시작 여부를 묻습니다.

### 4. initialize()

- 볼과 스트라이크 수를 초기화 하고 유저에게 숫자를 입력 받습니다.

### 5. print()

- printBall()과 printStrike()를 통해서 볼 과 스트라이크의 수를 콘솔창에 출력하고 낫싱 혹은 3개의 숫자를 모두 맞출 경우 특정 string 값을 반환합니다.

### 6. printBall()

- 볼 수를 출력하고 띄어쓰기 여부를 판단후 출력합니다.

### 7. printStrike()

- 스트라이크 수를 출력합니다.

## 👍 Computer.java

### 1. check()

- 유저가 입력한 세자리 수를 저장한 리스트에서 숫자를 한개씩 꺼내서 꺼낸 숫자와 해당 index를 파라미터로 checkIfExist()를 호출합니다.

### 2. checkIfExist()

- check()에서 파라미터로 보낸 숫자가 컴퓨터가 생성한 세자리 수가 저장된 리스트에 존재하는지 여부를 판단합니다.
- 존재한다면 그 숫자와 해당 index를 파라미터로 checkBallOrStrike()를 호출합니다.

### 3. checkBallOrStrike()

- 컴퓨터가 생성한 세자리 수가 저장된 리스트안에서 파라미터로 받은 index에 위치한 숫자를 꺼내 파라미터로 받은 숫자와 같은지 비교합니다.
- 같으면 strike수를 한개 올리고 같지 않다면 ball수를 한개 올립니다.

## 👍 Global.Strike.java

- strike 수를 멤버 변수로 가지고 있습니다.
- 싱글톤으로 제작했기 때문에 게임 도중 check()로 strike 수를 판단 후 저장하고 game()에서 접근해 유저에게 알려줍니다.

## 👍 Global.Ball.java

- ball 수를 멤버 변수로 가지고 있습니다.
- 싱글톤으로 제작했기 때문에 게임 도중 check()로 ball 수를 판단 후 저장하고 game()에서 접근해 유저에게 알려줍니다.

## 👍 NumberArray.java

- 3개의 숫자를 저장하는 리스트 멤버변수를 감싸주는 클래스입니다.

### 1. NumberArray()

- Computer.java에서 호출하는 constructor로 랜덤으로 중복되지않는 3개의 숫자를 생성해서 리스트 멤버변수에 저장합니다.

### 2. NumberArray(String num)

- 게임 도중 initialize()에서 호출되는 constructor로 유저에게 입력받은 3개의 숫자를 리스트 멤버변수에 저장합니다.
- 아래의 함수들 호출을 통해 입력받은 숫자 3개가 요구사항에 맞는지 체크해줍니다.

### 3. validateNumberLength()

- 입력 받은 값의 길이가 4이상이면 에러를 발생합니다.

### 4. validateOnlyNumber()

- 입력 받은 값이 숫자가 아니면 에러를 발생합니다.

### 5. validateDifferentThreeNumbers()

- 입력받은 3자리 숫자중 중복이 있다면 (ex : 112) 에러를 발생합니다.