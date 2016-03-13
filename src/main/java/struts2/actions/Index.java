package struts2.actions;

import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.opensymphony.xwork2.ActionSupport;

@Results({
        @Result(name = ActionSupport.SUCCESS, location = "${redirectName}", type = "redirectAction")
})
public class Index extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private String redirectName;

    public String execute() {
        redirectName = "hello";
        return ActionSupport.SUCCESS;
    }

    public String getRedirectName() {
        return redirectName;
    }

}
