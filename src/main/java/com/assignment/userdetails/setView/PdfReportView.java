package com.assignment.userdetails.setView;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.assignment.userdetails.Pojo.User;
import com.lowagie.text.Document;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfWriter;




public class PdfReportView extends AbstractPdfView{

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer, HttpServletRequest req,
			HttpServletResponse response) throws Exception {
		response.setHeader("Content-Diposition","attachment: filename=\"usersInfo.pdf\"");
		
		@SuppressWarnings("unchecked")
		List<User> list=(List<User>) model.get("userList");
		
		Table table=new Table(6);
		table.addCell("UserName");
		table.addCell("FirstName");
		table.addCell("LastName");
		table.addCell("Age");
		table.addCell("Occupation");
		table.addCell("Address");
		
		for(User user:list){
			
			table.addCell(user.getUsername());
			table.addCell(user.getFirst_name());
			table.addCell(user.getLast_name());
			table.addCell(String.valueOf(user.getAge()));
			table.addCell(user.getOccupation());
			table.addCell(user.getAddress());
		    
		}
		document.add(table);
	
	                 }                                                 
	}
