package cn.mldn.dibmp.web.action.back;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.mldn.util.action.abs.AbstractAction;
import cn.mldn.util.web.SplitPageUtil;

@Controller
@RequestMapping("/pages/back/admin/customer/*")
//这里表示
public class CustomerActionBack extends AbstractAction {
	private static final String TITLE = "客户" ;
	@RequestMapping("add_pre")
	public ModelAndView addPre() {
		ModelAndView mav = new ModelAndView(super.getPage("customer.add.page"));
		return mav;
	}
	@RequestMapping("add")
	public ModelAndView add() {
		ModelAndView mav = new ModelAndView(super.getPage("forward.page"));//资源文件通过key找到value
		super.setMsgAndUrl(mav, "customer.add.action", "vo.add.success", TITLE);
		return mav;//设置提示信息  customer  pages这个是获得资源文件里的action  messages vo是进行提示信息    Title 常量
	}
	@RequestMapping("edit_pre")   //这个方法的映射
	public ModelAndView editPre(long wid) {
		ModelAndView mav = new ModelAndView(super.getPage("customer.edit.page"));
		//这里是取的这个方法的映射路径   在资源文件里的pages里找到key
		return mav;
	}
	@RequestMapping("edit")
	public ModelAndView edit() {
		ModelAndView mav = new ModelAndView(super.getPage("forward.page"));
		super.setMsgAndUrl(mav, "customer.list.action", "vo.edit.success", TITLE);
		return mav;
	}
	@RequestMapping("list") 
	public ModelAndView list() {
		SplitPageUtil spu = new SplitPageUtil("客户姓名:name|联系电话:phone|客户地址:address", "customer.list.action") ;
		ModelAndView mav = new ModelAndView(super.getPage("customer.list.page"));
		return mav;
		//分页的util类        
	}
}
