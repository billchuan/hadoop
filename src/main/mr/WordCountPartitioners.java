import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

public class WordCountPartitioners extends Partitioner<Text, IntWritable> {
    //根据单词首字母进行分区数据处理
    @Override
    public int getPartition(Text text, IntWritable intWritable, int i) {
        String str = text.toString();
        //substring截取单词首字母,从0开始,判断是否相等，如果相同返回一个值
        if (str.substring(0, 1).equals("j")) {
            return 0;
        } else if (str.substring(0, 1).equals("h")) {
            return 1;
        } else if (str.substring(0, 1).equals("s")) {
            return 2;
        } else if (str.substring(0, 1).equals("t")) {
            return 3;
        } else {
            return 4;
        }


    }
}

