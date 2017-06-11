/*
 * Copyright (c) 2016 Mediteo GmbH.
 */

package ru.swift.moderncleanarchitecture;

import ru.swift.moderncleanarchitecture.domain.scheduler.PostExecutionThread;
import rx.Scheduler;

public class TestPostExecutionThread implements PostExecutionThread {

    @Override
    public Scheduler getScheduler() {
        return null;
    }
}
