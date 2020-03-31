import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.junit.Before;
import org.junit.Test;

import java.net.URI;

public class HDFSTest {
    final static String str = "hdfs://192.168.72.12:9000";
    final static Configuration conf = new Configuration();
    FileSystem fs;

    @Before
    public void fs_link() throws Exception {
        fs = FileSystem.get(new URI(str), conf, "root");
    }

    @Test
    public void mkdir_test() throws Exception {
        boolean mkdirs = fs.mkdirs(new Path("/1"));
        System.out.println("mkdirs" + mkdirs);
    }
}
