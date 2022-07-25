package io.github.athingx.athing.monitor.thing.builder;

import io.github.athingx.athing.dm.thing.ThingDm;
import io.github.athingx.athing.monitor.thing.ThingMonitor;
import io.github.athingx.athing.monitor.thing.impl.ThingInfoCompImpl;
import io.github.athingx.athing.monitor.thing.impl.ThingMonitorImpl;
import io.github.athingx.athing.monitor.thing.impl.ThingUsageCompImpl;

public class ThingMonitorBuilder {

    public ThingMonitor build(ThingDm thingDm) {
        thingDm.load(
                new ThingInfoCompImpl(),
                new ThingUsageCompImpl()
        );
        return new ThingMonitorImpl(thingDm);
    }

}
