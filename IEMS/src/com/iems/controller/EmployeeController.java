
package com.iems.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.iems.entity.Education;
import com.iems.entity.Employee;
import com.iems.entity.Profile;
import com.iems.model.EmployeeModel;


@Controller
@SessionAttributes("eid")
public class EmployeeController 
{
 int i=0;
	
	
	@RequestMapping(value="/profile")
	public ModelAndView EmployeeProfile(HttpServletRequest req,ModelMap model,@ModelAttribute("eid")int eid){
		EmployeeModel model1=new EmployeeModel();
		model.addAttribute("emp1",model1.getEmployee(eid));
		model.addAttribute("pro1",model1.getProfile(eid));
        model.addAttribute("edu",model1.getEducationList(eid));
        model.addAttribute("exp", model1.getExperienceList(eid));
		//model.addAttribute("skill",model1.getSkillIds());
	return new ModelAndView("profile",model);
	}
	
	
	@RequestMapping(value="/edit")
	public ModelAndView editProfile(ModelMap modelmap,@ModelAttribute("eid")int eid){
		EmployeeModel model1=new EmployeeModel();
	
		modelmap.addAttribute("emp1",model1.getEmployee(eid));
	    modelmap.addAttribute("pro1",model1.getProfile(eid));
		modelmap.addAttribute("edu", model1.getEducationList(eid));
		modelmap.addAttribute("exp", model1.getExperienceList(eid));
		modelmap.addAttribute("columncount",model1.getEducationList(eid).size());
		
		return new ModelAndView("edit",modelmap);	
	}
	
     @RequestMapping(value="/addedu")
     public ModelAndView addeducation(HttpServletRequest req,@ModelAttribute("eid")int eid){	
		
    	System.out.println(eid);
    	
		EmployeeModel model=new EmployeeModel();
  	    String columnid=req.getParameter("columnid");
  		int editcolumnid=Integer.parseInt(req.getParameter("columncountfld"));
	   	String deg=req.getParameter("Degreefld");
	   	String uni=req.getParameter("Boardfld");
		String yr=req.getParameter("Yearfld");
		
		String edu = deg+","+uni+","+yr;
		if(!deg.isEmpty() & !uni.isEmpty() & !yr.isEmpty())
		{	
			if(columnid==null)
			model.saveedu(prepareEducationBean(eid,edu,editcolumnid+1));
			else{
			model.deleteedu(model.getEducation(eid,Integer.parseInt(columnid)).get(0));	
			model.saveedu(prepareEducationBean(eid,edu,Integer.parseInt(columnid)));	
			}
			
		}
		
		//System.out.println(model.getEducation(emp1.getEid()));
        return new ModelAndView("redirect:/edit");
			
     }
    @RequestMapping(value="/editedu")
    public ModelAndView editEducation(HttpServletRequest req,@ModelAttribute("eid")Integer eid,ModelMap modelmap)
	{
    	int columnid=Integer.parseInt(req.getParameter("columnid"));
		EmployeeModel model1=new EmployeeModel();
		modelmap.addAttribute("emp1",model1.getEmployee(eid));
	    modelmap.addAttribute("pro1",model1.getProfile(eid));
		modelmap.addAttribute("edu", model1.getEducation(eid));
		modelmap.addAttribute("exp", model1.getExperience(eid));
		modelmap.addAttribute("columncount",model1.getEducationList(eid).size());
		
		
		//prepareEducationBean(eid,model1.getColumn(columnid,eid).get(0).toString(),columnid);
		String[] str=model1.getColumn(columnid,eid).get(0).toString().split(",");
		modelmap.addAttribute("degree",str[0]);
		modelmap.addAttribute("board",str[1]);
		modelmap.addAttribute("year",str[2]);
		modelmap.addAttribute("columnid",columnid);
		return new ModelAndView("edit",modelmap);
	}
	@RequestMapping(value="/deleteedu")
	public ModelAndView deleteEducation(Employee emp,HttpServletRequest req){
		int columnid=Integer.parseInt(req.getParameter("columnid"));
	    EmployeeModel model=new EmployeeModel();
	    model.deleteedu(model.getEducation(emp.getEid(),columnid).get(0));
		return new ModelAndView("redirect:edit");
	}
	
	
	private Education prepareEducationBean(int empid,String edu,int columnid ){
		Education bean = new Education();
		bean.setEid(empid);
		bean.setColumnid(columnid);
		bean.setDegree(edu);
		return bean;
	}
	
	
	    private Education prepareModel(Education oldedu,String newdegree){
        Education education = new Education();
        education.setEid(oldedu.getEid());
        education.setColumnid(oldedu.getColumnid());
        education.setDegree(newdegree);
//		employee.setSalary(employees.getSalary());
//		employee.setEmpId(employee.getId());
//		employee.setId(null);
		return education;
	}
	
}
