package com.example.demo.service.impl;

import com.example.demo.dao.*;
import com.example.demo.entity.*;
import com.example.demo.service.OrderFormService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.List;

@Service

public class OrderFormImpl implements OrderFormService {
    @Resource
    OrderFormMapper orderFormMapper;
    @Resource
    UserMapper userMapper;
    @Resource
    CartMapper cartMapper;
    @Resource
    ProductDetailMapper productDetailMapper;
    @Resource
    OrderDetailMapper orderDetailMapper;
    @Resource
    ProductMapper productMapper;
    @Resource
    AddressMapper addressMapper;

    @Override
    public boolean updateOrderForm(OrderForm orderForm) {
        if (orderForm == null)
            return false;
        return orderFormMapper.update(orderForm);
    }

    @Override
    public OrderForm searchById(Integer id) {
        OrderForm orderForm = new OrderForm();
        orderForm.setOrderId(id);
        List<OrderForm> orderForms = orderFormMapper.searchanything(orderForm);
        return orderForms.get(0);
    }

    @Override
    public boolean deleteOrderFormByAnything(OrderForm orderForm) {
        orderFormMapper.delete(orderForm);
        return false;
    }

    @Override
    public boolean createOrderInCart(String userName, Integer addressId) {
        /*
         * 查找到用户id，由于前期数据库设计问题
         */
        Address address = addressMapper.select(addressId);
        User user = new User();
        user.setUserName(userName);
        User user1 = userMapper.searchByName(user);
        /*
         * 查询指定用户id下的购物车列表，并加入到购物车详情中。
         */
        List<Cart> carts = cartMapper.searchById(user1.getUserId());
        OrderForm orderForm = new OrderForm();
        orderForm.setUserName(userName);
        orderForm.setPaymentTime(new Timestamp(System.currentTimeMillis()));
        orderForm.setCreationTime(new Timestamp(System.currentTimeMillis()));
        orderForm.setShippingAddress(address.getSpecificAddress());

        orderFormMapper.add(orderForm);
        List<OrderForm> orderForms = orderFormMapper.searchanything(orderForm);
        OrderForm orderForm1 = orderForms.get(0);
        int temp = 0;
        for (int i = 0; i < carts.size(); i++) {
            /*
              找到当前商品价钱
             */
            ProductDetail productDetail = new ProductDetail(carts.get(i).getProductId(), carts.get(i).getSize(),
                    carts.get(i).getColor(), null);
            /*
              更新数据库的商品
             */
            List<ProductDetail> productDetails = productDetailMapper.searchProductDetail(productDetail);
            productDetails.get(i).setSum(productDetails.get(0).getSum() - carts.get(i).getSum());
            productDetailMapper.updateProductDetail(productDetails.get(i));
            /*
              查询到当前id对应的商品
             */
            Product product = new Product();
            product.setProductId(carts.get(i).getProductId());
            Product product1 = productMapper.getProductInfoById(product);
            /*
              插入订单信息到订单详情表中
             */
            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setOrderId(orderForm1.getOrderId());
            orderDetail.setProductId(carts.get(i).getProductId());
            orderDetail.setSize(carts.get(i).getSize());
            orderDetail.setColor(carts.get(i).getColor());
            orderDetail.setProductPrice(Double.parseDouble(product1.getCurrentPrice()));
            orderDetail.setProductQuantity(carts.get(i).getSum());
            orderDetailMapper.add(orderDetail);
            temp += carts.get(i).getSum() * Integer.parseInt(product1.getCurrentPrice());
        }
        orderForm.setIntegral(temp);
        orderFormMapper.update(orderForm);
        return true;
    }

    @Override
    public boolean createOrderByInstance(String userName, ProductDetail productDetail, Integer addressId) {
        /*
         * 查找到用户id，由于前期数据库设计问题
         */
        OrderForm orderForm = new OrderForm();
        orderForm.setUserName(userName);
        orderFormMapper.searchanything(orderForm);
        User user = new User();
        user.setUserName(orderForm.getUserName());
        User user1 = userMapper.searchByName(user);

        orderFormMapper.add(orderForm);
        List<OrderForm> orderForms = orderFormMapper.searchanything(orderForm);
        OrderForm orderForm1 = orderForms.get(0);
        /*
         * 获取当前商品的价格
         */
        Product product = new Product();
        product.setProductId(productDetail.getProductId());
        Product product1 = productMapper.getProductInfoById(product);
        /*
         * 更新数据库的数量信息
         */
        ProductDetail productDetail1 = new ProductDetail();
        productDetail1.setSum(productDetail1.getSum());
        productDetail1.setProductId(productDetail.getProductId());
        productDetail1.setColor(productDetail.getColor());
        List<ProductDetail> list = productDetailMapper.searchProductDetail(productDetail1);
        productDetail.setSum(list.get(0).getSum() - productDetail.getSum());
        productDetailMapper.updateProductDetail(productDetail);
        /*
         * 将立即下单的商品生成订单
         */
        OrderDetail orderDetail = new OrderDetail(orderForm1.getOrderId(), productDetail.getProductId(),
                productDetail.getSize(), productDetail.getColor(),
                productDetail.getSum(), Double.parseDouble(product1.getCurrentPrice()) * productDetail.getSum());
        orderDetailMapper.add(orderDetail);
        return true;
    }

}
