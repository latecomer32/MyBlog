package com.MyBlog.Repository.mybatis;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.MyBlog.Dto.Board;
import com.MyBlog.Repository.BoardRepository;

@Repository
public class MybatisBoardRepository implements BoardRepository {

	private BoardRepository mapper;
	
	@Autowired
	public MybatisBoardRepository(SqlSession sqlSession) {
		mapper = sqlSession.getMapper(BoardRepository.class);
	}


	@Override
	public void saveTheWriting(Board board) {
	
		mapper.saveTheWriting(board);
		
	}


	@Override
	public List<Board> getWritingList(int offset, String field, String query, boolean pub, int size, String order, String desc, String categoryName, String nickName, boolean loginCheck, String uri, String channelNam) {
		System.out.println("MybatisBoardRepository_getWritingList:"
	+"\n offset:"+offset+
	"\n field:"+field+
	"\n query:"+query+
	"\n rowNum:"+size+
	"\n order:"+order+
	"\n categoryName:"+categoryName+
	"\n nickName:"+nickName+
	"\n loginCheck:"+loginCheck+
	"\n uri:"+uri+
	"\n channelName:"+channelNam
	);
		return mapper.getWritingList(offset, field, query, pub, size, order, desc, categoryName, nickName, loginCheck, uri, channelNam);
	}
	

	@Override
	public int deleteWritingList(int no) {
		return mapper.deleteWritingList(no);
	}
	
	@Override
	public int getWritingCount(String field, String query) {
		return mapper.getWritingCount(field, query);
	}


	@Override
	public Board getWritingDetail(int no) {
		return mapper.getWritingDetail(no);
	}


	@Override
	public List<Board> getChannelWritingList(int size) {
		// TODO Auto-generated method stub
		return mapper.getChannelWritingList(size);
	}
	


	
}
