import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

/*
 *KEYIN,VALUEIN:是mapper发送过来的数据类型，类似于<单词,1>==><Text,IntWritable>
 *
 *KEYOUT,VALUE:是reduce输出的数据类型<单词，求和值>==><Text,IntWritable>
 *
 *
 *
 *
 *
 */
public class WordCountReduce extends Reducer<Text, IntWritable, Text, IntWritable> {

    @Override
    protected void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {

    }
}
