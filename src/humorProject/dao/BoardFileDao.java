package humorProject.dao;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class BoardFileDao {
	private static BoardFileDao instance = new BoardFileDao();
	public BoardFileDao() {
	}
	public static BoardFileDao getInstance() {
		return instance;
	}
	/////////// DB연결부분///////////////////////////
	private static SqlSession session;
	static { // static 변수 초기화 블럭
		try {
			Reader reader = Resources.getResourceAsReader("configuration_file.xml");
			SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(reader); // sqlsession을 만든다.
			session = ssf.openSession(true); // 이걸 써줘야 db에서 자동 commit이 된다.
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	/////////////////////////////////////////////
	public int insert(BoardFile bf) {
		int result = 0;
		try {
			result = session.insert("insertFile", bf);
		} catch (Exception e) { System.out.println(e.getMessage());
		}
		return result;
	}
	/////////////////////////sessionFile
	public List<BoardFile> getImage(int num) {
		List<BoardFile> fileList = null;
		System.out.println(num);
		try {
			fileList =  session.selectList("getImage", num); 
		} catch (Exception e) { System.out.println(e.getMessage());
		}
		return fileList;
	}
}
