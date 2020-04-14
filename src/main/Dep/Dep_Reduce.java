import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

/*
*
* 由于shuffing自动会完成数据的除重（按key），完成之后会发送数据给reduce
* 输入的数据:(单词,1)==>(Text,IntWritable)
* 输出的数据:(单词)==><Text,NullWritable>
*
*
*/
public class Dep_Reduce extends Reducer<Text, IntWritable,Text, NullWritable> {
    /*
    *
    *key:单词
    * values:数值1
    * context:上下文，用于输出
    *
    */
    @Override
    protected void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {
        //输出，key（单词）value(置空)
        context.write(key,NullWritable.get());
    }
}
