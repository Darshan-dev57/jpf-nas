package nas.java.net;

import gov.nasa.jpf.annotation.MJI;
import gov.nasa.jpf.vm.MJIEnv;
import gov.nasa.jpf.vm.NativePeer;

/**
 * ExtendedSocketOptions registration handler for Java 11 compatibility
 * Prevents the registration chain that causes initialization issues
 */
public class JPF_sun_net_ext_ExtendedSocketOptions extends NativePeer {

    @MJI
    public static void register__Lsun_net_ext_ExtendedSocketOptions_2__V(MJIEnv env, int clsObjRef, int extOptsRef) {
        // This prevents the null string startsWith() call
    }

    @MJI
    public static int getInstance____Lsun_net_ext_ExtendedSocketOptions_2(MJIEnv env, int clsObjRef) {
        // Return a mock instance
        return env.newObject("sun.net.ext.ExtendedSocketOptions");
    }

    @MJI
    public static void setOption__Ljava_io_FileDescriptor_2Ljava_net_SocketOption_2Ljava_lang_Object_2__V(
            MJIEnv env, int objRef, int fdRef, int optionRef, int valueRef) {
    }

    @MJI
    public static int getOption__Ljava_io_FileDescriptor_2Ljava_net_SocketOption_2__Ljava_lang_Object_2(
            MJIEnv env, int objRef, int fdRef, int optionRef) {
        return MJIEnv.NULL;
    }
}
