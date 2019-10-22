package com.gnnt.mybatisgenerator;


import com.gnnt.mybatisgenerator.mapper.*;
import com.gnnt.mybatisgenerator.model.Company;
import com.gnnt.mybatisgenerator.model.CompanyCriteria;
import com.gnnt.mybatisgenerator.model.RoleExt;
import com.gnnt.mybatisgenerator.model.UserExt;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.UUID;

@SpringBootTest
class MybatisGeneratorApplicationTests {

    @Autowired
    private CompanyMapper companyMapper;

    @Autowired
    private CompanyMapperExt companyMapperExt;

    @Autowired
    private UserMapperExt userMapperExt;

    @Autowired
    private RoleMapperExt roleMapperExt;

    @Autowired
    private PersonMapper personMapper;
    @Test
    void contextLoads() {
    }
    @Test
    void test_insert(){
        Company company = new Company();
        company.setCode("004");
        company.setName("上海控股吖");
        company.setAddress("上海市开发区");
        company.setOwner("明生");
        company.setMoney(7000000.00);
        int result = companyMapper.insert(company);
        System.out.println("运行结果："+result);
    }
    
    @Test
    void test_select(){
        CompanyCriteria criteria = new CompanyCriteria();
        CompanyCriteria.Criteria criteria1 = criteria.createCriteria();
        criteria1.andMoneyLessThanOrEqualTo(7000000.00);
        List<Company> companies = companyMapper.selectByExample(criteria);
        System.out.println("查询结果："+companies.toString());
    }
    @Test
    void test_pageHelper(){
        List<Company> list= companyMapperExt.queryCompanyList();


    }

    @Test
    void test_ManytoMany(){
        UserExt userExt = userMapperExt.selectById(1);
        System.out.println(userExt.toString());
        System.out.println(userExt.getRoles().toString());
    }
    @Test
    void test_ManytoMany2(){
        RoleExt roleExt = roleMapperExt.selectById(1);
        System.out.println(roleExt.toString());
        System.out.println(roleExt.getPermissions().toString());
    }
}
