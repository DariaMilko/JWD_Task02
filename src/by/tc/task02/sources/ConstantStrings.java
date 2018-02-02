package by.tc.task02.sources;

public interface ConstantStrings {
	
	 public final String USER_DIR = System.getProperty("user.dir");
	 public final String SRC = "/src/";
	 public final String FILEPATH = "by/tc/task02/sources/file.txt/";
	 
	 public final String SPLIT_SYMBOL = "\\s";
	 public final String SEPARATOR = ": ";
	 public final String CURRENCY = ", $";
	 
	 public final int MAX_NUMBER_OF_GOODS_FOR_RENT = 3;
	 
	 public final String GOODS_NOT_FOUND = "List of goods isn't found at ";
	 public final String GOODS_IN_STOCK = "Current list of available goods:\n";
	 public final String GOODS_IN_RENT = "\nYour order:\n";
	 public final String DEFAULT_GOODS = "\nList of goods:";
	 public final String OUT_OF_GOODS = "One, two or three numbers separated by spaces are demanded!";
	    
}
