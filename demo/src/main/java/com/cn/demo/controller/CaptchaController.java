//package com.cn.demo.controller;
//
//import java.awt.image.BufferedImage;
//
//import javax.imageio.ImageIO;
//import javax.servlet.ServletOutputStream;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import com.cn.demo.service.CaptchaService;
//
//@Controller
//@RequestMapping("/code")
//public class CaptchaController {
//	@ResponseBody
//	@RequestMapping(value = "/captchaImage")
//	public void getJCaptchaImage(HttpServletRequest request, HttpServletResponse response) throws Exception {
//		response.setDateHeader("Expires", 0);
//		response.setHeader("Cache-Control", "no-cache, must-revalidate");
//		response.addHeader("Cache-Control", "post-check=0, pre-check=0");
//		response.setHeader("Pragma", "no-cache");
//		response.setContentType("image/jpeg");
//		BufferedImage bi = CaptchaService.getInstance().getImageChallengeForID(request.getSession(true).getId());
//		ServletOutputStream out = response.getOutputStream();
//		ImageIO.write(bi, "jpg", out);
//		try {
//			out.flush();
//		} finally {
//			out.close();
//		}
//		return;
//	}
//
//	@ResponseBody
//	@RequestMapping(value = "/validate")
//	public Boolean login(String username, String password, String captcha, HttpServletRequest request) {
//		Boolean result = false;
//		Boolean isCaptchaCorrect = CaptchaService.getInstance().validateResponseForID(request.getSession().getId(),
//				captcha);
//		if (isCaptchaCorrect) {
//
//		}
//		return result;
//	}
//}
