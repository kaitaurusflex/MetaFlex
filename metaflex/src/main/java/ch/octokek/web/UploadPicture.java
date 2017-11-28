package ch.octokek.web;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.drew.imaging.ImageMetadataReader;
import com.drew.imaging.ImageProcessingException;
import com.drew.metadata.Metadata;

public class UploadPicture extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Part filePart = request.getPart("file");
		InputStream fileContent = filePart.getInputStream();
		try {
			Metadata meta = ImageMetadataReader.readMetadata(fileContent);
		} catch (ImageProcessingException e) {
			// TODO: handle errors
		}
	}
}
