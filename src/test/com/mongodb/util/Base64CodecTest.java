package com.mongodb.util;


import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 * @author Sjoerd Mulder
 */
public class Base64CodecTest {

    private static final byte[] allBytes = new byte[255];
    private static final byte[] abc = new byte[] { 97, 98, 99}  ;
    private static final byte[] abcd = new byte[] { 97, 98, 99, 100};
    private static final byte[] abcde = new byte[] { 97, 98, 99, 100, 101};

    static {
        for (byte b = -128; b != 127; b++) {
            allBytes[b + 128] = b;
        }
    }

    @Test
    public void testDecodeEncode() throws Exception {
        Base64Codec codec = new Base64Codec();
        assertArrayEquals(abc, codec.decode(codec.encode(abc)));
        assertArrayEquals(abcd, codec.decode(codec.encode(abcd)));
        assertArrayEquals(abcde, codec.decode(codec.encode(abcde)));
        assertArrayEquals(allBytes, codec.decode(codec.encode(allBytes)));
    }

}
