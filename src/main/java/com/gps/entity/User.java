package com.gps.entity;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class User {

	private Integer id;

	@NotNull(message = "昵称格式错误")
	@Pattern(regexp = ".{4,10}", message = "昵称格式错误")
	private String name;

	@NotNull(message = "密码格式错误")
	@Pattern(regexp = "\\w{6,16}", message = "密码格式错误")
	private String pwd;

	@Email(message = "邮箱格式错误")
	private String email;

	@NotNull(message = "电话格式错误")
	@Pattern(regexp = "1[356789]\\d{9}", message = "手机格式错误")
	private String phone;

	@NotNull(message = "年龄格式错误")
	@Max(message = "怎么还不死？", value = 100)
	@Min(message = "咋还不出生？", value = 0)
	private Integer age;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", pwd=" + pwd + ", email=" + email + ", phone=" + phone + ", age="
				+ age + "]";
	}

}
