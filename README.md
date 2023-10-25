# 미션 - 숫자 야구


## 구현할 기능 목록

- generateRandomNumbers() : 3자리 랜덤 수 생성
- gameContinue : true이면 게임 계속 진행 / false이면 게임 종료
- checkGuess : answer와 비교해서 스트라이크 / 볼 / 낫싱 출력
- askContinue : 정답을 맞췄을 때 게임을 계속 진행할 것인지 질문
- validateInput(guess) : 잘못된 값 입력했을 경우 예외발생
  1. 입력값이 null이거나 비어있는 경우
  2. 입력값이 3자리가 아닌 경우
  3. 각 숫자가 1에서 9사이가 아닌 경우
  4. 입력값에 중복된 숫자가 있는 경우
- 볼, 스트라이크 중 아무것도 해당되지 않으면 "낫싱" 출력
- 결과가 "3스트라이크"라면 게임 종료 후 재시작 여부 물어보기
- 1입력 시 3자리 랜덤 수 생성 후 while문 처음으로 돌아가서 숫자 입력하게 하기
- 볼: 정답과 위치는 다르지만 그 숫자가 들어갈 경우
- 스트라이크: 위치, 숫자 모두 같은 경우