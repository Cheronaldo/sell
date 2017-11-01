package com.cherry.converter;

import com.cherry.dataobject.OrderMaster;
import com.cherry.dto.OrderDTO;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 用于需要将 OrderMaster list对象  转换为 OrderDTO list对象
 * Created by Administrator on 2017/09/29.
 */
public class OrderMaster2OrderDTOConverter {

    public static OrderDTO convert(OrderMaster orderMaster){

        OrderDTO orderDTO = new OrderDTO();
        BeanUtils.copyProperties(orderMaster,orderDTO);
        return orderDTO;

    }

    public static List<OrderDTO> convert(List<OrderMaster> orderMasterList){
        return orderMasterList.stream().map(e ->
                convert(e)
        ).collect(Collectors.toList());


    }

}
