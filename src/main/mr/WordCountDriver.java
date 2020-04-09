import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;


public class WordCountDriver {
    public static void main(String[] args) throws Exception {
        //实例化job
        Job job = Job.getInstance( new Configuration());
        //设置主类
        job.setJarByClass(WordCountDriver.class);
        //设置mapper和reduce类
        job.setMapperClass(WordCountMapper.class);
        job.setReducerClass(WordCountReduce.class);
        //mapper数据输出类型
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(IntWritable.class);
        //reduce数据输出类型
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);
        //设置combiner
        job.setCombinerClass(WordCountCombiner.class);
        //文件的输入
        FileInputFormat.setInputPaths(job, "C:\\Users\\Lenovo\\Desktop\\test.txt");
        //结果的输出
        FileOutputFormat.setOutputPath(job, new Path("D:\\temp"));
        //提交
        boolean bool = job.waitForCompletion(true);
        //退出
        System.exit(bool ? 0 : 1);
    }

}
