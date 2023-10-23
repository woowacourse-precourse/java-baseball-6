## 기능 구현 목록
<br>

### class BaseballGameManager implements GameManager

void startGameProcess()  
: 게임 프로세스를 제어하는 뼈대이다.  
: 큰 역할은, 게임 객체를 생성하는 것이다.  

<br>

---

### class BaseballGame implements Game

<br>

**∨ 사용자의 '게임 한 판'에 대한 메서드**  
void startAnnounce()  
: 최초 게임 시작시, 시작 멘트를 외친다.  

int generateAnswerNumber()  
: 컴퓨터가 정답 숫자를 생성한다.  

void playGame()  
: '게임 한 판'을 수행한다.   

boolean isContinue()  
: 사용자가 게임을 계속 할 것인지 선택한다.  

<br>

**∨ 사용자의 숫자 입력 시도 1회에서 호출되는 메서드**

boolean getResult()  
: 사용자의 숫자 입력 시도 1회에 대해, 성공/실패의 힌트를 제공한다.  
: return 성공/실패 여부  

int countStrike()  
: return 스트라이크 개수    

int countBall()  
: return 볼 개수  

<br>

**∨ 사용자 숫자 입력 관련 메서드**  

int inputNumber()  
: 사용자로부터 올바른 숫자 입력을 받는다.

int checkInputNumber()    
: 사용자가 입력한 숫자의 유효성을 검증한다.  
: 검증 실패시 IllegalArgumentException을 일으킨다.  

다음 4가지의 검증 메서드는 IllegalArgumentException을 발생시켜 checkInputNumber 메서드에게 넘긴다.

    **검증1**  
    int parseNumber()  
    : 사용자가 입력한 숫자문자열을 숫자로 변환한다.  
    
    **검증2**  
    void checkInputLength()  
    : 사용자가 입력한 숫자문자열의 길이는 3이어야 한다.  
    
    **검증3**  
    void checkInvalidNumber()  
    : 사용자가 입력한 숫자문자열이 0을 포함하지 않아야 한다.  
    
    **검증4**  
    void checkDuplicated()  
    : 사용자가 입력한 숫자문자열에서 중복숫자가 존재하지 않아야 한다.  
