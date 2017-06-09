package ru.swift.moderncleanarchitecture.domain.scheduler;

import rx.Scheduler;

public interface PostExecutionThread {
    Scheduler getScheduler();
}
