#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package};

import java.util.Vector;
import junit.framework.TestCase;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.${artifactId}.Reducer;
import org.apache.hadoop.mrunit.${artifactId}.ReduceDriver;
import org.junit.Before;
import org.junit.Test;

import ${package}.MapreduceReducer;

public class MapreduceReducerTest extends TestCase {
	private Reducer<Text, IntWritable, Text, IntWritable> reducer;
	private ReduceDriver<Text, IntWritable, Text, IntWritable> driver;
	
	@Before
	public void setUp() {
		reducer = new MapreduceReducer();
		driver = new ReduceDriver<Text, IntWritable, Text, IntWritable>(reducer);
	}
	
	@Test
	public void testCountOccurancesOfWordFromListOfOnes() {
		int expectedWordCount = 10;
		
		Vector<IntWritable> tenOnes = new Vector<IntWritable>();
		
		for (int i = 0; i < expectedWordCount; i++) {
			tenOnes.add( new IntWritable(1) );
		}
		
		driver.withInput(new Text("theword"), tenOnes)
			  .withOutput(new Text("theword"), new IntWritable(expectedWordCount) )
			  .runTest();
	}
}
