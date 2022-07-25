package io.github.athingx.athing.monitor.thing.impl;

import io.github.athingx.athing.dm.api.Identifier;
import io.github.athingx.athing.dm.thing.ThingDm;
import io.github.athingx.athing.monitor.api.info.Info;
import io.github.athingx.athing.monitor.api.usage.Usage;
import io.github.athingx.athing.monitor.thing.ThingMonitor;
import io.github.athingx.athing.thing.api.op.OpReply;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

public class ThingMonitorImpl implements ThingMonitor {

    private final ThingDm thingDm;

    public ThingMonitorImpl(ThingDm thingDm) {
        this.thingDm = thingDm;
    }


    @Override
    public CompletableFuture<OpReply<Set<Info.Item>>> info(Info.Item... items) {
        return thingDm.properties(Stream.of(items)
                        .map(Info.Item::getIdentifier)
                        .distinct()
                        .toArray(Identifier[]::new))
                .thenApply(reply -> {
                    final Set<Info.Item> set = new LinkedHashSet<>();
                    if (reply.isOk()) {
                        reply.data().forEach(identifier ->
                                Arrays.stream(Info.Item.values())
                                        .filter(item -> item.getIdentifier().equals(identifier))
                                        .findFirst()
                                        .ifPresent(set::add));
                    }
                    return OpReply.reply(reply.token(), reply.code(), reply.desc(), set);
                });
    }

    @Override
    public CompletableFuture<OpReply<Set<Usage.Item>>> usage(Usage.Item... items) {
        return thingDm.properties(Stream.of(items)
                        .map(Usage.Item::getIdentifier)
                        .distinct()
                        .toArray(Identifier[]::new))
                .thenApply(reply -> {
                    final Set<Usage.Item> set = new LinkedHashSet<>();
                    if (reply.isOk()) {
                        reply.data().forEach(identifier ->
                                Arrays.stream(Usage.Item.values())
                                        .filter(item -> item.getIdentifier().equals(identifier))
                                        .findFirst()
                                        .ifPresent(set::add));
                    }
                    return OpReply.reply(reply.token(), reply.code(), reply.desc(), set);
                });
    }

}
