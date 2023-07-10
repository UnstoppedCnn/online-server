package com.example.demo.service.impl;


import com.example.demo.dao.OrderDetailMapper;
import com.example.demo.entity.OrderDetail;
import com.example.demo.entity.Product;
import com.example.demo.entity.ProductDetail;
import com.example.demo.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.util.List;

public class OrderDetailImpl implements OrderDetailService {
    @Resource
    OrderDetailMapper orderDetailMapper;
    @Resource
    ProductDetailImpl productDetailImpl;

    /**
     * 订单信息应该只能是修改地址，需要更改数量或者商品颜色尺码信息的话。只能取消此订单，之后重新下单。
     */
    @Override
    public boolean updateOrdertail_notthislogic(OrderDetail orderDetail) {
        return false;
    }

    @Override
    public boolean addOrDertail_notthislogic(OrderDetail orderDetail) {
        return false;
    }

    @Override
    public boolean deleteOrderDetail(OrderDetail orderDetail) {
        ProductDetail productDetail = new ProductDetail();
        List<ProductDetail> detailList = productDetailImpl.searchProductDetail(productDetail);
        productDetail.setProductId(orderDetail.getProductId());
        productDetail.setColor(orderDetail.getColor());
        productDetail.setSize(orderDetail.getSize());
        productDetail.setSum(detailList.get(0).getSum() + orderDetail.getProductQuantity());
        productDetailImpl.updateProduct(productDetail);

        return orderDetailMapper.deleteBySth(orderDetail) != 0;
    }

    @Override
    public List<OrderDetail> searchOrdertail(OrderDetail orderDetail) {
        List<OrderDetail> orderDetails = orderDetailMapper.searchBySth(orderDetail);
        return orderDetails;
    }
}
