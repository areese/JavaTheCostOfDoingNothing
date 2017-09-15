// Copyright 2016 Yahoo Inc.
// Licensed under the terms of the New-BSD license. Please see LICENSE file in the project root for terms.
#include <string.h>

#include "com_yahoo_jmh_jmhtest_jni_JNIWrapper.h"
#include "jni_helper_defines.h"

/*
 * Class:     com_yahoo_jmh_jmhtest_jni_JNIWrapper
 * Method:    nativeParamNone
 * Signature: ()V
 */
JNIEXPORT void JNICALL Java_com_yahoo_jmh_jmhtest_jni_JNIWrapper_nativeParamNone
(JNIEnv *jenv, jclass)
{
    // we're doing nothing.  yay.
}

/*
 * Class:     com_yahoo_jmh_jmhtest_jni_JNIWrapper
 * Method:    nativeParamString
 * Signature: (Ljava/lang/String;)V
 */
JNIEXPORT void JNICALL Java_com_yahoo_jmh_jmhtest_jni_JNIWrapper_nativeParamString
(JNIEnv *jenv, jclass, jstring stringArg)
{
    // we're doing nothing.  yay.
    // we don't want to decode the string in this case.
}

/*
 * Class:     com_yahoo_jmh_jmhtest_jni_JNIWrapper
 * Method:    nativeParamStrings
 * Signature: (Ljava/lang/String;Ljava/lang/String;)V
 */
JNIEXPORT void JNICALL Java_com_yahoo_jmh_jmhtest_jni_JNIWrapper_nativeParamStrings
(JNIEnv *jenv, jclass, jstring lhsArg, jstring rhsArg) {
    // we want to use this string.
    ScopedStringUTFChars lhsString(jenv, lhsArg);
    ScopedStringUTFChars rhsString(jenv, rhsArg);
}

/*
 * Class:     com_yahoo_jmh_jmhtest_jni_JNIWrapper
 * Method:    nativeParamStringsUnicode
 * Signature: (Ljava/lang/String;Ljava/lang/String;)V
 */
JNIEXPORT void JNICALL Java_com_yahoo_jmh_jmhtest_jni_JNIWrapper_nativeParamStringsUnicode
(JNIEnv *jenv, jclass, jstring lhsArg, jstring rhsArg) {
    // we want to use this string.
    ScopedStringUnicodeChars lhsString(jenv, lhsArg);
    ScopedStringUnicodeChars rhsString(jenv, rhsArg);
}

/*
 * Class:     com_yahoo_jmh_jmhtest_jni_JNIWrapper
 * Method:    nativeParamArray
 * Signature: ([Ljava/lang/String;)V
 */
JNIEXPORT void JNICALL Java_com_yahoo_jmh_jmhtest_jni_JNIWrapper_nativeParamArray
(JNIEnv *jenv, jclass, jobjectArray stringArrayArg)
{
    // FIXME. need to convert to a char**
}

/*
 * Class:     com_yahoo_jmh_jmhtest_jni_JNIWrapper
 * Method:    nativeParamNoneReturnStringUTF8
 * Signature: ()Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL Java_com_yahoo_jmh_jmhtest_jni_JNIWrapper_nativeParamNoneReturnStringUTF8(
        JNIEnv *jenv, jclass) {
    return jenv->NewStringUTF("I'm doing nothing");

}

/*
 * Class:     com_yahoo_jmh_jmhtest_jni_JNIWrapper
 * Method:    nativeEquals
 * Signature: (Ljava/lang/String;Ljava/lang/String;)Z
 */
JNIEXPORT jboolean JNICALL Java_com_yahoo_jmh_jmhtest_jni_JNIWrapper_nativeEquals(
        JNIEnv *jenv, jclass, jstring lhsArg, jstring rhsArg) {
    // we want to use this string.
    ScopedStringUTFChars lhsString(jenv, lhsArg);
    ScopedStringUTFChars rhsString(jenv, rhsArg);

    return 0 == strcmp(lhsString.get(), rhsString.get());
}

/*
 * Class:     com_yahoo_jmh_jmhtest_jni_JNIWrapper
 * Method:    nativeParam2StringsNoScoping
 * Signature: (Ljava/lang/String;Ljava/lang/String;)V
 */
JNIEXPORT void JNICALL Java_com_yahoo_jmh_jmhtest_jni_JNIWrapper_nativeParam2StringsNoScoping
(JNIEnv *jenv, jclass, jstring lhs, jstring rhs)
{

}

/*
 * Class:     com_yahoo_jmh_jmhtest_jni_JNIWrapper
 * Method:    nativeParamStringsUTF8
 * Signature: (Ljava/lang/String;Ljava/lang/String;)V
 */
JNIEXPORT void JNICALL Java_com_yahoo_jmh_jmhtest_jni_JNIWrapper_nativeParamStringsUTF8
(JNIEnv *jenv, jclass, jstring lhs, jstring rhs)
{
    // we want to use this string.
    ScopedStringUTFChars lhsString(jenv, lhs);
    ScopedStringUTFChars rhsString(jenv, rhs);
}

/*
 * Class:     com_yahoo_jmh_jmhtest_jni_JNIWrapper
 * Method:    nativeParamStringUTF8
 * Signature: (Ljava/lang/String;)V
 */
JNIEXPORT void JNICALL Java_com_yahoo_jmh_jmhtest_jni_JNIWrapper_nativeParamStringUTF8
(JNIEnv *jenv, jclass, jstring lhs)
{
    // we want to use this string.
    ScopedStringUTFChars lhsString(jenv, lhs);
}

/*
 * Class:     com_yahoo_jmh_jmhtest_jni_JNIWrapper
 * Method:    nativeParamStringUnicode
 * Signature: (Ljava/lang/String;)V
 */
JNIEXPORT void JNICALL Java_com_yahoo_jmh_jmhtest_jni_JNIWrapper_nativeParamStringUnicode
(JNIEnv *jenv, jclass, jstring lhs)
{
    // we want to use this string.
    ScopedStringUnicodeChars lhsString(jenv, lhs);
}

/*
 * Class:     com_yahoo_jmh_jmhtest_jni_JNIWrapper
 * Method:    fillBytesInFromNative
 * Signature: (JJ)V
 */
JNIEXPORT void JNICALL Java_com_yahoo_jmh_jmhtest_jni_JNIWrapper_fillBytesInFromNative
(JNIEnv *jenv, jclass, jlong address, jlong size) {
    if (0 == address) {
        return;
    }

    memset((void*)address, 0xDA, size);
}

/*
 * Class:     com_yahoo_jmh_jmhtest_jni_JNIWrapper
 * Method:    dumpBytesFromAddress
 * Signature: (JJJ)V
 */
JNIEXPORT void JNICALL Java_com_yahoo_jmh_jmhtest_jni_JNIWrapper_dumpBytesFromAddress
(JNIEnv *jenv, jclass, jlong address, jlong start, jlong size) {
    if (0 == address) {
        return;
    }

    const char *ptr=(const char *)address;

    for (jlong i=start;i<size;i++) {
        printf ("0x%02x ", (unsigned char)ptr[i]);
    }
    printf ("\n");
}

