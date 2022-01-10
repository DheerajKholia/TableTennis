package com.game.tennis;

public class TennisScore {

    public static void main(String[] args) {
        System.out.println("Welcome to game of Tennis!!!");
        System.out.println("============================");
        play();
        System.out.println("======THANK YOU!!!========");

    }

    public static void play(){

        int score[]= {0,0};
        int serveCount[]={0,0};
        int winner=-1;
        int currentPlayer=0; // Player1=0, Player2=1
        while(winner==-1) {
            incrementServe(currentPlayer, serveCount);
            int rallyWinner = getOutcome();
            updateScores(rallyWinner, score);
            winner = checkForWinner(rallyWinner, score);
            currentPlayer = changeCurrentPlayer(currentPlayer, serveCount);
        }
        System.out.println("Player" + (winner + 1) + " has won the game!!!");

    }

    private static int checkForWinner(int rallyWinner,int[] score) {

        int winner=-1;
        int rallyWinnerScore=score[rallyWinner];
        int otherPlayerScore=score[Math.abs(rallyWinner-1)];
        if(otherPlayerScore==20 && rallyWinnerScore==21){
            winner=rallyWinner;
        }else if(otherPlayerScore>=10 && rallyWinnerScore-otherPlayerScore>=2){
            winner=rallyWinner;
        }else if(rallyWinnerScore==11 && otherPlayerScore<10){
            winner=rallyWinner;
        }
        return winner;
    }

    private static void updateScores(int rallyWinner, int[] score) {
        score[rallyWinner]++;
        System.out.println("Updated scores are Player1:"+score[0]+" vs Player2:"+score[1]);
    }

    private static void incrementServe(int currentPlayer,int[] serveCount) {
        System.out.println("Player"+(currentPlayer+1)+" is serving this rally....");
        serveCount[currentPlayer]++;
    }

    private static int changeCurrentPlayer(int currentPlayer, int[] serveCount) {
        int result=currentPlayer;
        if(serveCount[currentPlayer]==2){
            serveCount[currentPlayer]=0;
            result=Math.abs(currentPlayer-1);
        }
        return result;
    }

    private static int getOutcome() {
        int num=(int) Math.floor(Math.random()*100);
        //System.out.println("Num= "+num+"  Mod="+ (num%2 == 0));
        int result;
        if(num%2==0){
            System.out.println("Player1 has won the rally");
            result= 0;
        }else{
            System.out.println("Player2 has won the rally");
            result=1;
        }
        return result;
    }


}
