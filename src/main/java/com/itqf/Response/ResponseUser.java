package com.itqf.Response;

import com.itqf.domain.User;
import lombok.Data;

import java.util.List;

/**
 * Author 贾振乾
 * Date 2019/9/25
 * Time 19:08
 *
 */
@Data
public class ResponseUser<T>{

    private List<T> list;

    private Long total;
}
