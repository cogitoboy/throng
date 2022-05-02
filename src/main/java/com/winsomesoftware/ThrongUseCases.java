package com.winsomesoftware;

import com.winsomesoftware.command.room.RoomUseCase;
import com.winsomesoftware.lafore.arrays.Baseball;
import com.winsomesoftware.ui.ScreenIo;
import io.micronaut.configuration.picocli.PicocliRunner;
import io.micronaut.context.annotation.Primary;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

@Primary
@Singleton
public class ThrongUseCases {

    public Class getUseCase(String useCase) {

        int spaceIndex = useCase.indexOf(" ");

        String useCaseCommand = useCase;

        if(spaceIndex > 0)
            useCaseCommand = useCase.substring(0, useCase.indexOf(" "));

        switch(useCaseCommand) {
            case "room":
                return RoomUseCase.class;
            case "baseball":
                return Baseball.class;
            default:
                return ThrongHelp.class;

        }
    }

    public void displayAllUseCases(String filter) {



    }
}