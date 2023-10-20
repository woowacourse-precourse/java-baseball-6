# 기능 요구 사항
## 상대방 컴퓨터
- 숫자 3 자리 숫자 문자열을 가짐
- 1 ~ 9까지 서로 다른 임의의 수 3 개 선택 
  - camp.nextstep.edu.missionutils.Randoms - `pickNumberInRange()`
- 플레이어 - 컴퓨터 개수 계산
  - 스트라이크
    - 3스트라이크: 게임 재시작/종료 구분
  - 볼
  - 낫싱

## 입력
- 플레이어가 추측하는 컴퓨터의 서로 다른 3 개의 숫자
    - camp.nextstep.edu.missionutils.Console - `readLine()`
- 게임 재시작/종료를 구분하는 1과 2 중 하나의 수
**잘못된 값 입력 시 `IllegalArgumentException` 발생 후 종료**

## 출력
- 플레이어 - 컴퓨터 개수 계산 출력
- 하나도 없는 경우(낫싱) 경우 출력
- 3개의 숫자를 모두 맞힐 경우(3스트라이크) 경우 출력
- 게임 시작 문구 출력
- 게임 재시작/종료 문구


# 구현 기능 목록
## Model
- ComputerModel
  - 숫자 3 개 가짐

## View
- InputView
    - 플레이어 수 입력
    - 게임 재시작/종료 1과 2중 하나의 수 입력
- OutputView
    - 플레이어 - 컴퓨터 점수 출력
    - 하나도 없는 경우(낫싱) 경우 출력
    - 3개의 숫자를 모두 맞힐 경우(3스트라이크) 경우 출력
    - 게임 시작 문구 출력
    - 게임 재시작/종료 문구

## Controller
- 게임 진행 상태값(1과 2중 하나) 가짐
- 플레이어 - 컴퓨터 점수 계산 후 InputView로 반환
- 게임 재시작/종료 진행
- InputView 에서 입력받은 값에 대한 예외처리

## RandomNumber
- 중복없는 임의의 값 3 개 반환