/* DO NOT EDIT THIS FILE - it is machine generated */
#include <jni.h>
/* Header for class com_yahoo_jmh_jmhtest_jni_JNIWrapper */

#ifndef _Included_com_yahoo_jmh_jmhtest_jni_JNIWrapper
#define _Included_com_yahoo_jmh_jmhtest_jni_JNIWrapper
#ifdef __cplusplus
extern "C" {
#endif
/*
 * Class:     com_yahoo_jmh_jmhtest_jni_JNIWrapper
 * Method:    nativeParamNone
 * Signature: ()V
 */
JNIEXPORT void JNICALL Java_com_yahoo_jmh_jmhtest_jni_JNIWrapper_nativeParamNone
  (JNIEnv *, jclass);

/*
 * Class:     com_yahoo_jmh_jmhtest_jni_JNIWrapper
 * Method:    nativeParamString
 * Signature: (Ljava/lang/String;)V
 */
JNIEXPORT void JNICALL Java_com_yahoo_jmh_jmhtest_jni_JNIWrapper_nativeParamString
  (JNIEnv *, jclass, jstring);

/*
 * Class:     com_yahoo_jmh_jmhtest_jni_JNIWrapper
 * Method:    nativeParamStrings
 * Signature: (Ljava/lang/String;Ljava/lang/String;)V
 */
JNIEXPORT void JNICALL Java_com_yahoo_jmh_jmhtest_jni_JNIWrapper_nativeParamStrings
  (JNIEnv *, jclass, jstring, jstring);

/*
 * Class:     com_yahoo_jmh_jmhtest_jni_JNIWrapper
 * Method:    nativeParamArray
 * Signature: ([Ljava/lang/String;)V
 */
JNIEXPORT void JNICALL Java_com_yahoo_jmh_jmhtest_jni_JNIWrapper_nativeParamArray
  (JNIEnv *, jclass, jobjectArray);

/*
 * Class:     com_yahoo_jmh_jmhtest_jni_JNIWrapper
 * Method:    nativeParamNoneReturnString
 * Signature: ()Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL Java_com_yahoo_jmh_jmhtest_jni_JNIWrapper_nativeParamNoneReturnString
  (JNIEnv *, jclass);

/*
 * Class:     com_yahoo_jmh_jmhtest_jni_JNIWrapper
 * Method:    nativeEquals
 * Signature: (Ljava/lang/String;Ljava/lang/String;)Z
 */
JNIEXPORT jboolean JNICALL Java_com_yahoo_jmh_jmhtest_jni_JNIWrapper_nativeEquals
  (JNIEnv *, jclass, jstring, jstring);

#ifdef __cplusplus
}
#endif
#endif
