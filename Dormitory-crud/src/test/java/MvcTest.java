import com.github.pagehelper.PageInfo;
import com.kyle.crud.bean.Student;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

/**
 * @auther kyle
 * @creat 2022-07-21:26
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"classpath:applicationContext.xml", "file:../../main/webapp/WEB-INF/dispatcherServlet-servlet.xml"})
public class MvcTest {
    //传入Springmvc的ioc，需要第二个注释
    @Autowired
    WebApplicationContext context;
    //虚拟mvc请求
    MockMvc mockMvc;
    @Before
    public void initMockMvc(){
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }
    @Test
    public void testPage() throws Exception {
        //模拟请求拿到返回值
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                .get("/students")
                .param("pn", "201"))
                .andReturn();

        MockHttpServletRequest request = result.getRequest();
        PageInfo attribute = (PageInfo) request.getAttribute("pageInfo");
        System.out.println("当前页码："+attribute.getPageNum());
        System.out.println("总页码："+attribute.getPages());
        System.out.println("总记录数："+attribute.getTotal());
        System.out.println("在页面需要连续显示的页码");
        int[] nums = attribute.getNavigatepageNums();
        for (int i : nums) {
            System.out.println(" "+i);
        }
        //获取员工数据
        List<Student> list = attribute.getList();
        for (Student student:list){
            System.out.println("ID"+student.getStuId()+"==>Name:"+student.getStuName());
        }
    }
}
