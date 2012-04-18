package nmf.dictionary;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.Iterator;

class SearchEngine {
	Map<String, String>				criterionMap;
	Connection 						conn;
	Statement						statement;
	ResultSet						result;
	Set								s;
	Iterator						i;
	
	public SearchEngine(Map	_critMap)
	{
		criterionMap	=	new HashMap<String, String>();
		criterionMap.putAll(_critMap);
		
	}
	public ResultSet doSearch() throws SQLException
	{
		conn	=	this.getConnection();
		statement	=		conn.createStatement();
        result		=		statement.executeQuery(this.makeQuery());
        return result;
	}
	
	private Connection	getConnection() throws SQLException
	{
		if(conn	== null)
		{
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver()); 
            conn		=		DriverManager.getConnection(DictionaryConstants.server,
            												DictionaryConstants.login, DictionaryConstants.password);
            
		}	
		return conn;
	}
	
	private	String	makeQuery()
	{
		String query	=	String.format("%s %s", this.makeSelectPart(),	this.makeCriterionPart());
		return query;
	}
	
	private String makeSelectPart()
	{
		String query	=	"Select * from Dictionary";
		return query;
	}
	
	private String makeCriterionPart()
	{
		String query	=	"";
		if(criterionMap.size() != 0)
		{	
			query	=	"where (1=1) ";
			s		=	criterionMap.entrySet();
			i		=	s.iterator();	
			while(i.hasNext())
			{
			    Map.Entry m =(Map.Entry)i.next();
				query 		+=	String.format("and (%s = '%s') ", m.getKey(), m.getValue());
			}
			
		}
		return query;
	}
}
