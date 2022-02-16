package project.tms.daoLayer.databaseLayer;

import org.apache.commons.codec.binary.Base64;

public final class DaoUtils {

    private DaoUtils() {
        throw new UnsupportedOperationException();
    }

    public static String encrypt(String stringForEncrypt) {
        Base64 codec = new Base64();
        return new String(codec.encode(stringForEncrypt.getBytes()));
    }
}
