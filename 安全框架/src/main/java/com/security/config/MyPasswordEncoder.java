package com.security.config;

import org.springframework.security.crypto.password.PasswordEncoder;

/*设置密码的编码*/
/*passwordEncoder 是安全框架里面的特有功能*/
public class MyPasswordEncoder implements PasswordEncoder {

    @Override
    public String encode(CharSequence charSequence) {
        return charSequence.toString();
    }

    @Override
    public boolean matches(CharSequence charSequence, String s) {
        return s.equals(charSequence.toString());
    }
}
