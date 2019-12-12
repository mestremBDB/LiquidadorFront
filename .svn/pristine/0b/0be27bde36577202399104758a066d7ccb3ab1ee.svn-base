package core.rsolano.liqinterface.model.utils;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class EncoderUtil {
    public EncoderUtil() {
        super();
    }
    
    public static String encriptar(String clave) {
            Cipher cipher;
            try {
                cipher = Cipher.getInstance("DESEDE/ECB/PKCS5Padding");
                byte[] keyBytes = new byte[] { (byte)0xC1, (byte)0x57, (byte)0x45, (byte)0x08, (byte)0x85, (byte)0x02, (byte)0xB0, (byte)0xD3, 
                                               (byte)0xA2, (byte)0xEF, (byte)0x68, (byte)0x43, (byte)0x5E, (byte)0xE6, (byte)0xD0, (byte)0x75, 
                                               (byte)0x5E, (byte)0xE6, (byte)0xD0, (byte)0x75, (byte)0x5E, (byte)0xE6, (byte)0xD0, (byte)0x75 };
                SecretKey keySpec = new SecretKeySpec(keyBytes, "DESede");
                cipher.init(Cipher.ENCRYPT_MODE, keySpec);
                byte[] stringBytes = clave.getBytes("UTF8");
                byte[] raw = cipher.doFinal(stringBytes);
                BASE64Encoder encoder = new BASE64Encoder();
                String base64 = encoder.encode(raw);
                return base64;
            } catch(Exception e) {
                e.printStackTrace();
            }
            return null;
        }
        
        public static String desencriptar(String clave) {
            Cipher cipher;
            try {
                cipher = Cipher.getInstance("DESEDE/ECB/PKCS5Padding");
                // ObjectInputStream in = new ObjectInputStream();
                //Key key = (Key) in.readObject();
                // in.close();
                byte[] keyBytes = new byte[] { (byte)0xC1, (byte)0x57, (byte)0x45, (byte)0x08, (byte)0x85, (byte)0x02, (byte)0xB0, (byte)0xD3, 
                                               (byte)0xA2, (byte)0xEF, (byte)0x68, (byte)0x43, (byte)0x5E, (byte)0xE6, (byte)0xD0, (byte)0x75,
                                               (byte)0x5E, (byte)0xE6, (byte)0xD0, (byte)0x75, (byte)0x5E, (byte)0xE6, (byte)0xD0, (byte)0x75 };
                SecretKey keySpec = new SecretKeySpec(keyBytes, "DESede");
                cipher.init(Cipher.DECRYPT_MODE, keySpec);
                BASE64Decoder decoder = new BASE64Decoder();
                byte[] raw = decoder.decodeBuffer(clave);
                byte[] stringBytes = cipher.doFinal(raw);
                String result = new String(stringBytes, "UTF8");
                return result;
            } catch (Exception e) {
                return null;
            }
        }
}
