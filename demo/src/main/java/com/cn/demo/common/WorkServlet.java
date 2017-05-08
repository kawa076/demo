package com.cn.demo.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.AsyncContext;
import javax.servlet.ServletResponse;

public class WorkServlet extends Thread{
	private AsyncContext context;
	private String filepath;
    
    public WorkServlet(AsyncContext context, String filepath){  
        this.context = context;
        this.filepath = filepath;
    } 
    public void run(){
    	File file = new File(filepath);


        
		try {
			InputStream in = new FileInputStream(file);
			
			ServletResponse resp = context.getResponse();
			OutputStream os = resp.getOutputStream();
			byte[] b = new byte[1024];
	        int len;
	        try {
	            while ((len = in.read(b)) > 0){
	                os.write(b, 0, len);
//	                os.flush();
	            }
	            os.flush();
	        } catch (IOException e) {
	            e.printStackTrace();
	        } finally {
	            in.close();
	            os.close();
	        }
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
