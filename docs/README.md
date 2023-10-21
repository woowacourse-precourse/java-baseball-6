## 기능 구현 순서
1. 컴퓨터를 나타내는 Computer class 생성
2. 전체 게임 진행을 관리하는 BaseBallGameRunner class 생성
3. BaseBallGameRunner class 내부에 run이라는 메소드 작성
   - 사용자로부터 숫자를 입력받는 기능
   - 사용자가 입력한 숫자가 valid한 입력인지 check하는 기능
   - 입력받은 숫자와 컴퓨터가 생성한 숫자 비교하는 기능
     - GuessResultGenerator 클래스에서 기능 제공
     - 비교 결과를 GuessResult 객체로 반환
     - GuessResult에는 Console에 출력할 문자열 및 사용자가 
     정답을 맞혔는지에 대한 정보 포함
   - 숫자가 일치한다면 게임 추가 진행 여부 입력받는 기능