package com.guga.numbers;

import org.assertj.core.api.WithAssertions;
import org.junit.Test;

import java.util.function.UnaryOperator;


public class AllNumbersTest implements WithAssertions {

    private UnaryOperator<String> functionDescription = className -> "Instance of "+className+" class";

    @Test
    public void givenAPrimitiveWhenCheckTheInstanceThenReturnTheWrapperClass() {

        int myFirstInt = 42;
        assertThat(myFirstInt).as(functionDescription.apply("Integer")).isInstanceOf(Integer.class);

        float myFirstFloat = 42;
        assertThat(myFirstFloat).as(functionDescription.apply("Float")).isInstanceOf(Float.class);

        double myFirstDouble = 42;
        assertThat(myFirstDouble).as(functionDescription.apply("Double")).isInstanceOf(Double.class);

        boolean myFirstBoolean = false;
        assertThat(myFirstBoolean).as(functionDescription.apply("Boolean")).isInstanceOf(Boolean.class);

    }



}
