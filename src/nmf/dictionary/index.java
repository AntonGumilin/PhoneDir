package nmf.dictionary;

import java.io.PrintWriter;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/index")
public class index extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public index() {
        super();        
    }
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setCharacterEncoding(DictionaryConstants.encoding);
		res.setContentType(DictionaryConstants.contentType);
		PrintWriter out = res.getWriter();
	    out.println("<HTML>");
	    out.println("<HEAD><TITLE>Телефонный справочник</TITLE></HEAD>");
	    out.println("<BODY>");
	    out.println("<FORM method='post' action='Result'>");
	    out.println("<TABLE>");
	    out.println(String.format(DictionaryConstants.tableRow, DictionaryConstants.firstName, 		DictionaryConstants.firstNamePar));
	    out.println(String.format(DictionaryConstants.tableRow, DictionaryConstants.lastName,  		DictionaryConstants.lastNamePar));
	    out.println(String.format(DictionaryConstants.tableRow, DictionaryConstants.departament, 	DictionaryConstants.departamentPar));
	    out.println(String.format(DictionaryConstants.tableRow, DictionaryConstants.innerNumber, 	DictionaryConstants.innerNumberPar));
	    out.println(String.format(DictionaryConstants.tableRow, DictionaryConstants.mobNumber, 		DictionaryConstants.mobNumberPar));
	    out.println("</TABLE>");
	    out.println("<input type='submit' value='Поиск'>");	    
	    out.println("</FORM>");
	    out.println("</BODY></HTML>");

	}

}
