package com.CRM.CONST;



public class UrlConst {
	//AuthController
	
	public final static String AUTH_LOGIN = "/Login";
	public final static String AUTH_LOGOUT = "/Logout";
	
	//BlankPage
	
	public final static String BLANK_PAGE_ERROR = "/BlankError/error";
	public final static String BLANK_PAGE_BLANK = "/BlankError/blank";
	
	//GroupWorkController
	
	public final static String GROUP_TABLE = "/manager/Group/table";
	public final static String GROUP_ADD = "/manager/Group/add";
	public final static String GROUP_DETAILS = "/manager/Group/details";
	public final static String GROUP_DELETE  = "/manager/Group/delete";
	public final static String GROUP_EDIT = "/manager/Group/edit";
	
	//HomeController
	
	public final static String HOME = "/Home";
	
	//RoleController 
	
	public final static String ROLE_TABLE = "/admin/Role/table";
	public final static String ROLE_ADD = "/admin/Role/add";
	public final static String ROLE_DELETE  = "/admin/Role/delete";
	public final static String ROLE_EDIT  = "/admin/Role/edit";
	
	//UserController
	
	public final static String USER_ADD =  "/manager/User/add";
	public final static String USER_TABLE = "/manager/User/table";
	public final static String USER_DETAIL  = "/manager/User/details";
	public final static String USER_DELETE = "/manager/User/delete";
	public final static String USER_EDIT = "/manager/User/edit";
}
