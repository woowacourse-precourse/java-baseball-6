# 야구 게임 (Baseball Game)

## 게임 설명

야구 게임은 사용자가 1에서 9까지의 서로 다른 3자리 숫자를 맞히는 게임입니다. 컴퓨터가 임의로 생성한 숫자와 사용자가 입력한 숫자를 비교하여 결과를 출력합니다.

## 게임 진행

1. 게임 시작
    - 컴퓨터는 1에서 9까지의 서로 다른 3자리 숫자를 랜덤하게 생성합니다.
    - 숫자는 중복되어서는 안됩니다.

2. 야구 게임 시작
    - 게임이 시작되면 사용자는 3자리 숫자를 입력합니다.
    - 입력값은 다음과 같이 검증됩니다:
        - 숫자인지 확인
        - 3자리인지 확인
        - 중복된 숫자가 없는지 확인

3. 입력값으로 결과 도출
    - 사용자의 입력값을 기반으로 게임 결과를 계산하는 함수가 있습니다.

4. 결과에 따른 출력화면 생성
    - 3스트라이크인 경우, 게임 종료됩니다.
    - 그 외의 경우에는 반복문을 통해 게임이 계속 진행됩니다.
    - 각 라운드의 결과는 출력화면에 표시됩니다.

5. 게임을 더 진행할지 확인
    - 게임이 끝난 후, 사용자에게 게임을 더 진행할 것인지 묻습니다.
    - 1을 입력하면 게임이 재시작됩니다.
    - 2를 입력하면 게임이 종료됩니다.

## 프로그램 구현

### ComputerSingleton
- `List<Integer> generateComputerNumbers()`: 1에서 9까지의 서로 다른 3자리 숫자를 랜덤하게 생성합니다.

### View 

- `void introView()`: 게임 시작 화면을 표시합니다.
- `void gameplayView()`: 게임 플레이 중 화면을 표시합니다.
- `void outroView()`: 게임이 종료된 후 화면을 표시합니다.
- `boolean displayGameResult(Result result)`: 결과를 출력화면에 표시합니다.

### Service

- `Result calculateGameResult(String input)`: 사용자의 입력값을 기반으로 게임 결과를 계산하고 결과 객체를 반환합니다.
- `boolean isRestart(String input)`: 사용자의 입력값을 분석하여 게임 재시작 여부를 반환합니다.

### Domain

- `int checkStrike(String input, List<Integer> computerNumbers)`: 사용자의 입력값과 컴퓨터 숫자를 비교하여 스트라이크 수를 계산합니다.
- `int checkBall(String input, List<Integer> computerNumbers)`: 사용자의 입력값과 컴퓨터 숫자를 비교하여 볼 수를 계산합니다.
- `void setResultState()`: 스트라이크 및 볼 결과에 따라 결과 상태를 설정합니다.
