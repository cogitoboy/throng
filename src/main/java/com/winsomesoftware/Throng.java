package com.winsomesoftware;

import com.winsomesoftware.ui.ScreenIo;
import io.micronaut.configuration.picocli.PicocliRunner;

import jakarta.inject.Inject;
import picocli.CommandLine;
import picocli.CommandLine.Command;

import java.util.Arrays;

@Command(name = "throng", description = "...",
        mixinStandardHelpOptions = true)
public class Throng implements Runnable {

    @Inject
    ThrongUseCases throngCommandFactory;

    @Inject
    ScreenIo screen;




    public static void main(String[] args) throws Exception {
        PicocliRunner.run(Throng.class, args);
    }

    public void run() {

       while(true) {

           String [] command = screen.getCommand("throng");
           String [] args = Arrays.copyOfRange(command, 1, command.length);

           try {

               PicocliRunner.run(throngCommandFactory.getUseCase(command[0]), args);

           } catch (RuntimeException e) {

               PicocliRunner.run(ThrongException.class, new String[]{"-m", e.getMessage()});
           }

       }
    }

}
