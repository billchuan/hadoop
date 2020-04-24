import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class TopN_Driver {
    public static void main(String[] args) throws Exception {
        //实例化job
        Job job = Job.getInstance(new Configuration());
        //设置主类
        job.setJarByClass(TopN_Driver.class);
        //设置mapper和reduce类
        job.setMapperClass(TopN_Mapper.class);
        job.setReducerClass(TopN_Reduce.class);
        //mapper数据输出类型
        job.setMapOutputKeyClass(NullWritable.class);
        job.setMapOutputValueClass(IntWritable.class);
        //reduce数据输出类型
        job.setOutputKeyClass(IntWritable.class);
        job.setOutputValueClass(NullWritable.class);
        //文件的输入
        FileInputFormat.setInputPaths(job, "C:\\Users\\Lenovo\\Desktop\\1.txt");
        //文件的输出
        FileOutputFormat.setOutputPath(job, new Path("D:\\topN"));
        /* 提交、退出 */
        System.exit(job.waitForCompletion(true) ? 0 : 1);


    }
}
