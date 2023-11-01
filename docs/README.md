## 기능 설명서
### 메서드(기능) 목록

1. `List<Integer> makeAnswerNumberList()` 
   - 임의의 수 3자리를 랜덤으로 생성 하여 반환


2. `List<Integer> verifyValidNumber(String inputNumberStr)`
   - 입력 값이 3자리의 서로 다른 숫자가 맞는지 검증
     - 3자리가 맞는지 확인
     - 숫자가 맞는지 확인
     - 숫자에 0이 포함 되어 있는지 확인
     - 중복된 숫자가 있는지 확인


3. `StrikeBallCount countStrikeAndBall(List<Integer> inputNumberList, List<Integer> answerNumberList)`
   - 정답 숫자 리스트와 사용자 입력 값 숫자 리스트를 비교 하여 strike, ball 갯수 연산하여 반환


5. `boolean checkAnswer(int strike, int ball)`
   - strike, ball 갯수에 따라서 결과값 출력
   - 정답 여부 반환
