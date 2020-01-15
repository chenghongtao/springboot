package com.cht.springboot_mybaties.excel;

import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cht.springboot_mybaties.service.BookService;
import com.cht.springboot_mybaties.util.ExcelUtil;

@RestController
@RequestMapping(value = "/report")
public class ReportFormController {
	
	@Autowired
	private BookService service;

	/**
	 * 导出报表
	 * 
	 * @return
	 */
	@RequestMapping(value = "/export")
	@ResponseBody
	public void export(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		System.out.println("开始执行该方法");
		
		Map<String,Object> map=service.commonMethod();
		
		String[] title=(String[]) map.get("title");
		
		String fileName=String.valueOf(map.get("fileName"));
		
		String sheetName=String.valueOf(map.get("sheetName"));
		
		String[][] content=(String[][]) map.get("content");
		
		//创建HSSFWORKBOOK
		HSSFWorkbook wb=ExcelUtil.getHSSFWorkbook(sheetName, title, content, null);
		
		//响应到客户端
		try {
			this.setResponseHeader(response, fileName);
			OutputStream os=response.getOutputStream();
			wb.write(os);
			os.flush();
			os.close();
		}catch(Exception e){
			e.printStackTrace();
		}
 

	}

	// 发送响应流方法
	private void setResponseHeader(HttpServletResponse response, String fileName) {
		try {
			try {
				fileName = new String(fileName.getBytes(), "ISO8859-1");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			response.setContentType("application/octet-stream;charset=ISO8859-1");
			response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
			response.addHeader("Pargam", "no-cache");
			response.addHeader("Cache-Control", "no-cache");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
