# 기능 구현 리스트

## BaseballGame Class

### 임의의 세자리 숫자를 생성

- `camp.nextstep.edu.missionutils`의 `Randoms` API를 사용해서 3자리 숫자를 생성
- 서로 다른 1부터 9까지 3자리 숫자가 아니면 `IllegalArgumentException` 발생

### 사용자의 숫자와 컴퓨터의 숫자를 비교

- 입력받은 숫자와 사전에 생성한 임의의 숫자를 비교
- 각 자릿수들의 숫자가 같고 위치까지 같으면 스트라이크, 숫자만 같으면 볼의 카운트를 1씩 더함

### 스트라이크, 볼 카운트 결과 출력

- 스트라이크와 볼의 값을 출력, 두 값이 0이면 낫싱을 출력

### 결과가 3스트라이크가 될 때까지 반복

- 스트라이크 값이 3이 되면 게임 종료

## User Class

### 3자리 숫자를 입력 후 전송

- 3자리 숫자를 입력 받아서 BaseballGame에 전송
- `camp.nextstep.edu.missionutils`의 `Console` API를 사용해서 숫자를 입력 받음
- 서로 다른 1부터 9까지 3자리 숫자가 아니면 `IllegalArgumentException` 발생

### 게임 끝나면 재시작 여부 입력 후 전송

- BaseballGame이 끝나고 게임 재시작 여부를 입력 받고 BaseballGame에 전송
- 1 또는 2 이외의 값이 입력되었으면 `IllegalArgumentException` 발생

## Main 함수

### 게임이 시작되면 시작 문구를 출력

- `숫자 야구 게임을 시작합니다`라는 문구를 출력

### 게임 실행 및 재시작 또는 종료

- BaseBallGame의 객체를 생성 후 게임 시작
- 한 게임 종료 후 입력 받은 숫자가 1이면 BaseBallGame 객체 새로 생성, 2이면 함수 종료