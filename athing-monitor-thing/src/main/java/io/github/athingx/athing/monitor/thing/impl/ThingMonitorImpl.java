package io.github.athingx.athing.monitor.thing.impl;

import io.github.athingx.athing.dm.api.Identifier;
import io.github.athingx.athing.dm.thing.ThingDm;
import io.github.athingx.athing.monitor.api.info.Info;
import io.github.athingx.athing.monitor.api.usage.Usage;
import io.github.athingx.athing.monitor.thing.ThingMonitor;
import io.github.athingx.athing.thing.api.op.OpReply;

import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ThingMonitorImpl implements ThingMonitor {

    private final ThingDm thingDm;

    public ThingMonitorImpl(ThingDm thingDm) {
        this.thingDm = thingDm;
    }


    @Override
    public CompletableFuture<OpReply<Set<Identifier>>> info(Info.Item... items) {
        return thingDm.properties(Stream.of(items)
                .map(Info.Item::getIdentifier)
                .distinct()
                .toArray(Identifier[]::new)
        );
    }

    @Override
    public CompletableFuture<OpReply<Set<Identifier>>> usage(Usage.Item... items) {
        return thingDm.properties(Stream.of(items)
                .map(Usage.Item::getIdentifier)
                .distinct()
                .toArray(Identifier[]::new)
        );
    }

}
