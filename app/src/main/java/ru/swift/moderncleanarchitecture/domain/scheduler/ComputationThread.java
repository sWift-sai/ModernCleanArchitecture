/*
 * Copyright (c) 2016 Mediteo GmbH.
 */

package ru.swift.moderncleanarchitecture.domain.scheduler;

import javax.inject.Inject;
import javax.inject.Singleton;

import rx.Scheduler;
import rx.schedulers.Schedulers;

@Singleton
public class ComputationThread implements ExecutionThread {

    @Inject
    ComputationThread() {}

    @Override
    public Scheduler getScheduler() {
        return Schedulers.computation();
    }
}
