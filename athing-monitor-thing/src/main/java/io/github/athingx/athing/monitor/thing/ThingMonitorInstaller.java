package io.github.athingx.athing.monitor.thing;

import io.github.athingx.athing.dm.thing.ThingDm;
import io.github.athingx.athing.thing.api.Thing;
import io.github.athingx.athing.thing.api.plugin.ThingPluginInstaller;

import java.util.concurrent.CompletableFuture;

public class ThingMonitorInstaller implements ThingPluginInstaller<ThingMonitor> {

    @Override
    public Meta<ThingMonitor> meta() {
        return new Meta<>(ThingMonitor.PLUGIN_ID, ThingMonitor.class);
    }

    @Override
    public CompletableFuture<ThingMonitor> install(Thing thing) {
        return thing.plugins().depends(ThingDm.PLUGIN_ID, ThingDm.class)
                .thenApply(dm -> dm
                        .load(new DefaultThingInfoDmComp())
                        .load(new DefaultThingUsageDmComp())
                )
                .thenApply(dm -> new ThingMonitor())
                ;
    }

}
