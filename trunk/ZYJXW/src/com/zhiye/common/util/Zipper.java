package com.zhiye.common.util;

import java.io.File;

import org.apache.tools.ant.taskdefs.Zip;
import org.apache.tools.ant.types.FileSet;
import org.apache.tools.ant.Project;

public class Zipper {

	private File zipFile;

	public Zipper(String pathName) {
		zipFile = new File(pathName);
	}

	public void compress(String srcPathName) {
		File srcdir = new File(srcPathName);
		if (!srcdir.exists())
			throw new RuntimeException(srcPathName + "不存在！");

		Project prj = new Project();
		Zip zip = new Zip();
		zip.setProject(prj);
		zip.setDestFile(zipFile);
		FileSet fileSet = new FileSet();
		fileSet.setProject(prj);
		fileSet.setDir(srcdir);
		 fileSet.setIncludes("*.xls");
		// eg:zip.setIncludes("*.java");
		// fileSet.setExcludes(...); 排除哪些文件或文件夹
		zip.addFileset(fileSet);

		zip.execute();
	}

	public static void main(String[] args) {

		Zipper zca = new Zipper("E:\\szhzipant.zip");
		zca.compress("E:\\test");
	}
}
