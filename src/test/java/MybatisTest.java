import com.yyw.mybatistest.dao.Userdao;
import com.yyw.mybatistest.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

public class MybatisTest {
    public static void main(String[] args)throws Exception {
        //1.读取配置文件
        InputStream inputStream = Resources.getResourceAsStream("SqlMapconfig.xml");
        //2.创建SqlSessionFactoy工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(inputStream);
        //3.使用工厂生产SqlSession对象
        SqlSession session = factory.openSession();
        //4.使用Sqlsession创建Dao接口代理对象
        Userdao userdao = session.getMapper(Userdao.class);
        //5.使用代理对象执行方法
        List<User> users = userdao.findAll();
       for(User user : users){
           System.out.println(user);
       }
        //6.释放资源
        session.close();
       inputStream.close();
    }
}
