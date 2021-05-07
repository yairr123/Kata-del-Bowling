
package com.example.bowlinGame;

public class BowlingGame {
    private int[] roll = new  int[21];
    private int currentRoll = 0;

    public void roll(int pins) {
        roll[currentRoll++]= pins;
    }

    public int score() {
        int score=0;
        int frameIndex=0;
        for (int frame = 0; frame < 10; frame++) {
            if (roll[frameIndex]==10){
                score+= 10+roll[frameIndex+1]+roll[frameIndex+2];
                frameIndex++;
            }
            else if (isSpare(frameIndex)) {
                score+= 10+roll[frameIndex+2];
                frameIndex+=2;
            }else{
                score+=roll[frameIndex]+roll[frameIndex+1];
                frameIndex+=2;
            }

        }
        return score;
    }

    private boolean isSpare(int frameIndex) {
        return roll[frameIndex] + roll[frameIndex + 1] == 10;
    }
}