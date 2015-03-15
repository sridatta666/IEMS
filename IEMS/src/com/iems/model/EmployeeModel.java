package com.iems.model;
import java.util.List;

import org.hibernate.SQLQuery;

import com.iems.dao.*;
import com.iems.entity.Education;
import com.iems.entity.Experience;
import com.iems.entity.Profile;
import com.iems.entity.Employee;
public class EmployeeModel {
       
	   public List getEid(String userid){
		   EmployeeDao dao=new EmployeeDao();
		   String queryString="select eid from profiledetails where userid='"+userid+"'";
		   return (List) dao.listSQLQuery(queryString);
	   }

		public Employee getEmployee(int empid){
			EmployeeDao dao=new EmployeeDao();
			return dao.getEmployee(empid);
		}
		
		public void insertEmployee(Profile emp){
			EmployeeDao employeeDao=new EmployeeDao();
			employeeDao.save(emp);
		}
		
		public void insertedu(int eid,String edu,int columnid){
		new EmployeeDao().addEducation(eid,columnid,edu);	
		}
		

		public void updateedu(Education bean){
		new EmployeeDao().save(bean);	
		}
		public void saveedu(Education bean){
			new EmployeeDao().saveedu(bean);	
			}
			
		
		public void deleteedu(Education edu){
			EmployeeDao empdao=new EmployeeDao();
			empdao.delete(edu);
		}
		
		public Education getEducation(int empid){
			EmployeeDao dao=new EmployeeDao();
			return dao.getEducation(empid);
		}
		public Experience getExperience(int empid){
			EmployeeDao dao=new EmployeeDao();
			return dao.getExperience(empid);
		}
		public Profile getProfile(int empid){
			EmployeeDao dao=new EmployeeDao();
			return dao.getProfile(empid);
		}
		
//		public List<Employee> listEmployee() {
//			// TODO Auto-generated method stub
//			String queryString="FROM Employee";
//			EmployeeDao employeeDao=new EmployeeDao();
//			return (List<Employee>) employeeDao.listQuery(queryString);
//		}
		public List<Education> getEducation(int eid,int columnid){
			String queryString="FROM Education where eid="+eid+" AND columnid="+columnid;
			EmployeeDao dao = new EmployeeDao();
			return (List<Education>)dao.listQuery(queryString);
			
		}
		public List<Education> getEducationList(int eid){
			String queryString="FROM Education where eid="+eid;
			EmployeeDao empdao=new EmployeeDao();
			return (List<Education>)empdao.listQuery(queryString);  
			
		} 
        public List getColumn(int columnid,int eid){
        	String queryString="Select degree from education where columnid="+columnid+" AND eid="+eid ;  
        	EmployeeDao empdao=new EmployeeDao();
        	return (List)empdao.listSQLQuery(queryString);
        } 
    	public List<Experience> getExperienceList(int eid){
			String queryString="FROM Experience where eid="+eid;
			EmployeeDao empdao=new EmployeeDao();
			return (List<Experience>)empdao.listQuery(queryString);  
			
		} 
		
		
//		public List listEmployee1(Employee emp){
//			// TODO Auto-generated method stub
//			String queryString="FROM Employee where eid=6";//+emp.getEid();
//			EmployeeDao employeeDao=new EmployeeDao();
//			return (List) employeeDao.listQuery(queryString);
//		}
//		public List listEducation1(Employee emp){
//			// TODO Auto-generated method stub
//			String queryString="select * from education where eid=6";//+emp.getEid();
//			EmployeeDao employeeDao=new EmployeeDao();
//			List l = (List)employeeDao.mapSQLQuery(queryString);
//	        System.out.println(l);	
//			return l;
//		}
	   	
//		public List<Profile> listProfile1(Employee emp) {
//			// TODO Auto-generated method stub
//			String queryString="FROM Profile where eid=6";//+emp.getEid();
//			EmployeeDao employeeDao=new EmployeeDao();
//			return (List<Profile>) employeeDao.listQuery(queryString);
//		}
//		public List getSkillIds(Employee emp){
//			
//			EmployeeDao employeeDao=new EmployeeDao();
//			employeeDao.get(emp.getEid());
//			String queryString="FROM Emp_Skills where eid="+emp.getEid();
//			return (List)employeeDao.listQuery(queryString);
//			
//		}
		
	}


