package nas.java.net;

import gov.nasa.jpf.annotation.MJI;
import gov.nasa.jpf.vm.MJIEnv;
import gov.nasa.jpf.vm.NativePeer;

/**
 * Java 11 SocketCleanable compatibility - complete bypass
 * Prevents cleaner system initialization entirely
 */
public class JPF_java_net_SocketCleanable extends NativePeer {

    static {
        System.out.println("JPF_java_net_SocketCleanable loaded");
    }

    @MJI
    public static void $clinit____V(MJIEnv env, int clsObjRef) {
        System.out.println("SocketCleanable static initialization intercepted");
    }

    @MJI
    public static int register__Ljava_io_FileDescriptor_2__V(MJIEnv env, int clsObjRef, int fdRef) {
        System.out.println("SocketCleanable.register(void) bypassed for JPF-NAS");
        return 0;
    }
}
