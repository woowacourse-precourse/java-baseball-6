## 기능 목록

1. Application 에서 실행
2. BaseballGamePlayer 객체로 게임 실행
    - 아래를 (Option == 1)이면 반복
    1. 정답 번호 생성 (RandomNumbersGenerator 객체 사용)
    2. 사용자 입력 (Scanner 객체 사용) 
    3. 입력값 채점 (JudgeMachine 객체 사용)
    4. 채점 결과 저장 (BaseballForm 객체 사용)
    5. 채점 결과 출력 (Printer 객체 사용)
        1. 정답 이면 게임 재시작 여부 입력 (재시작 : 1, 종료 : 2)
        2. 오답이면 ii.b 부터 다시 실행
