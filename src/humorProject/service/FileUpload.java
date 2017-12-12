package humorProject.service;

import java.io.File;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import humorProject.dao.BoardDao;
import humorProject.dao.BoardFile;
import humorProject.dao.BoardFileDao;


public class FileUpload implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) {
		int result = 0;
		try {
			request.setCharacterEncoding("utf-8");
			String real = request.getSession().getServletContext().getRealPath("/upload"); // upload한 파일을 저장하는 폴더가 된다.
			int maxSize = 1024 * 1024 * 5; // 5MB
			//MultipartRequest를 생성함과 동시에 파일이 올라간다. ?
			MultipartRequest mr = new MultipartRequest(request, real, maxSize, "utf-8", new DefaultFileRenamePolicy()); // DefaultFileRenamePolicy
			// request, saveDirectory(업로드 폴더), maxSize, encoding
			String fileName = mr.getFilesystemName("originFile"); // DefaultFileRenamePolicy가 부여한 이름 반환 . 여기서 "originfile"은 jsp화면에서 업로드하기 위해 선택한 원래의 파일 이름을 말한다. 그래야 얘가 어떤 파일의  RenamePolicy를 받아올지 알 수 있으니까.
			File file = new File(real + "/" + fileName); // pathname을 지정해서 파일 생성?
			int fileSize = (int) file.length(); //파일이 업로된거임? MultipartRequest를 할때 업로드 됐다.
			//BoardFile에 값 세팅 : BoardFile에 파일을 직접올리는 것이 아니라. 파일은 upload폴더에 저장되고, 파일 이름과 size, 보드 num만 저장됨
			BoardFile bf = new BoardFile(); 
			bf.setFileName(fileName);
			bf.setFileSize(fileSize);
			BoardDao bd = BoardDao.getInstance();
			//num이 파일이 아직 작성이 안됐기 때문에 num도 아직 없다. 그래서 temp num에 넣어놓고 글작성을 완료하면 alter를 통해 num숫자만 바꿔주자
			//int num = bd.getMaxNum();
			bf.setNum(0);
			
			
			//BoardFileDao를 통해 DB에 값 올림
			BoardFileDao bfd = BoardFileDao.getInstance();
			result = bfd.insert(bf); 
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		request.setAttribute("result", result);
		return "uploadResult.jsp";
	}

}
