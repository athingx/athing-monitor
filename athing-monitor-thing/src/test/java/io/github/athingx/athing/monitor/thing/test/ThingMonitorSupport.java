package io.github.athingx.athing.monitor.thing.test;

import io.github.athingx.athing.dm.thing.ThingDm;
import io.github.athingx.athing.dm.thing.ThingDmInstaller;
import io.github.athingx.athing.monitor.thing.ThingMonitorInstaller;
import io.github.athingx.athing.thing.api.Thing;
import io.github.athingx.athing.thing.api.ThingPath;
import io.github.athingx.athing.thing.builder.ThingBuilder;
import io.github.athingx.athing.thing.builder.client.DefaultMqttClientFactory;
import org.junit.AfterClass;
import org.junit.BeforeClass;

public class ThingMonitorSupport implements LoadingProperties {

    protected static volatile Thing thing;
    protected static volatile ThingDm thingDm;

    @BeforeClass
    public static void _before() throws Exception {

        thing = new ThingBuilder(new ThingPath(PRODUCT_ID, THING_ID))
                .client(new DefaultMqttClientFactory()
                        .remote(THING_REMOTE)
                        .secret(THING_SECRET)
                )
                .build();

        thing.plugins().install(new ThingMonitorInstaller());
        thingDm = thing.plugins().install(new ThingDmInstaller()).get();

    }

    @AfterClass
    public static void _after() {
        thing.destroy();
    }

}
