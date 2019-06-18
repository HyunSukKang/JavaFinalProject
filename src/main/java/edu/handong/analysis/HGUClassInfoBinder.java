package edu.handong.analysis;

import java.io.File;
import java.util.Arrays;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;

import edu.handong.analysis.datamodel.ExcelType1;
import edu.handong.analysis.datamodel.ExcelType2;
import edu.handong.analysis.datamodel.LinkedList;
import edu.handong.analysis.utils.ExcelWriter;
import edu.handong.analysis.utils.ZipReader;

public class HGUClassInfoBinder {
	
	String input;
	String output;
	boolean help;
	
	public void run(String[] args) {
		Options options = createOptions();
		if(parseOptions(options, args)){
			if (help) {
				printHelp(options);
				return;
			}
			
			File dataDir = new File(input);
			if(!dataDir.exists()) {
				System.out.println("Wrong Input Path");
				System.exit(0);
			}
			
			LinkedList<ExcelType1> value1 = new LinkedList<ExcelType1>();
			LinkedList<ExcelType2> value2 = new LinkedList<ExcelType2>();
			
			File[] fileList = dataDir.listFiles();
			Arrays.sort(fileList);
			for(File file : fileList) {
				ZipReader.readFileInZip(file, value1, value2);
			}
			ExcelWriter.WriteAFile1(value1, output);
			ExcelWriter.WriteAFile2(value2, output);
		}
	}
	
	private boolean parseOptions(Options options, String[] args) {
		CommandLineParser parser = new DefaultParser();

		try {
			CommandLine cmd = parser.parse(options, args);

			input = cmd.getOptionValue("i");
			output = cmd.getOptionValue("o");
			help = cmd.hasOption("h");
			
		} catch (Exception e) {
			printHelp(options);
			return false;
		}

		return true;
	}
	
	private Options createOptions() {
		Options options = new Options();

		// add options by using OptionBuilder
		options.addOption(Option.builder("i").longOpt("input")
				.desc("Set an input file path")
				.hasArg()
				.argName("Input path")
				.required()
				.build());

		// add options by using OptionBuilder
		options.addOption(Option.builder("o").longOpt("output")
				.desc("Set an output file path")
				.hasArg()     
				.argName("Output path")
				.required() 
				.build());
		
		// add options by using OptionBuilder
		options.addOption(Option.builder("h").longOpt("help")
				.desc("Show a Help page")
				.argName("Help")
				.build());
		
		return options;
	}
	
	private void printHelp(Options options) {
		// automatically generate the help statement
		HelpFormatter formatter = new HelpFormatter();
		String header = "HGU Class Information Binder";
		String footer ="";
		formatter.printHelp("JavaFinalProject", header, options, footer, true);
	}
	
}