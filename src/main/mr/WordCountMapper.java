import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

/*
 * <KEYIN,VALUEIN,KEYOUT,VALUEOUT>
 *
 *  KEYIN,VALUEIN:是mapping接收到的数据类型（splitting发送的数据类型）
 *  <1,Deer Beer Driver>==<Int,String>==<IntWritable,Text>
 *  KEYOUT,VALUEOUT:是mapping发送出去的数据类型
 *  <单词,1>==<String,Int>==<Text,IntWriTable>  1:表示出现了
 *
 */
public class WordCountMapper extends Mapper<IntWritable, Text, Text, IntWritable> {

    @Override
    protected void map(IntWritable key, Text value, Context context) throws IOException, InterruptedException {
        //key:行数
        //value:每行的数据
        //获取第一行数据:<1,Deer Beer Driver>
        String str = value.toString();
        //得到一行中的每一个单词，以空格为分隔符 ["Deer" "Beer" "Driver"]
        String[] words = str.split("");
        //循环遍历数组
        for (String word : words) {
            //<Deer,1>,<Beer,1>,<Driver,1>
            //已经获取到每个单词,并将数据发送出去<单词,1>
            context.write(new Text(word), new IntWritable(1));
        }
    }
}
