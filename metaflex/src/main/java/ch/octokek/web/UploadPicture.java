package ch.octokek.web;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.drew.imaging.ImageMetadataReader;
import com.drew.imaging.ImageProcessingException;
import com.drew.metadata.Metadata;

@MultipartConfig

@WebServlet(name = "UploadPicture", urlPatterns = { "/upload" }, loadOnStartup = 1)
public class UploadPicture extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Part filePart = req.getPart("file");
		InputStream fileContent = filePart.getInputStream();
		try {
			Metadata meta = ImageMetadataReader.readMetadata(fileContent);
			if (meta.getDirectoryCount() == 0) {
				System.out.println("no metadata available!");
			} else {
				ImageData imageData = new ImageData();
				imageData.extractMetadata(meta, filePart.getContentType());
				// Forward to display site
				req.setAttribute("imageData", imageData);
				req.getRequestDispatcher("mainpage.jsp").forward(req, resp);
			}
		} catch (Exception e) {
			req.setAttribute("error", "an error occured please try again");
			req.getRequestDispatcher("mainpage.jsp").forward(req, resp);
		}

	}
}
