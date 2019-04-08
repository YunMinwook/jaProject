package excelWrite;

import java.awt.Color;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.RichTextString;
import org.apache.poi.xssf.usermodel.IndexedColorMap;
import org.apache.poi.xssf.usermodel.TextAlign;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import vo.MemberVo;


public class MemberWriteExcel2 {

	public void xlsxWriter(List<MemberVo> list) {
		
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet();
		XSSFRow row = sheet.createRow(0);
		XSSFCell cell;
		
		XSSFCellStyle cs1 = workbook.createCellStyle();
		cs1.setBorderBottom(BorderStyle.THIN);
		cs1.setBorderRight(BorderStyle.THIN);
		cs1.setBorderLeft(BorderStyle.THIN);
		cs1.setBorderTop(BorderStyle.THIN);
		cs1.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		cs1.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
		cs1.setAlignment(HorizontalAlignment.CENTER);
		
		XSSFCellStyle cs2 = workbook.createCellStyle();
		cs2.setBorderBottom(BorderStyle.THIN);
		cs2.setBorderRight(BorderStyle.THIN);
		cs2.setBorderLeft(BorderStyle.THIN);
		cs2.setBorderTop(BorderStyle.THIN);

		
		
		List<MemberVo> cols = new ArrayList<MemberVo>();
		for(int i=0; i<=cols.size(); i++) {
			cell = row.createCell(i);
			cell.setCellValue((RichTextString) cols.get(i));
			cell.setCellStyle(cs1);
		}
		
//		cell = row.createCell(0);
//		cell.setCellValue("ID");
//		cell.setCellStyle(cs1);
//
//		cell = row.createCell(1);
//		cell.setCellValue("NAME");
//		cell.setCellStyle(cs1);
//
//		cell = row.createCell(2);
//		cell.setCellValue("PASSWORD");
//		cell.setCellStyle(cs1);
		
		
		
		MemberVo vo;
		for(int rowIdx=0; rowIdx<list.size(); rowIdx++) {
			vo = list.get(rowIdx);
			
			row = sheet.createRow(rowIdx+1);
			
			cell = row.createCell(0);
			cell.setCellValue(vo.getId());
			cell.setCellStyle(cs2);

			cell = row.createCell(1);
			cell.setCellValue(vo.getName());
			cell.setCellStyle(cs2);
			
			cell = row.createCell(2);
			cell.setCellValue(vo.getPassword());
			cell.setCellStyle(cs2);
		}
		
		File file = new File("C:\\excelTest\\result.xlsx");
		FileOutputStream fos = null;
		
		try {
			fos = new FileOutputStream(file);
			workbook.write(fos);
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(workbook!=null) workbook.close();
				if(fos!=null) fos.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
