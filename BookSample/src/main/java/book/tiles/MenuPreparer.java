package book.tiles;

import java.util.ArrayList;
import java.util.List;

import org.apache.tiles.Attribute;
import org.apache.tiles.AttributeContext;
import org.apache.tiles.preparer.ViewPreparer;
import org.apache.tiles.request.Request;
import org.springframework.stereotype.Component;

//ViewPreparer: definition? ?€?? ? λͺ¨λ  jsp?? ?Έ? ?? ?λ°κ°μ²΄λ?? ??±?΄μ€?.
//Model(getter, setter)κ³? κ°μ? κΈ°λ₯ ??±?? ?΄ ?€λ₯? λΏ? 
//Model - μ»¨νΈλ‘€λ¬ ?€?? | ViewPreparer - definition ?€??
@Component
public class MenuPreparer implements ViewPreparer{

	@Override
	public void execute(Request tilesContext, AttributeContext attributeContext) {
		//List<String> menuList = new ArrayList<String>();
		//menuList.add("λ‘κ·Έ?Έ");
		//menuList.add("??κ°??");
		//menuList ?΄λ¦μΌλ‘? ?΄?Ή Attribute? listλ₯? μΆκ? , true? ?¬?¬ μ»¨νμΈ μ? ?Έ ? ??λ‘? ??©? ?λ―?
		//attributeContext.putAttribute("menuList", new Attribute(menuList), true);
	}

	
}
