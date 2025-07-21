package nas.java.net;

import gov.nasa.jpf.annotation.MJI;
import gov.nasa.jpf.vm.MJIEnv;
import gov.nasa.jpf.vm.NativePeer;

import java.util.HashMap;
import java.util.Map;

/**
 * OutputStream native peer for SocketOutputStream
 */
public class JPF_java_io_OutputStream extends NativePeer {
    private static Map<Integer, Integer> outputStreamToSocket = new HashMap<>();

    @MJI
    public static void write__I__V(MJIEnv env, int objRef, int b) {
        updateAssociatedSocketHash(env, objRef, b);
    }

    @MJI
    public static void write___3B__V(MJIEnv env, int objRef, int bufRef) {
        if (bufRef != MJIEnv.NULL) {
            byte[] data = env.getByteArrayObject(bufRef);
            for (byte b : data) {
                write__I__V(env, objRef, b & 0xFF);
            }
        }
    }

    @MJI
    public static void write___3BII__V(MJIEnv env, int objRef, int bufRef, int off, int len) {
        if (bufRef != MJIEnv.NULL && len > 0) {
            byte[] data = env.getByteArrayObject(bufRef);

            if (off >= 0 && off + len <= data.length) {
                for (int i = 0; i < len; i++) {
                    write__I__V(env, objRef, data[off + i] & 0xFF);
                }
            }
        }
    }

    @MJI
    public static void flush____V(MJIEnv env, int objRef) {
        // No-op for socket streams
    }

    @MJI
    public static void close____V(MJIEnv env, int objRef) {
        outputStreamToSocket.remove(objRef);
    }

    // Register socket-stream association for hash updates
    public static void registerSocketOutputStream(int socketRef, int outputStreamRef) {
        outputStreamToSocket.put(outputStreamRef, socketRef);
    }

    // Update associated socket hash when data is written
    private static void updateAssociatedSocketHash(MJIEnv env, int outputStreamRef, int data) {
        Integer socketRef = outputStreamToSocket.get(outputStreamRef);
        if (socketRef != null && socketRef != MJIEnv.NULL) {
            // Delegate to Socket peer's hash update method
            JPF_java_net_Socket.updateSocketHashForDataWrite(env, socketRef, data);
        }
    }
}
