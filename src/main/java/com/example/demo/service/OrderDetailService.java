package com.example.demo.service;

import com.example.demo.entity.OrderDetail;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderDetailService {
    public boolean updateOrdertail_notthislogic(OrderDetail orderDetail);
    public boolean addOrDertail_notthislogic(OrderDetail orderDetail);

    /**
     * 只有再取消订单的时候执行此操作，或者说调用此方法
     * @param orderDetail
     * @return
     */
    public boolean deleteOrderDetail(OrderDetail orderDetail);
    public List<OrderDetail> searchOrdertail(OrderDetail orderDetail);
}
