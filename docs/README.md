# 기능 목록

1. 게임 시작
   - 임의의 수 3개 선택
   - 수를 입력받는다
     - 잘못된 값을 입력할 경우 `IllegalArgumentException` 예외 발생
   - 컴퓨터가 선택한 3개의 숫자와 비교한다
     - 동일하면 게임 종료
     - 동일하지 않으면 힌트 출력
2. 게임 종료
   - 재시작 여부 확인
     - 1 = 새로 시작
     - 2 = 게임 종료
     - else = `IllegalArgumentException` 예외 발생