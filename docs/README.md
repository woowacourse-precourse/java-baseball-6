# 풀이 방법

## 숫자 야구

1. 숫자 야구 게임이 시작되면 랜덤한 3자리 숫자 생성
2. 게임 플레이어에게 3자리 숫자를 입력받는다
3. 힌트를 받는다
    1. 힌트가 스트라이크 → 같은 자리에 같은 숫자
    2. 힌트가 볼 → 다른 자리에 있음
    3. 힌트가 낫싱 → 입력한 숫자가 하나도 없음
4. 입력한 숫자가 정답이라면 정답메시지 출력하고 재시작 여부를 묻는 메시지 출력
    1. 1을 입력 → 게임을 새로 시작
    2. 2를 입력 → 게임을 종료

## MVC 패턴 적용

### Controller

- GameController

### Service

- GameService

### Domain

- ComputerNumber
- UserNumber

### View

- Input
- Output