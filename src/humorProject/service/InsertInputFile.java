package humorProject.service;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import humorProject.dao.BoardFile;
import humorProject.dao.BoardFileDao;



public class InsertInputFile {

	public int insert(HttpServletRequest request) {
		String real = request.getSession().getServletContext().getRealPath("/upload"); //upload한 파일을 저장하는 폴더가 된다.
		int result =0;
		int maxSize = 1024 * 1024 * 10; //5MB
		try {
			//cos.jar에있는 메소드
			MultipartRequest mr = new MultipartRequest(request, real, maxSize, "utf-8", new DefaultFileRenamePolicy());  //DefaultFileRenamePolicy : 파일이름을 중복되지 않게 해줌 
													//request, saveDirectory(업로드 폴더), maxSize, encoding
			String fileName = mr.getFilesystemName("file"); //DefaultFileRenamePolicy가 부여한 이름 반환?
			File file = new File(real + "/"+fileName); //pathname을 지정해서 파일 생성?
			int fileSize = (int)file.length();
			BoardFile bf = new BoardFile();
			
			
			BoardFileDao bfd = BoardFileDao.getInstance();
			result = bfd.insert(bf);
		} catch (Exception e) {System.out.println(e.getMessage());	}
		return result;
	}

}
