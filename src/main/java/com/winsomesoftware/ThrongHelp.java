package com.winsomesoftware;

import com.winsomesoftware.ui.ScreenIo;
import io.micronaut.configuration.picocli.PicocliRunner;
import jakarta.inject.Inject;
import picocli.CommandLine;

@CommandLine.Command(name = "help", description = "...",
        mixinStandardHelpOptions = true)
public class ThrongHelp implements Runnable {

    @Inject
    ThrongUseCases throngCommandFactory;

    @Inject
    ScreenIo screen;

    @CommandLine.Option(names = {"-l", "--list"}, description = "...")
    boolean list;


    @Override
    public void run() {

        if(list) {

            screen.displayOutput("room");


        } else {
            PicocliRunner.run(throngCommandFactory.getUseCase("room"), new String[]{"-h"});
        }




    }
}
