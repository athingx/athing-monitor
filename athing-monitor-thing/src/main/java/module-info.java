module athing.monitor.thing {

    exports io.github.athingx.athing.monitor.thing;
    exports io.github.athingx.athing.monitor.thing.builder;

    requires transitive athing.monitor.api;
    requires transitive athing.dm.thing;
    requires org.slf4j;
    requires com.github.oshi;

}