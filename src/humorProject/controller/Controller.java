package humorProject.controller;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import humorProject.service.CommandProcess;



@WebServlet(urlPatterns="*.do",
	initParams={@WebInitParam(name="config",value="/WEB-INF/command.properties")})//이걸 풀던가 web.xml에서 쓰던가.. 현 추세는 annotation으로 해결.
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Map<String, Object> commandMap = new HashMap<>();
	public void init(ServletConfig config) throws ServletException { //doget이나 dopost보다 먼저 실행
	   	String props = config.getInitParameter("config");
	   	// props : "/WEB-INF/command.properties"
	   	Properties pr = new Properties();
	   	// Java 11장 Properties클래스의 특징 키=값을 가진 Map을 구현
	    FileInputStream f = null;
	    try {
	          String configFilePath = 
	         		config.getServletContext().getRealPath(props);
	          // configFilePath 실제 사용할 위치에 있는 이름. 메타데이터위치
	          f = new FileInputStream(configFilePath);
	          pr.load(f);
	          // pr에는 command.properties라는 file의 데이터를 사용
	          // =앞에 있는 message.do을 key
	          // =뒤에 있는 service.Message을 값
	    } catch (IOException e) { throw new ServletException(e);
	     } finally {
	          if (f != null) try { f.close(); } catch(IOException ex) {}
	     }
	     Iterator<Object> keyIter = pr.keySet().iterator();
	     // message.do
	     while( keyIter.hasNext() ) {
	          String command = (String)keyIter.next(); 
	          // command : join.do
	          String className = pr.getProperty(command); 
	          // className : myBatis.service.JoinAction
	          try {
	               Class<?> commandClass = Class.forName(className);
	               // commandClass : service.JoinAction 클래스
	               Object commandInstance = commandClass.newInstance();
	               // commandInstance : service.JoinAction객체
	               commandMap.put(command, commandInstance);
	               // commnadMap에는
	               // key가 Join.do
	               // 값이 JoinAction객체
	          } catch (Exception e) {
	               throw new ServletException(e);
	          }
	     }
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
		String view = null;
	    CommandProcess com=null;
	    try { 
	    	  String command = request.getRequestURI();
	    	  // command : /myBatis/joinForm.do
	    	  // request.getContextPath() : /myBatis
	    	  // request.getContextPath().length()+1 : 8
		      command = command.substring(
		    		 request.getContextPath().length()+1); 
		      // command : joinForm.do
	          com = (CommandProcess)commandMap.get(command); 
	          // com : service.Message객체를 CommandProcess로 형변환
	          // 자식 즉 Message객체의 requestPro()메소드 실행
	          view = com.requestPro(request, response);
	          // view는 "list.jsp" 문자
	    } catch(Throwable e) { throw new ServletException(e); } 
	    RequestDispatcher dispatcher =
	      	request.getRequestDispatcher(view);
	   dispatcher.forward(request, response);
	}
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
    		request.setCharacterEncoding("utf-8");
    		doGet(request, response);
	}
}