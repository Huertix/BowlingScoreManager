olve the proposed problem  I have decided to do it from a OOP perspective. For this porpouse, I have used Java and JUnit which led me to a TDD (Test-Driven Development) resolution.  

Phase 1: Define steps to achive the resolution:

    1 step:
         - Register 2 throws per frame.
         - Save the score of both throws in the current frame.
         - Run the game for a total of 10 Frames.
            + Check if the currentFrame is equal to total frames value.
         - Update the score list with each new frame.

    2 step:
        - Introduce the strike concept.
            + Check if first throw was 10.
            + Jump to the next frame.

    3 step:
        - Introduce the spare concept.
            + Check if both throws are equal to 10.

    4 step:
        - In the last frame, introduce an extra throw.
            + Check if it is the last frame and allow an extra throw. 


Phase 2: Define the tests for each step in phase 1;

Phase 3: Code based in test succesful.

Phase 4: Debuge to achieve the resolution, refactoring and improving the code. 


I have defined two classes + the main class which is the entry point.

    GameController which is responsible of:
        - Initialize variables.
        - Register a new throw.
        - Register  a list of Frame Objects.
        - Register and update the score.

        Interface GameController{
                public void newThrow(int pins);
                private void updateFrames();
                private void updateScores();
                public int getScoreAtFrame(int frame);
                public boolean gameIsOver();
        }


    Frame which is responsible of:
        - Register throws.
        - Check if it is a Strike.
        - Check if it has a Spare.
        - Save the score from all throws in this frame.

        This class was designed with variables, getters and setters.

        Class Frame {
            private Integer throw1;
            private Integer throw2;
            private Integer extraThrow;
            private int score;
            private boolean isScorePending;
            private boolean isStrike;
            private boolean isSpare;
        }


In order to try the application, you can run the test defined with JUnit or run the jar file using as argument a throw list ( E.g: java -jar BowlingGame.jar 5 2 8 1 10 3 2 10 10 1 6 10 2 6 10 4 5 )   
