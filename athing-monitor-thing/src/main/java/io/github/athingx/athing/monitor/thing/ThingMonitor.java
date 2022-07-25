package io.github.athingx.athing.monitor.thing;

import io.github.athingx.athing.monitor.api.info.Info;
import io.github.athingx.athing.monitor.api.usage.Usage;
import io.github.athingx.athing.thing.api.op.OpReply;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

/**
 * 设备监控
 */
public interface ThingMonitor {

    /**
     * 上报设备信息
     *
     * @param items 设备信息选项
     * @return 上报结果
     */
    CompletableFuture<OpReply<Set<Info.Item>>> info(Info.Item... items);

    /**
     * 上报设备使用
     *
     * @param items 设备使用选项
     * @return 上报结果
     */
    CompletableFuture<OpReply<Set<Usage.Item>>> usage(Usage.Item... items);

}
