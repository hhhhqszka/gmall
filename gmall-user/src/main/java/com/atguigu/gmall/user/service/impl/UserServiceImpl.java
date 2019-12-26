package com.atguigu.gmall.user.service.impl;

import com.atguigu.gmall.user.bean.UmsMember;
import com.atguigu.gmall.user.bean.UmsMemberReceiveAddress;
import com.atguigu.gmall.user.mapper.UmsMemberReceiveAddressMapper;
import com.atguigu.gmall.user.mapper.UserMapper;
import com.atguigu.gmall.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;
    @Autowired
    UmsMemberReceiveAddressMapper umsMemberReceiveAddressMapper;

    @Override
    public List<UmsMember> getAllUser() {

        List<UmsMember> umsMemberList = userMapper.selectAll();//userMapper.selectAllUser();
        return umsMemberList;
    }

    @Override
    public boolean modifyUser() {
        return userMapper.updateUser();
    }

    @Override
    public List<UmsMemberReceiveAddress> getReceiveAddressByMemberId(String memberId) {
//        Example e = new Example(UmsMemberReceiveAddress.class);
//        e.createCriteria().andEqualTo("memberId",memberId);//property指的是UmsMemberReceiveAddress的属性
//        List<UmsMemberReceiveAddress> umsMemberReceiveAddresses = umsMemberReceiveAddressMapper.selectByExample(e);
        UmsMemberReceiveAddress umsMemberReceiveAddress=new UmsMemberReceiveAddress();
        umsMemberReceiveAddress.setMemberId(memberId);//对象中哪个字段不为空，就把哪个变量作为过滤条件
        List<UmsMemberReceiveAddress> umsMemberReceiveAddresses = umsMemberReceiveAddressMapper.select(umsMemberReceiveAddress);
        return umsMemberReceiveAddresses;
    }
}
