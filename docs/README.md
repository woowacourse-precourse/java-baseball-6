# 구현 기능 목록

## 컴퓨터의 서로 다른 3개의 수 생성 기능
- createNumbers 메서드
  - 랜덤으로 서로 다른 수를 리스트에 저장
  - Random 값 추출은 camp.nextstep.edu.missionutils.Randoms의 pickNumberInRange()를 활용

## 사용자가 서로 다른 3개의 수를 입력하는 기능
- inputNumbers 메서드
  - 사용자가 입력하는 값은 camp.nextstep.edu.missionutils.Console의 readLine()을 활용
  - 예외처리
    - 3개 미만으로 입력할 경우
    - 4개 이상으로 입력할 경우
    - 중복된 수를 입력할 경우

## 게임 재시작/종료 입력 기능
- 1을 입력할 경우
  - finished는 false이고 게임 재시작
- 2를 입력할 경우
  - finished는 true이고 게임 종료

## 스트라이크 판별 기능
- countStrike 메서드
  - 같은 수가 같은 자리에 있으면 count 증가

## 볼 판별 기능
- countBall 메서드
  - 같은 수가 다른 자리에 있으면 count 증가

## 결과 출력 기능
- printResult 메서드
  - 3스트라이크 경우
    - finished = true
  - 이외의 경우
    - 결과 출력