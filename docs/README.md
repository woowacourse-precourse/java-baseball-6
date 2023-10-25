
## Classes

### Application
#### main
    public static void main() throws IllegalArgumentException

### UserSession
#### game
    private Game game

#### UserSession()
    public UserSession()
- To separate the UserSession and the Game classes, don't initialize the game here.
#### run()
    public void run() throws IllegalArgumentException
- Initialize the game if not initialized.
- Repeat these steps until this method returns or IllegalArgumentException is thrown.
  - Call promptForRound
  - Call playRound method on the game.
  - Call showRoundResult
  - Call isWin method on the game.
    - If the result is true, print out the result and call promptForNewGame.
        - If the result is 1, call setNewGame method on the game.
        - If the result is 2, return.
#### showRoundResult()
    private void showRoundResult(int[] result)
- Print out the result of a round as the mission specified.
#### promptForRound()
    private String promptForRound() throws IllegalArgumentException
- Prompt user to give user input for game. i.e. integer consists of 3 distinct digits without 0.
- Call readLine() of camp.nextstep.edu.missionutils.Console to get user input.
#### promptForNewGame()
    private boolean promptForNewGame() throws IllegalArgumentException
- Prompt user to give "1" or "2" to decide whether continue game or not.
- Call readLine() of camp.nextstep.edu.missionutils.Console to get user input.
- Check user input and throw IllegalArgumentException if it is not valid.
  - valid: "1" or "2"

### Game

#### Rules
- target: an integer of 3 distinct non-zero digits.
- strike: counts of positions at which the target and user input is the same.
- ball: counts of digits in user input which are also in the target but at different position.
#### Rounds
- round: a single round consists of getting input value, comparing it with the target, and returning strike and ball count.

#### NUMBER_SIZE
    private static final int NUMBER_SIZE = 3;

#### target
    private List<Integer> target
- Elements of the target should be distinct and non-zero. the

#### Game()
    public Game()
- Call setNewTarget()
#### setNewGame()
    public void setNewGame()
- Call setNewTarget()
#### setNewTarget()
    private void setNewTarget()
- Initialize target randomly using pickNumberInRange() of camp.nextstep.edu.missionutils.Randoms.
- Must adhere to the Rules in definition of the target
#### playRound()
    public int[] playRound(String input) throws IllegalArgumentException
- The input parameter is String type to encapsulate the target and its related logic.
- Return array is two elemented array. The first is the number of strikes and the second is the number of balls.
#### parseUserInput()
    private int[] parseUserInput(String input) throws IllegalArgumentException
- If the input doesn't adhere to the definition of the target in the Rules, throw IllegalArgumentException.
- Parse user input to array of int according to the definition of the target in the Rules.
- Return is array of int with size of NUMBER_SIZE.
#### compareUserInput()
    private int[] compareUserInput(int[] userInput)
- Compare the target and the input according to Rules.
- Return is array of int with size of two.
  - The first int is the number of strikes and the second is of balls.
#### isWin()
    public boolean isWin(int[] result)
- Determine whether the result is considered as win in the Rules.
#### getNumberSize()
    public int getNumberSize()
- Return NUMBER_SIZE.