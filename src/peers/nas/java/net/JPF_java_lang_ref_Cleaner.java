package nas.java.net;

import gov.nasa.jpf.annotation.MJI;
import gov.nasa.jpf.vm.MJIEnv;
import gov.nasa.jpf.vm.NativePeer;

/**
 * Native peer for java.lang.ref.Cleaner
 */
public class JPF_java_lang_ref_Cleaner extends NativePeer {

    static {
        System.out.println("JPF_java_lang_ref_Cleaner loaded");
    }

    @MJI
    public static int register__Ljava_lang_Object_2Ljava_lang_Runnable_2__Ljava_lang_ref_Cleaner_Cleanable_2(
            MJIEnv env, int objRef, int objectRef, int runnableRef) {
        System.out.println("Cleaner.register() intercepted");

        int cleanableRef = env.newObject("java.lang.ref.Cleaner$Cleanable");
        return cleanableRef;
    }
}
