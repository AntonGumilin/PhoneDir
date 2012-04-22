package nmf.dictionary;

public class DictionaryConstants 
{
	public static final  String   tableRow					=	"<tr><td>%s:</td><td><input type='text' name='%s'></td></tr>";
	public static final  String	  selectRow					=	"<tr><td>%s</td><td><input type='checkbox' name='option' value='%s'checked></td></tr>";
	public static final  String   firstName					=	"Имя";
	public static final  String   firstNamePar		 		=   "firstName";
	public static final  String   lastName					=	"Фамилия";
	public static final  String   lastNamePar		 		=   "lastName";
	public static final  String	  departament				=	"Отдел";
	public static final  String	  departamentPar			=	"departament";
	public static final  String	  innerNumber				=	"Внутренний номер";
	public static final  String	  innerNumberPar			=	"innerNumber";
	public static final  String	  mobNumber					=	"Номер мобильного телефона";
	public static final  String	  mobNumberPar				=	"mobNumber";
	public static final  String	  server					=	"jdbc:oracle:thin:@localhost:1521:xe";
	public static final	 String   login						=	"system";
	public static final  String   password					=	"integral";
	public static final  String   encoding					=	"UTF-8";
	public static final  String   contentType				=	"text/html";
	public static final  String   headTableRowCell			=	"<th>%s</th>";
	public static final  String   resTableRowCell			=	"<td>%s</td>";
	public static final	 String	  headTableRow				=	"<tr><th>%s</th><th>%s</th><th>%s</th><th>%s</th><th>%s</th><th>%s</th><th>%s</th><th>%s</th></tr>";
	public static final	 String	  resTableRow			 	=	"<tr><td>%s</td><td>%s</td><td>%s</td><td>%s</td><td>%s</td><td>%s</td><td>%s</td><td>%s</td></tr>";
	// table headers
	public static final	 String	  emplId					=	"Табельный Номер";
	public static final	 String	  middleName				=	"Отчество";
	public static final  String   position					=	"Должность";	
	//DICTIONARY Table COLUMNS
	public static final  String	  emplIdCol					=	"EMPLD";
	public static final  String	  firstNameCol				=	"FIRSTNAME";
	public static final  String	  lastNameCol				=	"LASTNAME";
	public static final  String	  middleNameCol				=	"MIDDLENAME";
	public static final  String	  positionCol				=	"POSITION";
	public static final	 String   organizCol				=	"DEPARTAMENT";
	public static final	 String	  innerPhoneCol				=	"INNERPHONE";
	public static final	 String	  mobPhoneCol				=	"MOBPHONE";
	public static final  String	  empty						=	"";
	public static final  String   option					=	"option";
	
	public static final  String   PhoneDirTitle				=	"Телефонный справочник компании Nemiroff";
	public static final  String   SelectedColumn			=	"Отметьте информацию, которая Вам нужна:";
	public static final  String	  enterCriteria				=	"Введите критерии поиска:";
	
}
