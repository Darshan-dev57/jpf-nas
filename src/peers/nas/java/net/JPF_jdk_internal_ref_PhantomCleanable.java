package nas.java.net;

import gov.nasa.jpf.annotation.MJI;
import gov.nasa.jpf.vm.MJIEnv;
import gov.nasa.jpf.vm.NativePeer;

/**
 * Java 11 PhantomCleanable compatibility
 * Bypasses phantom reference cleanup system
 */
public class JPF_jdk_internal_ref_PhantomCleanable extends NativePeer {

    static {
        System.out.println("JPF_jdk_internal_ref_PhantomCleanable loaded");
    }

    @MJI
    public static void $init__Ljava_lang_Object_2Ljava_lang_ref_Cleaner_2Ljava_lang_Runnable_2__V(
            MJIEnv env, int objRef, int referentRef, int cleanerRef, int runnableRef) {
        System.out.println("PhantomCleanable.<init>() bypassed");
    }

    @MJI
    public static void $clinit____V(MJIEnv env, int clsObjRef) {
        System.out.println("PhantomCleanable static initialization intercepted");
    }
}
