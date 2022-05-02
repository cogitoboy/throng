package com.winsomesoftware.lafore.arrays;

import com.winsomesoftware.ThrongUseCase;
import com.winsomesoftware.ui.ScreenIo;
import jakarta.inject.Inject;
import picocli.CommandLine;

@CommandLine.Command(name = "baseball", description = "...",
        mixinStandardHelpOptions = true)
public class Baseball extends ThrongUseCase {

    @Inject
    protected ScreenIo screen;

    @CommandLine.Option(names = {"-i", "--insert"}, description = "Insert a player")
    String playerNumberToInsert;

    @CommandLine.Option(names = {"-f", "--find"}, description = "Is player present")
    String playerToFind;

    @CommandLine.Option(names = {"-d", "--delete"}, description = "Delete player")
    String playerToDelete;


    @Override
    public void execute() {
        BaseballLogic baseballLogic = new BaseballLogic();

        if(playerNumberToInsert != null) {
            screen.displayOutput(baseballLogic.insertPlayer(Integer.parseInt(playerNumberToInsert)));
        } else if(playerToFind != null) {
            screen.displayOutput(baseballLogic.findPlayer(Integer.parseInt(playerToFind)));
        }

    }
}

class BaseballLogic {

    public String insertPlayer(int playerNumber) {

        return "Inserted item with key " + playerNumber + " at index " + 0;
    }

    public String findPlayer(int playerNumber) {

        return "Have found item with key " + playerNumber;
    }

}

class BaseballDomain {

}
