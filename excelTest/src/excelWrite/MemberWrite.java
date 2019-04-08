package excelWrite;

import java.util.ArrayList;
import java.util.List;

import dao.MemberDAO;
import vo.MemberVo;

public class MemberWrite {

	public static void main(String[] args) {
		System.out.println("시작");
//		 List<MemberVo> list = new ArrayList<MemberVo>();
//		 list.add(new MemberVo(1, "사용자1", "1234"));
//		 list.add(new MemberVo(2, "사용자2", "2345"));
//		 list.add(new MemberVo(3, "사용자3", "3456"));
//		 list.add(new MemberVo(4, "사용자4", "4567"));
//		 list.add(new MemberVo(5, "사용자5", "5678"));
//		 list.add(new MemberVo(6, "사용자6", "6789"));
//		 list.add(new MemberVo(7, "사용자7", "7890"));
//		 list.add(new MemberVo(8, "사용자8", "0987"));
//		 list.add(new MemberVo(9, "사용자9", "9876"));

		MemberDAO dao = MemberDAO.getInstance();
		List<MemberVo> list = dao.getAllMembers();
		
		 MemberWriteExcel mw = new MemberWriteExcel();
		 mw.xlsxWriter(list);
		 
		 System.out.println("완료");
	}
	
}
