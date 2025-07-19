package nas.java.net;

import gov.nasa.jpf.annotation.MJI;
import gov.nasa.jpf.vm.MJIEnv;
import gov.nasa.jpf.vm.NativePeer;

public class JPF_java_net_InetAddress extends NativePeer {

    static {
        System.out.println("JPF_java_net_InetAddress loaded");
    }

    @MJI
    public static void init____V(MJIEnv env, int clsObjRef) {
        System.out.println("InetAddress.init() intercepted");
    }

    @MJI
    public static void $clinit____V(MJIEnv env, int clsObjRef) {
        System.out.println("InetAddress static initialization intercepted");
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
    public static boolean isLinkLocalAddress____Z(MJIEnv env, int objRef) {
        // Return false for testing (not a link-local address)
        return false;
    }

    @MJI
    public static boolean isLoopbackAddress____Z(MJIEnv env, int objRef) {
        // true for localhost testing
        return true;
    }

    @MJI
    public static boolean isMulticastAddress____Z(MJIEnv env, int objRef) {
        return false;
    }

    @MJI
    public static boolean isSiteLocalAddress____Z(MJIEnv env, int objRef) {
        return false;
    }

    @MJI
    public static boolean isAnyLocalAddress____Z(MJIEnv env, int objRef) {
        return false;
    }

    @MJI
    public static int getAddress____3B(MJIEnv env, int objRef) {
        // Return localhost IP bytes (127.0.0.1)
        byte[] localhost = {127, 0, 0, 1};
        return env.newByteArray(localhost);
    }

    @MJI
    public static int getHostAddress____Ljava_lang_String_2(MJIEnv env, int objRef) {
        return env.newString("127.0.0.1");
    }

    @MJI
    public static int getHostName____Ljava_lang_String_2(MJIEnv env, int objRef) {
        return env.newString("localhost");
    }

    @MJI
    public static int getLocalHostName____Ljava_lang_String_2(MJIEnv env, int clsObjRef) {
        return env.newString("localhost");
    }

    @MJI
    public static int lookupHostByName__Ljava_lang_String_2__I(MJIEnv env, int clsObjRef, int hostRef) {
        return env.newString("127.0.0.1");
    }

    @MJI
    public static int getHostByAddr___3B__Ljava_lang_String_2(MJIEnv env, int clsObjRef, int addrRef) {
        return env.newString("localhost");
    }

    @MJI
    public static boolean isReachable0___3BII_3BII__Z(MJIEnv env, int objRef,
                                                      int addrRef, int scope, int timeout,
                                                      int ifAddrRef, int ifScope, int ttl) {
        return true;
    }

    @MJI
    public static int getAllByName0__Ljava_lang_String_2Ljava_net_InetAddress_2Z___3Ljava_net_InetAddress_2(
            MJIEnv env, int clsRef, int hostRef, int reqAddrRef, boolean check) {

        if (hostRef == MJIEnv.NULL) {
            return env.newObjectArray("java.net.InetAddress", 0);
        }

        String host = env.getStringObject(hostRef);
        if (host == null) {
            return env.newObjectArray("java.net.InetAddress", 0);
        }

        if ("localhost".equals(host) || "127.0.0.1".equals(host)) {
            int arrRef = env.newObjectArray("java.net.InetAddress", 1);
            int addrRef = env.newObject("java.net.InetAddress");

            try {
                env.setReferenceField(addrRef, "hostName", env.newString("localhost"));
            } catch (Exception e) {
            }

            try {
                byte[] b = {127, 0, 0, 1};
                env.setReferenceField(addrRef, "address", env.newByteArray(b));
            } catch (Exception e) {
            }

            env.setReferenceArrayElement(arrRef, 0, addrRef);
            return arrRef;
        }

        // Unknown host - return empty array
        return env.newObjectArray("java.net.InetAddress", 0);
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
