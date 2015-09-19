package com.jiuxiao.zoubei.letusgo.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * 字符判断工具
 * Created by yx on 2015/9/18.
 */
public class StringUtils {

    /**
     * Judge String isEmpty
     * @param str
     * @return
     */
    public static boolean isEmpty(String str){
        if (str==null||str.length()==0){
            return true;
        }
        return false;
    }


    /**
     *判断输入的账号和密码是否正确
     * @param mStrPhone
     * @param mStrPwd
     * @param context
     * @return
     */
    public static boolean judgeUserFormat(String mStrPhone, String mStrPwd, Context context){
        if(!StringUtils.isEmpty(mStrPhone)){
                //不为空，执行
                if(mStrPhone.length()==11){
                    /**
                     * Account verification is successful
                     */
                    if ( StringUtils.judgePassword(mStrPwd, context))
                    {
                        Toast.makeText(context,"完成",Toast.LENGTH_LONG).show();
                        return true;
                    }
                }else{
                    Toast.makeText(context,"请输入11位账号",Toast.LENGTH_LONG).show();
                    return false;
                }
            }else {
            Toast.makeText(context,"账号不能为空",Toast.LENGTH_LONG).show();
            return false;
        }

        return false;
    }

    /**
     * 判断号码是否正确
     * @param mStrPhone
     * @param context
     * @return
     */
    public static boolean judgeNumFormat(String mStrPhone,Context context){
        if(!StringUtils.isEmpty(mStrPhone)){
            //不为空，执行
            if(mStrPhone.length()==11){
                /**
                 * 判断账号是否正确
                 */
             return true;
            }else{
                Toast.makeText(context,"请输入11位账号",Toast.LENGTH_LONG).show();
                return false;
            }
        }else {
            Toast.makeText(context,"账号不能为空",Toast.LENGTH_LONG).show();
            return false;
        }
    }


    /**
     *判断密码输入格式是否正确
     * @param str
     * @param context
     * @return
     */
    public static boolean judgePassword(String str,Context context){
           if (isEmpty(str)){
               Toast.makeText(context,"密码不能为空",Toast.LENGTH_SHORT).show();
           }else{
               String regex = "^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,12}$";
               boolean result = str.matches(regex);
               if (result){
                   return true;
               }else
               {
                   Toast.makeText(context,"密码输入错误",Toast.LENGTH_SHORT).show();
                   return false;
               }
           }
            return false;
    }

}
