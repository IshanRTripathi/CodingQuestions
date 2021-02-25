package main.java.machineCoding.snakesAndLadders;

import main.java.machineCoding.snakesAndLadders.models.*;
import main.java.machineCoding.snakesAndLadders.service.GameManager;

import java.util.*;

public class Game {
    private Map<Integer, Snake> snakes;
    private Map<Integer, Ladder> ladders;
    private Map<String, Player> players;

    public static boolean isGameOver;

    static Board board;

    Game(){
        isGameOver= false;
        snakes= new HashMap<>();
        ladders= new HashMap<>();
        players= new HashMap<>();
    }

    public static void main(String[] args) {
        Game game= new Game();
        board= game.getInputs();

        //game.printBoard(board);
        game.startGame();
    }

    private void startGame() {
        GameManager manager= new GameManager(this, board);
        while(!isGameOver){
            for(String playerName: players.keySet()){
                Player currentPlayer= players.get(playerName);
                System.out.println("\t\t\t\t\t\t\t\t\t"+playerName+"'s turn");
                manager.playTurn(currentPlayer);
                isGameOver= currentPlayer.getCurrentPosition()>=100;
                if(isGameOver)
                    break;
            }
        }
    }

    private Board getInputs() {
        List<Cell> cells= new ArrayList<>();
        for(int i=1; i<=100; i++){
            cells.add(new Cell(i, CellType.empty));
        }
        Scanner sc= new Scanner(System.in);
        int numberOfSnakes= sc.nextInt();

        for(int i=0; i<numberOfSnakes; i++){
            int head= sc.nextInt();
            int tail= sc.nextInt();
            snakes.put(head, new Snake(head, tail));
            cells.get(head).setType(CellType.snake);
        }

        int numberOfLadders= sc.nextInt();

        for(int i=0; i<numberOfLadders; i++){
            int start= sc.nextInt();
            int end= sc.nextInt();
            ladders.put(start, new Ladder(start, end));
            cells.get(start).setType(CellType.ladder);
        }

        int numberOfPlayers= sc.nextInt();
        sc.nextLine();
        for(int i=0; i<numberOfPlayers; i++){
            String playerName= sc.nextLine();
            players.put(playerName, new Player(playerName, 0));
        }

        return new Board(cells);
    }

    private void printBoard(Board board) {
        List<Cell> cells= board.getCells();
        int itr=99;
        for(int i=1; i<=10; i++){
            for(int j=1; j<=10; j++){
                System.out.print(cells.get(itr--));
            }
        }
    }

    public Map<Integer, Snake> getSnakes() {
        return snakes;
    }

    public void setSnakes(Map<Integer, Snake> snakes) {
        this.snakes = snakes;
    }

    public Map<Integer, Ladder> getLadders() {
        return ladders;
    }

    public void setLadders(Map<Integer, Ladder> ladders) {
        this.ladders = ladders;
    }

    public Map<String, Player> getPlayers() {
        return players;
    }

    public void setPlayers(Map<String, Player> players) {
        this.players = players;
    }
}