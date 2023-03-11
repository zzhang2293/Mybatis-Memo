package com.demo;
import com.mapper.BrandMapper;
import com.pojo.Brand;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisTest {
    @Test
    public void testSelectAll() throws IOException {
        // get SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession session = sqlSessionFactory.openSession();
        BrandMapper brandMapper = session.getMapper(BrandMapper.class);
        // get brandMapper proxy
        List<Brand> brands = brandMapper.selectAll();
        System.out.println(brands);
        session.close();

    }

    @Test
    public void testSelectById() throws IOException {
      //  System.out.println("type the id: ");
     //   int id = scanner.nextInt();
        // get SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession session = sqlSessionFactory.openSession();
        BrandMapper brandMapper = session.getMapper(BrandMapper.class);
        // get brandMapper proxy
        Brand brands = brandMapper.selectById(1);
        System.out.println(brands);
        session.close();

    }


    @Test
    public void testSelectByCondition() throws IOException {
        //  System.out.println("type the id: ");
        //   int id = scanner.nextInt();
        // get SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession session = sqlSessionFactory.openSession();
        BrandMapper brandMapper = session.getMapper(BrandMapper.class);
        // get brandMapper proxy
        String companyName = "%华为%";
        String brandName = "%华为%";
        List<Brand> brands = brandMapper.selectByCondition(null ,null, null);
        System.out.println(brands);
        session.close();

    }
    @Test
    public void testSelectByIdSingle() throws IOException {
        //  System.out.println("type the id: ");
        //   int id = scanner.nextInt();
        // get SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession session = sqlSessionFactory.openSession();
        BrandMapper brandMapper = session.getMapper(BrandMapper.class);
        // get brandMapper proxy
        Brand brand = new Brand();
//        brand.setId(1);
        List<Brand> brands = brandMapper.selectByConditionSingle(brand);
        System.out.println(brands);
        session.close();

    }
    @Test
    public void testInsertAll() throws Exception{
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = sqlSessionFactory.openSession();
        BrandMapper brandMapper = session.getMapper(BrandMapper.class);
        Brand brand = new Brand();
        brand.setBrandName("Cisco");
        brand.setCompanyName("DataEng");
        brand.setDescription("this is my description");
        brand.setStatus(1);
        brand.setOrdered(100);
        brandMapper.insertAll(brand);
        session.commit();
        Integer id = brand.getId();
        System.out.println(id);
        session.close();
    }
    @Test
    public void testUpdate() throws Exception{
        int status = 1;
        String companyName = "Amazon";
        String description = "Amazon No,1";
        int order = 100;
        int id = 8;
        String brandName = "AMA";
        Brand brand = new Brand(id, brandName, companyName,  order, description, status);
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = sqlSessionFactory.openSession(true);
        Brand brand1 = new Brand();
        brand1.setId(2);
        brand1.setDescription("HI!!");
        BrandMapper mapper = session.getMapper(BrandMapper.class);
        int result = mapper.update(brand1);
        System.out.println(result);
        session.close();
    }
    @Test
    public void testDeleteById() throws Exception{
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = sqlSessionFactory.openSession(true);
        BrandMapper mapper = session.getMapper(BrandMapper.class);
        mapper.deleteById(7);
        session.close();
    }
    @Test
    public void testDeleteByIds() throws Exception {
        String resources = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resources);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = sqlSessionFactory.openSession(true);
        BrandMapper mapper = session.getMapper(BrandMapper.class);
        int[] ids = {3, 8};
        int res = mapper.deleteByIds(ids);
        System.out.println(res);
        session.close();
    }

}
