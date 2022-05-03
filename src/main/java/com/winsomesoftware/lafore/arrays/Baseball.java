package com.winsomesoftware.lafore.arrays;

import com.winsomesoftware.ThrongUseCase;
import com.winsomesoftware.lafore.arrays.structures.Low;
import com.winsomesoftware.lafore.arrays.structures.LowArray;
import com.winsomesoftware.ui.ScreenIo;
import jakarta.inject.Inject;
import picocli.CommandLine;

@CommandLine.Command(name = "baseball", description = "...",
        mixinStandardHelpOptions = true)
public class Baseball extends ThrongUseCase {

    @Inject
    protected ScreenIo screen;

    @CommandLine.Option(names = {"insert", "--insert"}, description = "Insert a player")
    String playerNumberToInsert;

    @CommandLine.Option(names = {"find", "--find"}, description = "Is player present")
    String playerToFind;

    @CommandLine.Option(names = {"delete", "--delete"}, description = "Delete player")
    String playerToDelete;

    @CommandLine.Option(names = {"create", "--create"}, description = "Create Array")
    boolean create;

    BaseballLogic baseballLogic = new BaseballLogic();

    @Override
    public void execute() {


        if(create) {
               screen.displayOutput(baseballLogic.createArray(screen.getBoolean("baseball","LowArray? Y/N: ")));
        }else {
            if (playerNumberToInsert != null) {
                screen.displayOutput(baseballLogic.insertPlayer(Integer.parseInt(playerNumberToInsert)));
            } else if (playerToFind != null) {
                screen.displayOutput(baseballLogic.findPlayer(Integer.parseInt(playerToFind)));
            } else if (playerToDelete != null) {
                screen.displayOutput(baseballLogic.deletePlayer(Integer.parseInt(playerToDelete)));
            }
        }

    }
}

class BaseballLogic {

    static Low<Integer> lowArray;

    static int index = 0;


    public Low insertPlayer(int playerNumber) {

        lowArray.setElem(index++, playerNumber);
        return lowArray;

    }

    public String findPlayer(int playerNumber) {

        for (int i =0; i < 20; i++){
            if(playerNumber == lowArray.getElem(i))
                return "Found player " + playerNumber + " at index: "+ i;
        }
        return "Could not locate player";
    }

    public Low createArray(boolean low) {

        lowArray = new LowArray<>(20);
        return lowArray;

    }

    public Low deletePlayer(int playerNumber) {

        int adjustment = 0;

        for (int i =0; (i + adjustment) < 20; i++){
            if(lowArray.getElem(i) != null && playerNumber == lowArray.getElem(i)) {
                adjustment =+ 1;
                index--;
            }

            lowArray.setElem(i,lowArray.getElem(i + adjustment));
        }
        return lowArray;
    }

}

class BaseballDomain {

}
