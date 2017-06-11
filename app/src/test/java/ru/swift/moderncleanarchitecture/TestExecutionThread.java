/*
 * Copyright (c) 2016 Mediteo GmbH.
 */

package ru.swift.moderncleanarchitecture;

import ru.swift.moderncleanarchitecture.domain.scheduler.ExecutionThread;
import rx.Scheduler;

public class TestExecutionThread implements ExecutionThread {

    @Override
    public Scheduler getScheduler() {
        return null;
    }
}
