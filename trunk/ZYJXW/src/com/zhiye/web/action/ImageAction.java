package com.zhiye.web.action;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Date;

import org.apache.struts2.ServletActionContext;

public class ImageAction extends GenericActionSupport {
	private static final long serialVersionUID = 572146812454l;

	private static final int BUFFER_SIZE = 16 * 1024;

	private File imageFile;

	private String contentType;

	private String fileName;

	private String imageFileName;

	public void setImageFileContentType(String contentType) {
		this.contentType = contentType;
	}

	public void setImageFileFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getImageFileName() {
		return imageFileName;
	}


	private void copy(File src, File dst) {
		String m = "copy";
		info(m, "save image to local folder");
		try {
			InputStream in = null;
			OutputStream out = null;
			try {
				in = new BufferedInputStream(new FileInputStream(src),
						BUFFER_SIZE);
				out = new BufferedOutputStream(new FileOutputStream(dst),
						BUFFER_SIZE);
				byte[] buffer = new byte[BUFFER_SIZE];
				while (in.read(buffer) > 0) {
					out.write(buffer);
				}
			} finally {
				if (null != in) {
					in.close();
				}
				if (null != out) {
					out.close();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private String getExtention(String fileName) {
		int pos = fileName.lastIndexOf(".");
		return fileName.substring(pos);
	}

	public void upload() {
		String m = "upload";
		PrintWriter out =null;
		try {
			 out = response.getWriter();
			 String extension="";
			 try{
				 extension=getExtention(fileName).trim();
			 }catch(Exception e1){
				 out.println("<script>parent.fail('上传图片失败!请选择正确的图片文件.')</script>");
				 return;
			 }
			 if(!extension.equalsIgnoreCase(".jpg")&&!extension.equalsIgnoreCase(".png")&&!extension.equalsIgnoreCase(".bmp")&&!extension.equalsIgnoreCase(".gif")){
				 out.println("<script>parent.fail('上传图片失败!请选择正确的图片文件类型.')</script>");
				 return;
			 }
			imageFileName = new Date().getTime() + getExtention(fileName);
			File imageFile1 = new File(ServletActionContext.getServletContext()
					.getRealPath("Upload/News/Image/" + imageFileName));
			info(m, "upload image with name=" + "Upload/News/Image/ "
					+ imageFileName);
			copy(imageFile, imageFile1);
			info(m, "upload image success!");
			out.println("<script>parent.success('"+"Upload/News/Image/"
					+imageFileName+"')</script>");
		} catch (Exception e) {
			out.println("<script>parent.fail('上传图片失败!')</script>");
			e.printStackTrace();
		}
	}

	public File getImageFile() {
		return imageFile;
	}

	public void setImageFile(File imageFile) {
		this.imageFile = imageFile;
	}

	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}

}