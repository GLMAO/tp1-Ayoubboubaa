package org.emp.gl.clients;

import org.emp.gl.timer.service.TimerChangeListener;
import org.emp.gl.timer.service.TimerService;

public class Horloge implements TimerChangeListener {

    String name;
    TimerService timerService;

    public Horloge(String name, TimerService timerService) {
        this.name = name;
        this.timerService = timerService;
        this.timerService.addTimeChangeListener(this);
        System.out.println("Horloge " + name + " initialisée !");
    }

    public void afficherHeure() {
        if (timerService != null) {
            System.out.println(name + " affiche " +
                    String.format("%02d:%02d:%02d",
                            timerService.getHeures(),
                            timerService.getMinutes(),
                            timerService.getSecondes()));
        }
    }

    @Override
    public void propertyChange(String prop, Object oldValue, Object newValue) {
        if (TimerChangeListener.SECONDE_PROP.equals(prop)) {
            afficherHeure();
        }
    }
}
