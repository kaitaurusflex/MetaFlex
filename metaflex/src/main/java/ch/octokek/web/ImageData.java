package ch.octokek.web;

import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.Tag;
import com.drew.metadata.jpeg.JpegDescriptor;
import com.drew.metadata.jpeg.JpegDirectory;
import com.drew.metadata.png.PngDirectory;

public class ImageData {

	private static String filename;
	private static String compressionType;
	private static String height;
	private static String width;

	public static void extractMetadata(Metadata meta, String fileType) {
		fileType = fileType.split("/")[1];
		System.out.println(fileType);
		if(FileType.JPEG.getValue().equals(fileType)){
			System.out.println("amk");
			JpegDirectory jpegDirectory = meta.getFirstDirectoryOfType(JpegDirectory.class);
			JpegDescriptor descriptor = new JpegDescriptor(jpegDirectory);
			
			compressionType = descriptor.getImageCompressionTypeDescription();
			height = descriptor.getImageHeightDescription();
			width = descriptor.getImageWidthDescription();
			for (Directory directory : meta.getDirectories()) {
			    for (Tag tag : directory.getTags()) {
			        System.out.println(tag);
			    }
			}
			
		}else if(FileType.PNG.getValue().equals(fileType)){
			Directory pngDirectory = meta.getFirstDirectoryOfType(PngDirectory.class);
		}
	}
	
	
	
}
