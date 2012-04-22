package nmf.dictionary;

import java.io.PrintWriter;
public class Decor {
	public void addHead(PrintWriter pw){
		  pw.println("<HTML>");
		  pw.println("<HEAD>");
		  pw.println("<TITLE>Телефонный справочник</TITLE>");		
		  pw.println("<link rel='stylesheet' type='text/css' href='Styles.css' />");
		  pw.println("</HEAD>");
	}
	public void addHeader(PrintWriter pw){
		pw.println("<div id='header' class='header'>");
		pw.println(String.format("%s", DictionaryConstants.PhoneDirTitle));
		pw.println("</div>");
	}
}
