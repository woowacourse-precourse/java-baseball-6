# 미션 - 숫자 야구
## 1. Model
### 1.1 클래스: 'BaseballGameModel' 
### 1.1.1 개요
**'BaseballGameModel'** 클래스는 컴퓨터가 선택한 3개의 임의의 숫자를 관리하고, 사용자의 입력과 비교하여 게임 상태를 관리합니다.

### 1.1.2 주요 메소드
- **'generateRandomNumbers(): void'**: 1부터 9까지의 서로 다른 3개의 임의의 숫자를 생성하여 'computerNumbers' 배열에 저장합니다.
- **'getComputerNumbers(): List<Integer>'**: 현재 컴퓨터가 선택한 숫자 배열을 반환합니다.
- **'clearComputerNumbers: void'**: 현재 컴퓨터가 선택한 숫자 배열을 초기화합니다.

## 2. View
### 2.1 클래스: 'BaseballGameView'
### 2.1.1 개요
**'BaseballGameView'** 클래스는 게임 시작 메시지, 사용자 입력 및 결과 출력 등의 UI를 담당합니다.

### 2.1.2 주요 메소드
- **'displayStartMessage(): void'**: 게임 시작 메시지를 출력합니다.
- **'getUserInput(): String'**: 사용자로부터 서로 다른 3자리의 수를 입력받아 배열로 반환합니다.
- **'displayResult(Hashmap<String, Integer> result): void'**: 게임 결과를 출력합니다.
- **'getUserRestartInput(): String'**: 게임이 끝난 후 재시작 또는 종료 여부를 입력받아 반환합니다.

## 3. Controller
### 3.1 클래스: 'BaseballGameController'
### 3.1.1 개요
**'BaseballGameController'** 클래스는 사용자 입력을 받아 Model을 업데이트하고, 결과를 View에 전달하여 게임 플로우를 제어합니다.

### 3.1.2 주요 메소드
- **'playGame(): void'**: 게임을 시작하고 사용자 입력을 처리하여 게임 흐름을 관리합니다.
- **'processInput(String userInput, int length_limit): List<Integer>'**: 입력이 유효한지 확인합니다.
- **'computeResult(List<Integer> userNumbers, List<Integer> computerNumbers): Hashmap<String, Integer>'**: 사용자 입력과 컴퓨터가 선택한 숫자를 비교하여 결과를 계산하고 반환합니다.
- **'handleGameEnd(): void'**: 게임이 종료되면 재시작 또는 완전 종료 여부를 처리합니다.