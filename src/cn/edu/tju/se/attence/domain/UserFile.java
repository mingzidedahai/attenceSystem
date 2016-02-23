package cn.edu.tju.se.attence.domain;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import cn.edu.tju.se.base.cons.CommonConstant.Department;
import cn.edu.tju.se.base.cons.CommonConstant.Role;
import cn.edu.tju.se.base.cons.CommonConstant.Sex;
import cn.edu.tju.se.base.domain.BaseDomain;
/**
 * @author Ae
 *
 */
@Entity
@Table(name="userfile")
public class UserFile extends BaseDomain  {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	protected int id;
	protected String name;
	protected int employeeid;
	protected Sex sex  ;
	protected String phone;
	protected String email;
	protected Department department;
	protected Role role;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}






	public int getEmployeeid() {
		return employeeid;
	}

	public void setEmployeeid(int employeeid) {
		this.employeeid = employeeid;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Sex getSex() {
		return sex;
	}

	public void setSex(Sex sex) {
		this.sex = sex;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}





	
}



