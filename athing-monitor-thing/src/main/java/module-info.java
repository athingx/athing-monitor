module athing.monitor.thing {

    exports io.github.athingx.athing.monitor.thing;

    requires transitive athing.monitor.api;
    requires transitive athing.dm.thing;
    requires org.slf4j;
    requires com.github.oshi;

}