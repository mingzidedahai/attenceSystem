package cn.edu.tju.se.base.cons;

/**
 * 整个应用通用的常量 <br>
 * <b>类描述:</b>
 * 
 * <pre>
 * |
 * </pre>
 * 
 * @see
 * @since
 */
public class CommonConstant {
	/**
	 * 系统需要的enum，enum很强大
	 */
	public static enum Sex {
		男, 女
	}

	public static enum Type {
		年假, 病假, 事假, 婚假, 产假
	}

	public static enum State {
		审批中, 已拒绝, 已同意
	}

	public static enum Agree {
		审批中, 拒绝, 同意
	}

	public static enum Role {
		普通员工, 部门经理, 副总经理, 总经理
	}

	public static enum Department {
		研发部, 行政部, 财务部, 人事部
	}

	public static enum Auth {
		no,yes
	}

	public static final int AUTH_NUMBER = 6;
	public static final String AUTH_LEAVINGAPPROVAL = "AUTH_LEAVINGAPPROVAL";
	public static final String AUTH_EVECTIONAPPROVAL = "AUTH_EVECTIONAPPROVAL";
	public static final String AUTH_SETVOCATION = "AUTH_SETVOCATION";
	public static final String AUTH_LEAVINGTABLE = "AUTH_LEAVINGTABLE";
	public static final String AUTH_IMPORTPUNCHDATA = "AUTH_IMPORTPUNCHDATA";
	public static final String AUTH_ALLPUNCH = "AUTH_ALLPUNCH";
	/**
	 * 用户对象放到Session中的键名称
	 */
	public static final String USER_CONTEXT = "USER_CONTEXT";

	/**
	 * 将登录前的URL放到Session中的键名称
	 */
	public static final String LOGIN_TO_URL = "toUrl";

	/**
	 * 每页的记录数
	 */
	public static final int PAGE_SIZE = 3;
}
