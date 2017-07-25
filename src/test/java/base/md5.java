package base;

import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;

public class md5 {
    @Test
    public void md5Test(){
        String md5Digest = DigestUtils.md5Hex("aaa");
        System.out.println(md5Digest);
    }
}
