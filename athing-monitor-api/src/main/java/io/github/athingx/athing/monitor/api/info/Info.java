package io.github.athingx.athing.monitor.api.info;


import io.github.athingx.athing.dm.api.Identifier;

/**
 * 计算机信息
 */
public class Info {

    /**
     * 操作系统信息
     *
     * @param manufacturer 操作系统厂商
     * @param family       操作系统系列
     * @param bit          操作系统位数
     * @param version      操作系统版本
     */
    public record Os(String manufacturer, String family, int bit, String version) {

    }

    /**
     * JVM信息
     *
     * @param version    JVM版本号
     * @param home       JVM路径
     * @param memoryMax  JVM允许被使用的最大内存(bytes)
     * @param memoryUsed JVM当前已使用内存(bytes)
     * @param memoryFree JVM当前未使用内存(bytes)
     */
    public record Jvm(String version, String home, long memoryMax, long memoryUsed, long memoryFree) {

    }

    /**
     * 主板信息
     *
     * @param manufacturer 主板厂商
     * @param model        主板型号
     * @param version      主板版本
     * @param serial       主板序号
     */
    public record Baseboard(String manufacturer, String model, String version, String serial) {

    }

    /**
     * 设备信息
     *
     * @param manufacturer 设备厂商
     * @param model        设备型号
     * @param serial       设备序列号
     */
    public record Computer(String manufacturer, String model, String serial) {

    }

    /**
     * 处理器信息
     *
     * @param identifier  CPU 标识信息
     * @param processorID CPU ID
     * @param logicCnt    逻辑核数
     * @param phyCnt      物理核数
     * @param phyPkgCnt   物理芯片数
     */
    public record Cpu(String identifier, String processorID, int logicCnt, int phyCnt, int phyPkgCnt) {

    }

    /**
     * 磁盘信息
     *
     * @param serial 序列号
     * @param name   磁盘名称
     * @param model  产品系列
     * @param size   存储容量(bytes)
     */
    public record Disk(String serial, String name, String model, long size) {

    }

    /**
     * 固件信息
     *
     * @param manufacturer 固件厂商
     * @param name         固件名称
     * @param version      固件版本
     * @param description  固件描述
     */
    public record Firmware(String manufacturer, String name, String version, String description) {

    }

    /**
     * 内存信息
     *
     * @param phyCap 物理内存容量
     * @param virCap 虚拟内存容量
     */
    public record Memory(long phyCap, long virCap) {

    }

    /**
     * 电源信息
     *
     * @param name 电源名称
     * @param cap  电源容量
     * @param unit 容量单位
     */
    public record Power(String name, int cap, String unit) {

    }

    /**
     * 网络信息
     *
     * @param name  网卡名
     * @param mac   Mac地址
     * @param mtu   最大传输单元(bytes)
     * @param speed 最大传输速率(bytes)
     * @param ipv4s IPv4地址列表
     * @param ipv6s IPv6地址列表
     */
    public record Network(String name, String mac, long mtu, long speed, String[] ipv4s, String[] ipv6s) {

    }

    /**
     * 存储信息
     *
     * @param name     存储名称
     * @param mount    挂载点
     * @param format   存储格式
     * @param usable   可用容量(bytes)
     * @param capacity 整体容量(bytes)
     */
    public record Store(String name, String mount, String format, long usable, long capacity) {

    }

    /**
     * 信息项
     */
    public enum Item {

        OS("os"),
        JVM("jvm"),
        COMPUTER("computer"),
        BASEBOARD("baseboard"),
        FIRMWARE("firmware"),
        MEMORY("memory"),
        CPU("cpu"),
        DISK("disks"),
        POWER("powers"),
        NETWORK("networks"),
        STORE("stores");

        private final Identifier identifier;

        Item(String propertyId) {
            this.identifier = Identifier.toIdentifier(ThingInfoComp.COMP_ID, propertyId);
        }

        public Identifier getIdentifier() {
            return identifier;
        }

    }

}
