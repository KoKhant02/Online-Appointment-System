package com.example.appointment.listener;

import java.util.logging.Logger;

import jakarta.faces.event.PhaseEvent;
import jakarta.faces.event.PhaseId;
import jakarta.faces.event.PhaseListener;

public class MyFacesListener implements PhaseListener {

    private static final Logger logger = Logger.getLogger(MyFacesListener.class.getName());

    @Override
    public void beforePhase(PhaseEvent event) {
        // Log the phase that is about to be executed
        logger.info("Before phase: " + event.getPhaseId());
    }

    @Override
    public void afterPhase(PhaseEvent event) {
        // Log the phase that has just been executed
        logger.info("After phase: " + event.getPhaseId());
    }

    @Override
    public PhaseId getPhaseId() {
        // This listener listens to all phases
        return PhaseId.ANY_PHASE;
    }
}
