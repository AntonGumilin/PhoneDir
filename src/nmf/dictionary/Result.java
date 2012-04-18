package nmf.dictionary;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.HashMap;


@WebServlet("/Result")
public class Result extends HttpServlet {	
	String 				firstName, lastName, departament, innerPhone, mobPhone;
	SearchEngine		searchEngine;
	PrintWriter			out;	
	ResultSet			result;	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding(DictionaryConstants.encoding);
		res.setCharacterEncoding(DictionaryConstants.encoding);
		res.setContentType(DictionaryConstants.contentType);
		out	=	res.getWriter();
		firstName		=	req.getParameter(DictionaryConstants.firstNamePar);
		lastName		=	req.getParameter(DictionaryConstants.lastNamePar);
		departament		=	req.getParameter(DictionaryConstants.departamentPar);
		innerPhone		=	req.getParameter(DictionaryConstants.innerNumberPar);
		mobPhone		=	req.getParameter(DictionaryConstants.mobNumberPar);			
		searchEngine	=	new SearchEngine(this.getCriterionMap());
		try 
		{
			result	=	searchEngine.doSearch();
			this.outPut();
		}
		catch(SQLException e)
		{
			out.println(e.getMessage());
		}
		this.addReturn();
	}
	
	private HashMap getCriterionMap()
	{
		HashMap<String, String>	m = new HashMap<String, String>();
		if(firstName !=	DictionaryConstants.empty)
		{
			m.put(DictionaryConstants.firstNameCol, firstName);
		}
		if(lastName !=	DictionaryConstants.empty)
		{
			m.put(DictionaryConstants.lastNameCol, lastName);
		}
		if(departament !=	DictionaryConstants.empty)
		{
			m.put(DictionaryConstants.organizCol, departament);
		}
		if(innerPhone !=	DictionaryConstants.empty)
		{
			m.put(DictionaryConstants.innerPhoneCol, innerPhone);
		}
		if(mobPhone !=	DictionaryConstants.empty)
		{
			m.put(DictionaryConstants.mobPhoneCol, mobPhone);
		}
		return m;
	}
	private void outPut()	throws SQLException
	{
		out.println("<TABLE border=1>");
		out.println(String.format(DictionaryConstants.headTableRow, 
									DictionaryConstants.emplId,
									DictionaryConstants.lastName,
									DictionaryConstants.firstName,
									DictionaryConstants.middleName,
									DictionaryConstants.departament,
									DictionaryConstants.position,
									DictionaryConstants.innerNumber,
									DictionaryConstants.mobNumber));
		while(result.next())
		{			
			out.println(String.format(DictionaryConstants.resTableRow,
										result.getString(DictionaryConstants.emplIdCol),
										result.getString(DictionaryConstants.lastNameCol),
										result.getString(DictionaryConstants.firstNameCol),
										result.getString(DictionaryConstants.middleNameCol),
										result.getString(DictionaryConstants.organizCol),
										result.getString(DictionaryConstants.positionCol),
										result.getString(DictionaryConstants.innerPhoneCol),
										result.getString(DictionaryConstants.mobPhoneCol)										
										));			
		}	
		out.println("</TABLE>");
	}
	
	private void addReturn()
	{
		 out.println("<br><FORM method='get' action='index'>");
		 out.println("<input type='submit' value='Вернуться к поиску'>");	    
	     out.println("</FORM>");
	}

}
