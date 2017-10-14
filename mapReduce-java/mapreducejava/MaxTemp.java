package mapreducejava;

import java.io.FileInputStream;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.lib.input.FileInputFormat;
import org.apache.hadoop.lib.output.FileOutputFormat;

public class MaxTemp{

    public static void main(String args[]){
        if(args.length != 2){
            System.err.println("Usage: MaxTemperature <input path> <output path>");
            System.exit(-1);
        }

        Job.job = new Job();
        job.setJarByClass(MaxTemperature.class);
        job.setJobName("Max Temperature");

        FileInputFormat.addInputPath(job, new Path(args[0]));
        FileOutputFormat.setOutputPath(job, new Path(args[1]));

        job.setMapperClass(MapperMaxTemp.class);
        job.setCombinerClass(ReducerMaxTemp.class);
        job.setReducerClass(ReducerMaxTemp.class);

        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);

        System.exit(job.waitForCompletion(true) ? 0 : 1);
    }
}