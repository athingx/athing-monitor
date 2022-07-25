package io.github.athingx.athing.monitor.api.usage;

import io.github.athingx.athing.dm.api.ThingDmComp;
import io.github.athingx.athing.dm.api.annotation.ThDmComp;
import io.github.athingx.athing.dm.api.annotation.ThDmProperty;

/**
 * 设备使用率组件
 */
@ThDmComp(id = ThingUsageComp.COMP_ID, name = "thing usage monitor", desc = "usage of thing")
public interface ThingUsageComp extends ThingDmComp {

    String COMP_ID = "athing_monitor_usage";

    @ThDmProperty
    Usage.Cpu getCpu();

    @ThDmProperty
    Usage.Memory getMemory();

    @ThDmProperty
    Usage.Network[] getNetworks();

    @ThDmProperty
    Usage.Power[] getPowers();

    @ThDmProperty
    Usage.Store[] getStores();

}
