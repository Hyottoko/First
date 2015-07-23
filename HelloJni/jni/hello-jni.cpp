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
 *
 */
#include <string.h>
#include <jni.h>
#include <android/log.h>
//#include <iostream.h> 
#include <stdio.h>

#define CLASS_PATH "com/example/hellojni/HelloJni"
#define JAVA_CLASS_PATH "com/example/hellojni/JavaObj"
#ifndef ARRAYSIZE
#define ARRAYSIZE(array) (sizeof(array)/sizeof(array[0]))
#endif

#define  LOG_TAG    "FFMPEGSample"
#define  LOGI(...)  __android_log_print(ANDROID_LOG_INFO,LOG_TAG,__VA_ARGS__)
#define  LOGE(...)  __android_log_print(ANDROID_LOG_ERROR,LOG_TAG,__VA_ARGS__)
/*
//硬盘信息
struct  {
    char name[256];
    int serial;
}DiskInfo;

void stringTest(JNIEnv *env)
{
	const char *str;

	jfieldID id_str = env->GetFieldID(clz,"str","Ljava/lang/String;"); 
  	jstring jstr=(jstring)(env->GetObjectField(obj,id_str)); 

	str = env->GetStringUTFChars( jstr, NULL);  
	if(str != NULL)
	{
		jstr = env->NewStringUTF("setStringValue");
		if(jstr != NULL)
		jstr->setObjectField(obj,id_str,jstr);
	}   

}*/
 
/*the*/
jint callbackTest(JNIEnv *env, jobject j)
{
	 


	LOGE("Hello,world");
	LOGI("calltest !!!");
		jstring str = NULL;

		jclass clz = env->FindClass(CLASS_PATH);
		//获取clz的构造函数并生成一个对象
		jmethodID ctor = env->GetMethodID(clz, "<init>", "()V");
		jobject obj = env->NewObject(clz, ctor);

 
 
 
 /*!!!!!!!!!!!!!!!!!!!!!!!!!!!callback!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!*/

 
		// 如果是数组类型，则在类型前加[,如整形数组int[] intArray,则对应类型为[I,整形数组String[] strArray对应为[Ljava/lang/String;
		jmethodID mid = env->GetMethodID(clz, "sayHelloFromJava", "(Ljava/lang/String;II[I)I");
		if (mid)
		{
			LOGI("mid is get");
			jstring str1 = env->NewStringUTF("I am Native");
			jint index1 = 10;
			jint index2 = 12;
			//env->CallVoidMethod(obj, mid, str1, index1, index2);

			// 数组类型转换 testIntArray能不能不申请内存空间
			jintArray testIntArray = env->NewIntArray(10);
			jint *test = new jint[10];
			for(int i = 0; i < 10; ++i)
			{
				*(test+i) = i + 100;
			}
			env->SetIntArrayRegion(testIntArray, 0, 10, test);


			jint javaIndex = env->CallIntMethod(obj, mid, str1, index1, index2, testIntArray);
			LOGI("javaIndex = %d", javaIndex);
			delete[] test;
			test = NULL;
		}


  
 

	return 0;
}


