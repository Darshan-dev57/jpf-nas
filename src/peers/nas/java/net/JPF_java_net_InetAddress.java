package nas.java.net;

import gov.nasa.jpf.annotation.MJI;
import gov.nasa.jpf.vm.MJIEnv;
import gov.nasa.jpf.vm.NativePeer;

public class JPF_java_net_InetAddress extends NativePeer {

    @MJI
    public static void $clinit____V(MJIEnv env, int clsObjRef) {

    }

    @MJI
    public static int anyLocalAddress____Ljava_net_InetAddress_2(MJIEnv env, int clsObjRef) {
        try {
            int inetAddressRef = env.newObject("java.net.InetAddress");
            if (inetAddressRef != MJIEnv.NULL) {

                byte[] anyLocal = {0, 0, 0, 0};
                int addrArrayRef = env.newByteArray(anyLocal);

                try {
                    env.setReferenceField(inetAddressRef, "address", addrArrayRef);
                } catch (Exception e) {
                }

                System.out.println("Created anyLocalAddress InetAddress object");
                return inetAddressRef;
            }
        } catch (Exception e) {
            System.out.println("Warning: Could not create anyLocalAddress object: " + e.getMessage());
        }
        return MJIEnv.NULL;
    }


    @MJI
    public static int getByName__Ljava_lang_String_2__Ljava_net_InetAddress_2(MJIEnv env, int clsObjRef, int hostRef) {
        String hostname = env.getStringObject(hostRef);

        if ("localhost".equals(hostname) || "127.0.0.1".equals(hostname)) {
            return env.newObject("java.net.InetAddress");
        }

        env.throwException("java.net.UnknownHostException", "Unknown host: " + hostname);
        return MJIEnv.NULL;
    }
}
