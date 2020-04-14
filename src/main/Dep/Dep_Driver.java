import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class Dep_Driver {
    public static void main(String[] args) throws Exception {
        //获取job 静态方法的调用是使用类直接使用
        Job job = Job.getInstance(new Configuration());
        //设置相关类
        job.setJarByClass(Dep_Driver.class);
        //map和reduce
        job.setMapperClass(Dep_Mapper.class);
        job.setReducerClass(Dep_Reduce.class);
        //设置map输出和reduce的输出
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(IntWritable.class);

        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(NullWritable.class);
        //设置文件输入、输出路径
        FileInputFormat.setInputPaths(job, "C:\\Users\\Lenovo\\Desktop\\11.txt");
        FileOutputFormat.setOutputPath(job, new Path("D:\\test"));
        //提交
        boolean b = job.waitForCompletion(true);
        //退出
        System.exit(b ? 0 : 1);


    }
}

