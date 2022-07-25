package io.github.athingx.athing.monitor.thing.test;

import io.github.athingx.athing.dm.thing.ThingDm;
import io.github.athingx.athing.dm.thing.builder.ThingDmBuilder;
import io.github.athingx.athing.monitor.thing.ThingMonitor;
import io.github.athingx.athing.monitor.thing.builder.ThingMonitorBuilder;
import io.github.athingx.athing.thing.api.Thing;
import io.github.athingx.athing.thing.api.ThingPath;
import io.github.athingx.athing.thing.builder.ThingBuilder;
import io.github.athingx.athing.thing.builder.mqtt.AliyunMqttClientFactory;
import org.junit.AfterClass;
import org.junit.BeforeClass;

public class ThingMonitorSupport implements LoadingProperties {

    protected static volatile Thing thing;
    protected static volatile ThingDm thingDm;
    protected static volatile ThingMonitor thingMonitor;

    @BeforeClass
    public static void _before() throws Exception {

        thing = new ThingBuilder(new ThingPath(PRODUCT_ID, THING_ID))
                .client(new AliyunMqttClientFactory()
                        .remote(THING_REMOTE)
                        .secret(THING_SECRET))
                .build();

        thingDm = new ThingDmBuilder()
                .build(thing)
                .get();

        thingMonitor = new ThingMonitorBuilder()
                .build(thingDm);

    }

    @AfterClass
    public static void _after() {
        thing.destroy();
    }

}
