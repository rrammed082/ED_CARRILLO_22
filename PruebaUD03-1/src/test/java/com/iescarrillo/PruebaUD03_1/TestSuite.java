package com.iescarrillo.PruebaUD03_1;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

@Suite
@SelectClasses({TestCuentaMovimiento.class, TestEmpleado.class})
@SuiteDisplayName("Suite para ejecutar todos los test en una suite")

public class TestSuite {

	
}
