import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;


/*
*
*数据的输入：LongWritable,Text
* 1 2 990 4 5 6 7
* 12 31 32 33 43 90
* 12 311 322 323 43 90 12 31 32 33 43 90
* 将这些数据直接传送出去，而不进行任何处理，并将全部数据发送给reduce
* value:IntWritable key:NullWritable
* [Null,1 2 990 4 5 6 7 12 31 32 33 43 90 12 311 322 323 43 90 12 31 32 33 43 90]
*
*
*/
public class TopN_Mapper extends Mapper<LongWritable, Text,Text, IntWritable> {

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {


    }
}
