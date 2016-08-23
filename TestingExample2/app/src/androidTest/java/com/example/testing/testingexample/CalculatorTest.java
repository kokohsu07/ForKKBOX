package com.example.testing.testingexample;

import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiAutomatorTestCase;
import android.support.test.uiautomator.UiCollection;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObject2;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiSelector;
import android.support.test.uiautomator.Until;
import android.test.InstrumentationTestCase;

/**
 * Created by kokohsu on 16/8/20.
 */
public class CalculatorTest extends UiAutomatorTestCase {

    private UiDevice device;
    String resultText;

    UiObject getByDescription(String description) {
        return new UiObject(new UiSelector().description(description));
    }
    UiObject getByreourceID(String resourceID){
        return new UiObject(new UiSelector().resourceId(resourceID));
    }

    protected void setUp() throws Exception{
        super.setUp();

        getUiDevice().pressHome();
        getByDescription("Apps").clickAndWaitForNewWindow();
        getByDescription("Calculator").clickAndWaitForNewWindow();
    }

    public void testAdd() throws Exception {
        pressSeven();
        pressAdd();
        pressEight();
        pressEquals();

        resultText = getFormula();
        assertEquals("加法測試的结果錯誤", "15", resultText);
        pressClear();
    }

    public void testSub() throws Exception {
        pressNine();
        pressSub();
        pressFive();
        pressEquals();

        resultText = getFormula();
        assertEquals("減法測試的结果錯誤", "4", resultText);
        pressClear();
    }

    public void testMul() throws Exception {
        pressFour();
        pressMul();
        pressSix();
        pressEquals();

        resultText = getFormula();
        assertEquals("乘法測試的结果錯誤", "24", resultText);
        pressClear();
    }

    public void testDiv() throws Exception {
        pressOne();
        pressZero();
        pressDiv();
        pressFive();
        pressEquals();

        resultText = getFormula();
        assertEquals("除法測試的结果錯誤", "2", resultText);
        pressClear();
    }

    public void testClear() throws Exception{
        pressThree();
        pressMul();
        pressTwo();
        pressEquals();
        pressClear();

        resultText = getFormula();
        assertEquals("Clear 功能測試的结果錯誤：", "", resultText);

    }

    public void testDel() throws Exception{
        for(int i=0 ; i<2 ; i++ ) {
            pressOne();
        }
        pressDel();
        resultText = getFormula();
        assertEquals("Delete 功能測試的结果錯誤：", "1", resultText);
        pressDel();

    }

    public void testUnlimited() throws Exception{
        pressOne();
        pressDiv();
        pressZero();
        pressEquals();

        resultText = getFormula();
        assertEquals("無限大測試的结果錯誤：", "∞", resultText);
        pressClear();
    }

    public void testDecimal() throws Exception{
        funDecimal();
        pressAdd();
        funDecimal();
        pressEquals();

        resultText = getFormula();
        assertEquals("小數運算測試的结果錯誤：", "0.4", resultText);
        pressClear();

    }

    public void testPressPoint() throws Exception{
        for(int i =0 ; i<3 ; i++){
            pressPoint();
        }
        resultText = getFormula();
        assertEquals("小數點測試的结果錯誤：", ".", resultText);
        pressDel();

    }
    public void testSwitchOperator() throws Exception{
        pressThree();
        pressDiv();
        pressAdd();

        resultText = getFormula();
        assertEquals("運算元切換測試的结果錯誤：", "3+", resultText);
        pressDel();
        pressDel();

    }

    public void testError() throws Exception{
        pressSub();
        pressDiv();
        pressSix();
        pressEquals();

        resultText = getResult();
        assertEquals("無效運算測試的結果錯誤：","Error",resultText);
        pressClear();
    }

    protected void tearDown() throws Exception{
        super.tearDown();
    }

    public void funDecimal() throws Exception {
        pressZero();
        pressPoint();
        pressTwo();
    }

    public void pressZero() throws Exception{
        getByreourceID("com.android.calculator2:id/digit_0").click();
    }
    public void pressOne() throws Exception{
        getByreourceID("com.android.calculator2:id/digit_1").click();
    }
    public void pressTwo() throws Exception{
        getByreourceID("com.android.calculator2:id/digit_2").click();
    }
    public void pressThree() throws Exception{
        getByreourceID("com.android.calculator2:id/digit_3").click();
    }
    public void pressFour() throws Exception{
        getByreourceID("com.android.calculator2:id/digit_4").click();
    }
    public void pressFive() throws Exception{
        getByreourceID("com.android.calculator2:id/digit_5").click();
    }
    public void pressSix() throws Exception{
        getByreourceID("com.android.calculator2:id/digit_6").click();
    }
    public void pressSeven() throws Exception{
        getByreourceID("com.android.calculator2:id/digit_7").click();
    }
    public void pressEight() throws Exception{
        getByreourceID("com.android.calculator2:id/digit_8").click();
    }
    public void pressNine() throws Exception{
        getByreourceID("com.android.calculator2:id/digit_9").click();
    }
    public void pressPoint() throws Exception{
        getByreourceID("com.android.calculator2:id/dec_point").click();
    }
    public void pressEquals() throws Exception{
        getByreourceID("com.android.calculator2:id/eq").click();
    }
    public void pressAdd() throws Exception{
        getByreourceID("com.android.calculator2:id/op_add").click();
    }
    public void pressSub() throws Exception{
        getByreourceID("com.android.calculator2:id/op_sub").click();
    }
    public void pressMul() throws Exception{
        getByreourceID("com.android.calculator2:id/op_mul").click();
    }
    public void pressDiv() throws Exception{
        getByreourceID("com.android.calculator2:id/op_div").click();
    }
    public void pressClear() throws Exception{
        getByreourceID("com.android.calculator2:id/clr").click();
    }
    public void pressDel() throws Exception{
        getByreourceID("com.android.calculator2:id/del").click();
    }
    public String getFormula() throws Exception{
        resultText = getByreourceID("com.android.calculator2:id/formula").getText();
        return resultText;
    }
    public String getResult() throws Exception{
        resultText = getByreourceID("com.android.calculator2:id/result").getText();
        return resultText;
    }


}

