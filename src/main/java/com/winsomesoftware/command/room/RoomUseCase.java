package com.winsomesoftware.command.room;

import com.winsomesoftware.Throng;
import com.winsomesoftware.ThrongException;
import com.winsomesoftware.ThrongUseCase;
import com.winsomesoftware.ui.ScreenIo;
import io.micronaut.configuration.picocli.PicocliRunner;
import jakarta.inject.Inject;
import picocli.CommandLine;

@CommandLine.Command(name = "room", description = "...",
        mixinStandardHelpOptions = true)
public class RoomUseCase extends ThrongUseCase {

    @Inject
    protected ScreenIo screen;

    @CommandLine.Option(names = {"-b", "--building"}, description = " Specify the building")
    String building = "all buildings";


    @Override
    public void execute() {

        screen.displayOutput(getRoomNumber(screen.getInteger("room","Enter Room Number for "+ building+" : ")));

    }

    private RoomDomain getRoomNumber(Integer roomNumber) {

        RoomDomain domain = new RoomDomain();
        domain.roomNumber = roomNumber;
        domain.roomFloor = 34;
        domain.roomMaxSize = 4;
        return  domain;
    }

}

class RoomDomain {

    public int roomNumber;
    public int roomFloor;
    public int roomMaxSize;

    @Override
    public String toString(){

        return "roomNumber: " + roomNumber + " roomFloor: " + roomFloor + "  roomMaxSize: " + roomMaxSize;
    }
}