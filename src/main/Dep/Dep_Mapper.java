import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

//mapping接收到的数据来源于Spliting<key,value>==<LongWritable,Text>
//mapping数据的数据输出<key,value>==>自定义<单词，1>==><Text,IntWritable>
public class Dep_Mapper extends Mapper<LongWritable, Text, Text, IntWritable> {

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        //读取一行数据
        String str = value.toString();
        //拆分单词放入数组中
        String[] words = str.split(" ");
        //遍历数组
        for (String word : words) {
            //已经获取到每个单词,并将数据发送出去<单词,1>
            context.write(new Text(word), new IntWritable(1));
        }
    }
}
