## 기능 구현 목록
void startGame()  
: 게임 시작 멘트 출력  

int inputNumber()  
: int num = 사용자로부터 숫자 입력 받기  
: return checkNumber(num)  

int checkNumber(int num)  
: 숫자 검증하기  
: return num  
 
void printHint(int num)  
: 입력 값에 대한 힌트를 출력하기  

int generateAnswerNumber()  
: 정답 번호 생성하기 (서로 다른 세 자리의 숫자로 구성)   
: return 생성한 세자리 양수  