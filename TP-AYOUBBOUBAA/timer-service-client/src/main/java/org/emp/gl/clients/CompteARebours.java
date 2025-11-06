package org.emp.gl.clients;

import org.emp.gl.timer.service.TimerChangeListener;
import org.emp.gl.timer.service.TimerService;

public class CompteARebours implements TimerChangeListener {

    String name;
    TimerService timerService;
    int compteur;

    public CompteARebours(String name, TimerService timerService, int start) {
        this.name = name;
        this.timerService = timerService;
        this.compteur = start;
        this.timerService.addTimeChangeListener(this);
        System.out.println("CompteARebours " + name + " démarré à " + start + " secondes.");
    }

    @Override
    public void propertyChange(String prop, Object oldValue, Object newValue) {
        if (TimerChangeListener.SECONDE_PROP.equals(prop)) {
            if (compteur > 0) {
                compteur--;
                System.out.println(name + " : " + compteur);
                if (compteur == 0) {
                    timerService.removeTimeChangeListener(this);
                    System.out.println(name + " terminé et désinscrit.");
                }
            }
        }
    }
}
