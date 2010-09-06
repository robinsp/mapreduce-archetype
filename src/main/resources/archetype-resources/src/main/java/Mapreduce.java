#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package};

import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.${artifactId}.Job;
import org.apache.hadoop.${artifactId}.lib.input.FileInputFormat;
import org.apache.hadoop.${artifactId}.lib.input.TextInputFormat;
import org.apache.hadoop.${artifactId}.lib.output.FileOutputFormat;
import org.apache.hadoop.${artifactId}.lib.output.TextOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

public class ${main-class-name} extends Configured implements Tool {
	
    public int run(String [] args) throws Exception {
        Job job = new Job(getConf());
        job.setJarByClass(Mapreduce.class);
        job.setJobName("${artifactId}");
	
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);
	
        job.setMapperClass(MapreduceMapper.class);
        job.setCombinerClass(MapreduceReducer.class);
        job.setReducerClass(MapreduceReducer.class);
	
        job.setInputFormatClass(TextInputFormat.class);
        job.setOutputFormatClass(TextOutputFormat.class);
	
        FileInputFormat.setInputPaths(job, new Path(args[0]));
        FileOutputFormat.setOutputPath(job, new Path(args[1]));

        boolean success = job.waitForCompletion(true);
        return success ? 0 : 1;
    }
	
    public static void main(String[] args) throws Exception {
        int ret = ToolRunner.run(new Mapreduce(), args);
        System.exit(ret);
    }
}
