package ch.octokek.web;

import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.Tag;
import com.drew.metadata.exif.ExifIFD0Descriptor;
import com.drew.metadata.exif.ExifIFD0Directory;
import com.drew.metadata.exif.ExifSubIFDDescriptor;
import com.drew.metadata.exif.ExifSubIFDDirectory;
import com.drew.metadata.exif.GpsDescriptor;
import com.drew.metadata.exif.GpsDirectory;
import com.drew.metadata.jpeg.JpegDescriptor;
import com.drew.metadata.jpeg.JpegDirectory;
import com.drew.metadata.png.PngDescriptor;
import com.drew.metadata.png.PngDirectory;

public class ImageData {
	
	//jpeg
	private static String compressionType;
	private static String height;
	private static String width;

	// private static String camera; didn't find how to get these values
	// private static String model;
	// private static String dateTime;
	
	//exifSub
	private static String exposureTime;
	private static String aperture;
	private static String iso;
	private static String flash;
	
	//GPS
	private static String longitude;
	private static String latitude;

	public void extractMetadata(Metadata meta, String fileType) {
		fileType = fileType.split("/")[1];
		System.out.println(fileType);getClass();
		
		if (FileType.JPEG.getValue().equals(fileType)) {
			JpegDirectory jpegDirectory = meta.getFirstDirectoryOfType(JpegDirectory.class);
			JpegDescriptor jpegDescriptor = new JpegDescriptor(jpegDirectory);
			
			if(jpegDirectory != null){
				compressionType = jpegDescriptor.getImageCompressionTypeDescription();
				height = jpegDescriptor.getImageHeightDescription();
				width = jpegDescriptor.getImageWidthDescription();
			}


		} 
		
//		for (Directory directory : meta.getDirectories()) {
//			for (Tag tag : directory.getTags()) {
//				System.out.println(tag);
//			}
//		}
		
		//geting exifsub values
		ExifSubIFDDirectory exifSubIFDDirectory = meta.getFirstDirectoryOfType(ExifSubIFDDirectory.class);
		ExifSubIFDDescriptor exifSubIFDDescriptor = new ExifSubIFDDescriptor(exifSubIFDDirectory);
		
		if (exifSubIFDDirectory != null) {
			exposureTime = exifSubIFDDescriptor.getExposureTimeDescription();
			aperture = exifSubIFDDescriptor.getApertureValueDescription();
			iso = exifSubIFDDescriptor.getIsoEquivalentDescription();
			flash = exifSubIFDDescriptor.getFlashDescription();
		}
		
		//getting gps values
		GpsDirectory gpsDirectory = meta.getFirstDirectoryOfType(GpsDirectory.class);
		GpsDescriptor gpsDescriptor = new GpsDescriptor(gpsDirectory);
		
		if(gpsDirectory != null){
			longitude = gpsDescriptor.getGpsLongitudeDescription();
			latitude = gpsDescriptor.getGpsLatitudeDescription();
		}
	}
}
