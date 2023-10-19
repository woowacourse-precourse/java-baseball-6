## 기능 구현 목록
void startGame()  
: 게임 시작 멘트 출력  

int inputNumber()  
: int num = 사용자로부터 숫자 입력 받기  
: return checkNumber(num)  

int checkNumber(int num)  
: 숫자 검증하기  
: 올바르지 않으면 IllegalArgumentException  
: return num  
 
void printHint(int num)  
: 입력 값에 대한 힌트를 출력하기  

int generateAnswerNumber()  
: 정답 번호 생성하기 (서로 다른 세 자리의 숫자로 구성)   
: return 생성한 세자리 양수 

int getOptionNumber(String num)  
: 사용자 입력으로부터 옵션 선택 번호 검증  
: 올바르지 않으면 IllegalArgumentException  
: return num  

boolean isContinue(int option):
: option값 유효성 검증 후
: return option이 1이면 true, 2이면 false
