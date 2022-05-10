// < 전화번호 관리 프로그램을 작성하세요 >
// 데이터는 PhoneDB.txt파일로 관리합니다
// 데이터 구분은 , 로 합니다.
///이름(name), 휴대전화(hp), 회사번호(company)

package com.javaex.phonebook;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PersonInfo {

	public static void main(String[] args) throws IOException {
		// 스캐너
		Scanner sc = new Scanner(System.in);

		List<PhoneDB> dbList = new ArrayList<PhoneDB>();
		// PersonInfo = new HashMap<String, PhoneDB>();

		// PhoneDB.txt 읽어오기 - > 읽기용 스트림
		Reader fr = new FileReader("./PhoneDB.txt");
		BufferedReader br = new BufferedReader(fr);

		while (true) {
			// 데이터 읽기
			String data = br.readLine();

			if (data == null) {
				break;
			}

			String[] phonedb = data.split(",");
			String name = phonedb[0];
			String hp = phonedb[1];
			String company = phonedb[2];

			PhoneDB pd = new PhoneDB(name, hp, company);
			// 배열
			dbList.add(pd);
		}

		// 출력
		System.out.println("*******************************************");
		System.out.println("*            전화번호 관리 프로그램             *");
		System.out.println("*******************************************");

		boolean bool = true;
		// 초기값 bool이 true이기 때문에 while문 실행
		// bool값이 false로 변경되거나 break를 만나면 반복문 종료

		while (bool) {

			// 메뉴 출력
			System.out.println();
			System.out.print(" 1.리스트 ");
			System.out.print(" 2.등록 ");
			System.out.print(" 3.삭제 ");
			System.out.print(" 4.검색 ");
			System.out.println(" 5.종료 ");
			System.out.println("---------------------------------");
			System.out.print(" >메뉴번호 :  ");

			int num = sc.nextInt(); // 메뉴 번호 입력
			sc.nextLine();

			// switch문
			switch (num) {
			case 1:
				// 1. 리스트 전체 출력
				System.out.println("<1.리스트>");
				for (int i = 0; i < dbList.size(); i++) {
					System.out.print(i + 1 + ".    ");
					System.out.print(dbList.get(i).getName() + "    ");
					System.out.print(dbList.get(i).getHp() + "    ");
					System.out.println(dbList.get(i).getCompany() + "    ");
				}
				System.out.println();

				break;
			case 2:
				// 2. 등록
				System.out.println("<2. 등록>");

				System.out.print(">이름 : ");
				String name = sc.nextLine();
				System.out.print(">휴대전화 : ");
				String hp = sc.nextLine();
				System.out.print(">회사전화 : ");
				String company = sc.nextLine();

				PhoneDB pb = new PhoneDB(name, hp, company);
				// 데이터 추가 등록
				dbList.add(pb);

				System.out.println("[ 새 정보가 등록되었습니다. ]");
				System.out.println();

				break;

			case 3:
				// 삭제
				System.out.println("<3.삭제>");
				System.out.print(">번호 : ");

				// 삭제할 번호 입력 받기
				int deldata = sc.nextInt();
				// ArrayList.remove(int index) : 인덱스 위치의 아이템을 리스트에서 삭제되고, 그 객체는 리턴
				dbList.remove(deldata - 1); // 인덱스번호로 인식하기 때문에 -1로해야 고객이 인식하는 숫자와

				System.out.println("[ 해당 정보가 삭제되었습니다. ]");
				System.out.println();

				break;

			case 4:
				// 검색 : 이름 "석" 검색시 -> 이름에 “석"을 포함한 리스트 출력
				System.out.println("<4. 검색>");
				System.out.print(">이름 : ");
				
				String strsearch = sc.nextLine();
//				for (int i = 0; i < dbList.size(); i++) {
//
//				}
				

				System.out.println();
				break;

			case 5:
				// 종료
				System.out.println("*******************************************");
				System.out.println("*                  감사합니다                *");
				System.out.println("*******************************************");
				return;
			// 예외번호 입력시
			default:
				System.out.println("[ 다시 입력해 주세요 ]");
			} // switch문 종료

			// 새로 등록 쓰기용 스트림
			Writer fw = new FileWriter("/Users/joyunju/javaStudy/workspace/minipro/PhoneDB.txt");
			BufferedWriter bw = new BufferedWriter(fw);

			for (PhoneDB db : dbList) {
				// 2. 등록 info txt파일에 추가
				String saveStr = db.getName() + "," + db.getHp() + "," + db.getCompany();
				bw.write(saveStr);
				bw.newLine();
			}

			bw.close();
			br.close();
			// fr.close();

		} // while문 종료

		sc.close();

	}

}
