import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;
import java.util.TreeMap;

//TopN:最大的几个值

/*
 * NullWritable, IntWritable:mapper输入
 * IntWritable,NullWritable(990 323):reduce的输出
 *
 */
public class TopN_Reduce extends Reducer<NullWritable, IntWritable, IntWritable, NullWritable> {
    /**
     * @param key     Null:无意义
     * @param values  1 2 990 4 5 6 7 12 31 32 33 43 90 12 311 322 323 43 90 12 31 32 33 43 90
     * @param context
     * @throws IOException
     * @throws InterruptedException
     */

    //生成了TreeMap对象，Integer:表示的是key String:表示的是value  int的装箱Integer
    //TreeMap:也是按照<k1,v1>按照k1的大小进行排序
    static TreeMap<Integer, String> treeMap = new TreeMap<Integer, String>();

    @Override
    protected void reduce(NullWritable key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {
        //循环获取数据
        for (IntWritable value : values) {
            //put(Integer,String)
            //放入数据到TreeMap里面，完成按照k1排序
            treeMap.put(value.get(), " ");
            //数据的个数，超过5个就删除一个最小值
            if (treeMap.size() > 5) {
                //remove:删除 FirstKey:最小值
                treeMap.remove(treeMap.firstKey());
            }

        }

    }

    //map处理之后，可以进行数据的分发
    @Override
    protected void cleanup(Context context) throws IOException, InterruptedException {
        //循环的就是TreeMap的键（排序的数据）
        for (Integer num : treeMap.keySet()) {
            //990 323 322 311 90
            context.write(new IntWritable(num), NullWritable.get());

        }

    }
}
