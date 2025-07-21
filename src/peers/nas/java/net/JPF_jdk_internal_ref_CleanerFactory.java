package nas.java.net;

import gov.nasa.jpf.annotation.MJI;
import gov.nasa.jpf.vm.MJIEnv;
import gov.nasa.jpf.vm.NativePeer;

/**
 * Java 11 CleanerFactory compatibility
 * Avoids all object creation that JPF cannot handle
 */
public class JPF_jdk_internal_ref_CleanerFactory extends NativePeer {

    @MJI
    public static void $clinit____V(MJIEnv env, int clsObjRef) {
    }

    @MJI
    public static int cleaner____Ljava_lang_ref_Cleaner_2(MJIEnv env, int clsObjRef) {
        return MJIEnv.NULL;
    }
}
