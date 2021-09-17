import java.util.List;
import java.util.Scanner;

import controller.StudentRecordHellper;
import model.StudentRecords;

/**
 * rggeleta@dmacc.edu roman
 * CIS175-Fall2021
 * Sep 16, 2021
 */
public class StartProgram {
	static Scanner in = new Scanner(System.in);
	static StudentRecordHellper srh = new StudentRecordHellper();

	private static void addRecord() {
		// TODO Auto-generated method stub
		StudentRecords toAdd = new StudentRecords();
		srh.insertRecords(toAdd);
		System.out.print("Enter a student name: ");
		String studentName = in.nextLine();
		System.out.print("Enter a courseName: ");
		String courseName = in.nextLine();

	}

	private static void deleteRecord() {
		// TODO Auto-generated method stub
		System.out.print("Enter the student name to delete: ");
		String studentName = in.nextLine();
		System.out.print("Enter the course name to delete: ");
		String courseName = in.nextLine();

	}
	

	private static void editRecord() {
		// TODO Auto-generated method stub
		System.out.println("How would you like to search? ");
		System.out.println("1 : Search by Student name");
		System.out.println("2 : Search by course name");
		int searchBy = in.nextInt();
		in.nextLine();
		List<StudentRecords> foundRecords ;
		if (searchBy == 1) {
			System.out.print("Enter the student name: ");
			String sName = in.nextLine();
			foundRecords= srh.searchForRecordByStudentName(sName);
			
		} else {
			
			String cName = in.nextLine();
			foundRecords= srh.searchForRecordByStudentName(cName);
			

		}

		if (!foundRecords.isEmpty()) {
			System.out.println("Found Results.");
			for (StudentRecords l : foundRecords) {
				System.out.println(l.getStudentId() + " : " + l.toString());
			}
			System.out.print("Which Student ID to edit: ");
			int studentIdToEdit = in.nextInt();

			StudentRecords toEdit = srh.searchForRecordByStudentId(studentIdToEdit);
			System.out.println("Retrieved " + toEdit.getStudentName() + " from " + toEdit.getCourseName());
			System.out.println("1 : Update student name");
			System.out.println("2 : Update course name");
			int update = in.nextInt();
			in.nextLine();

			if (update == 1) {
				System.out.print("New student name: ");
				String newStudentName = in.nextLine();
				toEdit.setStudentName(newStudentName);
			} else if (update == 2) {
				System.out.print("New course name: ");
				String newCourseName = in.nextLine();
				toEdit.setCourseName(newCourseName);
			}

			srh.updateRecord(toEdit);

		} else {
			System.out.println("---- No results found");
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		runMenu();

	}

	public static void runMenu() {
		boolean goAgain = true;
		System.out.println(" Welcome to the student record!");
		while (goAgain) {
			System.out.println("*  Select a student from the following options:");
			System.out.println("*Enter  1  to add to the student record");
			System.out.println("*Enter  2  to Edit a student name");
			System.out.println("*Enter  3  to Delete a student name");
			System.out.println("*Enter  4  to View the record");
			System.out.println("*Enter  5  to Exit the program");
			System.out.print("*  Your selection: ");
			int selection = in.nextInt();
			in.nextLine();

			if (selection == 1) {
				addRecord();
			} else if (selection == 2) {
				editRecord();
			} else if (selection == 3) {
				deleteRecord();
			} else if (selection == 4) {
				viewTheList();
			} else {
				srh.cleanUp();
				System.out.println("   Goodbye!   ");
				goAgain = false;
			}

		}

	}

	private static void viewTheList() {
		// TODO Auto-generated method stub
		

	}

}
