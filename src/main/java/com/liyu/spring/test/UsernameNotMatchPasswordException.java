package com.liyu.spring.test;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by twcn on 10/7/16.
 */

@ResponseStatus(value= HttpStatus.FORBIDDEN, reason = "username not match password")
public class UsernameNotMatchPasswordException extends RuntimeException {
}
