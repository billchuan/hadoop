import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.net.URI;

public class HDFS {
    public static void main(String[] args) throws Exception {
        //需要什么操作直接调用方法
        HDFS.pro();
        HDFS.delete_file();

    }

    //定义Hadoop地址
    public static final String str = "hdfs://192.168.72.12:9000";
    public static FileSystem fs;

    public static void pro() throws Exception {
        fs = FileSystem.get(new URI(str), new Configuration(), "root");
    }

    //创建Hadoop路径
    public static void mkdir() throws Exception {
        boolean mkdirs = fs.mkdirs(new Path("/21810/21810"));
        System.out.println("mkdirs" + mkdirs);
    }

    //上传
    public static void upload() throws Exception {
        Path src = new Path("C:\\Users\\Lenovo\\Desktop\\test_1.txt");
        Path drc = new Path("/");
        fs.copyFromLocalFile(src, drc);
    }

    //下载
    public static void get_File() throws Exception {
        Path src = new Path("/test_1.txt");
        Path drc = new Path("D:\\tmp\\");
        fs.copyToLocalFile(false, src, drc, true);
        System.out.println("src");
    }

    //删除
    public static void delete_file() throws Exception {
        Path path = new Path("/test_1.txt");
        boolean delete = fs.delete(path, true);
        System.out.println("delete" + delete);
    }

}