#include <jni.h>
#include <stdlib.h>
#include <string.h>
#include "com_yahoo_jmh_jmhtest_jni_AllocationJNI.h"

/*
 * Class:     com_yahoo_jmh_jmhtest_jni_AllocationJNI
 * Method:    allocate
 * Signature: (I)J
 */
JNIEXPORT jlong JNICALL Java_com_yahoo_jmh_jmhtest_jni_AllocationJNI_allocate(
        JNIEnv *jenv, jclass, jint size) {
    if (0 == size) {
        return 0;
    }

    return (jlong) calloc(1, size);
}

/*
 * Class:     com_yahoo_jmh_jmhtest_jni_AllocationJNI
 * Method:    release
 * Signature: (J)V
 */
JNIEXPORT void JNICALL Java_com_yahoo_jmh_jmhtest_jni_AllocationJNI_release
(JNIEnv *jenv, jclass, jlong address)
{
    if (0!=address) {
        free((void*)address);
    }
}

const char static_value[] = { 1, 2, 3, 4 };

/*
 * Class:     com_yahoo_jmh_jmhtest_jni_AllocationJNI
 * Method:    doSomething
 * Signature: (JI)I
 */
JNIEXPORT jint JNICALL Java_com_yahoo_jmh_jmhtest_jni_AllocationJNI_doSomething(
        JNIEnv *jenv, jclass, jlong address, jint size) {
    // we need to at least touch the address.
    if (0 == address) {
        return -1;
    }

    if (size > sizeof(static_value)) {
        size = sizeof(static_value);
    }

    return memcmp(static_value, (const char *) address, size);
}

