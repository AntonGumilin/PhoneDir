package nmf.dictionary;

import java.io.PrintWriter;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;

@WebServlet("/index")
public class index extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Decor	decor;
   
    public void init() throws ServletException{
    	decor 	=	new Decor();
    }
    
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setCharacterEncoding(DictionaryConstants.encoding);
		res.setContentType(DictionaryConstants.contentType);
		PrintWriter out = res.getWriter();
		decor.addHead(out);
	    out.println("<BODY >");
	    decor.addHeader(out);
	    out.println("<div id='search' class='searchform'>");
	    out.println("<FORM method='post' action='Result'>");
	    out.println("<TABLE id='searchTable' class='selectTable'>");
		    out.println("<tr><td>");
		    out.println(String.format("<span class='title'>%s</span>", DictionaryConstants.enterCriteria));
		    out.println("</td><td>");	  
		    out.println(String.format("<span class='title'>%s</span>", DictionaryConstants.SelectedColumn));
		    out.println("</td></tr>");
		    out.println("<tr><td>");
		    out.println("<table id='criterionTable'>");
			    out.println(String.format(DictionaryConstants.tableRow, DictionaryConstants.firstName, 		DictionaryConstants.firstNamePar));
			    out.println(String.format(DictionaryConstants.tableRow, DictionaryConstants.lastName,  		DictionaryConstants.lastNamePar));
			    out.println(String.format(DictionaryConstants.tableRow, DictionaryConstants.departament, 	DictionaryConstants.departamentPar));
			    out.println(String.format(DictionaryConstants.tableRow, DictionaryConstants.innerNumber, 	DictionaryConstants.innerNumberPar));
			    out.println(String.format(DictionaryConstants.tableRow, DictionaryConstants.mobNumber, 		DictionaryConstants.mobNumberPar));
		    out.println("</table>");		    
		    out.println("</td><td>");
		    out.println("<table id='seekColTable'>");
			    out.println(String.format(DictionaryConstants.selectRow, DictionaryConstants.emplId, 		DictionaryConstants.emplIdCol));
			    out.println(String.format(DictionaryConstants.selectRow, DictionaryConstants.lastName, 		DictionaryConstants.lastNameCol));
			    out.println(String.format(DictionaryConstants.selectRow, DictionaryConstants.firstName, 	DictionaryConstants.firstNameCol));
			    out.println(String.format(DictionaryConstants.selectRow, DictionaryConstants.middleName, 	DictionaryConstants.middleNameCol));
			    out.println(String.format(DictionaryConstants.selectRow, DictionaryConstants.departament,	DictionaryConstants.organizCol));
			    out.println(String.format(DictionaryConstants.selectRow, DictionaryConstants.position,		DictionaryConstants.positionCol));
			    out.println(String.format(DictionaryConstants.selectRow, DictionaryConstants.innerNumber,	DictionaryConstants.innerPhoneCol));
			    out.println(String.format(DictionaryConstants.selectRow, DictionaryConstants.mobNumber,		DictionaryConstants.mobPhoneCol));
		    out.println("</table>");
	    out.println("</td></tr></TABLE>");	
	    out.println("<input  type='submit'  value='Поиск'>");	
	    out.println("</FORM>");
	    out.println("</div>");
	    out.println("</BODY></HTML>");

	}

}
