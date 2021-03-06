import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

/*
 *KEYIN,VALUEIN:是mapper发送过来的数据类型，类似于<单词,1>==><Text,IntWritable>
 *
 *KEYOUT,VALUE:是reduce输出的数据类型<单词，总和>==<Beer,2>==><Text,IntWritable>
 *
 */
public class WordCountReduce extends Reducer<Text, IntWritable, Text, IntWritable> {

    @Override
    protected void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {
        //key:map的key(单词)    values:map的value(1,1)
        int sum = 0;
        //循环遍历数据
        for (IntWritable value : values) {
            //获取每一个数据
            int count = value.get();
            //对每一个数据进行求和运算
            sum += count;
        }
        context.write(key, new IntWritable(sum));

    }
}
