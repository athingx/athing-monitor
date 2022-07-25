package io.github.athingx.athing.monitor.thing.test;

import io.github.athingx.athing.dm.thing.dump.DumpToFn;
import io.github.athingx.athing.monitor.api.info.ThingInfoComp;
import io.github.athingx.athing.monitor.api.usage.ThingUsageComp;
import org.junit.Assert;
import org.junit.Test;

public class ThingMonitorTestCase extends ThingMonitorSupport {

    @Test
    public void test$thing$monitor$dump() throws Exception {
        thingDm.dump().dumpTo(new DumpToFn.ToMap(map ->
                map.forEach((compId, json) ->
                        System.out.printf("""
                                COMP: %s
                                JSON: %s%n
                                """, compId, json))));
    }

    @Test
    public void test$thing$monitor$info() {
        final var infoComp = thingDm.comp(ThingInfoComp.COMP_ID, ThingInfoComp.class);
        Assert.assertNotNull(infoComp.getBaseboard());
        Assert.assertNotNull(infoComp.getComputer());
        Assert.assertNotNull(infoComp.getCpu());
        Assert.assertNotNull(infoComp.getOs());
        Assert.assertNotNull(infoComp.getDisks());
        Assert.assertNotNull(infoComp.getFirmware());
        Assert.assertNotNull(infoComp.getJvm());
        Assert.assertNotNull(infoComp.getMemory());
        Assert.assertNotNull(infoComp.getNetworks());
        Assert.assertNotNull(infoComp.getPowers());
        Assert.assertNotNull(infoComp.getStores());
    }

    @Test
    public void test$thing$monitor$usage() {
        final var usageComp = thingDm.comp(ThingUsageComp.COMP_ID, ThingUsageComp.class);
        Assert.assertNotNull(usageComp.getCpu());
        Assert.assertNotNull(usageComp.getNetworks());
        Assert.assertNotNull(usageComp.getStores());
        Assert.assertNotNull(usageComp.getMemory());
        Assert.assertNotNull(usageComp.getPowers());
    }

}
