olve the problem proposed, I have decided to resolve it from a OOP perspective. For this porpouse, I have used Java and JUnit which was driven me to a TDD (Test-Driven Development) resolution.  

Phase 1: Define steps to achive the resolution:

    1 step:
         - Register 2 throws per frame.
         - Save the score of both throws in the current frame.
         - Run the game for a total of 10 Frames.
            + Check if the currentFrame is equal to total frames value.
         - Update the score list with each new frame.

    2 step:
        - Introduce the strike concept.
            + Check if firts throw was 10.
            + Jump to the next frame.

    3 step:
        - Introduce the spare concept.
            + Check if both throws are equal to 10.

    4 step:
        - In the last frame, introduce an extra throw.
            + Check if it is the last frame and allow an extra throw. 


Phase 2: Define the tests for each step in phase 1;

Phase 3: Coding the resolution based in pass the test previously defined.

Phase 4: Debuging to achive the resolution, refactoring and improve the code. 
