import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;


/*
 *
 * 数据的输入：LongWritable,Text(Splitting)
 * 1 2 990 4 5 6 7
 * 12 31 32 33 43 90
 * 12 311 322 323 43 90 12 31 32 33 43 90
 * 将这些数据直接传送出去，而不进行任何处理，并将全部数据发送给reduce
 * value:IntWritable key:NullWritable
 * [Null,1 2 990 4 5 6 7 12 31 32 33 43 90 12 311 322 323 43 90 12 31 32 33 43 90]
 *
 *
 */
public class TopN_Mapper extends Mapper<LongWritable, Text, NullWritable, IntWritable> {
    /**
     * @param key     1,2,3 分别表示行数
     * @param value   (1 2 990 4 5 6 7)、(12 31 32 33 43 90)、(12 311 322 323 43 90 12 31 32 33 43 90) 每行数据
     * @param context
     * @throws IOException
     * @throws InterruptedException
     */
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        //读取一行数据 1 2 990 4 5 6 7
        String str = value.toString();
        //分隔数据，按照空格分割
        String[] counts = str.split(" ");
        int i = 0;
        //提取每一个数字
        for (String count : counts) {
            //字符串不能比较大小，要想比较大小，只能是数字
            //将字符串转换成整形的数字
            i = Integer.parseInt(count);
            //发送数据
            context.write(NullWritable.get(), new IntWritable(i));
        }

    }
}
