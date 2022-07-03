import com.kyle.crud.bean.Student;
import com.kyle.crud.dao.DormitoryMapper;
import com.kyle.crud.dao.StudentMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Random;
import java.util.UUID;

/**
 * @auther kyle
 * @creat 2022-06-1:51
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class MapperTest {
    @Autowired
    DormitoryMapper dormitoryMapper;
    @Autowired
    StudentMapper studentMapper;
    @Autowired
    SqlSession sqlSession;
    //        测试DormitoryMapper
    @Test
    public void testCRUD(){
//        ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
//        DormitoryMapper bean = ioc.getBean(DormitoryMapper.class);
        System.out.println(dormitoryMapper);
        //1、插入宿舍楼
//        dormitoryMapper.insertSelective(new Dormitory(null,"A1"));
//        dormitoryMapper.insertSelective(new Dormitory(null,"A2"));

        //2、插入学生
//        studentMapper.insertSelective(new Student(null, "kyle", "M", "88888888", "203", 1));
//        studentMapper.insertSelective(new Student(null, "lucy", "W", "66666666", "1006", 2));

        //3、批量插入学生
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        for (int i = 0; i < 600; i++) {
            String uid = UUID.randomUUID().toString().substring(0,5)+i;

            Random random = new Random();
            String telNum = "136556"+(int)(random.nextFloat() * 10000);
            String dormNum1 = ""+(random.nextInt(11)+2);
            String dormNum2 = ""+(random.nextInt(20)+10);
            String dormNum = dormNum1+dormNum2;



            mapper.insertSelective(new Student(null,uid,"W",telNum,dormNum,2));
        }
    }
}
