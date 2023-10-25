class Service
  inputNums :  세자리 숫자를 유저에게 입력받음
  validateInput: 입력 받은 숫자가 3자리 숫자인지, 중복된 숫자는 아닌지 점검, 올바른 입력 점검
    올바른 숫자가 아닐때는 exception
  calcResult :  입력받은 숫자에 대해 결과 계산
    score class 생성 후 setter와 getter통해 설정
     숫자 일치 시 ball+
     숫자와 자리 모두 일치 striker+
  generateGameResult: 결과문을 string 값으로 생성 ex: 1볼 1스트라이크
  creRandomNums :  랜덤 숫자 생성
  askReStart: 재시작 여부 질문 1,2로 답변 받음

class Controller
  playGame: 게임전체 실행
  startGame: 게임 시작 후 랜덤 숫자 생성
  runGame: 게임 숫자 입력받음
  endGame: 게임 종료 후 재시작 여부

class Exception
  validateNumberLength: 입력받은 멘트가 3자리 숫자가 아닐시 throw IllegalArgumentException
  validateUniqueNumbers: 중복되지 않은 숫자 count 후 3보다 작으면 throw IllegalArgumentException
  validateRestartInput: 답변이 1이거나 2가 아니면 throw IllegalArgumentException
  

package Constants 
  exceptionConstants: 예외 상수 처리
  gameConstants: 게임 진행에 필요한 멘트, 랜덤 숫자 범위 및 기타 숫자 상수 처리
  resultConstants: ball, striker에 대한 결과 멘트 상수처리
