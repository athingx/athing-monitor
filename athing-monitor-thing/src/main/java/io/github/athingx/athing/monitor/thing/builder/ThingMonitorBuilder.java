package io.github.athingx.athing.monitor.thing.builder;

import io.github.athingx.athing.dm.thing.ThingDm;
import io.github.athingx.athing.monitor.thing.ThingMonitor;
import io.github.athingx.athing.monitor.thing.impl.ThingInfoCompImpl;
import io.github.athingx.athing.monitor.thing.impl.ThingMonitorImpl;
import io.github.athingx.athing.monitor.thing.impl.ThingUsageCompImpl;

/**
 * 设备监控构造器
 */
public class ThingMonitorBuilder {

    /**
     * 构造设备监控
     *
     * @param thingDm 设备模型
     * @return 设备监控
     */
    public ThingMonitor build(ThingDm thingDm) {
        thingDm.load(
                new ThingInfoCompImpl(),
                new ThingUsageCompImpl()
        );
        return new ThingMonitorImpl(thingDm);
    }

}
