# 숫자야구 readme.md

## 기능 요구사항

### 숫자 랜덤 생성

1. 컴퓨터가 1부터 9까지의 숫자를 생성하여 세자리 수를 생성한다.
    1. 이때 범위가 1~9까지이기 때문에 0을 포함하여 생성하지 않도록 주의.
2. 각 자리 숫자는 중복되지 않아야한다.

### 사용자 입력

주의 ! 주컴퓨터와 마찬가지로 1부터 9까지의 숫자로 세자리 수 입력한다. (0은 포함되지 않는다)

- exception
1. 입력이 세자리의 자연수가 아닌 경우.
    1.  input의 길이가 4 이상인 경우.
    2. int 타입이 아닌 다른 타입의 입력이 들어올 경우.
2. 입력된 숫자가 1~9까지 숫자가 아닐 경우.
    1. 입력된 숫자 중 0이 존재할 경우.
3. 입력된 숫자에 중복이 존재할 경우.

### 결과 출력

1. 볼, 스트라이크 수를 count한 후 결과를 출력
   - 출력 format : (x)볼 (y) 스트라이크
2. y가 3이 아닌 경우에 사용자 입력을 다시 받음.
3. y가 3인경우 3스트라이크를 출력 후 게임 종료 조건 문구 출력

### 게임 종료 조건 입력

1 입력 시 숫자 랜덤 생성으로 전환

2 입력 종료 : 게임 종료

- exception
1. 1과 2가 아닌 다른 값을 입력할 경우.

### 기능 구현 시 class 분할

- model
    - **ComputerNumber**(컴퓨터 숫자 생성)
    - **UserNumber**(사용자의 입력에 대한 검증)
    - **NumberComparator**(컴퓨터 숫자와 유저 입력을 비교후 **GameController**로 전달)

- controller
    - **GameController**(게임의 시작 및 종료를 결정)
        - 유저의 입력을 **UserNumber로 전달**
        - **NumberComparator** 결과를 OutputView로 전달

- view
    - **InputView** (유저 입력 받아오고 GameController로 전달)
    - **OutputView** (compare한 후 결과를 출력)

- vailidator
    - NumberVailidator