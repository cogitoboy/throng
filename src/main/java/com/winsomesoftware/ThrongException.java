package com.winsomesoftware;


import com.winsomesoftware.ui.ScreenIo;
import jakarta.inject.Inject;
import picocli.CommandLine;

@CommandLine.Command(name = "throng", description = "...",
        mixinStandardHelpOptions = true)
public class ThrongException implements Runnable {

    @Inject
    ScreenIo screen;

    @CommandLine.Option(names = {"-m", "--message"}, description = "Exception Message")
    String exceptionMessage = "unknown";

    @Override
    public void run() {

        screen.displayOutput(exceptionMessage);

    }
}
