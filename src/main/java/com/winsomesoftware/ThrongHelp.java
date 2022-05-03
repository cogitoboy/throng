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


    @CommandLine.Option(names = {"-u", "--usecase"}, description = "...")
    String command;

    @Override
    public void run() {

        if(list) {

            screen.displayOutput("room");
            screen.displayOutput("baseball");


        } else if(command != null){
            switch(command) {
                case "room":
                    PicocliRunner.run(throngCommandFactory.getUseCase("room"), new String[]{"-h"});
                    break;
                case "baseball":
                    PicocliRunner.run(throngCommandFactory.getUseCase("baseball"), new String[]{"-h"});
                    break;
            }

        }




    }
}
