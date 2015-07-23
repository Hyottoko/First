/*
 * Copyright (C) 2009 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.hellojni;

import android.app.Activity;
import android.util.Log;
import android.widget.TextView;
import android.os.Bundle;


public class HelloJni extends Activity
{
	 
//	public class DiskInfo {
//		 // 名字 
//	   public  String name;
//
//	  // 序列号 
//	   public   int  serial;
//
//	   public DiskInfo() {
//		super();
//		// TODO Auto-generated constructor stub
//	}
	   
//	}
	
	int number = 3;
	String str = "11san";
	public static void staticTestMethod( )
	{	int result = 10;
		 
		System.out.println("result === "+result);
	 
	}
	void  callbackSan()//没有返回值好像会报错。,callBack  分为CallSVoidMethod，CallIntMethod
	{ 
	    		System.out.println(" callbackTest1 in java");
	    		 
	}
	public int sayHelloFromJava(String str, int index1, int index2, int[] intArray)  
    {  
        Log.i("TEST", str + " But I am show in java");   
        Log.i("TEST", "index1 = " + index1 + " index2 = " + index2 );  
        int javaIndex = 5;  
        return javaIndex;  
    }  
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        /* Create a TextView and set its content.
         * the text is retrieved by calling a native
         * function.
         */
      System.out.println("starting ");
      System.out.println("str ==== "+str);
      jniTest();
      callbackTest();
      callbackTest1();
     // staticCallbackAdd(); 
      basicType(1,'c',12.5);
      String testStr =  stringPara("sanmao" );
      System.out.println("java string === "+testStr);
      System.out.println("after str ==== "+str);
      
      boolean[] testBoolean = new boolean[2];
      testBoolean[0] = true;
      testBoolean[1] = false;
      arrayPara(testBoolean );
      System.out.println(" testBoolean[0]  === "+ testBoolean[0] );
     
      String[] strList= getStringArray();
      for (int i = 0; i < strList.length; i++) {
          System.out.println(strList[i]);
      }
      
      DiskInfo info =  getStruct();
      System.out.println("info ==== "+info.name);
      System.out.println("info ==== "+info.serial);
      DiskInfo[] infoArray = getStructArrayTest(); 
      int len = infoArray.length;
      System.out.println("infoArray len === "+len);
      for(int i = 0;i < len;i++)
      {
    	  System.out.println("info ==== "+infoArray[i].name);
          System.out.println("info ==== "+infoArray[i].serial);
      }
      
      System.out.println("stop "); 
    }
/*
 * if you can not remember the data type,just call the native method,the error log will show the data type.
 * 
 * stringPara:(Ljava/lang/String;)Ljava/lang/String;
 * arrayPara:([Z)V
 * getStringArray:()[Ljava/lang/String; 
 * getStruct:()Lcom/example/hellojni/DiskInfo;
 * getStructArray:()[Lcom/example/hellojni/DiskInfo;

 ()Lcom/example/hellojni/HelloJni$DiskInfo;


*/ 
   
    public native int  callbackTest();//带参数
    public native void  callbackTest1();//不带参数
    public  native  void  staticCallbackAdd();//调用静态函数
    public native int  jniTest();
    
    public native int basicType(int age,char sex,double d );//传基本参数
    public native String stringPara(String str );//传字符串和返回字符串
    public native void arrayPara(boolean[] blList);//传数组
    public native String[] getStringArray();//获取字符串数组
    public  native DiskInfo getStruct();//实例化Java类，不是JNI接口的类。
    public  native DiskInfo[] getStructArrayTest();//实例化多个Java类。
    
    
    static 
    {
        System.loadLibrary("hello-jni");
    }
}
