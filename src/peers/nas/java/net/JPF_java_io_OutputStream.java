package nas.java.net;

import gov.nasa.jpf.annotation.MJI;
import gov.nasa.jpf.vm.MJIEnv;
import gov.nasa.jpf.vm.NativePeer;

/**
 * OutputStream native peer to handle abstract method issues in socket testing
 * This prevents AbstractMethodError when tests try to write to socket OutputStreams
 */
public class JPF_java_io_OutputStream extends NativePeer {

    static {
        System.out.println("JPF_java_io_OutputStream loaded");
    }

    @MJI
    public static void write__I__V(MJIEnv env, int objRef, int b) {
        // Ensure buffer is initialized
        int bufRef = env.getReferenceField(objRef, "buf");
        if (bufRef == MJIEnv.NULL) {
            bufRef = env.newByteArray(1024);
            env.setReferenceField(objRef, "buf", bufRef);
            env.setIntField(objRef, "count", 0);
        }
    }


    @MJI
    public static void write___3B__V(MJIEnv env, int objRef, int bufRef) {
        // Mock write operation for byte arrays
        System.out.println("OutputStream.write(byte[]) intercepted");
    }

    @MJI
    public static void write___3BII__V(MJIEnv env, int objRef, int bufRef, int off, int len) {
        // Mock write operation for byte array segments
        System.out.println("OutputStream.write(byte[], int, int) intercepted");
    }

    @MJI
    public static void flush____V(MJIEnv env, int objRef) {
        // Mock flush operation
        System.out.println("OutputStream.flush() intercepted");
    }

    @MJI
    public static void close____V(MJIEnv env, int objRef) {
        // Mock close operation
        System.out.println("OutputStream.close() intercepted");
    }
}
