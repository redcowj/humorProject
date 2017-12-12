package humorProject.dao;

import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.session.TransactionIsolationLevel;

import humorProject.model.Member;

public class MemberDao {
	private static MemberDao instance = new MemberDao();
	private MemberDao() {}
	public static MemberDao getInstance() {
		return instance;
	}//singleton
	private static SqlSession session;
	static {
		try {
			Reader reader = Resources.getResourceAsReader("configuration.xml");
			SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(reader);
			session= ssf.openSession(true);
			} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	public int idChk(String id) {
		int result = 1;
		Member member = null;
		try {
			member = (Member)session.selectOne("memberns.select",id);//namespace붙여서 insert빨리찾음//넘어온 member랑 같으면 헷갈리므로 mem으로 명함.
			if(member == null) result = 0;
			else result = 1;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return result;
	}
	public int insert(Member member) {
		int result = 0;
		try {
			result = session.insert("memberns.insert",member);//namespace붙여서 insert빨리찾음
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return result;
		
	}
	
	public int loginChk(Member member) {
		int result = -1;
		try {
			Member mem = (Member)session.selectOne("memberns.select",member.getId());//namespace붙여서 insert빨리찾음//넘어온 member랑 같으면 헷갈리므로 mem으로 명함.
			if(mem==null) result =-1;
			else {
				String dbPass = mem.getPassword();
				if(dbPass.equals(member.getPassword())) result =1;
				else result = 0;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return result;
	}
	public Member select(String id) {
		Member member = null;
		try {
			member = (Member)session.selectOne("memberns.select",id);//namespace붙여서 insert빨리찾음//넘어온 member랑 같으면 헷갈리므로 mem으로 명함.
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return member;
	}
	public int update(Member member) {
		int result = 0;
		try {
			result = session.update("memberns.update",member);//namespace붙여서 insert빨리찾음
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return result;
	}
	public int delete(String id) {
		int result = 0;
		try {
			result = session.update("memberns.delete",id);//update그대로 두고 속은 delete. 실제로는 n-> y만 실행
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return result;
	}
	
}
