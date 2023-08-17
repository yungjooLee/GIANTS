package kr.spring.member.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.spring.member.dao.MemberMapper;
import kr.spring.member.vo.CompanyDetailVO;
import kr.spring.member.vo.MemberVO;

@Service
@Transactional
public class MemberServiceImpl implements MemberService{

	@Autowired
	private MemberMapper memberMapper;
	
	@Override
	public void insertMember(MemberVO member) {
		member.setMem_num(memberMapper.selectMem_num());
		memberMapper.insertMember(member);
		memberMapper.insertMember_detail(member);
	}
	
	@Override 
	public void insertCompany(MemberVO member) {
		member.setMem_num(memberMapper.selectMem_num());
		memberMapper.insertCompany(member);
		memberMapper.insertCompany_detail(member);
	}
	
	@Override
	public MemberVO selectCheckMember(String id) {
		return memberMapper.selectCheckMember(id);
	}

	@Override
	public MemberVO selectMember(Integer mem_num) {
		return memberMapper.selectMember(mem_num);
	}
	
	@Override
	public MemberVO selectCompany(Integer mem_num) {
		return memberMapper.selectCompany(mem_num);
	}

	@Override
	public void updateMember(MemberVO member) {
		memberMapper.updateMember(member);
		memberMapper.updateMember_detail(member);
	}
	
	@Override
	public void updateCompany(MemberVO member) {
		memberMapper.updateCompany_detail(member);
	}
	
	@Override
	public void updateAu_id(String au_id, int mem_num) {
		memberMapper.updateAu_id(au_id, mem_num);
	}

	@Override
	public MemberVO selectAu_id(String au_id) {
		return memberMapper.selectAu_id(au_id);
	}

	@Override
	public void deleteAu_id(int mem_num) {
		memberMapper.deleteAu_id(mem_num);
	}

	@Override
	public void updateProfile(MemberVO member) {
		memberMapper.updateProfile(member);
	}
	
	@Override
	public void updatePasswd(MemberVO member) {
		memberMapper.updatepasswd(member);
	}

	@Override
	public void deleteMember(Integer mem_num) {
		memberMapper.deleteMember(mem_num);
		memberMapper.deleteMember_detail(mem_num);
	}
	
	@Override
	public void deleteCompany(Integer mem_num) {
		memberMapper.deleteCompany(mem_num);
		memberMapper.deleteCompany_detail(mem_num); 
		
	}

	@Override
	public CompanyDetailVO selectCompanyDetail(String comp_num) {
		return memberMapper.selectCompanyDetail(comp_num);
	}

	@Override
	public void updateComProfile(MemberVO member) {
		memberMapper.updateComProfile(member);
	}

	@Override
	public int selectRowCount(Map<String, Object> map) {
		return memberMapper.selectRowCount(map);
	}

	@Override
	public List<MemberVO> selectList(Map<String, Object> map) {
		return memberMapper.selectList(map);
	}
	

	@Override
	public void updateByAdmin(MemberVO memberVO) {
		memberMapper.updateByAdmin(memberVO);
	}

	@Override
	public MemberVO selectCheckMemberNk(String nickname) {
		return memberMapper.selectCheckMemberNk(nickname);
	}

	@Override
	public void updateMemberNk(MemberVO member) {
		memberMapper.updateMemberNk(member);
	}

	@Override
	public MemberVO findMemberId(String mem_name, String mem_phone) {
		return memberMapper.findMemberId(mem_name, mem_phone);
	}

	@Override
	public MemberVO findMemberPw(String mem_id, String mem_name, String mem_phone, String mem_email) {
		return memberMapper.findMemberPw(mem_id, mem_name, mem_phone, mem_email);
	}

	@Override
	public void changePw(int mem_num, String new_passwd) {
		memberMapper.changePw(mem_num, new_passwd);
	}
}
