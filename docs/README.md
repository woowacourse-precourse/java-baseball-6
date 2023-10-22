## 📌 기능 목록

### Computer
- [x] 게임에 필요한 3개의 숫자(정수)를 가짐
- [x] 컴퓨터가 가질 숫자(정수)를 생성
  - [x] 랜덤한 숫자를 생성
  - [x] 숫자의 범위는 1부터 9까지
  - [x] 랜덤값 추출은 [우테코에서 제공하는 라이브러리](https://github.com/woowacourse-projects/mission-utils#mission-utils) `camp.nextstep.edu.missionutils.Randoms`의 `pickNumberInRange()`를 활용


### Player
- [x] 게임에 필요한 3개의 숫자(정수)를 가짐
- [x] 플레이어가 입력한 숫자를 가져옴
  - [x] 검증(예외처리)이 완료된 값을 가져옴


### Application
- [x] Game Controller 실행
- [x] Game Controller 재실행 (게임 종료 후 플레이어가 게임 재시작을 원할 경우)


### Game Controller
- [x] 컴퓨터 랜덤 숫자 생성 명령
- [x] 플레이어 숫자 입력 명령
- [x] 숫자 비교 명령
- [x] 게임 결과 출력 명령
- [x] 플레이어가 이기지 않을 경우(3스트라이크) 플레이어 숫자 입력 재시작


### Exception Check
- [x] 플레이어 숫자 입력값 검증
  - [x] 수량 체크 : 입력된 값이 3개 초과일 경우 예외 처리
  - [x] 숫자 확인 : 입력된 값이 숫자가 아닐 경우 예외 처리
  - [x] 범위 확인 : 입력된 숫자가 1~9 범위내에 있지 않을 경우 예외 처리
  - [x] 중복 확인 : 입력된 숫자끼리 중복이 있을 경우 예외 처리
- [x] 게임 재시작 안내에 대한 플레이어 입력값 검증
  - [x] 1, 2 외에 다른값을 입력할 경우 예외 처리
- [x] 예외 처리 방식 : `IllegalArgumentException` 발생시킨 후 애플리케이션 종료


### Compare Number
- [x] 컴퓨터와 플레이어의 숫자를 비교
  - [x] 같은 수가 같은 자리에 있으면 스트라이크 카운트
  - [x] 같은 수가 다른 자리에 있으면 볼 카운트
  - [x] 같은 수가 전혀 없으면 낫싱 카운트


### Output
- [x] 야구 게임 시작 메세지 출력
- [x] 게임 결과에 대한 메세지 출력(스트라이크, 볼, 낫싱)
- [x] 플레이어가 이길 경우에 대한 메세지 출력 (게임 종료 안내)


### Input
- [x] 플레이어 숫자를 입력받음
- [x] 게임 재시작 여부 입력받음 (1 재시작, 2 게임 종료)
- [x] 입력받는 값은 [우테코에서 제공하는 라이브러리](https://github.com/woowacourse-projects/mission-utils#mission-utils) `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용