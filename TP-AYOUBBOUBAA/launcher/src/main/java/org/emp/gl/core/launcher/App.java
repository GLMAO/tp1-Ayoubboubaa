package org.emp.gl.core.launcher;

import java.util.concurrent.ThreadLocalRandom;
import org.emp.gl.clients.Horloge;
import org.emp.gl.clients.CompteARebours;
import org.emp.gl.time.service.impl.DummyTimeServiceImpl;
import org.emp.gl.timer.service.TimerService;

public class App {
    public static void main(String[] args) {
        TimerService timerService = new DummyTimeServiceImpl();

        Horloge h1 = new Horloge("Horloge 1", timerService);
        Horloge h2 = new Horloge("Horloge 2", timerService);

        CompteARebours c1 = new CompteARebours("C1", timerService, 5);

        for (int i = 0; i < 10; i++) {
            int start = ThreadLocalRandom.current().nextInt(10, 21);
            new CompteARebours("C" + (i + 2), timerService, start);
        }
    }
}
