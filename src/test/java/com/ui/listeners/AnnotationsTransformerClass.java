package com.ui.listeners;

import org.testng.annotations.ITestAnnotation;
import org.testng.internal.annotations.IAnnotationTransformer;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class AnnotationsTransformerClass implements IAnnotationTransformer {
    @Override
    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod, Class<?> occurringClazz) {
        annotation.setRetryAnalyzer(MyRetryAnalyzer.class);
    }
}
