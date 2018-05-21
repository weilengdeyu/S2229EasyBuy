package cn.easybuy.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.easybuy.entity.Category;
import cn.easybuy.service.ICategoryService;
import cn.easybuy.service.impl.CategoryServiceImpl;

@WebServlet("/CategoryServlet")
public class CategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    ICategoryService categoryService=new CategoryServiceImpl();
	    try {
			List<Category> list = categoryService.findAllCategories();
			
			List<Category> rootCates=new ArrayList<Category>();
			for (Category item : list) {
				Category childCate=item;
				int pid=childCate.getParentId();
				if (pid==0) {
					rootCates.add(item);
				}else{
					for (Category innerCate : list) {
						int id=innerCate.getId();
						if (id==pid) {
							Category parentCate=innerCate;
							parentCate.getChildren().add(childCate);
							break;
						}
					}
				}
			}
			request.setAttribute("cateList", rootCates);
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
