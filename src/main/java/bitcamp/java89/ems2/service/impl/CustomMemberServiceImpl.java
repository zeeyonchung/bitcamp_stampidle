package bitcamp.java89.ems2.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bitcamp.java89.ems2.dao.CustomCardDao;
import bitcamp.java89.ems2.dao.CustomMemberDao;
import bitcamp.java89.ems2.domain.CustomMember;
import bitcamp.java89.ems2.service.CustomMemberService;

@Service
public class CustomMemberServiceImpl implements CustomMemberService {
  @Autowired CustomMemberDao customMemberDao;
  @Autowired CustomCardDao customCardDao;
  
  
  @Override
  public int add(CustomMember customMember, int cafeMemberNo) throws Exception {
    int success = customMemberDao.insert(customMember);
    int customMemberNo = customMember.getCustomMemberNo();
    int stampCafeCardNo = customCardDao.getStampCafeCardNo(cafeMemberNo);
    
    Map<String, Object> paramMap = new HashMap<>();
    paramMap.put("customMemberNo", customMemberNo);
    paramMap.put("stampCafeCardNo", stampCafeCardNo);
    customCardDao.insert(paramMap);
    return success;
  }
  
  public List<CustomMember> getSrchListCustomMember() throws Exception {
  	return customMemberDao.getSrchListCustomMember();
  }
  
  @Override
  public int update(CustomMember customMember) throws Exception {
    return customMemberDao.update(customMember);
  }
  @Override
  public CustomMember getOne(int customMemberNo) throws Exception {
    return customMemberDao.getOne(customMemberNo);
  }
}
  
















