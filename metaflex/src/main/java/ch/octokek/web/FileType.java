package ch.octokek.web;

public enum FileType {
	JPEG("jpeg"),
	PNG("png");
	
	final String fileType;
	
	FileType(final String fileType){
		this.fileType = fileType;
	}
	
	public String getValue(){
		return fileType;
	}
	
	@Override
	public String toString(){
		return fileType;
	}
}
