package com.cn.demo.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class ViewServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2421981649639939898L;

	private static Logger logger = LoggerFactory.getLogger(ViewServlet.class);

    ApplicationContext context;


    @Override
    public void init() throws ServletException {
        context = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
        super.init();
    }


    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }



    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        FileLogService fileLogService = (FileLogService) context.getBean("fileLogService");
//        String baseDir = fileLogService.getBaseDir();
    	 String baseDir = "D:\\";
    	int t = request.getSession().getMaxInactiveInterval();
    	logger.info("session time out is" + t);
        String uri = request.getRequestURI();
        logger.info("请求路径" + uri);
        String realPath = appendSlash(baseDir) + uri.substring(uri.indexOf("/upload")+ "/upload".length());
        logger.info("文件路径" + realPath);

        File file = new File(realPath);
        
        String filename = uri.substring(uri.lastIndexOf("/")+1);

        InputStream in = new FileInputStream(file);
        
        response.setContentType("application/octet-stream");
//        response.setContentType("text/plain");
//        response.setContentType("application/x-download");
        response.setHeader("Content-Disposition", "attachment; filename=\"" + filename + "\"");

        OutputStream os = response.getOutputStream();


        byte[] b = new byte[1024];
        int len;
        try {
            while ((len = in.read(b)) > 0){
                os.write(b, 0, len);
//                os.flush();
            }
            os.flush();
        } catch (IOException e) {
            logger.error(e.getMessage(),e);
            e.printStackTrace();
        } finally {
            in.close();
            os.close();
        }
    }
    public static String appendSlash(String path){

        if(path.endsWith("/")){
            return path;
        }else{
            return path + "/";
        }
    }
}
