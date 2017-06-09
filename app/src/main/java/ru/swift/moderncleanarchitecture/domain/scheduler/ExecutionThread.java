package ru.swift.moderncleanarchitecture.domain.scheduler;

import rx.Scheduler;

public interface ExecutionThread {
    Scheduler getScheduler();
}
