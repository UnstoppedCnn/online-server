package com.example.demo.service.impl;

import com.example.demo.dao.LinkMapper;
import com.example.demo.entity.Link;
import com.example.demo.service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LinkImpl implements LinkService {

    LinkMapper linkDao;
    @Autowired
    public LinkImpl(LinkMapper linkDao) {
        this.linkDao = linkDao;
    }

    @Override
    public boolean save(Link link) {
        return linkDao.add(link);
    }

    @Override
    public boolean delete(int linkId) {
        return linkDao.delete(linkId);
    }

    @Override
    public List<Link> get() {
        return linkDao.getAll();
    }
}
