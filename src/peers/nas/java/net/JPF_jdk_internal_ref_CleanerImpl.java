package nas.java.net;

import gov.nasa.jpf.annotation.MJI;
import gov.nasa.jpf.vm.MJIEnv;
import gov.nasa.jpf.vm.NativePeer;

/**
 * Native peer for jdk.internal.ref.CleanerImpl
 * Handles Java 11 cleaner system integration
 */
public class JPF_jdk_internal_ref_CleanerImpl extends NativePeer {

    static {
        System.out.println("JPF_jdk_internal_ref_CleanerImpl loaded");
    }

    @MJI
    public static int getCleanerImpl__Ljava_util_function_Function_2__Ljava_lang_Object_2(
            MJIEnv env, int objRef, int functionRef) {
        System.out.println("CleanerImpl.getCleanerImpl() intercepted");

        return env.newObject("java.lang.Object");
    }

    @MJI
    public static int register__Ljava_lang_Object_2Ljava_lang_Runnable_2__Ljava_lang_ref_Cleaner_Cleanable_2(
            MJIEnv env, int objRef, int objectRef, int runnableRef) {
        System.out.println("CleanerImpl.register() intercepted");

        int cleanableRef = env.newObject("java.lang.ref.Cleaner$Cleanable");
        return cleanableRef;
    }
}
