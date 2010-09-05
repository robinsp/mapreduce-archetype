#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package};

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;

import org.apache.hadoop.${artifactId}.Mapper;
import org.apache.hadoop.mrunit.${artifactId}.MapDriver;

import ${package}.MapreduceMapper;

public class MapreduceMapperTest extends TestCase {
	private static final IntWritable ONE_OCCURANCE = new IntWritable(1);
	private Mapper<LongWritable, Text, Text, IntWritable> mapper;
    private MapDriver<LongWritable, Text, Text, IntWritable> driver;

    @Before 
    public void setUp() {
        mapper = new MapreduceMapper();
        driver = new MapDriver<LongWritable, Text, Text, IntWritable>(mapper);
    }

    @Test
    public void testWordCount() {
    	String line = "Hello World Bye World";
				
		driver.withInput(UNUSED_LONG_KEY, new Text(line) )
			  .withOutput(new Text("Hello"), ONE_OCCURANCE )
			  .withOutput(new Text("World"), ONE_OCCURANCE )
			  .withOutput(new Text("Bye"),   ONE_OCCURANCE )
			  .withOutput(new Text("World"), ONE_OCCURANCE )
			  .runTest();
    }

    private static final LongWritable UNUSED_LONG_KEY = new LongWritable(1);
}
