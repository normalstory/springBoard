package kr.or.ddit.util;

public class FileUtil {
	public static String getFileExt(String fileName) {

		//FileUtil.getFileExt(String fileName);   확장자가 있으면, .을포함한 값 리턴, 없으면 whitespace리턴
		//테스트값 sally.png  -> .png
		//테스트값 sally       ->    
		
//		String[] split = fileName.split("\\.");
//		
//		if(split.length==1)
//			return "";
//		else
//			return "." + split[split.length-1];
			
		String ext = "";
		int lastDotIndex = fileName.lastIndexOf(".");	//리펙터 : 테스트코드를 통해 보장을 받을 수 있다 
		
		if(lastDotIndex<0) {	// <-- ==-1
			return ext="";
		}else {
			return ext=fileName.substring(lastDotIndex);
		}
	}
}
