// Copyright 2016 Yahoo Inc.
// Licensed under the terms of the New-BSD license. Please see LICENSE file in the project root for terms.
#include <string.h>

#include "com_yahoo_jmh_jmhtest_jni_LotsOfLongs.h"
#include "jni_helper_defines.h"

/*
 * Class:     com_yahoo_jmh_jmhtest_jni_LotsOfLongs
 * Method:    testLongArray
 * Signature: ([J)V
 */
JNIEXPORT void JNICALL Java_com_yahoo_jmh_jmhtest_jni_LotsOfLongs_testLongArray
(JNIEnv *jenv, jclass, jlongArray array)
{
    jlong inetAddress;
    jlong inetAddressLen;
    jlong ra;
    jlong raLen;
    jlong rp;
    jlong rpLen;
    jlong rs;
    jlong rsLen;

    jint len = jenv->GetArrayLength(array);
    if (8 != len) {
        return;
    }

    jlong *arrayPointer = (jlong*)jenv->GetPrimitiveArrayCritical(array, 0);
    inetAddress=arrayPointer[0];
    inetAddressLen=arrayPointer[1];
    ra=arrayPointer[2];
    raLen=arrayPointer[3];
    rp=arrayPointer[4];
    rpLen=arrayPointer[5];
    rs=arrayPointer[6];
    rsLen=arrayPointer[7];
    jenv->ReleasePrimitiveArrayCritical(array, arrayPointer, 0);

}

/*
 * Class:     com_yahoo_jmh_jmhtest_jni_LotsOfLongs
 * Method:    testLongParams
 * Signature: (JJJJJJJJ)V
 */
JNIEXPORT void JNICALL Java_com_yahoo_jmh_jmhtest_jni_LotsOfLongs_testLongParams
(JNIEnv *, jclass,
        jlong inetAddress, jlong inetAddressLen, jlong ra, jlong raLen, jlong rp,
        jlong rpLen, jlong rs, jlong rsLen) {

}
