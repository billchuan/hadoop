import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.mapreduce.Job;

public class WordCountDriver {
    public static void main(String[] args) {
        //实例化job
        Job job = Job.getInstance(new Configuration());
    }
}
