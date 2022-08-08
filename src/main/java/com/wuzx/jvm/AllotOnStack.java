package com.wuzx.jvm;


/**
 *
 *
 * 2 *
 * 3 *
 * 4*
 * 栈上分配，标量替换 代码调用了1亿次alloc()，如果是分配到堆上，大概需要1GB以上堆空间，如果堆空间小于该值，必然会触发GC。
 * DoEscapeAnalysis 逃逸分析，就是这个对象可能在这个方法栈帧调用结束就销毁了，所以就没有必要在堆上创建的必要，直接在栈内存中创建，随着栈内存一起被收回
 * EliminateAllocations 标量替换，这个意思就是 开启了逃逸分析，确认了这个对象不会被外接访问，所以将这个对象进行分解，不会创建这个对象，而是将这个对象的成员变量分解成，不会因为没有一大块连续空间导致对象内存不够分配
 * * 使用如下参数不会发生GC
 * * ‐Xmx15m ‐Xms15m ‐XX:+DoEscapeAnalysis ‐XX:+PrintGC ‐XX:+EliminateAllocations
 * * 使用如下参数都会发生大量GC
 * * ‐Xmx15m ‐Xms15m ‐XX:‐DoEscapeAnalysis ‐XX:+PrintGC ‐XX:+EliminateAllocations
 * * ‐Xmx15m ‐Xms15m ‐XX:+DoEscapeAnalysis ‐XX:+PrintGC ‐XX:‐EliminateAllocations
 *
 */
public class AllotOnStack {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100000000; i++) {
            alloc();
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    private static void alloc() {
        User user = new User();
        user.setId(1);
        user.setName("zhuge");
    }
}
