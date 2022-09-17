package io.github.athingx.athing.monitor.api.usage;

import io.github.athingx.athing.dm.api.Identifier;

/**
 * 设备使用
 */
public class Usage {

    /**
     * CPU使用率
     *
     * @param user       使用率: user(%)
     * @param nice       使用率: nice(%)
     * @param system     使用率: system(%)
     * @param idle       使用率: idle(%)
     * @param iowait     使用率: iowait(%)
     * @param irq        使用率: irq(%)
     * @param sirq       使用率: soft-irq(%)
     * @param steal      使用率: steal(%)
     * @param load01     LOAD系列：1
     * @param load05     LOAD系列：5
     * @param load15     LOAD系列：15
     * @param cs         上下文切换次数
     * @param interrupts 中断发生次数
     */
    public record Cpu(
            float user, float nice, float system, float idle, float iowait,
            float irq, float sirq, float steal,
            float load01, float load05, float load15,
            long cs, long interrupts
    ) {

    }

    /**
     * 内存使用率
     *
     * @param usable      内存可用容量(bytes)
     *                    phyUsable
     * @param usableRate  内存可用率(%)
     * @param swapUsed    交换分区已用容量(bytes)
     * @param swapUseRate 交换分区使用率(%)
     */
    public record Memory(long usable, float usableRate, long swapUsed, float swapUseRate) {

    }

    /**
     * 网络使用率
     *
     * @param mac       Mac地址
     * @param name      网络名称
     * @param recv      已接收(bytes)
     * @param sent      已发送(bytes)
     * @param recvPkt   已接收包
     * @param sentPkt   已发送包
     * @param inDropPkt 收包丢包数量
     * @param inErrPkt  收包错误数量
     * @param outErrPkt 发包错误数量
     */
    public record Network(
            String mac, String name,
            long recv, long sent, long recvPkt, long sentPkt,
            long inDropPkt, long inErrPkt, long outErrPkt
    ) {

    }

    /**
     * 电源使用率
     *
     * @param name          电源名
     * @param remainingRate 剩余电量比率(%)
     */
    public record Power(String name, float remainingRate) {

    }

    /**
     * 存储使用率
     *
     * @param mount      挂载点
     * @param usable     可用空间(bytes)
     * @param usableRate 可用率(%)
     */
    public record Store(String mount, long usable, float usableRate) {

    }

    /**
     * 使用率项目
     */
    public enum Item {

        CPU("cpu"),
        MEMORY("memory"),
        POWER("powers"),
        NETWORK("networks"),
        STORE("stores");

        private final Identifier identifier;

        Item(String propertyId) {
            this.identifier = Identifier.toIdentifier(ThingUsageDmComp.COMP_ID, propertyId);
        }

        public Identifier getIdentifier() {
            return identifier;
        }

    }
}
