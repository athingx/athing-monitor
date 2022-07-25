package io.github.athingx.athing.monitor.thing;

import io.github.athingx.athing.dm.api.Identifier;
import io.github.athingx.athing.monitor.api.info.Info;
import io.github.athingx.athing.monitor.api.usage.Usage;
import io.github.athingx.athing.thing.api.op.OpReply;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public interface ThingMonitor {

    CompletableFuture<OpReply<Set<Identifier>>> info(Info.Item... items);

    CompletableFuture<OpReply<Set<Identifier>>> usage(Usage.Item... items);

}
