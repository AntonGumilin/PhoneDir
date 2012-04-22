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
	String[]			seekColumns;
	SearchEngine		searchEngine;
	PrintWriter			out;	
	ResultSet			result;	
	HashMap     		accordanceMap;
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
		seekColumns		=	req.getParameterValues(DictionaryConstants.option);
		searchEngine	=	new SearchEngine(this.getCriterionMap(), seekColumns);
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
		this.makeAccordanceMap();
		out.println("<TABLE border=1>");
		out.print("<tr>");
		for(int i=0;i<seekColumns.length;i++)
		{
			out.print(String.format(DictionaryConstants.headTableRowCell, accordanceMap.get(seekColumns[i])));
		}
		out.println("</tr>");		
		while(result.next())
		{			
			out.print("<tr>");
			for(int i=0;i<seekColumns.length;i++){
				out.print(String.format(DictionaryConstants.resTableRowCell, result.getString(seekColumns[i])));
			}			
			out.println("</tr>");
		}
		out.println("</TABLE>");
	}
	
	private void addReturn()
	{
		 out.println("<br><FORM method='get' action='index'>");
		 out.println("<input type='submit' value='Вернуться к поиску'>");	    
	     out.println("</FORM>");
	}
	
	private void  makeAccordanceMap()
	{
		accordanceMap	=	new HashMap<String, String>();
		accordanceMap.put(DictionaryConstants.emplIdCol, 		DictionaryConstants.emplId);
		accordanceMap.put(DictionaryConstants.firstNameCol, 	DictionaryConstants.firstName);
		accordanceMap.put(DictionaryConstants.lastNameCol, 		DictionaryConstants.lastName);
		accordanceMap.put(DictionaryConstants.middleNameCol, 	DictionaryConstants.middleName);
		accordanceMap.put(DictionaryConstants.organizCol, 		DictionaryConstants.departament);
		accordanceMap.put(DictionaryConstants.positionCol, 		DictionaryConstants.position);
		accordanceMap.put(DictionaryConstants.innerPhoneCol, 	DictionaryConstants.innerNumber);
		accordanceMap.put(DictionaryConstants.mobPhoneCol, 		DictionaryConstants.mobNumber);
	}

}