jint jniTest(JNIEnv *env, jobject j)
{
	const char *str;
	LOGE("jniTest");
/*init the class*/
	jclass clz = env->FindClass(CLASS_PATH);//check the class is exist??
		//获取clz的构造函数并生成一个对象
	jmethodID ctor = env->GetMethodID(clz, "<init>", "()V");
	jobject obj = env->NewObject(clz, ctor);
/*get string*/
	jfieldID id_str = env->GetFieldID(clz,"str","Ljava/lang/String;"); 
  	jstring jstr=(jstring)(env->GetObjectField(obj,id_str)); 
	 
 
	str = env->GetStringUTFChars( jstr, NULL); 
	if (str == NULL) 
	{           
	   return -1;       
	}
	LOGE("before jstr ==== %S",str);
 	env->ReleaseStringUTFChars( jstr, str); 
	 
	jstr = env->NewStringUTF("setStringValue");
	LOGE("after jstr ==== %S",jstr);
		if(jstr != NULL)
		{
			LOGE("set the string value");
			env->SetObjectField(obj,id_str,jstr);
		}
	 

/*get int*/
	jfieldID id_number = env->GetFieldID(clz,"number","I");
	jint number = env->GetIntField(obj,id_number);  
	jint tmp = 12;
	LOGE("tmp === %d",tmp);
	LOGE("number as === %d",number); 
env->SetIntField(obj,id_number,100L);

/*get    xObj javaObj; javaObj   JavaObj javaObj;*/
/*
jfieldID id_obj = env->GetFieldID(clz,"javaObj","L/com/example/hellojni/JavaObj");

jobject empobj = env->GetObjectField(obj, id_obj);
jclass   clzN = env->GetObjectClass(empobj); 
//can not register the class
 
		//获取clz的构造函数并生成一个对象
	jmethodID ctorN = env->GetMethodID(clzN, "<init>", "()V");
	jobject objN = env->NewObject(clzN, ctorN);

jfieldID id_numberN = env->GetFieldID(clzN,"value","I");
jint numberN = env->GetIntField(objN,id_numberN);  
	 
	 
	LOGE("numberN === %d",numberN);

	env->SetObjectField(obj,id_obj,objN);*/
	return 0;
}
void callbackTest1(JNIEnv *env, jobject j)
{
	jclass clz = env->FindClass(CLASS_PATH);//check the class is exist??
		//获取clz的构造函数并生成一个对象
	jmethodID ctor = env->GetMethodID(clz, "<init>", "()V");
	jobject obj = env->NewObject(clz, ctor);
	jmethodID mid = env->GetMethodID(clz, "callbackSan", "()V");
	LOGE("callbackTest1");
	env->CallVoidMethod(obj, mid);
	
}
void staticCallbackAdd(JNIEnv *env, jobject j)
{
	jclass clz = env->FindClass(CLASS_PATH);//check the class is exist??
	 
	jmethodID mid = env->GetMethodID(clz, "staticTestMethod", "()V");
	LOGE("callbackTest1");
	env->CallStaticVoidMethod(clz, mid);
	
}

jint basicType(JNIEnv *env, jobject j,jint age,jchar sex,jlong score)
{
	printf("age1 ==== %d",age);
	LOGE("age ==== %d",age); 
	LOGE("sex ==== %c",sex);
	LOGE("score ==== %ld",score);
	return 0;
}

jstring stringPara(JNIEnv *env, jobject j,jstring jstr)//C plus is not support the jstring,so we should change char*
{	
	const char *str =  env->GetStringUTFChars( jstr, NULL); 
	LOGE("str === %s",str);
	env->ReleaseStringUTFChars( jstr, str); 

	jstr = env->NewStringUTF("setStringValue");
	
	return jstr;
}

void arrayPara(JNIEnv *env, jobject j, jbooleanArray ba)
{
    jboolean* pba = (env)->GetBooleanArrayElements(ba, 0 );
    jsize len = (env)->GetArrayLength(ba);
    int i=0;
    // change even array elements
    for( i=0; i < len; i+=2 )
    {
        pba[i] = JNI_FALSE;
        printf( "boolean = %s\n", (pba[i]==JNI_TRUE ? "true" : "false") );
    }
    (env)->ReleaseBooleanArrayElements(ba, pba, 0 );
}

//
jobjectArray  getStringArray(JNIEnv *env, jobject)
{
    jstring      str;
    jobjectArray args = 0;
    jsize        len = 5;
    char*        sa[] = { "Hello,", "world!", "JNI", "is", "fun" };
    int          i=0;
    args = (env)->NewObjectArray(len,(env)->FindClass("java/lang/String"),0);
    for( i=0; i < len; i++ )
    {
        str = (env)->NewStringUTF(sa[i] );
        (env)->SetObjectArrayElement(args, i, str);
    }
    return args;
}

 //返回一个结构,这里返回一个硬盘信息的简单结构类型
