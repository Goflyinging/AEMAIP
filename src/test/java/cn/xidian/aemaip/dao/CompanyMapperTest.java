package cn.xidian.aemaip.dao;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.xidian.aemaip.entity.Company;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:ApplicationContext.xml" })
public class CompanyMapperTest {
    @Autowired
    CompanyMapper companyMapper;
    
    @Test
    public void testInsert() {
        Company company = new Company();
        company.setCompanyname("哈哈");
        assertEquals(1, companyMapper.insert(company));
    }
    
    @Test
    public void testSelect() {
        Company company = companyMapper.selectByID(1);
        assertEquals("哈哈", company.getCompanyname());
    }
}
