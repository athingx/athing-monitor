package io.github.athingx.athing.monitor.api.info;

import io.github.athingx.athing.dm.api.ThingDmComp;
import io.github.athingx.athing.dm.api.annotation.ThDmComp;
import io.github.athingx.athing.dm.api.annotation.ThDmProperty;

/**
 * 设备信息组件
 */
@ThDmComp(id = ThingInfoDmComp.COMP_ID, name = "thing info monitor", desc = "information of thing")
public interface ThingInfoDmComp extends ThingDmComp {

    String COMP_ID = "athing_monitor_info";

    @ThDmProperty
    Info.Os getOs();

    @ThDmProperty
    Info.Jvm getJvm();

    @ThDmProperty
    Info.Computer getComputer();

    @ThDmProperty
    Info.Baseboard getBaseboard();

    @ThDmProperty
    Info.Firmware getFirmware();

    @ThDmProperty
    Info.Cpu getCpu();

    @ThDmProperty
    Info.Memory getMemory();

    @ThDmProperty
    Info.Disk[] getDisks();

    @ThDmProperty
    Info.Network[] getNetworks();

    @ThDmProperty
    Info.Power[] getPowers();

    @ThDmProperty
    Info.Store[] getStores();

}