jobject  getStruct(JNIEnv *env, jobject obj1)
{
    /* 下面为获取到Java中对应的实例类中的变量*/



    //获取Java中的实例类
    jclass objectClass = (env)->FindClass("com/example/hellojni/DiskInfo");
	 jmethodID ctor = env->GetMethodID(objectClass, "<init>", "()V");
	jobject obj = env->NewObject(objectClass, ctor);

    //获取类中每一个变量的定义
    //名字
    jfieldID str = (env)->GetFieldID(objectClass,"name","Ljava/lang/String;");
    //序列号	
     jfieldID ival = (env)->GetFieldID(objectClass,"serial","I");


    //给每一个实例的变量付值
    (env)->SetObjectField(obj,str,(env)->NewStringUTF("my name is D:"));
     (env)->SetIntField(obj,ival,10);
    
    return obj;
}

//返回一个结构数组，返回一个硬盘信息的结构数组
jobjectArray   getStructArrayTest(JNIEnv *env, jobject _obj)
{
 
 //申明一个object数组 
    jobjectArray args = 0;
    
    //数组大小
    jsize        len = 5;

    //获取object所属类,一般为ava/lang/Object就可以了
    jclass objClass = (env)->FindClass("java/lang/Object");
LOGE("geifield id 111");
    //新建object数组
    args = (env)->NewObjectArray(len, objClass, 0);

 

    //获取Java中的实例类
    
  LOGE("geifield id 222");  
    //获取类中每一个变量的定义
    //名字
 
    //给每一个实例的变量付值，并且将实例作为一个object，添加到objcet数组中
    for(int  i=0; i < len; i++ )
    {
	LOGE("geifield id 333");
	jclass objectClass = (env)->FindClass("com/example/hellojni/DiskInfo");
 	 jmethodID ctor = env->GetMethodID(objectClass, "<init>", "()V");
	jobject obj = env->NewObject(objectClass, ctor);

    //获取类中每一个变量的定义
    //名字
    jfieldID str = (env)->GetFieldID(objectClass,"name","Ljava/lang/String;");
    //序列号	
     jfieldID ival = (env)->GetFieldID(objectClass,"serial","I");


    //给每一个实例的变量付值
    (env)->SetObjectField(obj,str,(env)->NewStringUTF("my name is D:"));
     (env)->SetIntField(obj,ival,10+i);

        //添加到objcet数组中
        (env)->SetObjectArrayElement(args, i, obj);
    }
    //返回object数组
    return args;
 
 return NULL;
 }

static JNINativeMethod mymethods[] =
{
	{"callbackTest", "()I", (void*)callbackTest},
	{"jniTest", "()I", (void*)jniTest},
	{"staticCallbackAdd", "()V", (void*)staticCallbackAdd},
	{"callbackTest1", "()V", (void*)callbackTest1},
	{"basicType", "(ICD)I", (void*)basicType},
	{"stringPara", "(Ljava/lang/String;)Ljava/lang/String;", (void*)stringPara},
  	{"arrayPara", "([Z)V", (void*)arrayPara},
	{"getStringArray", "()[Ljava/lang/String;", (void*)getStringArray},
	 {"getStruct", "()Lcom/example/hellojni/DiskInfo;", (void*)getStruct},
	{"getStructArrayTest", "()[Lcom/example/hellojni/DiskInfo;", (void*)getStructArrayTest},


};


jint JNI_OnLoad(JavaVM * vm,void * reserved)
{
	LOGE("JNI_OnLoad");
	JNIEnv *env = NULL;
	jint ret = 0;
	jclass myclass;


	ret = vm->GetEnv((void **)&env, JNI_VERSION_1_4);
	if(ret < 0)
	{
		LOGE("error");
		return ret;
	}

	myclass = env->FindClass(CLASS_PATH);
	

	ret = env->RegisterNatives(myclass, mymethods, ARRAYSIZE(mymethods));
	if(ret < 0)
	{
		//LOGE("(%s)RegisterNatives : %d-----%s\n", __FUNCTION__, errno,strerror(errno));
		return ret;
	}

	return JNI_VERSION_1_4;
}
