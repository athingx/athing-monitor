package io.github.athingx.athing.monitor.thing;

import io.github.athingx.athing.thing.api.plugin.ThingPlugin;

import java.util.concurrent.CompletableFuture;

public class ThingMonitor implements ThingPlugin {

    public static final String PLUGIN_ID = "athingx.athing.monitor";

    @Override
    public CompletableFuture<Void> uninstall() {
        return CompletableFuture.completedFuture(null);
    }
}
