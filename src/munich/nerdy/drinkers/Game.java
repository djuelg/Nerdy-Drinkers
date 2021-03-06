package munich.nerdy.drinkers;

import munich.nerdy.drinkers.io.GameInput;
import munich.nerdy.drinkers.io.GameOutput;
import munich.nerdy.drinkers.player.Player;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Domi on 14.05.2016.
 */
public class Game {

    List<Player> players = new ArrayList<>();
    boolean continueGame = true;
    boolean isSuperRound = false;
    int roundCount= 0;
    GameOutput Output;
    GameInput Input;

    public Game(List<Player> players) {
        this.players = players;
        Output= new GameOutput(this.players);
        Input= new GameInput();
    }

    public void addRound() {
        isSuperRound = false;
        Double random = Math.random();
        if(random > 0.75) {
            isSuperRound = !isSuperRound;
        }
        this.roundCount++;
    }

    public void incrementFailed(String name) {
        for(Player currentPlayer : players) {
            if(currentPlayer.getName().equals(name)) currentPlayer.incrementFailed();
        }
    }

    public Player getRandomPlayer() {
        return players.get((int)(Math.random() * ((this.players.size() - 1) + 1)));
    }


    // Setter and Getter

    public boolean getContinueGame() {
        return continueGame;
    }

    public int getRoundCount() {
        return roundCount;
    }

    public void setContinueGame(boolean continueGame) {
        this.continueGame = continueGame;
    }
}
