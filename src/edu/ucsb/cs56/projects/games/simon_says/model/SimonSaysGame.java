package edu.ucsb.cs56.projects.games.simon_says.model;

import java.util.ArrayList;

public class SimonSaysGame {
    private ArrayList<Integer> computerPresses;
    private int currentCorrectButton;
    private int placeInSequence;

    // no-arg constructor
    public SimonSaysGame(){
        int randomNum = (int) (Math.random() * 3.9999999);
        computerPresses = new ArrayList<Integer>();
        computerPresses.add(randomNum);
        currentCorrectButton = computerPresses.get(0);
        placeInSequence = 0;
    }

    //constructor with arguments to initialize all the instance variables
    public SimonSaysGame(ArrayList<Integer> flashSequence, int tmpCurrentCorrectButton,int tmpPlaceInSequence){
        computerPresses = flashSequence;
        currentCorrectButton = tmpCurrentCorrectButton;
        placeInSequence = tmpPlaceInSequence;
    }

    // Create all the getters
    public  ArrayList<Integer> getComputerPresses(){
        return this.computerPresses;
    }

    public int getCurrentCorrectButton(){
        return this.currentCorrectButton;
    }

    public  int getPlaceInSequence(){
        return this.placeInSequence;
    }


    // Create all the setters
    public void setComputerPresses(ArrayList<Integer> newComputerPresses){
        this.computerPresses.clear();
        this.computerPresses.addAll(newComputerPresses);
    }

    public void setCurrentCorrectButton(int newCurrentCorrectButton){
        this.currentCorrectButton = newCurrentCorrectButton;
    }

    public void setPlaceInSequence(int newPlaceInSequence){
        this.placeInSequence = newPlaceInSequence;
    }

    // returns the length of the sequence currently being guessed
    public int getSequenceLength(){
        return computerPresses.size();
    }

    public boolean sequenceComplete(){
        return (placeInSequence >= (computerPresses.size()-1));
    }


    //guess the next color and it returns a boolean value indicating whether the guess is correct
    public boolean guessNextColor(int guessbButtonNum){
        // increment the place in the sequence by 1
        placeInSequence++;

        // set the next correct button as the new correct button
        setCurrentCorrectButton(computerPresses.get(placeInSequence));

        //check whether the guessed button matches the correct button
        if (guessbButtonNum == currentCorrectButton)
            return true;   //the player's guess is correct
        else
            return false;  //the player's guess is incorrect

    }


    public void startTurn(int guessNum){
        while(true){
            //create a variable to store the boolean value of guessNextColor
            //and call guessNextColor to make corresponding changes
            boolean amIRight = guessNextColor(guessNum);
            if(!amIRight)
                break;
            else if(sequenceComplete())
                endTurn();
                break;
        }

    }

    public void endTurn(){
        computerPresses.clear();
        placeInSequence = 0;
        currentCorrectButton = computerPresses.get(0);
    }



}
