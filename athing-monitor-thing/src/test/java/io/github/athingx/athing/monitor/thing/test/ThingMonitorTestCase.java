package io.github.athingx.athing.monitor.thing.test;

import io.github.athingx.athing.dm.thing.dump.DumpToFn;
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

}
