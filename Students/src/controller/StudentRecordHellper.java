package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.StudentRecords;

/**
 * rggeleta@dmacc.edu roman
 * CIS175-Fall2021
 * Sep 16, 2021
 */
public class StudentRecordHellper {
	static EntityManagerFactory emfactory = 
			Persistence.createEntityManagerFactory("Students");
	
	public void insertRecords(StudentRecords sr) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(sr);
		em.getTransaction().commit();
		em.close();		
		
	}
	
	public List<StudentRecords> showAllItems(){
		EntityManager em = emfactory.createEntityManager();
		List<StudentRecords> allItems =
				em.createQuery("SELECT i FROM StudentRecords i").getResultList();
		return allItems;
		
	}
	
	public void deletRecord(StudentRecords toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<StudentRecords>typedQuery= em.createQuery("select sr from StudentRecords sr where sr.studentName= :selectedStudentName and sr.courseName = :selectedCourseName",StudentRecords.class);
		
				typedQuery.setParameter("SelectedStudentName", toDelete.getStudentName());
				typedQuery.setParameter("SelectedCourseName", toDelete.getCourseName());
				
						//we only want one result
						typedQuery.setMaxResults(01);
						
						//get the result and save it into a new list item
						StudentRecords result = typedQuery.getSingleResult();
						
						//remove it
						em.remove(result);
						em.getTransaction().commit();
						em.close();
		
	}

	public List<StudentRecords> searchForRecordByStudentName(String sName) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<StudentRecords>typedQuery = em.createQuery("select sr from StudentRecords sr where sr.studentName= :selectedStudentName",StudentRecords.class);
		typedQuery.setParameter("selectedStudentName", sName);
		List<StudentRecords>foundItems = typedQuery.getResultList();
		em.close();
		return foundItems;
	
				
	}

	public List<StudentRecords> searchForRecordByCourseName(int studentIdToEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<StudentRecords>typedQuery = em.createQuery("select sr from StudentRecords sr where sr.courseName= :selectedCourseName",StudentRecords.class);
		typedQuery.setParameter("selectedItem", studentIdToEdit);
		List<StudentRecords>foundItems = typedQuery.getResultList();
		em.close();
		return foundItems;
	}
	
	public void updateRecord(StudentRecords toEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
		
	}
	
	public void cleanUp() {
		emfactory.close();
	}

	public StudentRecords searchForItemById(int idToEdit) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public StudentRecords searchForRecordByStudentId(int studentIdToEdit) {
		// TODO Auto-generated method stub
		return null;
	}

	
	

}
