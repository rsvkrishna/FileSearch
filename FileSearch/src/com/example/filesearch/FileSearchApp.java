package com.example.filesearch;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileSearchApp {

	private String path;
	private String regex;
	private String zipFileName;
	
	public static void main(String[] args) {
		
		FileSearchApp app=new FileSearchApp(); 
		
		switch(Math.min(args.length, 3)){
		case 0:
			System.out.println("USAGE: FileSearchApp path [regex] [zipfile]");
			return;
		case 3:
			app.setZipFileName(args[2]);
		case 2:
			app.setRegex(args[1]);
		case 1:
			app.setPath(args[0]);
		}
		try{
		app.walkDirectory(app.getPath());
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/*public void walkDirectory(String path){
		System.out.println("walkDirectory: "+path);
		searchFile(null);
		addFileToZip(null);
	}*/
	
	public void processFile(File file){
		System.out.println("processFile: "+file);
	}

	private void addFileToZip(File file) {
		// TODO Auto-generated method stub
		System.out.println("addFile: "+file);
	}

	private void searchFile(File file) {
		// TODO Auto-generated method stub
		System.out.println("searchFile: "+file);
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getRegex() {
		return regex;
	}

	public void setRegex(String regex) {
		this.regex = regex;
	}

	public String getZipFileName() {
		return zipFileName;
	}

	public void setZipFileName(String zipFileName) {
		this.zipFileName = zipFileName;
	}
	
	public void walkDirectory(String path) throws IOException{
		File dir =new File(path);
		File[] files=dir.listFiles();
		for(File file : files){
			if(file.isDirectory()){
				walkDirectory(file.getAbsolutePath());
			}
			else{
				processFile(file);
			}
		}
		
	}
	public void walkDirectoryInJava8(String path) throws IOException{
		Files.walk(Paths.get(path)).forEach(f->processFile(f.toFile()));
	}

}
