package com.MyBlog.Service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.MyBlog.Dto.Board;
import com.MyBlog.Dto.Channel;
import com.MyBlog.Repository.BoardRepository;
import com.MyBlog.Repository.ChannelRepository;

@Service
public class ChannelServiceImp implements ChannelService{

	@Autowired
	ChannelRepository channelRepository;

	@Override
	public List<Channel> getChannelList(int page, int size, String query) {
		int offset= 0+(page-1)*size;
		return channelRepository.getChannelList(offset, size, query);
	}

	@Override
	public int getChannelCount(String field, String query) {
		return channelRepository.getChannelCount(field, query);
	}

}
