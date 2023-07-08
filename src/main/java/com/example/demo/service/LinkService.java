package com.example.demo.service;


import com.example.demo.entity.Link;

import java.util.List;

public interface LinkService {
    boolean save(Link link);
    boolean delete(int linkId);
    List<Link> get();
}
