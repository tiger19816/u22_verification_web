

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tool.ImageSave;

/**
 * Servlet implementation class ImageUploadServlet
 */
@WebServlet("/ImageUploadServlet")
@MultipartConfig(location = "", maxFileSize = 1024 * 1024 * 10)	//partを使用する際に書く。maxFileSizeは1024×1024×10で10MB。
public class ImageUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ImageUploadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//文字化け対策
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		//画像を保存するtempフォルダのパスを取得
		String tempPath = getServletContext().getRealPath("temp");
		String tempSmallPath = tempPath + "\\small";
		Path path = Paths.get(tempPath);
		Path smallPath = Paths.get(tempSmallPath);

		//tempフォルダが存在しない場合は作成する
		if(!Files.exists(path)) {
			Files.createDirectory(path);
		}
		if(!Files.exists(smallPath)) {
			Files.createDirectory(smallPath);
		}

		//画像を保存する
		ImageSave is = new ImageSave();
		is.imageTempSave(request.getPart("filename"), tempPath);

		request.setAttribute("imgPath", "./temp/" + is.getFileName());

		RequestDispatcher rd = request.getRequestDispatcher("imgUploadSampleResult.jsp");
		rd.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}