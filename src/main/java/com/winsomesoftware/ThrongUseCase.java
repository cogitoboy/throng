package com.winsomesoftware;

import com.winsomesoftware.ui.ScreenIo;
import io.micronaut.configuration.picocli.PicocliRunner;
import jakarta.inject.Inject;

public abstract class ThrongUseCase implements Runnable {

    @Override
    public void run() {

        try {
             execute();
        } catch (RuntimeException e) {
            PicocliRunner.run(ThrongException.class, new String[]{"-m", e.getMessage()});
        }

    }

    public abstract void execute();

}
